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
		student.setName("ȫ�浿");
		student.setAvg(90);
		arrStudent.add(student);
		
		//ȫ�浿 ����
		Score score = new Score();
		score.setNo(no);
		score.setType("�߰�");
		score.setGrade(90);
		arrScore.add(score);

		score = new Score();
		score.setNo(no);
		score.setType("�⸻");
		score.setGrade(90);
		arrScore.add(score);
		
		no = no + 100;
		student = new Student();
		student.setNo(no);
		student.setName("��û��");
		student.setAvg(80);
		arrStudent.add(student);
		
		
		System.out.println("********** �� �� �� �� **********");
		
		while(run == true) {
			System.out.println("---------------------------------");
			System.out.println("1. ������� | 2. �����˻� | 0. ����");
			System.out.println("---------------------------------");
			System.out.print("���� > ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("���α׷��� ����˴ϴ�.\n");
				
				break;
				
			case 1:
				boolean find = false;
				
				System.out.print("�й� : ");
				int sno = s.nextInt(); s.nextLine();
		
				
				for(Student stu:arrStudent){
					if(sno == stu.getNo()) {	//�л� �й��� ã����
						find = true;
						int sum = 0;
						int count = 0;
						
						System.out.println("�л��� : " + stu.getName());
						System.out.println("��� : " + stu.getAvg());
						
						//�������
						System.out.println("---------------------------------");
						System.out.println("����\t����");
						System.out.println("---------------------------------");
						
						for(Score sco:arrScore) {
							if(sno == sco.getNo()) {
								System.out.printf("%s\t%d\n", sco.getType(), sco.getGrade());
								count++;
								sum = sum + sco.getGrade();
							}
						}
						System.out.println("");
						
						//�����Է�
						System.out.print("���� : ");
						String type = s.nextLine();
						
						System.out.print("���� : ");
						int grade = s.nextInt(); s.nextLine();
						
						score = new Score();
						score.setNo(sno);
						score.setType(type);
						score.setGrade(grade);
						arrScore.add(score);
						
						//��� ������Ʈ
						sum = sum + grade;
						double avg = (double)sum/(count+1);
						stu.setAvg(avg);
						System.out.println("������ ��ϵǾ����ϴ�.");
						
					}
				}
				if(find == false) {
					System.out.println(sno + "���� �ش��ϴ� �л��� �����ϴ�.\n");
				}
				
				break;
				
			case 2:
				find = false;
				
				System.out.print("�й� : ");
				sno = s.nextInt(); s.nextLine();
		
				
				for(Student stu:arrStudent){
					if(sno == stu.getNo()) {	//�л� �й��� ã����
						find = true;
						System.out.println("�л��� : " + stu.getName());
						System.out.println("��� : " + stu.getAvg());
						
						//�������
						System.out.println("---------------------------------");
						System.out.println("����\t����");
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
					System.out.println(sno + "���� �ش��ϴ� �л��� �����ϴ�.\n");
				}
				
				break;
				
			default:
				System.out.println("0~2�� �޴� �� �����ϼ���.\n");
			}
		}
	}
}
