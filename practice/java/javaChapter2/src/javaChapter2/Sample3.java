package javaChapter2;

public class Sample3 {
	public static void main(String[] args) {
		char ban = 'A';
		String name = "ȫ�浿";
		
		int kor = 90;
		int eng = 95;
		int mat = 87;
		int tot = kor + eng + mat;
		float avg = (float)tot / 3;
		
		System.out.println("��: " + ban);
		System.out.println("�̸�: " + name);
		System.out.println("����: " + kor);
		System.out.println("����: " + eng);
		System.out.println("����: " + mat);
		System.out.println("����: " + tot);
		System.out.println("���: " + avg);
	}
}
