package ex06;

import java.text.DecimalFormat;

//성적 클래스
public class Grade {
	//필드(속성)
	String name;
	int kor;
	int eng;
	int mat;
	
	//생성자
	public Grade(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	//메소드
	
	//총점 구하기
	public int total() {
		int tot = kor + eng + mat;
		return tot;
	}

	//평균 구하기
	public String average() {
		DecimalFormat df = new DecimalFormat("###.00");
		double avg = total() / 3.;
		return df.format(avg);
	}
	
	//성적 출력
	public void print() {
		System.out.println("이름 : " + name);
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + mat);
		System.out.println("총점 : " + total());
		System.out.println("평균 : " + average());
	}
	
	//성적 목록 출력
	public void printList() {
		System.out.println(name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + total() + "\t" + average());
	}
}
