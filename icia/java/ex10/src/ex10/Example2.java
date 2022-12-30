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
		vo.setName("ȫ�浿");
		vo.setGrade(90);
		array.add(vo);
		
		vo = new ScoreVO();
		vo.setNo(200);
		vo.setName("��û��");
		vo.setGrade(100);
		array.add(vo);
		
		vo = new ScoreVO();
		vo.setNo(300);
		vo.setName("������");
		vo.setGrade(100);
		array.add(vo);
		
		array = dao.list(no, array);	//��ü������ �ʱ�ȭ
		vo = null;
		
		while(run) {
			System.out.println("---------------------------------------------");
			System.out.println("1.��� | 2.�˻� | 3.��� | 4.���� | 5.���� | 0.����");
			System.out.println("---------------------------------------------");
			
			System.out.print("���� : ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("���α׷��� �����մϴ�.\n");
				
				break;
				
			case 1:
				System.out.println("��ȣ : " + no);
				vo = new ScoreVO();
				vo.setNo(no);
				System.out.print("�̸� : ");
				vo.setName(s.nextLine());
				
				System.out.print("���� : ");
				vo.setGrade(s.nextInt()); s.nextLine();
				
				dao.insert(vo, array);
				System.out.println(no + "���� ������ ��ϵǾ����ϴ�.\n");
				
				no = no + 100;
				
				break;
				
			case 2:
				System.out.print("�˻��� ��ȣ : ");
				int sno = s.nextInt(); s.nextLine();
				vo = dao.read(sno, array);
				if(vo.getName() == null) {
					System.out.println("��ϵ� ��ȣ�� �����ϴ�.\n");
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
				System.out.print("������ ��ȣ : ");
				int uno = s.nextInt(); s.nextLine();
				
				vo = dao.read(uno, array);
				if(vo.getName() == null) {
					System.out.println("������ ��ȣ�� �����ϴ�.\n");
				} else {
					System.out.print(vo.getName() + " > ");
					String newName = s.nextLine();
					
					System.out.print(vo.getGrade() + " > ");
					String newGrade = s.nextLine();
					
					if(!newName.equals("")) vo.setName(newName);
					if(!newGrade.equals("")) vo.setGrade(Integer.parseInt(newGrade));
					
					dao.update(vo, array);
					System.out.println(uno + "���� ������ �����Ǿ����ϴ�.\n");
				}
				
				break;
				
			case 5:
				System.out.print("������ ��ȣ : ");
				int dno = s.nextInt(); s.nextLine();
				vo = dao.read(dno, array);
				if(vo.getName() == null) {
					System.out.println("������ ��ȣ�� �����ϴ�.\n");
				} else {
					dao.delete(dno, array);
					System.out.println(dno + "���� ������ �����Ǿ����ϴ�.\n");
				}
				
				break;
				
			default:
				System.out.println("0~5�� �޴� �� �����ϼ���.");
				
			}
		}
	}
}
