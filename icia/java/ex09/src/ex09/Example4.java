package ex09;

import java.io.*;
import java.util.*;

public class Example4 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		
		File file = new File("c://data/java/address.txt");
		
		boolean run = true;
		
		while(run == true) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1. �ּҵ�� | 2. �ּҰ˻� | 3. �ּҸ�� | 4. �ּһ��� | 0. ����");
			System.out.println("-----------------------------------------------------");
			System.out.print("���� > ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("���α׷��� ����˴ϴ�.\n");
				
				break;
				
			case 1:
				Address add = new Address();
				
				System.out.print("�̸� : ");
				add.setName(s.nextLine());
				
				System.out.print("��ȭ : ");
				add.setTel(s.nextLine());
				
				System.out.print("�ּ� : ");
				add.setJuso(s.nextLine());
				
				try {
					FileWriter writer = new FileWriter(file, true);
					writer.write(add.getName() + " | " + add.getTel() + " | " + add.getJuso() + "\n");
					writer.flush();
					writer.close();
					System.out.println("�ּҰ� ��ϵǾ����ϴ�.\n");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				

				break;

			case 2:
				System.out.print("�˻��� �̸� : ");
				String sname = s.nextLine();
				
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line = "";
					boolean find = false;
					while((line = reader.readLine()) != null) {
						StringTokenizer st = new StringTokenizer(line, " | ");
						add = new Address();
						add.setName(st.nextToken());
						add.setTel(st.nextToken());
						add.setJuso(st.nextToken());

						if(sname.equals(add.getName())) {
							find = true;
							add.printList();
						}
					}
					if(find == false) {
						System.out.println("��ġ�ϴ� ������ �����ϴ�.\n");
					}
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
				
			case 3:
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line = "";
					while((line = reader.readLine()) != null) {
						StringTokenizer st = new StringTokenizer(line, " | ");
						add = new Address();
						add.setName(st.nextToken());
						add.setTel(st.nextToken());
						add.setJuso(st.nextToken());
						add.printList();
					}
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
				
			case 4:
				System.out.print("������ �̸� : ");
				String dname = s.nextLine();
				
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					
					String line = "";
					String strLine = "";
					boolean find = false;
					
					while((line = reader.readLine()) != null) {
						StringTokenizer st = new StringTokenizer(line, " | ");
						add = new Address();
						add.setName(st.nextToken());
						add.setTel(st.nextToken());
						add.setJuso(st.nextToken());
						
						if(dname.equals(add.getName())) {	//������ �̸� ���� ���� ��
							find = true;
						} else {
							//strLine = strLine + score.getName() + "|";
							strLine += add.getName() + "|";
							strLine += add.getTel() + "|";
							strLine += add.getJuso() + "\n";
						}
					}
					
					if(find == false) {
						System.out.println(dname + "�� �ּҰ� �������� �ʽ��ϴ�.");
					} else {
						System.out.print("�����Ͻðڽ��ϱ�? ( �� : Y )");
						String sel = s.nextLine();
						if (sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
							FileWriter writer = new FileWriter(file, false);
							writer.write(strLine);
							writer.flush();
							writer.close();
							System.out.println(dname + "�� ������ �����Ǿ����ϴ�.");
						}
					}
				} catch(Exception e) {}

				break;
				
			default:

				System.out.println("0~3�� �޴� �� �����ϼ���.\n");
				
			}
		}
	}
}
