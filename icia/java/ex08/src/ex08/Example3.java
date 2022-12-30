package ex08;

import java.text.*;
import java.util.*;

public class Example3 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		ArrayList<Account> array = new ArrayList<>();
		ArrayList<Trans> tarray = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DecimalFormat df = new DecimalFormat("#,###��");
		
		int no = 100;
		boolean run = true;
		
		Account acc = new Account();
		Trans tr = new Trans();		
		
		acc.setNo(no);
		acc.setName("ȫ�浿");
		acc.setBalance(1000);
		acc.setOpenDate(new Date());
		array.add(acc);
		
		tr.setNo(no);
		tr.setType("�Ա�");
		tr.setAmount(1000);
		tr.setDate(new Date());
		tarray.add(tr);
		
		
		no = no + 100;
		acc = new Account();
		acc.setNo(no);
		acc.setName("��û��");
		acc.setBalance(2000);
		acc.setOpenDate(new Date());
		array.add(acc);
		
		tr = new Trans();
		tr.setNo(no);
		tr.setType("�Ա�");
		tr.setAmount(2000);
		tr.setDate(new Date());
		tarray.add(tr);
		
		System.out.println("***************** �� �� �� �� *****************");
		
		while(run == true) {
			System.out.println("------------------------------------------------");
			System.out.println("1. ���»��� | 2. ���¸�� | 3.���� | 4. ��� | 0. ����");
			System.out.println("------------------------------------------------");
			System.out.print("���� > ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("���α׷��� ����˴ϴ�.\n");
				
				break;
				
			case 1:
				no = no + 100;
				System.out.println("���¹�ȣ : " + no);
				acc = new Account();
				acc.setNo(no);
				
				System.out.print("�����ָ� : ");
				acc.setName(s.nextLine());
				
				System.out.print("�ʱ� �Աݾ� : ");
				int balance = s.nextInt(); s.nextLine();
				acc.setBalance(balance);
				
				acc.setOpenDate(new Date());
				array.add(acc);
				System.out.println("���°� �����Ǿ����ϴ�.");
				
				break;
				
			case 2:
				for(Account a:array) {
					String date = sdf.format(a.getOpenDate());
					String sbalance = df.format(a.getBalance());
					System.out.printf("%d\t%s\t%s\t%s\n", a.getNo(), a.getName(), date, sbalance);
				}
				
				break;
				
			case 3:
				System.out.print("���¹�ȣ : ");
				int sno = s.nextInt(); s.nextLine();
				
				boolean find = false;
				
				for(Account a:array) {
					if(sno == a.getNo()) {
						find = true;
						System.out.println("������ : " + a.getName());
						
						String sbalance = df.format(a.getBalance());
						System.out.println("�ܾ� : " + sbalance);

						//�ŷ��������
						System.out.println("------------------------------------------------");
						System.out.println("����\t�������\t\t\t����ݾ�");
						System.out.println("------------------------------------------------");
						
						for(Trans t:tarray) {
							if(sno == t.getNo()) {	//�ŷ��������� ���¹�ȣ�� ������ ���
								String date = sdf.format(t.getDate());
								String amount = df.format(t.getAmount());
								System.out.printf("%s\t%s\t%s\n", t.getType(), date, amount);
							}
						}
						System.out.println("");
						
						System.out.print("�Աݾ� : ");
						int input = s.nextInt(); s.nextLine();
						a.setBalance(a.getBalance() + input);
						
						//�ŷ������� �Ա� �Է�
						tr = new Trans();
						tr.setNo(sno);
						tr.setDate(new Date());
						tr.setType("�Ա�");
						tr.setAmount(input);
						tarray.add(tr);
						
						System.out.println(sno + " ���¿� " + input + "�� �Ա��� �Ϸ�Ǿ����ϴ�.\n");
						
					}
				}
				if(find == false) {
					System.out.println("��ϵ��� ���� �����Դϴ�.");
				}
				
				break;
				
			case 4:
				System.out.print("���¹�ȣ : ");
				sno = s.nextInt(); s.nextLine();
				
				find = false;
				
				for(Account a:array) {
					if(sno == a.getNo()) {
						find = true;
						System.out.println("������ : " + a.getName());
						
						String sbalance = df.format(a.getBalance());
						System.out.println("�ܾ� : " + sbalance);
						
						System.out.println("------------------------------------------------");
						System.out.println("����\t�������\t\t\t����ݾ�");
						System.out.println("------------------------------------------------");
						
						for(Trans t:tarray) {
							if(sno == t.getNo()) {	//�ŷ��������� ���¹�ȣ�� ������ ���
								String date = sdf.format(t.getDate());
								String amount = df.format(t.getAmount());
								System.out.printf("%s\t%s\t%s\n", t.getType(), date, amount);
							}
						}
						System.out.println("");
						
						System.out.print("��ݾ� : ");
						int output = s.nextInt(); s.nextLine();
						
						if(output <= a.getBalance() && output > 0) {
							a.setBalance(a.getBalance() - output);
							
							tr = new Trans();
							tr.setNo(sno);
							tr.setDate(new Date());
							tr.setType("���");
							tr.setAmount(output);
							tarray.add(tr);
							
							System.out.println(sno + " ���¿��� " + output + "�� ����� �Ϸ�Ǿ����ϴ�.\n");
							
							String nbalance = df.format(a.getBalance());
							System.out.println("�ܾ� : " + nbalance);
						} else if(output <= 0) {
							System.out.println("�Էµ� ��ݾ��� Ȯ�����ּ���.");
							break;
						} else {
							System.out.println("�ܾ��� �����մϴ�.");
							break;
						}
					}
				}
				if(find == false) {
					System.out.println("��ϵ��� ���� �����Դϴ�.");
				}
				
				break;
				
			default:
				System.out.println("0~4�� �޴� �� �����ϼ���.\n");
			}
		}
	}
}
