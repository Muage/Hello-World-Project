package ex14;

import java.util.*;

public class Example2 {
	public static void execute() {
		Scanner scanner = new Scanner(System.in);
		CampDAO campDAO = new CampDAO();
		CampVO campVO = null;
		FacilDAO facilDAO = new FacilDAO();
				
		boolean run = true;
		int switchMenu;
		String[] facility = {"취소", "화장실", "전기", "수도", "와이파이", "놀이터", "수영장", "편의점"};
		
		while(run) {
			System.out.println("┌──────────────────────────────────────────┐");
			System.out.println("│ 1.시설물등록 │ 2.시설물삭제 │ 0.이전으로 돌아가기 │");
			System.out.println("└──────────────────────────────────────────┘");
			
			switchMenu = Main.input("메뉴를 선택해주세요.");
			
			switch(switchMenu) {
			case 0:
				run = false;
				
				break;
				
			case 1:
				int code = Main.input("캠핑장 번호를 입력해주세요.");
				campVO = campDAO.read(code);
				if(campVO.getName() == null) {
					System.out.println("해당 캠핑장이 없습니다.\n");
					break;
				}
				System.out.println("캠핑장 이름: " + campVO.getName());
				System.out.println("캠핑장 주소: " + campVO.getAddress());
				System.out.println("──────────────────────────────────────────────────────────────────────");
				ArrayList<String> farray = facilDAO.list(code);
				ArrayList<String> check = new ArrayList<>();
				
				for(int i=0; i<facility.length; i++) {
					
					//시설물 유무 확인
					boolean isFind = false;
					for(String f : farray) {
						if(facility[i].equals(f)) isFind = true;
					}
					if(isFind == true) {
						check.add("O");
					} else {
						check.add("X");
					}
					System.out.printf("[%d] %s \t[ %s ]\n", i, facility[i], check.get(i));
				}
				System.out.println("──────────────────────────────────────────────────────────────────────");
				int sel = Main.input("시설물을 선택해주세요.");
				if(sel == 0) break;
				if(check.get(sel).equals("O")) {
					System.out.println("이미 등록되어 있는 시설물입니다.\n");
					break;
				}
				facilDAO.insert(code, facility[sel]);
				System.out.println(facility[sel] + "이(가) 등록되었습니다.\n");
				
				break;
				
			case 2:
				code = Main.input("캠핑장 번호를 입력해주세요.");
				campVO = campDAO.read(code);
				if(campVO.getName() == null) {
					System.out.println("해당 캠핑장이 없습니다.\n");
					break;
				}
				System.out.println("캠핑장 이름: " + campVO.getName());
				System.out.println("캠핑장 주소: " + campVO.getAddress());
				System.out.println("──────────────────────────────────────────────────────────────────────");
				farray = facilDAO.list(code);
				check = new ArrayList<>();
				
				
				for(int i=0; i<facility.length; i++) {
					//시설물 유무 확인
					
					boolean isFind = false;
					for(String f : farray) {
						if(facility[i].equals(f)) isFind = true;
					}
					if(isFind == true) {
						check.add("O");
					} else {
						check.add("X");
					}
					System.out.printf("[%d] %s \t[ %s ]\n", i, facility[i], check.get(i));
				}
				System.out.println("──────────────────────────────────────────────────────────────────────");
				sel = Main.input("시설물을 선택해주세요.");
				if(sel == 0) break;
				if(check.get(sel).equals("X")) {
					System.out.println("등록되지 않은 시설물입니다.\n");
					break;
				}
				facilDAO.delete(code, facility[sel]);
				System.out.println(facility[sel] + "이(가) 삭제되었습니다.\n");
					
				break;
				
			default:
				System.out.println("0~2번 중 선택해주세요.\n");
				
			}
		}
	}
}
