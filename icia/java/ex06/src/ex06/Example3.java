package ex06;

import java.util.*;

public class Example3 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		ArrayList<Grade> grades = new ArrayList<>();
		
		Grade grade = new Grade("ȫ�浿", 98, 94, 87);
		grades.add(grade);
		
		grade = new Grade("��û��", 98, 88, 77);
		grades.add(grade);
		
		System.out.println("******************** �� �� �� �� ********************");
		
		boolean run = true;
		
		while(run) {
			System.out.println("---------------------------------------------------");
			System.out.println("1. ��� | 2. �˻� | 3. ��� | 4. ���� | 5. ���� | 0. ����");
			System.out.println("---------------------------------------------------");
			System.out.print("���� > ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("���α׷��� �����մϴ�.\n");
				
				break;
				
			case 1:
				System.out.println("�̸� : ");
				String name = s.nextLine();
				System.out.println("���� : ");
				String kor = s.nextLine();
				System.out.println("���� : ");
				String eng = s.nextLine();
				System.out.println("���� : ");
				String mat = s.nextLine();
				
				int intKor = Integer.parseInt(kor);
				int intEng = Integer.parseInt(eng);
				int intMat = Integer.parseInt(mat);
				Grade grade2 = new Grade(name, intKor, intEng, intMat);
				grades.add(grade2);
				
				System.out.println("���� �� " + grades.size() + "���� �л��� ��ϵǾ� �ֽ��ϴ�.\n");
				
				break;
				
			case 2:
				System.out.print("�˻��� �л��� �̸� : ");
				String sname = s.nextLine();
				
				boolean find = false;
				
				for(Grade g:grades) {
					if(sname.equals(g.name)) {
						find = true;
						g.print();
					}
				}
				if(find == false) {
					System.out.println(sname + " �л��� ���� �˻������ �����ϴ�.\n");
				}
				
				break;
				
			case 3:
				for(Grade g:grades) {
					g.printList();
					System.out.println("---------------------------------------------------");
				}
				
				break;
				
			case 4:
				System.out.print("������ �л��� �̸� : ");
				String dname = s.nextLine();
				
				find = false;
				
				for(Grade g:grades) {
					if(dname.equals(g.name)) {
						find = true;
						g.print();
						
						System.out.println("�����Ͻðڽ��ϱ�? (�� : Y)");
						String sel = s.nextLine();
						
						if(sel.equals("Y") || sel.equals("y") || sel.equals("��") ) {
							grades.remove(g);
							System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
							break;
						}
					}
				}
				if(find == false) {
					System.out.println(dname + " �л��� ���� �˻������ �����ϴ�.\n");
				}
				
				break;
				
			case 5:
				System.out.print("������ �л��� �̸� : ");
				String uname = s.nextLine();
				
				find = false;
				
				for(Grade g:grades) {
					if(uname.equals(g.name)) {
						find = true;
						
						System.out.print("�л� �̸� : " + g.name + " > ");
						name = s.nextLine();
						
						System.out.print("���� ���� : " + g.kor + " > ");
						kor = s.nextLine();
						
						System.out.print("���� ���� : " + g.eng + " > ");
						eng = s.nextLine();
						
						System.out.print("���� ���� : " + g.mat + " > ");
						mat = s.nextLine();
						
						System.out.println(uname + " �л��� ������ �����Ͻðڽ��ϱ�? (�� : Y)");
						String sel = s.nextLine();
						
						if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
							if(!name.equals("")) g.name = name;
							if(!kor.equals("")) g.kor = Integer.parseInt(kor);
							if(!eng.equals("")) g.eng = Integer.parseInt(eng);
							if(!mat.equals("")) g.mat = Integer.parseInt(mat);
							g.print();
							System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
							break;
						}
					}
				}
				if(find == false) {
					System.out.println(uname + " �л��� ���� �˻������ �����ϴ�.\n");
				}
				
				break;
				
			default:
				System.out.println("0~5�� �޴��� �������ּ���.\n");
			}
		}
	}
}
