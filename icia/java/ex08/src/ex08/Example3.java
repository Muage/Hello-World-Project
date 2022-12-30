package ex08;

import java.text.*;
import java.util.*;

public class Example3 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		ArrayList<Account> array = new ArrayList<>();
		ArrayList<Trans> tarray = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DecimalFormat df = new DecimalFormat("#,###원");
		
		int no = 100;
		boolean run = true;
		
		Account acc = new Account();
		Trans tr = new Trans();		
		
		acc.setNo(no);
		acc.setName("홍길동");
		acc.setBalance(1000);
		acc.setOpenDate(new Date());
		array.add(acc);
		
		tr.setNo(no);
		tr.setType("입금");
		tr.setAmount(1000);
		tr.setDate(new Date());
		tarray.add(tr);
		
		
		no = no + 100;
		acc = new Account();
		acc.setNo(no);
		acc.setName("심청이");
		acc.setBalance(2000);
		acc.setOpenDate(new Date());
		array.add(acc);
		
		tr = new Trans();
		tr.setNo(no);
		tr.setType("입금");
		tr.setAmount(2000);
		tr.setDate(new Date());
		tarray.add(tr);
		
		System.out.println("***************** 통 장 관 리 *****************");
		
		while(run == true) {
			System.out.println("------------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3.예금 | 4. 출금 | 0. 종료");
			System.out.println("------------------------------------------------");
			System.out.print("선택 > ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("프로그램이 종료됩니다.\n");
				
				break;
				
			case 1:
				no = no + 100;
				System.out.println("계좌번호 : " + no);
				acc = new Account();
				acc.setNo(no);
				
				System.out.print("계좌주명 : ");
				acc.setName(s.nextLine());
				
				System.out.print("초기 입금액 : ");
				int balance = s.nextInt(); s.nextLine();
				acc.setBalance(balance);
				
				acc.setOpenDate(new Date());
				array.add(acc);
				System.out.println("계좌가 생성되었습니다.");
				
				break;
				
			case 2:
				for(Account a:array) {
					String date = sdf.format(a.getOpenDate());
					String sbalance = df.format(a.getBalance());
					System.out.printf("%d\t%s\t%s\t%s\n", a.getNo(), a.getName(), date, sbalance);
				}
				
				break;
				
			case 3:
				System.out.print("계좌번호 : ");
				int sno = s.nextInt(); s.nextLine();
				
				boolean find = false;
				
				for(Account a:array) {
					if(sno == a.getNo()) {
						find = true;
						System.out.println("계좌주 : " + a.getName());
						
						String sbalance = df.format(a.getBalance());
						System.out.println("잔액 : " + sbalance);

						//거래내역출력
						System.out.println("------------------------------------------------");
						System.out.println("구분\t입출금일\t\t\t입출금액");
						System.out.println("------------------------------------------------");
						
						for(Trans t:tarray) {
							if(sno == t.getNo()) {	//거래내역에서 계좌번호가 같으면 출력
								String date = sdf.format(t.getDate());
								String amount = df.format(t.getAmount());
								System.out.printf("%s\t%s\t%s\n", t.getType(), date, amount);
							}
						}
						System.out.println("");
						
						System.out.print("입금액 : ");
						int input = s.nextInt(); s.nextLine();
						a.setBalance(a.getBalance() + input);
						
						//거래내역에 입금 입력
						tr = new Trans();
						tr.setNo(sno);
						tr.setDate(new Date());
						tr.setType("입금");
						tr.setAmount(input);
						tarray.add(tr);
						
						System.out.println(sno + " 계좌에 " + input + "원 입금이 완료되었습니다.\n");
						
					}
				}
				if(find == false) {
					System.out.println("등록되지 않은 계좌입니다.");
				}
				
				break;
				
			case 4:
				System.out.print("계좌번호 : ");
				sno = s.nextInt(); s.nextLine();
				
				find = false;
				
				for(Account a:array) {
					if(sno == a.getNo()) {
						find = true;
						System.out.println("계좌주 : " + a.getName());
						
						String sbalance = df.format(a.getBalance());
						System.out.println("잔액 : " + sbalance);
						
						System.out.println("------------------------------------------------");
						System.out.println("구분\t입출금일\t\t\t입출금액");
						System.out.println("------------------------------------------------");
						
						for(Trans t:tarray) {
							if(sno == t.getNo()) {	//거래내역에서 계좌번호가 같으면 출력
								String date = sdf.format(t.getDate());
								String amount = df.format(t.getAmount());
								System.out.printf("%s\t%s\t%s\n", t.getType(), date, amount);
							}
						}
						System.out.println("");
						
						System.out.print("출금액 : ");
						int output = s.nextInt(); s.nextLine();
						
						if(output <= a.getBalance() && output > 0) {
							a.setBalance(a.getBalance() - output);
							
							tr = new Trans();
							tr.setNo(sno);
							tr.setDate(new Date());
							tr.setType("출금");
							tr.setAmount(output);
							tarray.add(tr);
							
							System.out.println(sno + " 계좌에서 " + output + "원 출금이 완료되었습니다.\n");
							
							String nbalance = df.format(a.getBalance());
							System.out.println("잔액 : " + nbalance);
						} else if(output <= 0) {
							System.out.println("입력된 출금액을 확인해주세요.");
							break;
						} else {
							System.out.println("잔액이 부족합니다.");
							break;
						}
					}
				}
				if(find == false) {
					System.out.println("등록되지 않은 계좌입니다.");
				}
				
				break;
				
			default:
				System.out.println("0~4번 메뉴 중 선택하세요.\n");
			}
		}
	}
}
