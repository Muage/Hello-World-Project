package ex18;

import java.text.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DecimalFormat dfWon = new DecimalFormat("#,###원");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		AccountDAO accountDAO = new AccountDAO();
		AccountVO accountVO;
		StatementDAO statementDAO = new StatementDAO();
		StatementVO statementVO;
		ArrayList<AccountVO> array;
		ArrayList<StatementVO> sarray;
		String menu;			//switch문
		String aname;			//계좌주명 입력
		String stringBalance;	//잔액 포맷 형식 변경
		String stringDate;		//날짜 포맷 형식 변경
		String ano;				//계좌번호 입력
		String stringAmount;	//거래금액 포맷 형식 변경
		String sel;				//진행여부 선택
		boolean run = true;
		int newAno;				//계좌생성 시 계좌번호 부여
		int trade;				//입출금액 입력
		int balance;			//잔액 업데이트
		
		while(run) {
			System.out.println("******************** 계 좌 관 리 ********************");
			System.out.println("───────────────────────────────────────────────────");
			System.out.println("1.계좌생성 │ 2.계좌목록 │ 3.계좌조회 │ 4.입금 │ 5.출금 │ 0.종료");
			System.out.println("───────────────────────────────────────────────────");
			
			System.out.print("메뉴를 선택해주세요. : ");
			menu = scanner.nextLine();
			switch(menu) {
			case "0":
				run = false;
				System.out.println("프로그램을 종료합니다.\n");
				
				break;
				
			case "1":
				newAno = accountDAO.getNewNo() + 100;
				System.out.println("계좌번호 : " + newAno);
				
				System.out.print("계좌주명을 입력해주세요. : ");
				aname = scanner.nextLine();
				if(aname.equals("")) {
					System.out.println("계좌주명이 기입되지 않아 계좌 생성이 취소되었습니다.\n");
					break;
				}
				
				System.out.print("초기입금액을 입력해주세요. : ");
				stringBalance = scanner.nextLine();
				if(stringBalance.equals("")) {
					System.out.println("초기입금액이 기입되지 않아 계좌 생성이 취소되었습니다.\n");
					break;
				}
				
				accountVO = new AccountVO();
				accountVO.setAno(String.valueOf(newAno));
				accountVO.setAname(aname);
				accountVO.setBalance(Integer.valueOf(stringBalance));
				accountDAO.insert(accountVO);
				
				System.out.printf("%s 고객님의 새로운 계좌가 생성되었습니다.\n", aname);
				System.out.println("");
				
				break;
				
			case "2":
				System.out.println("\n계좌번호\t│ 계좌주명\t│ 잔액\t\t│ 계좌생성일");
				System.out.println("────────┼───────┼───────────────┼──────────────────");
				for(AccountVO account : accountDAO.list()) {
					stringBalance = dfWon.format(account.getBalance());
					System.out.printf("%s\t│ %s\t│ %s\t│ %s\n", account.getAno(), account.getAname(), stringBalance, account.getOdate());
				}
				System.out.println("");
				
				break;
				
			case "3":
				System.out.print("조회할 계좌번호를 입력해주세요. : ");
				ano = scanner.nextLine();
				if(ano.equals("")) {
					System.out.println("입력된 계좌번호가 없어 계좌조회가 취소되었습니다.\n");
					break;
				}
				accountVO = accountDAO.read(ano);
				if(accountVO.getAname() == null) {
					System.out.println("입력하신 계좌번호의 정보가 없습니다.\n");
					break;
				}
				//계좌 정보 출력
				System.out.println("\n[계좌정보]");
				System.out.println("계좌주명\t│ 잔액\t\t│ 계좌생성일");
				System.out.println("────────┼───────────────┼──────────────────");
				stringBalance = dfWon.format(accountVO.getBalance());
				System.out.printf("%s\t│ %s\t│ %s\n", accountVO.getAname(), stringBalance, accountVO.getOdate());

				System.out.println("\n[거래내역]");
				System.out.println("거래일(최근순)\t│ 내용\t│ 거래금액");
				System.out.println("────────────────┼───────┼──────────────────");
				sarray = statementDAO.list(ano);
				for(StatementVO s : sarray) {
					stringAmount = dfWon.format(s.getAmount());
					System.out.printf("%s\t│ %s\t│ %s\n", s.getSdate(), s.getType(), stringAmount);
				}
				System.out.println("");
				
				break;
				
			case "4":
				System.out.print("입금할 계좌번호를 입력해주세요. : ");
				ano = scanner.nextLine();
				if(ano.equals("")) {
					System.out.println("입력된 계좌번호가 없어 입금이 취소되었습니다.\n");
					break;
				}
				accountVO = accountDAO.read(ano);
				if(accountVO.getAname() == null) {
					System.out.println("입력하신 계좌번호의 정보가 없습니다.\n");
					break;
				}
				//계좌 정보 출력
				System.out.println("\n계좌주명\t│ 잔액");
				System.out.println("────────┼───────────────────────────");
				stringBalance = dfWon.format(accountVO.getBalance());
				System.out.printf("%s\t│ %s\n", accountVO.getAname(), stringBalance);
				System.out.println("\n");
				//입금
				System.out.print("입금액을 입력해주세요. : ");
				trade = scanner.nextInt(); scanner.nextLine();
				
				System.out.printf("%s님의 계좌로 %s을 입금하시겠습니까? (예 : Y , 아니요 : N) : ", accountVO.getAname(), dfWon.format(trade));
				sel = scanner.nextLine();
										
				if (sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
					balance = accountVO.getBalance() + trade;
					accountDAO.trade(balance, ano);
					
					statementVO = new StatementVO();
					statementVO.setAno(ano);
					statementVO.setSdate(sdf.format(new Date()));
					statementVO.setType("입금");
					statementVO.setAmount(trade);
					
					statementDAO.insert(statementVO);
					
					System.out.printf("\n%s님의 계좌로 %s 입금되었습니다.\n", accountVO.getAname(), dfWon.format(trade));
					
					System.out.printf("현재 잔액은 %s 입니다.\n\n", dfWon.format(balance));
				} else {
					System.out.println("입금이 취소되었습니다.\n");
				}
				
				break;
				
			case "5":
				System.out.print("출금할 계좌번호를 입력해주세요. : ");
				ano = scanner.nextLine();
				if(ano.equals("")) {
					System.out.println("입력된 계좌번호가 없어 출금이 취소되었습니다.\n");
					break;
				}
				accountVO = accountDAO.read(ano);
				if(accountVO.getAname() == null) {
					System.out.println("입력하신 계좌번호의 정보가 없습니다.\n");
					break;
				}
				//계좌 정보 출력
				System.out.println("\n계좌주명\t│ 잔액");
				System.out.println("────────┼───────────────────────────");
				stringBalance = dfWon.format(accountVO.getBalance());
				System.out.printf("%s\t│ %s\n", accountVO.getAname(), stringBalance);
				System.out.println("\n");
				//출금
				System.out.print("출금액을 입력해주세요. : ");
				trade = scanner.nextInt(); scanner.nextLine();
				
				System.out.printf("%s님의 계좌에서 %s을 출금하시겠습니까? (예 : Y , 아니요 : N) : ", accountVO.getAname(), dfWon.format(trade));
				sel = scanner.nextLine();
										
				if (sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
					balance = accountVO.getBalance() - trade;
					accountDAO.trade(balance, ano);
					
					statementVO = new StatementVO();
					statementVO.setAno(ano);
					statementVO.setSdate(sdf.format(new Date()));
					statementVO.setType("출금");
					statementVO.setAmount(trade);
					
					statementDAO.insert(statementVO);
					
					System.out.printf("\n%s님의 계좌에서 %s 출금되었습니다.\n", accountVO.getAname(), dfWon.format(trade));
					
					System.out.printf("현재 잔액은 %s 입니다.\n\n", dfWon.format(balance));
				} else {
					System.out.println("출금이 취소되었습니다.\n");
				}
				
				break;
				
			default:
				System.out.println("0~5번 메뉴 중 선택해주세요.\n");
			}
		}
	}
}
