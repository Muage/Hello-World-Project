package ex04;

import java.text.DecimalFormat;

public class Example6 {
	public static void execute() {
		DecimalFormat df = new DecimalFormat("###.00");	//###.##�� �Ҽ��� ���� �ڸ��� �ٸ� ex) 90.1
														//###.00�� �Ҽ��� ���� �ڸ��� ���� ex) 90.10
		String[] name = {"ȫ�浿", "������", "�̼���"};
		int[] kor = {98, 67, 78};
		int[] eng = {78, 67, 78};
		int[] mat = {99, 88, 66};
		
		System.out.println("******************** ����ǥ ********************");
		for(int i=0; i<name.length; i++) {
			int tot = kor[i] + eng[i] + mat[i];
			double avg = tot / 3.;
			System.out.print(name[i] + "\t");
			System.out.print(kor[i] + "\t");
			System.out.print(eng[i] + "\t");
			System.out.print(mat[i] + "\t");
			System.out.print(tot + "\t");
			System.out.println(df.format(avg));
		}
	}
}
