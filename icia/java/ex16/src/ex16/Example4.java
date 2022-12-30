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
		
		System.out.println("************* �� �� �� �� *************");
		while(run) {
			System.out.println("������������������������������������������������������������������������");
			System.out.println("1.������ȸ �� 2.�����Է� �� 3.�������� �� 0.����");
			System.out.println("������������������������������������������������������������������������");
			
			int menu = Main.input("����");
			switch(menu) {
			case 0:
				run = false;
				System.out.println("���θ޴��� �̵��մϴ�.\n");
				
				break;
				
			case 1:
				System.out.print("��ȸ�� �й� : ");
				sno = scanner.nextLine();
				if(sno.equals("")) {
					System.out.println("���� ��ȸ�� ��ҵǾ����ϴ�.\n");
					break;
				}
				studentVO = studentDAO.read(sno);
				if(studentVO.getSname() == null) {
					System.out.println("�ش� �л��� �������� �ʽ��ϴ�.\n");
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
				System.out.print("����� �й� : ");
				sno = scanner.nextLine();
				if(sno.equals("")) {
					System.out.println("���� ����� ��ҵǾ����ϴ�.\n");
					break;
				}
				studentVO = studentDAO.read(sno);
				if(studentVO.getSname() == null) {
					System.out.println("�ش� �л��� �������� �ʽ��ϴ�.\n");
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
					System.out.print("���� ���� : ");
					tcode = scanner.nextLine();
					if(tcode.equals("")) break;
					
					count = scoreDAO.read(sno, tcode);
					if(count == 1) break;
					
					typeVO = typeDAO.read(tcode);
					if(typeVO.getTname() != null) isFind = true;
					if(isFind == false) System.out.println("���� ������ Ȯ�����ּ���.");
				} while(isFind == false);
				
				if(tcode.equals("")) {
					System.out.println("���� ����� ��ҵǾ����ϴ�.\n");
					break;
				}
				
				if(count == 1) {
					System.out.println("�̹� ��ϵ� �����Դϴ�.\n");
					break;
				}
				
				grade = Main.input("����");
				scoreVO = new ScoreVO();
				scoreVO.setSno(sno);
				scoreVO.setTcode(tcode);
				scoreVO.setGrade(grade);
				scoreDAO.insert(scoreVO);
				System.out.println("���� ����� �Ϸ�Ǿ����ϴ�.\n");
				
				break;
				
			case 3:
				System.out.print("������ �й� : ");
				sno = scanner.nextLine();
				studentVO = studentDAO.read(sno);
				if(studentVO.getSname() == null) {
					System.out.println("�ش� �л��� �������� �ʽ��ϴ�.\n");
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
					System.out.print("������ ���� : ");
					tcode = scanner.nextLine();
					if(tcode.equals("")) break;
					count = scoreDAO.read(sno, tcode);
					if(count == 0) System.out.println("������ �����Ͱ� �����ϴ�.\n");
					else break;
				} while(true);
				
				if(tcode.equals("")) {
					System.out.println("������ ��ҵǾ����ϴ�.\n");
					break;
				}
				
				System.out.print("�����Ͻðڽ��ϱ�?");
				sel = scanner.nextLine();
				if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
					scoreDAO.delete(sno, tcode);
					System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.\n");
				} else {
					System.out.println("������ ��ҵǾ����ϴ�.\n");
				}
				
				break;
				
			default:
				System.out.println("0~3�� �޴� �� �������ּ���.\n");
			}
		}
	}
}
