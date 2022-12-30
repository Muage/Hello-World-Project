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
		student.setName("ȫ�浿");
		student.setDept("����");
		students.add(student);
		
		Score score = new Score();
		score.setNo(no);
		score.setType("�߰�");
		score.setKor(90);
		score.setEng(90);
		score.setMat(90);
		scores.add(score);
		
		score = new Score();
		score.setNo(no);
		score.setType("�⸻");
		score.setKor(95);
		score.setEng(95);
		score.setMat(95);
		scores.add(score);
		
		boolean run = true;
						
		while(run == true) {
			System.out.println("------------------------------------------");
			System.out.println("1. �л���� | 2. �л��˻� | 3. ������� | 0. ����");
			System.out.println("------------------------------------------");
			System.out.print("���� > ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("���α׷��� ����Ǿ����ϴ�.");
				
				break;
				
			case 1:
				no++;
				
				student = new Student();
				System.out.println("�й� : " + no);
				student.setNo(no);
				
				System.out.print("�̸� : ");
				student.setName(s.nextLine());
				
				System.out.print("�а� : ");
				student.setDept(s.nextLine());
				
				System.out.print("���� : ");
				score.setKor(s.nextInt());
				
				System.out.print("���� : ");
				score.setEng(s.nextInt());
				
				System.out.print("���� : ");
				score.setMat(s.nextInt());
				
				
//				boolean find = false;
//				
//				System.out.print("����� �л��� �й��� �Է��ϼ���. : ");
//				int cno = s.nextInt(); s.nextLine();
//				
//				for(Student stu : students) {
//					if(cno == stu.getNo()) {
//						find = true;
//						
//						System.out.printf(cno + "�� �л��� �̹� ��ϵǾ� �ֽ��ϴ�.\n");
//						System.out.println("");
//						System.out.printf("%d�� %s(%s)\n", stu.getNo(), stu.getName(), stu.getDept());
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
//					System.out.print("�̸� : ");
//					String name = s.nextLine();
//					student.setName(s.nextLine());
//					
//					System.out.print("�а� : ");
//					String dept = s.nextLine();
//					student.setDept(s.nextLine());
//					
//					System.out.print("���� : ");
//					String type = s.nextLine();
//					score.setType(type);
//										
//					System.out.print("���� : ");
//					int kor = s.nextInt(); s.nextLine();
//					score.setKor(kor);
//										
//					System.out.print("���� : ");
//					int eng = s.nextInt(); s.nextLine();
//					score.setEng(eng);
//										
//					System.out.print("���� : ");
//					int mat = s.nextInt(); s.nextLine();
//					score.setMat(mat);
//					
					students.add(student);
					scores.add(score);
					System.out.println(no + "�� �л��� ������ ��ϵǾ����ϴ�.");
//					System.out.println(cno + "�� �л��� ������ ��ϵǾ����ϴ�.");
				
				
				break;
				
			case 2:
				boolean find = false;
				
				System.out.print("�˻��� �й��� �Է��ϼ���. : ");
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
					System.out.println(sno + "�� �л��� ������ �����ϴ�.\n");
				}
				
				break;
				
			case 3:
				find = false;
				
				System.out.print("������ ����� �й��� �Է��ϼ���. : ");
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
						
						System.out.print("���� : ");
						String type = s.nextLine();
						score.setType(type);
						
						System.out.print("���� : ");
						int kor = s.nextInt(); s.nextLine();
						score.setKor(kor);
						
						System.out.print("���� : ");
						int eng = s.nextInt(); s.nextLine();
						score.setEng(eng);
						
						System.out.print("���� : ");
						int mat = s.nextInt(); s.nextLine();
						score.setMat(mat);
						
						scores.add(score);
						System.out.println(sno + "�� �л��� ������ ��ϵǾ����ϴ�.");
						
					}
				}
				if(find == false) {
					System.out.println(sno + "�� �л��� ������ �����ϴ�.\n");
				}
				
				break;
				
			default:
				System.out.println("0~3�� �޴� �� �������ּ���.\n");
			}
		}
	}
}
