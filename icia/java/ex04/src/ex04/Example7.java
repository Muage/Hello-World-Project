package ex04;

import java.util.Scanner;

public class Example7 {
	public static void execute() {
		
		Scanner s = new Scanner(System.in);
		
		int[] no = new int[100];	//0~99
		String[] name = new String[100];
		int[] kor = new int[100];
		int[] eng = new int[100];
		int[] mat = new int[100];
		int cnt = 0;	//�Է��� �л� �� ����
		
		boolean run = true;
		while(run) {
			System.out.println("------------------------------------------------------------");
			System.out.println("1. �����Է� | 2. �����˻� | 3. �������� | 4. ����ǥ��� | 0. ����");
			System.out.println("------------------------------------------------------------");
			
			System.out.print("���� > ");
			int sel = s.nextInt();
			
			switch(sel) {
			case 1:	//�����Է�
				cnt++; //cnt = cnt + 1;
				System.out.println("�й� : " + cnt);
				no[cnt] = cnt;
				
				System.out.print("�̸� > ");
				name[cnt] = s.next();
				
				System.out.print("���� > ");
				kor[cnt] = s.nextInt();
				
				System.out.print("���� > ");
				eng[cnt] = s.nextInt();
				
				System.out.print("���� > ");
				mat[cnt] = s.nextInt();
				
				break;
				
			case 2:	//�����˻�
				System.out.println("�й� > ");
				int num = s.nextInt();
				if(num<1 || num>cnt ) {
					System.out.println("�л��� �������� �ʽ��ϴ�.\n");
				} else {
					System.out.println("�̸�\t����\t����\t����\t����\t���");
					int tot = kor[num] + eng[num] + mat[num];
					double avg = tot / 3.;
					System.out.print(name[num] + "\t" + kor[num] + "\t" + eng[num] + "\t" + mat[num]);
					System.out.println("\t" + tot + "\t" + avg + "\n");
				}
				
				break;
				
			case 3:
				
				break;
				
			case 4:	//����ǥ���
				System.out.println("�̸�\t����\t����\t����\t����\t���");
				for(int i=1; i<=cnt; i++) {
					int tot = kor[i] + eng[i] + mat[i];
					double avg = tot / 3.;
					System.out.print(name[i] + "\t" + kor[i] + "\t" + eng[i] + "\t" + mat[i]);
					System.out.println("\t" + tot + "\t" + avg);
				}
				System.out.println("");
				break;
				
			case 0:
				System.out.println("���α׷��� �����մϴ�!\n");
				run = false;
				break;
			default:
				System.out.println("0~4�� �޴��� �����ϼ���!\n");
				break;
			}
		}
	}
}
