package ex05;

import java.util.Scanner;

public class Example4 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		
		boolean run = true;
		
		String[] name = new String[100];
		String[] address = new String[100];
		String[] tel = new String[100];
		
		int count = 0;
		
		while(run == true) {
			System.out.println("---------------------------------------------");
			System.out.println("1. 주소등록 | 2. 주소검색 | 3. 주소목록 | 0. 종료");
			System.out.println("---------------------------------------------");
			System.out.print("선택 > ");
			int menu = s.nextInt();
			
			switch(menu) {
				case 1:
					System.out.print("이름 > ");
					name[count] = s.next(); s.nextLine();
					
					System.out.print("주소 > ");
					address[count] = s.nextLine();
					
					System.out.print("전화 > ");
					tel[count] = s.next(); s.nextLine();
					
					count++;	//count = count + 1;
					System.out.println(count + "명 입력 완료\n");
					
					break;
				
				case 2:
					System.out.print("이름 > ");
					String sname = s.next();
					
					boolean find = false;
					
					for(int i=0; i<count; i++) {
						if(sname.equals(name[i])) {
							find = true;
							
							System.out.println("주소 > " + address[i]);
							System.out.println("전화 > " + tel[i]);
							System.out.println("");
						}
					}
					
					break;
				
				case 3:
					System.out.println("*************** 주소목록 ***************");
					System.out.println("이름\t주소\t\t전화");
					for(int i=0; i<count; i++) {
						System.out.println(name[i] + "\t" + address[i] + "\t" + tel[i]);
					}
					System.out.println("");
					
					break;
					
				case 0:
					run = false;
					System.out.println("프로그램이 종료됩니다.\n");
					
					break;
					
				default:
					System.out.println("0~3번 메뉴를 선택하세요.\n");
			}
		}
	}
}
