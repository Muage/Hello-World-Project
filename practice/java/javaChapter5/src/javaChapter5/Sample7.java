package javaChapter5;

public class Sample7 {
	public static void main(String[] args) {
		// 향상된 for문
		int[] scores = {95, 71, 84, 93, 87};
		int sum = 0;
		for(int score : scores) {
			sum += score;
		}
		System.out.println("점수 총합 : " + sum);
		
		double avg = (double)sum / scores.length;
		System.out.println("점수 평균 : " + avg);
	}
}
