package ex06;

import java.util.*;

public class Example2 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		
		boolean run = true;
		ArrayList<Car> cars = new ArrayList<>();

		Car car = new Car("���", "K7", 250);
		cars.add(car);
		
		car = new Car("���", "K5", 200);
		cars.add(car);
		
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
				System.out.print("ȸ��� > ");
				String company = s.next(); s.nextLine();
				
				System.out.print("�𵨸� > ");
				String model = s.next(); s.nextLine();
				
				System.out.print("�ִ�ӵ� > ");
				int maxSpeed = s.nextInt(); s.nextLine();
				
				car = new Car(company, model, maxSpeed);
				cars.add(car);
				System.out.println("���� ������ " + cars.size() + "�� ��ϵǾ� �ֽ��ϴ�.\n");
				
				break;
				
			case 2:
				System.out.print("�𵨸� > ");
				String smodel = s.next(); s.nextLine();
				
				boolean find = false;
				
				for(Car c:cars) {
					if(smodel.equals(c.model)) {
						c.infoPrint();
						find = true;
					}
				}
				
				if(find == false) {
					System.out.println("��ϵ� ������ �ƴմϴ�.\n");
				}
				
				break;
				
			case 3:
				for(Car c:cars) {
//				for(int i=0; i<cars.size(); i++) {
//					Car c = cars.get(i);
					System.out.println(c.company + "\t" + c.model + "\t" + c.maxSpeed);
				}
				
				break;
				
			case 4:
				System.out.print("������ �𵨸� : ");
				String dmodel = s.next(); s.nextLine();
				
				find = false;

				for(Car c:cars) {
					if(dmodel.equals(c.model)) {
						find = true;
						c.infoPrint();
						
						System.out.println("�����Ͻðڽ��ϱ�?(Y)?");
						String sel = s.next(); s.nextLine();
						
						if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
							cars.remove(c);
							System.out.println("������ �Ϸ�Ǿ����ϴ�.");
							System.out.println("���� ������ " + cars.size() + "�� ��ϵǾ� �ֽ��ϴ�.\n");
							break;
						}
					}
				}
				if(find == false) {
					System.out.println("��ϵ� ������ �ƴմϴ�.\n");
				}
				
				break;
				
			case 5:
				System.out.print("������ �𵨸� : ");
				String umodel = s.next(); s.nextLine();
				
				find = false;

				for(Car c:cars) {
					if(umodel.equals(c.model)) {
						find = true;
						
						System.out.print(c.company + " > ");
						String ncompany = s.nextLine();
						
						System.out.print(c.model + " > ");
						String nmodel = s.nextLine();
						
						System.out.print(c.maxSpeed + " > ");
						String nmaxSpeed = s.nextLine();
						
						
						System.out.println("�����Ͻðڽ��ϱ�?(Y)?");
						String sel = s.next(); s.nextLine();
						
						if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
							//if�� ó���� ������ �ϳ��� {} ���� ����
							if(!ncompany.equals("")) c.company = ncompany;
							
							if(!nmodel.equals("")) c.model = nmodel;
							
							if(!nmaxSpeed.equals("")) c.maxSpeed = Integer.parseInt(nmaxSpeed);
							
							System.out.println("");
							
							c.infoPrint();
							System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
						}
						
						System.out.println("��ü ���� ����� Ȯ���Ͻðڽ��ϱ�?(Y)?");
						String yes = s.next(); s.nextLine();
						
						if(yes.equals("Y") || yes.equals("y") || yes.equals("��")) {
							System.out.println("ȸ��\t��\t�ִ�ӵ�");
							for(Car r:cars) {
								System.out.println(r.company + "\t" + r.model + "\t" + r.maxSpeed);
							}
						}
							break;
					}
				}
				if(find == false) {
					System.out.println("��ϵ� ������ �ƴմϴ�.\n");
				}
				
				break;
			
			default:
				System.out.println("0~3�� �޴��� �����ϼ���.\n");
			}
		}
	}
}
