package ex06;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Product {
	//�ʵ�
	String name;
	int price;
	int qnt;
	
	//������
	public Product(String name, int price, int qnt) {
		super();
		this.name = name;
		this.price = price;
		this.qnt = qnt;
	}
	
	//�޼ҵ�
	//�ݾ� ���ϱ�
	public int sum() {
		int sum = price * qnt;
		return sum;
	}
	
	//��ǰ ���(1,000,000�� �̻� : �ֿ��, 500,000�� �̻� : ���, 500,000 �̸� : ����)  
	public String grade() {
		String grade = "";
		if(sum() >= 1000000) {
			grade = "�ֿ��";
		} else if(sum() >= 500000) {
			grade = "���";
		} else {
			grade = "����";
		}
		return grade;
	}
	
	//��ǰ ���
	public void print() {
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println("��ǰ �̸� : " + name);
		System.out.println("��ǰ �ܰ� : " + df.format(price));
		System.out.println("�Ǹ� ���� : " + df.format(qnt));
		System.out.println("�Ǹ� �ݾ� : " + df.format(sum()));
		System.out.println("�Ǹ� ��� : " + grade());
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
