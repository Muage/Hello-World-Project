package ex17;

import java.util.*;

public class Example2 {
	public static void execute() {
		Scanner scanner = new Scanner(System.in);
		TypeDAO typeDAO = new TypeDAO();
		TypeVO typeVO;
		CampDAO campDAO = new CampDAO();
		CampVO campVO;
		ArrayList<TypeVO> tarray;
		ArrayList<TypeVO> allArray;
		String menu;
		String newCode;
		String tname;
		String tcode;
		String code;
		boolean run = true;
		boolean find;
		int qnt;
		
//		FacilityDAO facilityDAO = new FacilityDAO();
//		FacilityVO facilityVO;
//		ArrayList<FacilityVO> farray;
//		String sel;
//		boolean success;

		
		while(run) {
			System.out.println("********************** 유 형 관 리 **********************");
			System.out.println("───────────────────────────────────────────────────────");
			System.out.println("1.등록 │ 2.목록 │ 3.삭제 │ 4.등록(캠핑장) │ 5.삭제(캠핑장) │ 0.종료");
			System.out.println("───────────────────────────────────────────────────────");
			
			System.out.print("메뉴를 선택해주세요. : ");
			menu = scanner.nextLine();
			switch(menu) {
			case "0":
				run = false;
				System.out.println("프로그램을 종료합니다.\n");
				
				break;
				
			case "1":
				newCode = typeDAO.getNewCode();
				System.out.println("유형코드 : " + newCode);
				System.out.print("유형이름 : ");
				tname = scanner.nextLine();
				if(tname.equals("")) {
					System.out.println("입력된 유형이름이 없어 등록이 취소되었습니다.\n");
				}
				typeDAO.insert(newCode, tname);
				System.out.println("새로운 유형이 등록되었습니다.\n");
				
				break;
				
			case "2":
				System.out.println("\n유형코드\t│ 유형이름");
				System.out.println("────────┼──────────────────────────────────────────────");
				for(TypeVO t : typeDAO.list()) {
					System.out.printf("%s\t│ %s\n", t.getTcode(), t.getTname());
				}
				System.out.println("");
				
				break;
				
			case "3":
				System.out.print("삭제할 유형코드 : ");
				tcode = scanner.nextLine();
				if(tcode.equals("")) {
					System.out.println("입력된 유형코드가 없어 삭제가 취소되었습니다.\n");
					break;
				}
				typeVO = typeDAO.read(tcode);
				if(typeVO.getTname() == null) {
					System.out.println("삭제할 유형코드가 존재하지 않습니다.\n");
					break;
				}
				//삭제
				typeDAO.delete(tcode);
//				if(typeDAO.delete(tcode)) {
//					System.out.println("유형 삭제가 완료되었습니다.\n");
//				} else {
//					System.out.println("이 유형을 사용중인 캠핑장이 있어 삭제할 수 없습니다.\n");
//				}
				
				break;
				
			case "4":
				System.out.print("캠핑장코드 : ");
				code = scanner.nextLine();
				if(code.equals("")) {
					System.out.println("입력된 캠핑장코드가 없어 등록이 취소되었습니다.\n");
					break;
				}
				campVO = campDAO.read(code);
				if(campVO.getCname() == null) {
					System.out.println("해당 캠핑장이 존재하지 않습니다.\n");
					break;
				}
				//캠핑장 정보 출력
				System.out.println("\n캠핑장이름\t\t캠핑장주소");
				System.out.printf("%s\t\t%s\n\n", campVO.getCname(), campVO.getAddress());
				
				//유형 출력
				System.out.println("[등록된 유형]");
				tarray = typeDAO.list(code);
				for(TypeVO t : tarray) {
					System.out.printf("● %s(%s)     ", t.getTname(), t.getTcode());
				}
				System.out.println("\n");
				
				System.out.println("[등록되지 않은 유형]");
				allArray = typeDAO.list();
				for(TypeVO a : allArray) {
					typeVO = typeDAO.read(code, a.getTcode());
					if(typeVO.getTname() == null) System.out.printf("○ %s(%s)     ", a.getTname(), a.getTcode());
				}
				System.out.println("\n");
				
				do {
					System.out.print("유형코드 : ");
					tcode = scanner.nextLine();
					if(tcode.equals("")) break;
					typeVO = typeDAO.read(tcode);
					if(typeVO.getTname() == null) {
						System.out.println("없는 유형코드 입니다.\n");
					} else {
						typeVO = typeDAO.read(code, tcode);
						if(typeVO.getTname() == null) {
							System.out.print("수량 : ");
							qnt = scanner.nextInt(); scanner.nextLine();
							
							typeVO = new TypeVO();
							typeVO.setCode(code);
							typeVO.setTcode(tcode);
							typeVO.setQnt(qnt);
							
							typeDAO.insert(typeVO);
							System.out.println("캠핑장에 새로운 유형이 입력되었습니다.\n");
						} else {
							System.out.println("이미 등록된 유형입니다.\n");
						}
					}
				} while(true);
				
				break;
				
			case "5":
				System.out.print("캠핑장코드 : ");
				code = scanner.nextLine();
				if(code.equals("")) {
					System.out.println("입력된 캠핑장코드가 없어 삭제가 취소되었습니다.\n");
				}
				campVO = campDAO.read(code);
				if(campVO.getCname() == null) {
					System.out.println("캠핑장이 존재하지 않습니다.\n");
					break;
				}
				//캠핑장 정보 출력
				System.out.println("\n캠핑장이름\t\t캠핑장주소");
				System.out.printf("%s\t\t%s\n\n", campVO.getCname(), campVO.getAddress());
				//유형 출력
				System.out.println("[등록된 유형]");
				tarray = typeDAO.list(code);
				for(TypeVO t : tarray) {
					System.out.printf("● %s(%s)     ", t.getTname(), t.getTcode());
				}
				System.out.println("\n");
				
				do {
					System.out.print("삭제할 유형코드 : ");
					tcode = scanner.nextLine();
					if(tcode.equals("")) {
						System.out.println("입력된 유형코드가 없어 삭제가 취소되었습니다.\n");
						break;
					}
					typeVO = typeDAO.read(code, tcode);
					if(typeVO.getTname() == null) {
						System.out.println("등록되지 않은 유형입니다.\n");
					} else {
						typeDAO.delete(code, tcode);
						System.out.println("캠핑장의 유형이 삭제되었습니다.\n");
					}	
				} while(true);
				
				break;
				
			default:
				System.out.println("0~5번 메뉴 중 선택해주세요.\n");
			}
		}
	}
}
