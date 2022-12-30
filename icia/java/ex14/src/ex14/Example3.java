package ex14;

import java.util.*;

public class Example3 {
	public static void execute() {
		Scanner scanner = new Scanner(System.in);
		CampDAO campDAO = new CampDAO();
		CampVO campVO = null;
		TypeDAO typeDAO = new TypeDAO();
		String[] type = {"취소", "오토캠핑", "카라반", "글램핑", "펜션"};
				
		boolean run = true;
		int switchMenu;
		
		while(run) {
			System.out.println("┌────────────────────────────────────────────────┐");
			System.out.println("│ 1.시설물종류등록 │ 2.시설물종류삭제 │ 0.이전으로 돌아가기 │");
			System.out.println("└────────────────────────────────────────────────┘");
			
			switchMenu = Main.input("메뉴를 선택해주세요.");
			
			switch(switchMenu) {
			case 0:
				run = false;
				
				break;
				
			case 1:
				int code = Main.input("캠핑장 번호를 입력해주세요.");
				campVO = campDAO.read(code);
				if(campVO.getName() == null) {
					System.out.println("입력하신 번호로 등록된 캠핑장이 없습니다.\n");
					break;
				}
				System.out.println("캠핑장 이름 : " + campVO.getName());
				System.out.println("캠핑장 주소: " + campVO.getAddress());
				System.out.println("──────────────────────────────────────────────────────────────────────");
				ArrayList<String> tarray = typeDAO.list(code);
				ArrayList<String> check = new ArrayList<>();
				
				for(int i=0; i<type.length; i++) {
					
					boolean isFind = false;
					for(String t : tarray) {
						if(t.equals(type[i])) isFind = true;
					}
					if(isFind == true) {
							check.add("O");
					} else {
						check.add("X");
					}
					System.out.printf("[%d] %s \t[ %s ]\n", i, type[i], check.get(i));
				}
				System.out.println("──────────────────────────────────────────────────────────────────────");
				int sel = Main.input("유형을 선택해주세요.");
				if(sel == 0) break;
				if(check.get(sel).equals("O")) {
					System.out.println("이미 등록되어 있는 유형입니다.\n");
					break;
				}
				//종류 등록
				typeDAO.insert(code, type[sel]);
				System.out.println(type[sel] + " 유형이 등록되었습니다.\n");
				
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
				tarray = typeDAO.list(code);
				check = new ArrayList<>();
				
				
				for(int i=0; i<type.length; i++) {
					//시설물 유무 확인
					
					boolean isFind = false;
					for(String t : tarray) {
						if(type[i].equals(t)) isFind = true;
					}
					if(isFind == true) {
						check.add("O");
					} else {
						check.add("X");
					}
					System.out.printf("[%d] %s \t[ %s ]\n", i, type[i], check.get(i));
				}
				System.out.println("──────────────────────────────────────────────────────────────────────");
				sel = Main.input("유형을 선택해주세요.");
				if(sel == 0) break;
				if(check.get(sel).equals("X")) {
					System.out.println("등록되지 않은 유형입니다.\n");
					break;
				}
				typeDAO.delete(code, type[sel]);
				System.out.println(type[sel] + "유형이 삭제되었습니다.\n");
				
				break;
			
			default:
				System.out.println("0~2번 중 선택해주세요.\n");
			}
		}
	}
}
