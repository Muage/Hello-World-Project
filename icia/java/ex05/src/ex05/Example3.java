package ex05;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Example3 {
	public static void execute() {
		Scanner s = new Scanner(System.in);	//Ű���� ���� �Է¹ޱ� ���� ��ĳ�� ����
		DecimalFormat df = new DecimalFormat("#,###��");	//������ ����� df�� ����
		DecimalFormat df2 = new DecimalFormat("#,###��");
		
		boolean run = true;
		
		String[] product = new String[100];
		int[] price = new int[100];
		int[] qnt = new int[100];
		
		int num = 0;
		
		while(run) {
			
			System.out.println("");
			System.out.println("---------------------------------------------");
			System.out.println("1. ��ǰ ��� | 2. ��ǰ �˻� | 3. ���� ��Ȳ | 0. ����");
			System.out.println("---------------------------------------------");
			
			System.out.print("���� > ");
			int menu = s.nextInt();
			
			switch(menu) {
			case 1:
				System.out.print("��ǰ�� > ");
				product[num] = s.next();
				
				System.out.print("�ܰ� > ");
				price[num] = s.nextInt();
				
				System.out.print("�Ǹż��� > ");
				qnt[num] = s.nextInt();
				
				num++;	//num = num + 1;
				System.out.println(num + " �� ��ǰ�� ��� �Ǿ����ϴ�.");
				
				break;
				
			case 2:
				System.out.print("��ǰ�� > ");
				String sproduct = s.next();
				
				boolean find = false;
				
				for(int i=0; i<num; i++) {
					if(sproduct.equals(product[i])) {
						find = true;
						
						int sum = price[i] * qnt[i];
						
						String strPrice = df.format(price[i]);
						String strQnt = df2.format(qnt[i]);
						String srtSum = df.format(sum);
						
						System.out.println("�ܰ�   \t�Ǹż���   \t�ݾ�");
						System.out.println(strPrice + "   \t" + strQnt + "   \t" + srtSum); 
					}
				}
				
				break;
				
			case 3:
				System.out.println("*************** ���� ��Ȳ ***************");
				System.out.println("��ǰ��   \t�ܰ�   \t�Ǹż���   \t�ݾ�");
				
				for(int i=0; i<num; i++) {
					int sum = price[i] * qnt[i];
					
					String strPrice = df.format(price[i]);
					String strQnt = df2.format(qnt[i]);
					String srtSum = df.format(sum);
					
					System.out.println(product[i] + "   \t" + strPrice + "   \t" + strQnt + "   \t" + srtSum);
				}
				
				break;
				
			case 0:
				run = false;
				System.out.println("���α׷��� ����˴ϴ�.");
				
				break;
				
			default:
				System.out.println("0~3�� �޴��� �������ּ���.");
			}
		}
		
	}
}