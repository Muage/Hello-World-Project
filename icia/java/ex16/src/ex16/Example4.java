package ex16;

import java.util.*;

public class Example4 {
	public static void execute() {
		Scanner scanner = new Scanner(System.in);
		StudentDAO studentDAO = new StudentDAO();
		StudentVO studentVO = null;
		ScoreDAO scoreDAO = new ScoreDAO();
		ScoreVO scoreVO = null;
		TypeDAO typeDAO = new TypeDAO();
		TypeVO typeVO = null;
		ArrayList<ScoreVO> array;
		ArrayList<TypeVO> tarray;
		String sno;
		String tcode;
		String sel;
		int grade;
		int count;
		boolean run = true;
		boolean isFind = false;
		
		System.out.println("************* 성 적 관 리 *************");
		while(run) {
			System.out.println("────────────────────────────────────");
			System.out.println("1.성적조회 │ 2.성적입력 │ 3.성적삭제 │ 0.종료");
			System.out.println("────────────────────────────────────");
			
			int menu = Main.input("선택");
			switch(menu) {
			case 0:
				run = false;
				System.out.println("메인메뉴로 이동합니다.\n");
				
				break;
				
			case 1:
				System.out.print("조회할 학번 : ");
				sno = scanner.nextLine();
				if(sno.equals("")) {
					System.out.println("성적 조회가 취소되었습니다.\n");
					break;
				}
				studentVO = studentDAO.read(sno);
				if(studentVO.getSname() == null) {
					System.out.println("해당 학생이 존재하지 않습니다.\n");
					break;
				}
				System.out.printf("%s(%s)\n", studentVO.getSname(), studentVO.getDname());
				array = scoreDAO.list(sno);
				for(ScoreVO v : array) {
					System.out.printf("%s(%s)\t%s\t%d\n", v.getTname(), v.getTcode(), v.getTdate(), v.getGrade());
				}
				System.out.println("");
				
				break;
				
			case 2:
				System.out.print("등록할 학번 : ");
				sno = scanner.nextLine();
				if(sno.equals("")) {
					System.out.println("성적 등록이 취소되었습니다.\n");
					break;
				}
				studentVO = studentDAO.read(sno);
				if(studentVO.getSname() == null) {
					System.out.println("해당 학생이 존재하지 않습니다.\n");
					break;
				}
				
				System.out.printf("%s(%s)\n", studentVO.getSname(), studentVO.getDname());
				array = scoreDAO.list(sno);
				for(ScoreVO v : array) {
					System.out.printf("%s(%s)\t%s\t%d\n", v.getTname(), v.getTcode(), v.getTdate(), v.getGrade());
				}
				System.out.println("");
				
				tarray = typeDAO.list();
				for(TypeVO v : tarray) {
					System.out.printf("%s | %s\n", v.getTcode(), v.getTname());
				}
				System.out.println("");
				
				isFind = false;
				tcode = "";
				count = 0;
				do {
					System.out.print("시험 유형 : ");
					tcode = scanner.nextLine();
					if(tcode.equals("")) break;
					
					count = scoreDAO.read(sno, tcode);
					if(count == 1) break;
					
					typeVO = typeDAO.read(tcode);
					if(typeVO.getTname() != null) isFind = true;
					if(isFind == false) System.out.println("시험 유형을 확인해주세요.");
				} while(isFind == false);
				
				if(tcode.equals("")) {
					System.out.println("성적 등록이 취소되었습니다.\n");
					break;
				}
				
				if(count == 1) {
					System.out.println("이미 등록된 성적입니다.\n");
					break;
				}
				
				grade = Main.input("성적");
				scoreVO = new ScoreVO();
				scoreVO.setSno(sno);
				scoreVO.setTcode(tcode);
				scoreVO.setGrade(grade);
				scoreDAO.insert(scoreVO);
				System.out.println("성적 등록이 완료되었습니다.\n");
				
				break;
				
			case 3:
				System.out.print("삭제할 학번 : ");
				sno = scanner.nextLine();
				studentVO = studentDAO.read(sno);
				if(studentVO.getSname() == null) {
					System.out.println("해당 학생이 존재하지 않습니다.\n");
					break;
				}
				
				System.out.println("");
				System.out.printf("%s(%s)\n", studentVO.getSname(), studentVO.getDname());
				array = scoreDAO.list(sno);
				for(ScoreVO v : array) {
					System.out.printf("%s(%s)\t%s\t%d\n", v.getTname(), v.getTcode(), v.getTdate(), v.getGrade());
				}
				System.out.println("");
				
				count = 0;
				do {
					System.out.print("삭제할 유형 : ");
					tcode = scanner.nextLine();
					if(tcode.equals("")) break;
					count = scoreDAO.read(sno, tcode);
					if(count == 0) System.out.println("삭제할 데이터가 없습니다.\n");
					else break;
				} while(true);
				
				if(tcode.equals("")) {
					System.out.println("삭제가 취소되었습니다.\n");
					break;
				}
				
				System.out.print("삭제하시겠습니까?");
				sel = scanner.nextLine();
				if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
					scoreDAO.delete(sno, tcode);
					System.out.println("성적 삭제가 완료되었습니다.\n");
				} else {
					System.out.println("삭제가 취소되었습니다.\n");
				}
				
				break;
				
			default:
				System.out.println("0~3번 메뉴 중 선택해주세요.\n");
			}
		}
	}
}
