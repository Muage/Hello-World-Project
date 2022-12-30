package ex07;

import java.util.*;

public class Example6 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		ArrayList<Student> students = new ArrayList<>();
		ArrayList<Score> scores = new ArrayList<>();
		
		int no = 10;
		Student student = new Student();
		student.setNo(no);
		student.setName("홍길동");
		student.setDept("컴정");
		students.add(student);
		
		Score score = new Score();
		score.setNo(no);
		score.setType("중간");
		score.setKor(90);
		score.setEng(90);
		score.setMat(90);
		scores.add(score);
		
		score = new Score();
		score.setNo(no);
		score.setType("기말");
		score.setKor(95);
		score.setEng(95);
		score.setMat(95);
		scores.add(score);
		
		boolean run = true;
						
		while(run == true) {
			System.out.println("------------------------------------------");
			System.out.println("1. 학생등록 | 2. 학생검색 | 3. 성적등록 | 0. 종료");
			System.out.println("------------------------------------------");
			System.out.print("선택 > ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("프로그램이 종료되었습니다.");
				
				break;
				
			case 1:
				no++;
				
				student = new Student();
				System.out.println("학번 : " + no);
				student.setNo(no);
				
				System.out.print("이름 : ");
				student.setName(s.nextLine());
				
				System.out.print("학과 : ");
				student.setDept(s.nextLine());
				
				System.out.print("국어 : ");
				score.setKor(s.nextInt());
				
				System.out.print("영어 : ");
				score.setEng(s.nextInt());
				
				System.out.print("수학 : ");
				score.setMat(s.nextInt());
				
				
//				boolean find = false;
//				
//				System.out.print("등록할 학생의 학번을 입력하세요. : ");
//				int cno = s.nextInt(); s.nextLine();
//				
//				for(Student stu : students) {
//					if(cno == stu.getNo()) {
//						find = true;
//						
//						System.out.printf(cno + "번 학생은 이미 등록되어 있습니다.\n");
//						System.out.println("");
//						System.out.printf("%d번 %s(%s)\n", stu.getNo(), stu.getName(), stu.getDept());
//						for(Score sco : scores) {
//							if(cno == sco.getNo()) {
//								System.out.printf("%s\t%d\t%d\t%d\n", sco.getType(), sco.getKor(), sco.getEng(), sco.getMat());
//							}
//						}
//					}
//				}
//				if(find == false) {
//					score = new Score();
//					score.setNo(cno);
//					
//					student = new Student();
//					
//					System.out.print("이름 : ");
//					String name = s.nextLine();
//					student.setName(s.nextLine());
//					
//					System.out.print("학과 : ");
//					String dept = s.nextLine();
//					student.setDept(s.nextLine());
//					
//					System.out.print("구분 : ");
//					String type = s.nextLine();
//					score.setType(type);
//										
//					System.out.print("국어 : ");
//					int kor = s.nextInt(); s.nextLine();
//					score.setKor(kor);
//										
//					System.out.print("영어 : ");
//					int eng = s.nextInt(); s.nextLine();
//					score.setEng(eng);
//										
//					System.out.print("수학 : ");
//					int mat = s.nextInt(); s.nextLine();
//					score.setMat(mat);
//					
					students.add(student);
					scores.add(score);
					System.out.println(no + "번 학생의 성적이 등록되었습니다.");
//					System.out.println(cno + "번 학생의 성적이 등록되었습니다.");
				
				
				break;
				
			case 2:
				boolean find = false;
				
				System.out.print("검색할 학번을 입력하세요. : ");
				int sno = s.nextInt(); s.nextLine();
				
				for(Student stu : students) {
					if(sno == stu.getNo()) {
						find = true;
						
						System.out.printf("%s(%s)\n", stu.getName(), stu.getDept());
						
						for(Score sco : scores) {
							if(sno == sco.getNo()) {
								System.out.printf("%s\t%d\t%d\t%d\n", sco.getType(), sco.getKor(), sco.getEng(), sco.getMat());	
							}
						}
					}
				}
				if(find == false) {
					System.out.println(sno + "번 학생의 정보가 없습니다.\n");
				}
				
				break;
				
			case 3:
				find = false;
				
				System.out.print("성적을 등록할 학번을 입력하세요. : ");
				sno = s.nextInt(); s.nextLine();
				
				for(Student stu : students) {
					if(sno == stu.getNo()) {
						find = true;
						
						System.out.printf("%s(%s)\n", stu.getName(), stu.getDept());
						
						for(Score sco : scores) {
							if(sno == sco.getNo()) {
								System.out.printf("%s\t%d\t%d\t%d\n", sco.getType(), sco.getKor(), sco.getEng(), sco.getMat());	
							}
						}
						
						score = new Score();
						score.setNo(sno);
						
						System.out.print("구분 : ");
						String type = s.nextLine();
						score.setType(type);
						
						System.out.print("국어 : ");
						int kor = s.nextInt(); s.nextLine();
						score.setKor(kor);
						
						System.out.print("영어 : ");
						int eng = s.nextInt(); s.nextLine();
						score.setEng(eng);
						
						System.out.print("수학 : ");
						int mat = s.nextInt(); s.nextLine();
						score.setMat(mat);
						
						scores.add(score);
						System.out.println(sno + "번 학생의 성적이 등록되었습니다.");
						
					}
				}
				if(find == false) {
					System.out.println(sno + "번 학생의 정보가 없습니다.\n");
				}
				
				break;
				
			default:
				System.out.println("0~3번 메뉴 중 선택해주세요.\n");
			}
		}
	}
}
