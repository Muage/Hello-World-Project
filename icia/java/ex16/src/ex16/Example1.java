package ex16;

import java.util.*;

public class Example1 {
	public static void execute() {
		Scanner scanner = new Scanner(System.in);
		DeptDAO deptDAO = new DeptDAO();
		DeptVO deptVO = null;
		String maxCode;
		String newCode;
		String dname;
		String dcode;
		String sel;
		boolean run = true;
		boolean success = false;
		int code;
		
		System.out.println("********************* 학 과 코 드 관 리 *********************");
		while(run) {
			System.out.println("─────────────────────────────────────────────────────────");
			System.out.println("1.학과등록 │ 2.학과목록 │ 3.학과수정 │ 4.학과삭제 │ 5.학과조회 │ 0.종료");
			System.out.println("─────────────────────────────────────────────────────────");
			
			int menu = Main.input("선택");
			switch(menu) {
			case 0:
				run = false;
				System.out.println("메인메뉴로 이동합니다.\n");
				
				break;
				
			case 1:
				maxCode = deptDAO.getMaxCode();
				code = Integer.parseInt(maxCode.substring(1)) + 10;
				newCode = "D" + code;
				System.out.println("학과코드 : " + newCode);
				System.out.print("학과이름 : ");
				dname = scanner.nextLine();				
				
				System.out.print("학과를 등록하시겠습니까?");
				sel = scanner.nextLine();
				if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
					deptVO = new DeptVO();
					deptVO.setDcode(newCode);
					deptVO.setDname(dname);
					deptDAO.insert(deptVO);
					System.out.println("새로운 학과가 등록되었습니다.");
				} else {
					System.out.println("등록이 취소되었습니다.");
				}
				System.out.println("");
				
				break;
				
			case 2:
				ArrayList<DeptVO> array = deptDAO.list();
				for(DeptVO v : array) {
					System.out.printf("%s\t%s\n", v.getDcode(), v.getDname());
				}
				System.out.println("");
				
				break;
				
			case 3:
				System.out.print("수정할 학과코드를 입력해주세요. : ");
				dcode = scanner.nextLine();
				deptVO = deptDAO.read(dcode);
				if(deptVO.getDname() == null) {
					System.out.println("해당 학과가 존재하지 않습니다.");
				} else {
					System.out.print("학과명 : " + deptVO.getDname() + ", 변경할 학과명 : ");
					dname = scanner.nextLine();
//					if(dname.equals("")) deptVO.setDname(dname);
					if(dname.equals("")) {
						System.out.println("수정이 취소되었습니다.");
					} else {
						System.out.print("수정하시겠습니까?");
						sel = scanner.nextLine();
						if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
							deptVO.setDcode(dcode);
							deptVO.setDname(dname);
							deptDAO.update(deptVO);
							System.out.println("수정이 완료되었습니다.");
						} else {
							System.out.println("수정이 취소되었습니다.");
						}
					}
				}
				System.out.println("");
				
				break;
			
			case 4:
				System.out.print("삭제할 학과코드를 입력해주세요. : ");
				dcode = scanner.nextLine();
				deptVO = deptDAO.read(dcode);
				if(deptVO.getDname() == null) {
					System.out.println("해당 학과가 존재하지 않습니다.");
				} else {	//해당학과가 존재하는 경우
					System.out.println("학과이름 : " + deptVO.getDname());
					System.out.print(deptVO.getDname() + "과를 삭제하시겠습니까?");
					sel = scanner.nextLine();
					if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
						success = deptDAO.delete(dcode);
						if(success == true) {
							System.out.println(deptVO.getDname() + "과가 삭제되었습니다.");
						} else {
							System.out.println("해당 학과에 학생이 있어 삭제할 수 없습니다.");
						}
					} else {
						System.out.println("삭제가 취소되었습니다.");
					}
				}
				System.out.println("");
				
				break;
				
			case 5:
				System.out.print("학과코드 : ");
				dcode = scanner.nextLine();
				deptVO = deptDAO.read(dcode);
				if(deptVO.getDname() == null) {
					System.out.println("해당 학과가 존재하지 않습니다.");
				} else {
					System.out.println("학과이름 : " + deptVO.getDname());
				}
				System.out.println("");
				
				break;
				
			default:
				System.out.println("0~5번 메뉴 중 선택해주세요.\n");
			}
		}
	}
}
