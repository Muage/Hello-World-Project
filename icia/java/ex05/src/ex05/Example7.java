package ex05;

import java.util.*;

public class Example7 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		
		boolean run = true;
		ArrayList<Address> array = new ArrayList<>();
		
		while(run) {
			System.out.println("---------------------------------------------");
			System.out.println("1. 주소등록 | 2. 주소검색 | 3. 주소목록 | 0. 종료");
			System.out.println("---------------------------------------------");
			System.out.print("선택 > ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 1:
				Address juso = new Address();
				
				System.out.print("이름 > ");
				juso.name = s.next(); s.nextLine();
				
				System.out.print("주소 > ");
				juso.address = s.nextLine();
				
				System.out.print("전화 > ");
				juso.tel = s.next(); s.nextLine();
				
				array.add(juso);
				
				break;

			case 2:
				System.out.print("검색할 이름 > ");
				String sname = s.nextLine();
				
				boolean find = false;
				
				for(Address a:array) {
					if(sname.equals(a.name)) {
						a.print();
						find = true;
					}
//					하나의 값마다 출력이 된다. 
//					else {
//						System.out.println("입력한 데이터가 없습니다.");
//					}
				}
				if(find == false) {
					System.out.println("입력한 데이터가 없습니다.");					
				}
				
				
				break;
				
			case 3:
				for(Address a:array) {
					a.print();
				}
				
				break;
				
			case 0:
				run = false;
				System.out.println("프로그램을 종료합니다.");
				break;
			
			default:
				System.out.println("0~3번 메뉴를 선택하세요.");
			}
		}
		
	}
}
