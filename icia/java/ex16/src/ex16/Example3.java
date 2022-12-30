package ex16;

import java.util.*;

public class Example3 {
	public static void execute() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<StudentVO> array;
		ArrayList<DeptVO> darray;
		StudentDAO studentDAO = new StudentDAO();
		StudentVO studentVO = null;
		DeptDAO deptDAO = new DeptDAO();
		DeptVO deptVO = null;
		String sno;
		String sname;
		String maxNo;
		String dcode;
		String sel;
		int newNo;
		boolean run = true;
		boolean isFind = false;
		boolean success = false;
		
		System.out.println("************************ 학 생 관 리 ************************");
		while(run) {
			System.out.println("─────────────────────────────────────────────────────────");
			System.out.println("1.학생등록 │ 2.학생목록 │ 3.학생수정 │ 4.학생삭제 │ 5.학생조회 │ 0.종료");
			System.out.println("─────────────────────────────────────────────────────────");
			
			int menu = Main.input("선택");
			switch(menu) {
			case 0:
				run = false;
				System.out.println("메인메뉴로 이동합니다.\n");
				
				break;
				
			case 1:
				maxNo = studentDAO.maxNo();
				newNo = Integer.parseInt(maxNo) + 100;
				System.out.println("학번 : " + newNo);
				
				System.out.print("이름 : ");
				sname = scanner.nextLine();
				if(sname.equals("")) {
					System.out.println("학생 등록이 취소되었습니다.\n");
					break;
				}
				
				System.out.println("");
				
				darray = deptDAO.list();
				for(DeptVO v : darray) {
					System.out.printf("%s | %s\n", v.getDcode(), v.getDname());
				}
				
				System.out.println("");
				
				do{
					System.out.print("학과코드 : ");
					dcode = scanner.nextLine();
					if(dcode.equals("")) break;
					deptVO = deptDAO.read(dcode);
					if(deptVO.getDname() != null) isFind = true;
					if(isFind == false) System.out.println("올바른 학과 코드를 입력해주세요.\n"); 
				} while(isFind == false);
				
				if(dcode.equals("")) {
					System.out.println("학생 등록이 취소되었습니다.");
					break;
				}
				
				studentVO = new StudentVO();
				studentVO.setSno(String.valueOf(newNo));
				studentVO.setSname(sname);
				studentVO.setDcode(dcode);
				studentDAO.insert(studentVO);
				System.out.println(studentVO.getSname() + " 학생이 등록되었습니다.\n");
				
				break;
				
			case 2:
				array = studentDAO.list();
				for(StudentVO v : array) {
					System.out.printf("%s\t%s\t%s(%s)\n", v.getSno(), v.getSname(), v.getDcode(), v.getDname());
				}
				System.out.println("");
				
				break;
				
			case 3:
				System.out.print("수정할 학번 : ");
				sno = scanner.nextLine();
				if(sno.equals("")) {
					System.out.println("수정이 취소되었습니다.\n");
					break;
				}
				studentVO = studentDAO.read(sno);
				if(studentVO.getSname() == null) {
					System.out.println("해당 학생이 존재하지 않습니다.");
					break;
				}
				System.out.print("이름 : " + studentVO.getSname() + ", 수정할 이름 : ");
				sname = scanner.nextLine();
				if(!sname.equals("")) studentVO.setSname(sname);
				
				System.out.println("");
				
				darray = deptDAO.list();
				for(DeptVO v : darray) {
					System.out.printf("%s | %s\n", v.getDcode(), v.getDname());
				}
				
				System.out.println("");
				
				isFind = false;
				do {
					System.out.printf("학과 : %s(%s), 수정할 학과 : ", studentVO.getDcode(), studentVO.getDname());
					dcode = scanner.nextLine();
					if(dcode.equals("")) break;
					deptVO = deptDAO.read(dcode);
					if(deptVO.getDname() != null) isFind = true;
					if(isFind == false) System.out.println("해당 학과가 없습니다.");
				} while(isFind == false);
				
				if(!dcode.equals("")) studentVO.setDcode(dcode);
				studentDAO.update(studentVO);
				System.out.println("\n수정이 완료되었습니다.\n");
				
				break;
				
			case 4:
				System.out.print("삭제할 학번 : ");
				sno = scanner.nextLine();
				if(sno.equals("")) {
					System.out.println("삭제가 취소되었습니다.\n");
					break;
				}
				studentVO = studentDAO.read(sno);
				if(studentVO.getSname() == null) {
					System.out.println("해당 학생이 존재하지 않습니다.\n");
					break;
				}
				System.out.printf("%s(%s)\n\n", studentVO.getSname(), studentVO.getDname());
				
				System.out.print("삭제하시겠습니까?");
				sel = scanner.nextLine();
				if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
					success = studentDAO.delete(sno);
					if(success) {
						System.out.println("삭제가 완료되었습니다.\n");
					} else {
						System.out.println("성적 데이터가 존재해서 삭제할 수 없습니다.\n");
					}
				}
				
				break;
				
			case 5:
				System.out.print("조회할 학번 : ");
				sno = scanner.nextLine();
				studentVO = studentDAO.read(sno);
				if(studentVO.getSname() == null) {
					System.out.println("해당 학생이 존재하지 않습니다.\n");
					break;
				}
				System.out.println("학생 이름 : " + studentVO.getSname());
				System.out.printf("학생 학과 : %s(%s)\n\n", studentVO.getDcode(), studentVO.getDname());				
				
				break;
				
			default:
				System.out.println("0~5번 메뉴 중 선택해주세요.\n");
			}
		}
	}
}
