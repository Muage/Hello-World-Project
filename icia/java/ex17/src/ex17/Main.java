package ex17;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CampDAO campDAO = new CampDAO();
		CampVO campVO;
		FacilityDAO facilityDAO = new FacilityDAO();
		FacilityVO facilityVO;
		TypeDAO typeDAO = new TypeDAO();
		TypeVO typeVO;
		ArrayList<CampVO> array;
		ArrayList<FacilityVO> farray;
		ArrayList<TypeVO> tarray;
		String newCode;
		String cname;
		String address;
		String code;
		boolean run = true;
		int menu;
		
		while(run) {
			System.out.println("┌───────────────────────┐");
			System.out.println("│\t1.캠핑장등록\t│");
			System.out.println("├───────────────────────┤");
			System.out.println("│\t2.캠핑장목록\t│");
			System.out.println("├───────────────────────┤");
			System.out.println("│\t3.캠핑장조회\t│");
			System.out.println("├───────────────────────┤");
			System.out.println("│\t4.시설물관리\t│");
			System.out.println("├───────────────────────┤");
			System.out.println("│\t5.유형관리\t\t│");
			System.out.println("├───────────────────────┤");
			System.out.println("│\t0.프로그램종료\t│");
			System.out.println("└───────────────────────┘");
			
			System.out.print("메뉴를 선택해주세요. : ");
			menu = scanner.nextInt(); scanner.nextLine();
			switch(menu) {
			case 0:
				run = false;
				System.out.println("프로그램을 종료합니다.\n");
				
				break;
				
			case 1:
				newCode = campDAO.getNewCode();
				System.out.println("캠핑장코드 : " + newCode);
				System.out.print("캠핑장이름 : ");
				cname = scanner.nextLine();
				if(cname.equals("")) {
					System.out.println("캠핑장이름의 입력이 없어 캠핑장 등록이 취소되었습니다.\n");
					break;
				}
				System.out.print("캠핑장주소 : ");
				address = scanner.nextLine();
				if(address.equals("")) {
					System.out.println("캠핑장주소의 입력이 없어 캠핑장 등록이 취소되었습니다.\n");
					break;
				}
				campVO = new CampVO();
				campVO.setCode(newCode);
				campVO.setCname(cname);
				campVO.setAddress(address);
				
				campDAO.insert(campVO);
				System.out.println("캠핑장 등록이 완료되었습니다.\n");
				
				break;
				
			case 2:
				array = campDAO.list();
				System.out.println("\n캠핑장코드\t\t캠핑장이름\t\t캠핑장주소");
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				for(CampVO v : array) {
					System.out.printf("%s\t\t%s\t\t%s\n", v.getCode(), v.getCname(), v.getAddress());
					System.out.println("");
					//각 캠핑장의 시설물 목록
					farray = facilityDAO.list(v.getCode());
					System.out.println("[시설물]");
					for(FacilityVO f : farray) {
						System.out.printf("○ %s(%s)     ", f.getFname(), f.getFcode());
					}
					System.out.println("\n");
					
					//각 캠핑장의 유형 목록
					tarray = typeDAO.list(v.getCode());
					System.out.println("[캠핑유형]");
					for(TypeVO t : tarray) {
						System.out.printf("● %s(%d개)     ", t.getTname(), t.getQnt());
					}
					System.out.println("");
					System.out.println("──────────────────────────────────────────────────");
				}
				System.out.println("");
				
				break;
				
			case 3:
				System.out.print("캠핑장코드 : ");
				code = scanner.nextLine();
				if(code.equals("")) {
					System.out.println("입력된 캠핑장코드가 없어 조회가 취소되었습니다.\n");
					break;
				}
				campVO = campDAO.read(code);
				if(campVO.getCname() == null) {
					System.out.println("해당 캠핑장이 없습니다.\n");
					break;
				}
				//캠핑장 정보 출력
				System.out.println("\n캠핑장이름\t\t캠핑장주소");
				System.out.printf("%s\t\t%s\n\n", campVO.getCname(), campVO.getAddress());
				//시설물 목록 출력
				farray = facilityDAO.list(code);
				System.out.println("[시설물]");
				for(FacilityVO f : farray) {
					System.out.printf("□ %s(%s)     ", f.getFname(), f.getFcode());
				}
				System.out.println("\n");
				//유형 목록 출력
				tarray = typeDAO.list(code);
				System.out.println("[캠핑유형]");
				for(TypeVO t : tarray) {
					System.out.printf("□ %s(%d개)     ", t.getTname(), t.getQnt());
				}
				System.out.println("\n");
				
				break;
				
			case 4:
				Example1.execute();
				break;
		
			case 5:
				Example2.execute();
				break;
		
			default:
				System.out.println("0~5번 메뉴 중 선택해주세요.\n");
			}
		}
	}
}
