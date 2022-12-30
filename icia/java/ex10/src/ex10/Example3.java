package ex10;

import java.text.DecimalFormat;
import java.util.*;

public class Example3 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#,###원");
		AccountVO vo = null;
		AccountDAO dao = new AccountDAO();
		ArrayList<AccountVO> array = dao.list();
		boolean run = true;
		int no = 400;
		
		while(run) {
			System.out.println("---------------------------------------------------");
			System.out.println("1.계좌생성 | 2.잔액조회 | 3.입금 | 4.출금 | 5.목록 | 0.종료");
			System.out.println("---------------------------------------------------");
			
			System.out.print("선택 : ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("프로그램을 종료합니다.\n");
				
				break;
				
			case 1:
				vo = new AccountVO();
				System.out.println("계좌번호 : " + no);
				vo.setNo(no);
				System.out.print("계좌주명 : ");
				vo.setName(s.nextLine());
				System.out.print("초기 입금액 : ");
				vo.setBalance(Integer.parseInt(s.nextLine()));
				
				dao.insert(vo, array);
				System.out.println("계좌가 생성되었습니다.\n");
				
				break;
				
			case 2:
				System.out.print("조회할 계좌번호 : ");
				String sno = s.nextLine();
				
				vo = dao.read(Integer.parseInt(sno), array);
				if(vo.getName() == null) {
					System.out.println("해당 계좌가 존재하지 않습니다.\n");
				} else {
					System.out.println("계좌주명 : " + vo.getName());
					System.out.println("잔액 : " + vo.getBalance());
					System.out.println("");
				}
				
				
				break;
				
			case 3:
				System.out.print("입금할 계좌번호 : ");
				int ino = s.nextInt(); s.nextLine();
				vo = dao.read(ino, array);
				if(vo.getName() == null) {
					System.out.println("해당 계좌가 존재하지 않습니다.\n");
				} else {
					System.out.print("입금액 : ");
					int amount = s.nextInt(); s.nextLine();
					dao.trade(ino, amount, array);
					System.out.println(vo.getName() + "님의 (" + ino + ") 계좌로 " + df.format(amount) + "이 입금되었습니다.");
					vo = dao.read(ino, array);
					System.out.println("현재 잔액은 " + df.format(vo.getBalance()) + " 입니다.\n");
				}
				
				break;
				
			case 4:
				System.out.print("출금할 계좌번호 : ");
				int ono = s.nextInt(); s.nextLine();
				vo = dao.read(ono, array);
				if(vo.getName() == null) {
					System.out.println("해당 계좌가 존재하지 않습니다.\n");
				}else {
					System.out.print("출금액 : ");
					int amount = s.nextInt(); s.nextLine();
				
					if (amount <= vo.getBalance() && amount > 0) {
						dao.trade(ono, amount * -1, array);
						System.out.println(vo.getName() + "님의 (" + ono + ") 계좌에서 " + df.format(amount) + "이 출금되었습니다.");
						vo = dao.read(ono, array);
						System.out.println("현재 잔액은 " + df.format(vo.getBalance()) + " 입니다.\n");
					} else if (amount <= 0) {
						System.out.println("입력된 출금액을 확인해주세요.\n");
					} else {
						System.out.println("잔액이 부족합니다.\n");
					}
				}
				
				break;
				
			case 5:
				for(AccountVO v : array) {
					System.out.println(v.toString());
				}
				System.out.println("전체 계좌수 : " + array.size());
				System.out.println("");
				
				break;
				
			default:
				System.out.println("0~4번 메뉴 중 선택하세요.\n");
			}
		}
	}
}
