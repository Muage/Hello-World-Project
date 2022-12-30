package ex04;

import java.util.*;

public class Example4 {
	public static void execute() {
		
		Scanner s = new Scanner(System.in);
		ArrayList<Student> arrStudent = new ArrayList<>();
		ArrayList<Score> arrScore = new ArrayList<>();
		
		boolean run = true;
		int no = 100;
		
		Student student = new Student();
		student.setNo(no);
		student.setName("홍길동");
		student.setAvg(90);
		arrStudent.add(student);
		
		//홍길동 성적
		Score score = new Score();
		score.setNo(no);
		score.setType("중간");
		score.setGrade(90);
		arrScore.add(score);

		score = new Score();
		score.setNo(no);
		score.setType("기말");
		score.setGrade(90);
		arrScore.add(score);
		
		no = no + 100;
		student = new Student();
		student.setNo(no);
		student.setName("심청이");
		student.setAvg(80);
		arrStudent.add(student);
		
		
		System.out.println("********** 성 적 관 리 **********");
		
		while(run == true) {
			System.out.println("---------------------------------");
			System.out.println("1. 성적등록 | 2. 성적검색 | 0. 종료");
			System.out.println("---------------------------------");
			System.out.print("선택 > ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("프로그램이 종료됩니다.\n");
				
				break;
				
			case 1:
				boolean find = false;
				
				System.out.print("학번 : ");
				int sno = s.nextInt(); s.nextLine();
		
				
				for(Student stu:arrStudent){
					if(sno == stu.getNo()) {	//학생 학번을 찾으면
						find = true;
						int sum = 0;
						int count = 0;
						
						System.out.println("학생명 : " + stu.getName());
						System.out.println("평균 : " + stu.getAvg());
						
						//성적목록
						System.out.println("---------------------------------");
						System.out.println("구분\t점수");
						System.out.println("---------------------------------");
						
						for(Score sco:arrScore) {
							if(sno == sco.getNo()) {
								System.out.printf("%s\t%d\n", sco.getType(), sco.getGrade());
								count++;
								sum = sum + sco.getGrade();
							}
						}
						System.out.println("");
						
						//성적입력
						System.out.print("구분 : ");
						String type = s.nextLine();
						
						System.out.print("점수 : ");
						int grade = s.nextInt(); s.nextLine();
						
						score = new Score();
						score.setNo(sno);
						score.setType(type);
						score.setGrade(grade);
						arrScore.add(score);
						
						//평균 업데이트
						sum = sum + grade;
						double avg = (double)sum/(count+1);
						stu.setAvg(avg);
						System.out.println("성적이 등록되었습니다.");
						
					}
				}
				if(find == false) {
					System.out.println(sno + "번에 해당하는 학생이 없습니다.\n");
				}
				
				break;
				
			case 2:
				find = false;
				
				System.out.print("학번 : ");
				sno = s.nextInt(); s.nextLine();
		
				
				for(Student stu:arrStudent){
					if(sno == stu.getNo()) {	//학생 학번을 찾으면
						find = true;
						System.out.println("학생명 : " + stu.getName());
						System.out.println("평균 : " + stu.getAvg());
						
						//성적목록
						System.out.println("---------------------------------");
						System.out.println("구분\t점수");
						System.out.println("---------------------------------");
						for(Score sco:arrScore) {
							if(sno == sco.getNo()) {
								System.out.printf("%s\t%d\n", sco.getType(), sco.getGrade());
							}
						}
						System.out.println("");
					}
				}
				if(find == false) {
					System.out.println(sno + "번에 해당하는 학생이 없습니다.\n");
				}
				
				break;
				
			default:
				System.out.println("0~2번 메뉴 중 선택하세요.\n");
			}
		}
	}
}
