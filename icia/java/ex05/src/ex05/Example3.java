package ex05;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Example3 {
	public static void execute() {
		Scanner s = new Scanner(System.in);	//키보드 값을 입력받기 위해 스캐너 생성
		DecimalFormat df = new DecimalFormat("#,###원");	//포맷을 만들어 df에 저장
		DecimalFormat df2 = new DecimalFormat("#,###개");
		
		boolean run = true;
		
		String[] product = new String[100];
		int[] price = new int[100];
		int[] qnt = new int[100];
		
		int num = 0;
		
		while(run) {
			
			System.out.println("");
			System.out.println("---------------------------------------------");
			System.out.println("1. 상품 등록 | 2. 상품 검색 | 3. 매출 현황 | 0. 종료");
			System.out.println("---------------------------------------------");
			
			System.out.print("선택 > ");
			int menu = s.nextInt();
			
			switch(menu) {
			case 1:
				System.out.print("상품명 > ");
				product[num] = s.next();
				
				System.out.print("단가 > ");
				price[num] = s.nextInt();
				
				System.out.print("판매수량 > ");
				qnt[num] = s.nextInt();
				
				num++;	//num = num + 1;
				System.out.println(num + " 번 상품이 등록 되었습니다.");
				
				break;
				
			case 2:
				System.out.print("상품명 > ");
				String sproduct = s.next();
				
				boolean find = false;
				
				for(int i=0; i<num; i++) {
					if(sproduct.equals(product[i])) {
						find = true;
						
						int sum = price[i] * qnt[i];
						
						String strPrice = df.format(price[i]);
						String strQnt = df2.format(qnt[i]);
						String srtSum = df.format(sum);
						
						System.out.println("단가   \t판매수량   \t금액");
						System.out.println(strPrice + "   \t" + strQnt + "   \t" + srtSum); 
					}
				}
				
				break;
				
			case 3:
				System.out.println("*************** 매출 현황 ***************");
				System.out.println("상품명   \t단가   \t판매수량   \t금액");
				
				for(int i=0; i<num; i++) {
					int sum = price[i] * qnt[i];
					
					String strPrice = df.format(price[i]);
					String strQnt = df2.format(qnt[i]);
					String srtSum = df.format(sum);
					
					System.out.println(product[i] + "   \t" + strPrice + "   \t" + strQnt + "   \t" + srtSum);
				}
				
				break;
				
			case 0:
				run = false;
				System.out.println("프로그램이 종료됩니다.");
				
				break;
				
			default:
				System.out.println("0~3번 메뉴를 선택해주세요.");
			}
		}
		
	}
}