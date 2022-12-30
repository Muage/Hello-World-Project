package ex04;

import java.text.DecimalFormat;

public class Example6 {
	public static void execute() {
		DecimalFormat df = new DecimalFormat("###.00");	//###.##은 소수점 이하 자릿수 다름 ex) 90.1
														//###.00은 소수점 이하 자릿수 동일 ex) 90.10
		String[] name = {"홍길동", "강감찬", "이순신"};
		int[] kor = {98, 67, 78};
		int[] eng = {78, 67, 78};
		int[] mat = {99, 88, 66};
		
		System.out.println("******************** 성적표 ********************");
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
