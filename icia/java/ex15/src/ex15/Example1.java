package ex15;

import java.util.*;

public class Example1 {
	public static void execute() {
		Scanner scanner = new Scanner(System.in);
		DeptDAO deptDAO = new DeptDAO();
		DeptVO deptVO = null;
		boolean run = true;
		
		System.out.println("*************** 학 과 코 드 관 리 ***************");
		while(run) {
			System.out.println("──────────────────────────────────────────────");
			System.out.println("1.코드등록 │ 2.코드목록 │ 3.코드수정 │ 4.코드삭제 │ 0.종료");
			System.out.println("──────────────────────────────────────────────");
			
			int menu = Main.input("선택");
			switch(menu) {
			case 0:
				run = false;
				System.out.println("메인페이지로 이동합니다.\n");
				break;
				
			case 1:
				String mcode = deptDAO.getMaxCode();
				int newCode = Integer.parseInt(mcode) + 10;
				System.out.println("학과코드 : " + newCode);
				System.out.print("학과명 : ");
				String codeName = scanner.nextLine();
				
				deptVO = new DeptVO();
				deptVO.setCode(String.valueOf(newCode));
				deptVO.setDname(codeName);
				deptDAO.insert(deptVO);
				System.out.println("새로운 학과가 등록되었습니다.\n");
				
				break;
				
			case 2:
				System.out.println("학과코드\t학과명");
				ArrayList<DeptVO> array = deptDAO.list();
				for(DeptVO v : array) {
					System.out.printf("%s\t%s\n", v.getCode(), v.getDname());
				}
				System.out.println("");
				
				break;
				
			case 3:
				break;
				
			case 4:
				break;
				
			default:
				System.out.println("0~4번 메뉴 중 선택해주세요.\n");
			}
		}
	}
}
