package ex17;

import java.util.*;

public class Example1 {
	public static void execute() {
		Scanner scanner = new Scanner(System.in);
		FacilityDAO facilityDAO = new FacilityDAO();
		FacilityVO facilityVO;
		CampDAO campDAO = new CampDAO();
		CampVO campVO;
		ArrayList<FacilityVO> farray;
		ArrayList<FacilityVO> allArray;
		String newCode;
		String fname;
		String fcode;
		String sel;
		String code;
		boolean run = true;
		boolean success;
		boolean find;
		int menu;
		
		while(run) {
			System.out.println("********************* 시 설 물 관 리 *********************");
			System.out.println("───────────────────────────────────────────────────────");
			System.out.println("1.등록 │ 2.목록 │ 3.삭제 │ 4.등록(캠핑장) │ 5.삭제(캠핑장) │ 0.종료");
			System.out.println("───────────────────────────────────────────────────────");
			
			System.out.print("메뉴를 선택해주세요. : ");
			menu = scanner.nextInt(); scanner.nextLine();
			switch(menu) {
			case 0:
				run = false;
				System.out.println("프로그램을 종료합니다.\n");
				
				break;
				
			case 1:
				newCode = facilityDAO.getNewCode();
				System.out.println("시설물코드 : " + newCode);
				System.out.print("시설물이름 : ");
				fname = scanner.nextLine();
				if(fname.equals("")) {
					System.out.println("시설물 등록이 취소되었습니다.\n");
					break;
				}
				//새로운 시설물 등록
				facilityDAO.insert(newCode, fname);
				System.out.println("\n새로운 시설물이 등록되었습니다.\n");
				
				break;
				
			case 2:
				farray = facilityDAO.list();
				System.out.println("\n시설물코드\t│ 시설물이름");
				System.out.println("────────┼──────────────────────────────────────────────");
				for(FacilityVO f : farray) {
					System.out.printf("%s\t│ %s\n", f.getFcode(), f.getFname());
				}
				System.out.println("");
				
				break;
				
			case 3:
				System.out.print("삭제할 시설물 코드 : ");
				fcode = scanner.nextLine();
				if(fcode.equals("")) {
					System.out.println("시설물 삭제가 취소되었습니다.\n");
					break;
				}
				facilityVO = facilityDAO.read(fcode);
				if(facilityVO.getFname() == null) {
					System.out.println("해당 시설물이 존재하지 않습니다.\n");
					break;
				}
				System.out.println("시설물 이름 : " + facilityVO.getFname());
				System.out.print("시설물을 삭제하시겠습니까?");
				sel = scanner.nextLine();
				if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
					success = facilityDAO.delete(fcode);
					if(success == true) {
						System.out.println("시설물 삭제가 완료되었습니다.\n");
					} else {
						System.out.println("이 시설물을 사용중인 캠핑장이 있습니다.\n");
					}
				} else {
					System.out.println("시설물 삭제가 취소되었습니다.\n");
				}
				 
				break;
				
			case 4:
				System.out.print("캠핑장 코드 : ");
				code = scanner.nextLine();
				if(code.equals("")) {
					System.out.println("캠핑장 시설물 등록이 취소되었습니다.\n");
					break;
				}
				campVO = campDAO.read(code);
				if(campVO.getCname() == null) {
					System.out.println("해당 캠핑장이 존재하지 않습니다.\n");
					break;
				}
				System.out.println("\n캠핑장이름\t│ 캠핑장주소");
				System.out.println("───────────────────────────────────────────────────────");
				System.out.printf("%s\t│ %s\n\n", campVO.getCname(), campVO.getAddress());
				
				farray = facilityDAO.list(code);
				System.out.println("시설물코드\t│ 시설물이름\t[설치(●) / 미설치(○)]");
				System.out.println("───────────────────────────────────────────────────────");
				for(FacilityVO f : farray) {
					System.out.printf("● %s\t│ %s\n", f.getFcode(), f.getFname());
				}
				allArray = facilityDAO.list();
				for(FacilityVO a : allArray) {
					find = false;
					for(FacilityVO f : farray) {
						if(a.getFcode().equals(f.getFcode())) find = true;
					}
					if(find == false) {
						System.out.printf("○ %s\t│ %s\n", a.getFcode(), a.getFname());
					}
				}
				System.out.println("");
				
				do {
					System.out.print("시설물코드 : ");
					fcode = scanner.nextLine();
					if(fcode.equals("")) {
						System.out.println("입력된 코드가 없어 캠핑장 시설물 등록이 종료되었습니다.\n");
						break;
					}
					facilityVO = facilityDAO.read(fcode);
					if(facilityVO.getFname() == null) {
						System.out.println("등록되지 않은 시설물입니다.\n");
						break;
					}
					facilityVO = facilityDAO.read(code, fcode);
					if(facilityVO.getFname() == null) {
						facilityVO.setCode(code);
						facilityVO.setFcode(fcode);
						facilityDAO.insert(facilityVO);
						System.out.println("캠핑장 시설물 등록이 완료되었습니다.\n");
					} else {
						System.out.println(facilityVO.getFname() + " 시설물은 이미 등록되어 있습니다.\n");
					}
				}while(true);
				
				break;
				
			case 5:
				System.out.print("캠핑장코드 : ");
				code = scanner.nextLine();
				if(code.equals("")) {
					System.out.println("캠핑장 시설물 삭제가 취소되었습니다.\n");
					break;
				}
				campVO = campDAO.read(code);
				if(campVO.getCname() == null) {
					System.out.println("해당 캠핑장이 존재하지 않습니다.\n");
					break;
				}
				//캠핑장 정보 출력
				System.out.println("\n캠핑장이름\t│ 캠핑장주소");
				System.out.println("───────────────────────────────────────────────────────");
				System.out.printf("%s\t│ %s\n\n", campVO.getCname(), campVO.getAddress());
				
				//캠핑장에 설치된 시설물
				farray = facilityDAO.list(code);
				System.out.println("시설물코드\t│ 시설물이름\t[설치(●)]");
				System.out.println("───────────────────────────────────────────────────────");
				for(FacilityVO f : farray) {
					System.out.printf("● %s\t│ %s\n", f.getFcode(), f.getFname());
				}
				System.out.println("");
				
				do {
					System.out.print("시설물코드 : ");
					fcode = scanner.nextLine();
					if(fcode.equals("")) {
						System.out.println("입력된 코드가 없어 캠핑장 시설물 삭제가 종료되었습니다.\n");
						break;
					}
					facilityVO = facilityDAO.read(code, fcode);
					if(facilityVO.getFname() == null) {
						System.out.println("해당 시설물은 설치되어 있지 않습니다.\n");
					} else {
						facilityDAO.delete(code, fcode);
						System.out.println(facilityVO.getFname() + " 시설물이 삭제되었습니다.\n");
					}
				} while(true);
				
				break;
				
			default:
				System.out.println("0~5번 메뉴 중 선택해주세요.\n");
			}
		}
	}
}
