package ex06;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Product {
	//필드
	String name;
	int price;
	int qnt;
	
	//생성자
	public Product(String name, int price, int qnt) {
		super();
		this.name = name;
		this.price = price;
		this.qnt = qnt;
	}
	
	//메소드
	//금액 구하기
	public int sum() {
		int sum = price * qnt;
		return sum;
	}
	
	//상품 등급(1,000,000원 이상 : 최우수, 500,000원 이상 : 우수, 500,000 미만 : 보통)  
	public String grade() {
		String grade = "";
		if(sum() >= 1000000) {
			grade = "최우수";
		} else if(sum() >= 500000) {
			grade = "우수";
		} else {
			grade = "보통";
		}
		return grade;
	}
	
	//상품 출력
	public void print() {
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println("상품 이름 : " + name);
		System.out.println("상품 단가 : " + df.format(price));
		System.out.println("판매 수량 : " + df.format(qnt));
		System.out.println("판매 금액 : " + df.format(sum()));
		System.out.println("판매 등급 : " + grade());
	}
	
	public void printList() {
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.printf("%-10s", name);
		System.out.printf("%-20s", df.format(price));
		System.out.printf("%-20s", df.format(qnt));
		System.out.printf("%-20s", df.format(sum()));
		System.out.printf("%-20s", grade());
	}
}
