package javaChapter4;

public class Sample {
	public static void main(String[] args) {
		// 조건문
		// if문
		int score = 90;
		
		if(score >= 90) {
			System.out.println("점수가 90보다 큽니다.\n등급은 A입니다.");
		}
		if(score <90) {
			System.out.println("점수가 90보다 작습니다.\n등급은 B입니다.");
		}
		
		// if-else문
		score = 85;
		if(score >= 90) {
			System.out.println("점수가 90보다 큽니다.\n등급은 A입니다.");
		} else {	// score >= 90이 아닌 경우
			System.out.println("점수가 90보다 작습니다.\n등급은 B입니다.");
		}
		
		// if-else if-else문
		score = 75;
		if(score >= 90) {
			System.out.println("점수가 90보다 큽니다.\n등급은 A입니다.");
		} else if(score >= 80) {
			System.out.println("점수가 80~89점 입니다.\n등급은 B입니다.");
		} else if(score >= 70) {
			System.out.println("점수가 70~79점 입니다.\n등급은 C입니다.");
		} else {
			System.out.println("점수가 70점 미만입니다.\n등급은 F입니다.");
		}
		
		// 중첩 if문
		score = 88;
		System.out.println("점수 : " + score);
		
		String grade;
		if(score >= 90) {
			if(score >= 95) {
				grade = "A+";
			} else {
				grade = "A0";
			}
		} else {
			if(score >= 85) {
				grade = "B+";
			} else {
				grade = "B0";
			}
		}
		System.out.println("학점 : " + grade);
	}
}