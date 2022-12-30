package ex04;

public class Example5 {
	public static void execute() {
		//배열 (하나의 변수명에 여러개의 데이터를 저장할 수 있다.)
		int[] a = {11, 22, 33, 44, 55, 66, 77, 88};
		System.out.println("3번째 : " + a[2]);
		System.out.println("6번째 : " + a[5]);
		System.out.println("--------------------");
		
		a[7] = 40;	//8번째 값을 40으로 변경
		int sum = 0;
		
		for(int i=0; i<a.length; i++) {	//a.length : 배열의 크기
			System.out.println(i+1 + "번째 : " + a[i]);
			sum = sum + a[i];
		}
		System.out.println("--------------------");
		System.out.println("총점 : " + sum);
		
		double avg = (double)sum / a.length;
		System.out.println("평균 : " + avg);
	}
}
