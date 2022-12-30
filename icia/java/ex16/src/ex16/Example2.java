package ex16;

import java.util.*;

public class Example2 {
	public static void execute() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<TypeVO> array;
		TypeDAO typeDAO = new TypeDAO();
		TypeVO typeVO = null;
		String tname;
		String tcode;
		String tdate;
		String maxCode;
		String newCode;
		boolean run = true;
		int code;
		
		String sel;
		boolean success = false;
		
		
		System.out.println("********************* 타 입 코 드 관 리 *********************");
		while(run) {
			System.out.println("─────────────────────────────────────────────────────────");
			System.out.println("1.타입등록 │ 2.타입목록 │ 3.타입수정 │ 4.타입삭제 │ 5.타입조회 │ 0.종료");
			System.out.println("─────────────────────────────────────────────────────────");
			
			int menu = Main.input("선택");
			switch(menu) {
			case 0:
				run = false;
				System.out.println("메인메뉴로 이동합니다.\n");
				
				break;
				
			case 1:
				maxCode = typeDAO.getMaxCode();
				code = Integer.parseInt(maxCode.substring(1)) + 10;
				newCode = "T" + code;
				System.out.println("타입코드 : " + newCode);
				System.out.print("타입이름 : ");
				tname = scanner.nextLine();
				if(tname.equals("")) {
					System.out.println("등록이 취소되었습니다.");
					break;
				}
				typeVO = new TypeVO();
				typeVO.setTcode(newCode);
				typeVO.setTname(tname);
				typeDAO.insert(typeVO);
				System.out.println("새로운 타입이 등록되었습니다.");
				System.out.println("");
				
				break;
				
			case 2:
				array = typeDAO.list();
				System.out.println("코드\t코드명\t\t시험일");
				for(TypeVO v : array) {
					System.out.printf("%s\t%s\t\t%s\n", v.getTcode(), v.getTname(), v.getTdate());
				}
				System.out.println("");
				
				break;
				
			case 3:
				System.out.print("수정할 타입코드 : ");
				tcode = scanner.nextLine();
				typeVO = typeDAO.read(tcode);
				if(typeVO.getTname() == null) {
					System.out.println("해당 코드가 존재하지 않습니다.\n");
					break;
				}
				System.out.print("타입 이름 : " + typeVO.getTname() + ", 변경할 이름 : ");
				tname = scanner.nextLine();
				if(!tname.equals("")) typeVO.setTname(tname);
				
				System.out.print("시험 일자 : " + typeVO.getTdate() + ", 변경할 일자 : ");
				tdate = scanner.nextLine();
				if(!tdate.equals("")) typeVO.setTdate(tdate);
				
				typeDAO.update(typeVO);
				System.out.println("수정이 완료되었습니다.\n");
				
				break;
			
			case 4:
				System.out.print("삭제할 타입코드 : ");
				tcode = scanner.nextLine();
				typeVO = typeDAO.read(tcode);
				if(typeVO.getTname() == null) {
					System.out.println("해당 코드가 존재하지 않습니다.\n");
					break;
				}
				System.out.println("타입이름 : " + typeVO.getTname());
				System.out.print("삭제하시겠습니까?");
				sel = scanner.nextLine();
				if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
					success = typeDAO.delete(tcode);
					if(success == true) {
						System.out.println("삭제가 완료되었습니다.");
					} else {
						System.out.println("성적테이블에서 사용중이어서 삭제할 수 없습니다.");
					}
				} else {
					System.out.println("삭제가 취소되었습니다.");
				}
				System.out.println("");
				
				break;
				
			case 5:
				System.out.print("타입 코드 : ");
				tcode = scanner.nextLine();
				typeVO = typeDAO.read(tcode);
				if(typeVO.getTname() == null) {
					System.out.println("해당 코드가 존재하지 않습니다.");
					break;
				}
				System.out.println("타입 이름 : " + typeVO.getTname());
				System.out.println("시험 일자 : " + typeVO.getTdate());
				System.out.println("");
				
				break;
				
			default:
				System.out.println("0~5번 메뉴 중 선택해주세요.\n");
			}
		}
	}
}
