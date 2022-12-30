package ex14;

import java.util.*;

public class Example1 {
	public static void execute() {
		Scanner scanner = new Scanner(System.in);
		CampDAO campDAO = new CampDAO();
		CampVO campVO = null;
		TypeDAO typeDAO = new TypeDAO();
		FacilDAO facilDAO = new FacilDAO();
				
		boolean run = true;
		String switchMenu;
		int newCode;
		int code;
		
		while(run) {
			System.out.println("\n┌────────────────────────────────────────────────────────────────────┐");
			System.out.println("│\t\t            캠핑장관리 프로그램            \t\t     │");
			System.out.println("├────────────────────────────────────────────────────────────────────┤");
			System.out.println("│ 1.캠핑장등록 │ 2.캠핑장조회 │ 3.캠핑장목록 │ 4.시설물관리 │ 5.종류관리 │ 0.종료 │");
			System.out.println("└────────────────────────────────────────────────────────────────────┘");
			
			System.out.print("원하시는 업무를 선택해주세요. > ");
			switchMenu = scanner.nextLine();
			
			switch(switchMenu) {
			case "0":
				run = false;
				System.out.println("프로그램을 종료합니다.");
				
				break;
				
			case "1":
				newCode = campDAO.getLastCode() + 100;
				System.out.println("캠핑장 코드: " + newCode);
				campVO = new CampVO();
				campVO.setCode(newCode);
				System.out.print("캠핑장 이름을 입력해주세요. : ");
				campVO.setName(scanner.nextLine());
				
				System.out.print("캠핑장 주소를 입력해주세요. : ");
				campVO.setAddress(scanner.nextLine());
				
				//파일에 저장
				campDAO.insert(campVO);
				System.out.printf("%s 캠핑장이 등록되었습니다.\n", campVO.getName());

				break;
				
			case "2":
				code = Main.input("조회할 코드를 입력해주세요.");
				campVO = campDAO.read(code);
				if(campVO.getName() == null) {
					System.out.println("해당 캠핑장이 없습니다.");
				} else {
					System.out.println("캠핑장 이름: " + campVO.getName());
					System.out.println("캠핑장 주소: " + campVO.getAddress());
					System.out.println("──────────────────────────────────────────────────────────────────────");
					
					//캠핑장 Type 목록
					ArrayList<String> tarray = typeDAO.list(code);
					System.out.print("캠핑장 옵션:");
					if(tarray.size() == 0) System.out.println("없음");
					for(String t : tarray) {
						System.out.printf(" %s |", t);
					}
					System.out.println("");
					
					//캠핑장 시설물 목록
					ArrayList<String> farray = facilDAO.list(code);
					System.out.print("캠핑장 시설물:");
					if(farray.size() == 0) System.out.println("없음");
					for(String f : farray) {
						System.out.printf(" %s |", f);
					}
					System.out.println("");
				}
					
				break;
				
			case "3":
				System.out.println("──────────────────────────────────────────────────────────────────────");
				System.out.println("코드\t\t캠핑장이름\t\t캠핑장주소");
				System.out.println("──────────────────────────────────────────────────────────────────────");
				ArrayList<CampVO> carray = campDAO.list();
				for(CampVO c : carray) {
					System.out.printf("%d\t\t%s\t\t%s\n", c.getCode(), c.getName(), c.getAddress());
					
					//각 캠핑장별 Type 목록
					ArrayList<String> tarray = typeDAO.list(c.getCode());
					System.out.println("[캠핑장 옵션]");
					if(tarray.size() == 0) System.out.println("없음");
					for(String t : tarray) {
						System.out.printf("○ %s\n", t);
					}
					System.out.println("──────────────────────────────────────────────────────────────────────");
					
					//각 캠핑장별 시설물 목록
					ArrayList<String> farray = facilDAO.list(c.getCode());
					System.out.println("[캠핑장 시설물]");
					if(farray.size() == 0) System.out.println("없음");
					for(String f : farray) {
						System.out.printf("- %s\n", f);
					}
					System.out.println("──────────────────────────────────────────────────────────────────────");
				}
				System.out.println("등록된 캠핑장 수 : " + carray.size());
				
				break;
				
			case "4":
				Example2.execute();
				
				break;
				
			case "5":
				Example3.execute();
				
				break;
				
			default:
				System.out.println("0~5번 중 선택해주세요.");
			}
		}
	}
}
