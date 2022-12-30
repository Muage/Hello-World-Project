package ex11;

import java.util.Scanner;

import sale.Example2;
import student.Example1;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		boolean run = true;
		
		while(run) {
			System.out.println("---------------------------------------------");
			System.out.println("1.학생관리 프로그램");
			System.out.println("2.매출관리 프로그램");
			System.out.println("0.프로그램 종료");
			System.out.println("---------------------------------------------");
			
			System.out.print("어떤 프로그램을 실행하시겠습니까? > ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("프로그램을 종료합니다.\n");
				
				break;
				
			case 1:
				Example1.execute();
				
				break;
				
			case 2:
				Example2.execute();
				
				break;
				
				default:
				System.out.println("0~2번 중 선택해주세요.\n");
			}
		}
	}
}
