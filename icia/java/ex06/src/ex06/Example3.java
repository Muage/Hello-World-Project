package ex06;

import java.util.*;

public class Example3 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		ArrayList<Grade> grades = new ArrayList<>();
		
		Grade grade = new Grade("홍길동", 98, 94, 87);
		grades.add(grade);
		
		grade = new Grade("심청이", 98, 88, 77);
		grades.add(grade);
		
		System.out.println("******************** 성 적 관 리 ********************");
		
		boolean run = true;
		
		while(run) {
			System.out.println("---------------------------------------------------");
			System.out.println("1. 등록 | 2. 검색 | 3. 목록 | 4. 삭제 | 5. 수정 | 0. 종료");
			System.out.println("---------------------------------------------------");
			System.out.print("선택 > ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("프로그램을 종료합니다.\n");
				
				break;
				
			case 1:
				System.out.println("이름 : ");
				String name = s.nextLine();
				System.out.println("국어 : ");
				String kor = s.nextLine();
				System.out.println("영어 : ");
				String eng = s.nextLine();
				System.out.println("수학 : ");
				String mat = s.nextLine();
				
				int intKor = Integer.parseInt(kor);
				int intEng = Integer.parseInt(eng);
				int intMat = Integer.parseInt(mat);
				Grade grade2 = new Grade(name, intKor, intEng, intMat);
				grades.add(grade2);
				
				System.out.println("현재 총 " + grades.size() + "명의 학생이 등록되어 있습니다.\n");
				
				break;
				
			case 2:
				System.out.print("검색할 학생의 이름 : ");
				String sname = s.nextLine();
				
				boolean find = false;
				
				for(Grade g:grades) {
					if(sname.equals(g.name)) {
						find = true;
						g.print();
					}
				}
				if(find == false) {
					System.out.println(sname + " 학생에 대한 검색결과가 없습니다.\n");
				}
				
				break;
				
			case 3:
				for(Grade g:grades) {
					g.printList();
					System.out.println("---------------------------------------------------");
				}
				
				break;
				
			case 4:
				System.out.print("삭제할 학생의 이름 : ");
				String dname = s.nextLine();
				
				find = false;
				
				for(Grade g:grades) {
					if(dname.equals(g.name)) {
						find = true;
						g.print();
						
						System.out.println("삭제하시겠습니까? (예 : Y)");
						String sel = s.nextLine();
						
						if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ") ) {
							grades.remove(g);
							System.out.println("삭제가 완료되었습니다.\n");
							break;
						}
					}
				}
				if(find == false) {
					System.out.println(dname + " 학생에 대한 검색결과가 없습니다.\n");
				}
				
				break;
				
			case 5:
				System.out.print("수정할 학생의 이름 : ");
				String uname = s.nextLine();
				
				find = false;
				
				for(Grade g:grades) {
					if(uname.equals(g.name)) {
						find = true;
						
						System.out.print("학생 이름 : " + g.name + " > ");
						name = s.nextLine();
						
						System.out.print("국어 점수 : " + g.kor + " > ");
						kor = s.nextLine();
						
						System.out.print("영어 점수 : " + g.eng + " > ");
						eng = s.nextLine();
						
						System.out.print("수학 점수 : " + g.mat + " > ");
						mat = s.nextLine();
						
						System.out.println(uname + " 학생의 정보를 수정하시겠습니까? (예 : Y)");
						String sel = s.nextLine();
						
						if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
							if(!name.equals("")) g.name = name;
							if(!kor.equals("")) g.kor = Integer.parseInt(kor);
							if(!eng.equals("")) g.eng = Integer.parseInt(eng);
							if(!mat.equals("")) g.mat = Integer.parseInt(mat);
							g.print();
							System.out.println("수정이 완료되었습니다.\n");
							break;
						}
					}
				}
				if(find == false) {
					System.out.println(uname + " 학생에 대한 검색결과가 없습니다.\n");
				}
				
				break;
				
			default:
				System.out.println("0~5번 메뉴를 선택해주세요.\n");
			}
		}
	}
}
