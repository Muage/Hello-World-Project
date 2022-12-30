package ex10;

import java.util.*;

public class Example2 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		ArrayList<ScoreVO> array = new ArrayList<>();
		boolean run = true;
		ScoreDAO dao = new ScoreDAOImpl();
		int no = 400;
		
		ScoreVO vo = new ScoreVO();
		vo.setNo(100);
		vo.setName("홍길동");
		vo.setGrade(90);
		array.add(vo);
		
		vo = new ScoreVO();
		vo.setNo(200);
		vo.setName("심청이");
		vo.setGrade(100);
		array.add(vo);
		
		vo = new ScoreVO();
		vo.setNo(300);
		vo.setName("강감찬");
		vo.setGrade(100);
		array.add(vo);
		
		array = dao.list(no, array);	//전체데이터 초기화
		vo = null;
		
		while(run) {
			System.out.println("---------------------------------------------");
			System.out.println("1.등록 | 2.검색 | 3.목록 | 4.수정 | 5.삭제 | 0.종료");
			System.out.println("---------------------------------------------");
			
			System.out.print("선택 : ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("프로그램을 종료합니다.\n");
				
				break;
				
			case 1:
				System.out.println("번호 : " + no);
				vo = new ScoreVO();
				vo.setNo(no);
				System.out.print("이름 : ");
				vo.setName(s.nextLine());
				
				System.out.print("점수 : ");
				vo.setGrade(s.nextInt()); s.nextLine();
				
				dao.insert(vo, array);
				System.out.println(no + "번의 성적이 등록되었습니다.\n");
				
				no = no + 100;
				
				break;
				
			case 2:
				System.out.print("검색할 번호 : ");
				int sno = s.nextInt(); s.nextLine();
				vo = dao.read(sno, array);
				if(vo.getName() == null) {
					System.out.println("등록된 번호가 없습니다.\n");
				} else {
					System.out.println(vo.toString());
				}
				
				break;
				
			case 3:
				for(ScoreVO v : array) {
					System.out.println(v.toString());
				}
				System.out.println("");
				
				break;
				
			case 4:
				System.out.print("수정할 번호 : ");
				int uno = s.nextInt(); s.nextLine();
				
				vo = dao.read(uno, array);
				if(vo.getName() == null) {
					System.out.println("수정할 번호가 없습니다.\n");
				} else {
					System.out.print(vo.getName() + " > ");
					String newName = s.nextLine();
					
					System.out.print(vo.getGrade() + " > ");
					String newGrade = s.nextLine();
					
					if(!newName.equals("")) vo.setName(newName);
					if(!newGrade.equals("")) vo.setGrade(Integer.parseInt(newGrade));
					
					dao.update(vo, array);
					System.out.println(uno + "번의 성적이 수정되었습니다.\n");
				}
				
				break;
				
			case 5:
				System.out.print("삭제할 번호 : ");
				int dno = s.nextInt(); s.nextLine();
				vo = dao.read(dno, array);
				if(vo.getName() == null) {
					System.out.println("삭제할 번호가 없습니다.\n");
				} else {
					dao.delete(dno, array);
					System.out.println(dno + "번의 성적이 삭제되었습니다.\n");
				}
				
				break;
				
			default:
				System.out.println("0~5번 메뉴 중 선택하세요.");
				
			}
		}
	}
}
