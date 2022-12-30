package ex05;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Example2 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("###.00");
		
		String[] name = new String[100];
		int[] kor = new int [100];
		int[] eng = new int [100];
		int[] mat = new int [100];
		
		int count = 0;
		
		boolean run = true;
		while(run) {
		
			System.out.println("****************** �������� ******************");
			System.out.println("---------------------------------------------");
			System.out.println("1. ������� | 2. �����˻� | 3. ����ǥ��� | 0. ����");
			System.out.println("---------------------------------------------");
			System.out.print("���� > ");
			int menu = s.nextInt();
			
			switch(menu) {
			case 1:
				System.out.print("�̸� > ");
				name[count] = s.next();
				
				System.out.print("���� > ");
				kor[count] = s.nextInt();
				
				System.out.print("���� > ");
				eng[count] = s.nextInt();
				
				System.out.print("���� > ");
				mat[count] = s.nextInt();
				
				count = count + 1; 
				System.out.println(count + "�� �л��� �ԷµǾ����ϴ�.\n");
				break;
				
			case 2:
				System.out.print("�̸� > ");
				String sname = s.next();	//�˻��� �̸� ����
				
				boolean find = false;
				
				for(int i=0; i<count; i++) {
					if(sname.equals(name[i])) {	//if(sname == name[i])�� �ּҸ� ���ϴ� �����̶� �˻��� �ȵȴ�.
						find = true;
						
						int sum = kor[i] + eng[i] + mat[i];
						double avg = sum / 3.;
						String strAvg = df.format(avg);
						
						System.out.println("����\t����\t����\t����\t���");
						System.out.println(kor[i] + "\t" + eng[i] + "\t" + mat[i] + "\t" + sum + "\t" + strAvg + "\n");
					}
				}
				
				if(find == false) {
					System.out.println("�л��� �������� �ʽ��ϴ�.\n");
				}
				
				break;
				
			case 3:
				
				System.out.println("�̸�\t����\t����\t����\t����\t���");
				for(int i=0; i<count; i++) {
					int sum = kor[i] + eng[i] + mat[i];
					double avg = sum / 3.;
					String strAvg = df.format(avg);
					
					System.out.println(name[i] + "\t" + kor[i] + "\t" + eng[i] + "\t" + mat[i] + "\t" + sum + "\t" + strAvg);
				}
				System.out.println("");
				
				break;
				
			case 0:
				run = false;
				System.out.println("���α׷��� ����˴ϴ�.\n");
				
				break;
				
			default:
				System.out.println("0~3�� �޴��� �������ּ���.\n");
			}
		}
	}
}
