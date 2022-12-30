package ex09;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Example5 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		File file = new File("C:/data/java/score.txt");
		
		boolean run = true;
		
		while(run == true) {
			System.out.println("-------------------------------------------");
			System.out.println("1.�������|2.�����˻�|3.�������|4.��������|0.����");
			System.out.println("-------------------------------------------");
			System.out.print("���� > ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("���α׷��� ����˴ϴ�.\n");
				
				break;
				
			case 1:
				try {
					FileWriter writer = new FileWriter(file, true);
					
					Score score = new Score();
					
					System.out.print("�̸� : ");
					score.setName(s.nextLine());
					
					System.out.print("���� : ");
					score.setKor(s.nextInt()); s.nextLine();
					
					System.out.print("���� : ");
					score.setEng(s.nextInt()); s.nextLine();
					
					System.out.print("���� : ");
					score.setMat(s.nextInt()); s.nextLine();
					
					writer.write(score.getName() + "|" + score.getKor() + "|" + score.getEng() + "|" + score.getMat() + "\n");
					writer.flush();
					writer.close();
					
					System.out.println("������ ��ϵǾ����ϴ�.");
					
				} catch (Exception e) {}
				
				break;
				
			case 2:
				System.out.print("�˻��� �̸� : ");
				String sname = s.nextLine();
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line = "";
					boolean find = false;
					while((line = reader.readLine()) != null) {
						StringTokenizer st = new StringTokenizer(line, "|");
						Score score = new Score();
						score.setName(st.nextToken());
						score.setKor(Integer.parseInt(st.nextToken()));
						score.setEng(Integer.parseInt(st.nextToken()));
						score.setMat(Integer.parseInt(st.nextToken()));
						if(sname.equals(score.getName())) {
							find = true;
							score.printList();
						}
					}
					if(find == false) {
						System.out.println("�ش� �л��� ������ �����ϴ�.");
					}
				} catch(Exception e) {}
				
				break;
				
			case 3:
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line = "";
					while((line = reader.readLine()) != null) {
						StringTokenizer st = new StringTokenizer(line, "|");
						
						Score score = new Score();
						score.setName(st.nextToken());
						score.setKor(Integer.parseInt(st.nextToken()));
						score.setEng(Integer.parseInt(st.nextToken()));
						score.setMat(Integer.parseInt(st.nextToken()));						
						score.printList();
						
					}
				} catch(Exception e) {}
				
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
						StringTokenizer st = new StringTokenizer(line, "|");
						Score score = new Score();
						score.setName(st.nextToken());
						score.setKor(Integer.parseInt(st.nextToken()));
						score.setEng(Integer.parseInt(st.nextToken()));
						score.setMat(Integer.parseInt(st.nextToken()));		
						
						if(dname.equals(score.getName())) {	//������ �̸� ���� ���� ��
							find = true;
						} else {
							//strLine = strLine + score.getName() + "|";
							strLine += score.getName() + "|";
							strLine += score.getKor() + "|";
							strLine += score.getEng() + "|";
							strLine += score.getMat() + "\n";
						}
					}
					if(find == false) {
						System.out.println(dname + "�� ���� ������ �������� �ʽ��ϴ�.");
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
