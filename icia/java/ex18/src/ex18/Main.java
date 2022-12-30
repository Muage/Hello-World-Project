package ex18;

import java.text.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DecimalFormat dfWon = new DecimalFormat("#,###��");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		AccountDAO accountDAO = new AccountDAO();
		AccountVO accountVO;
		StatementDAO statementDAO = new StatementDAO();
		StatementVO statementVO;
		ArrayList<AccountVO> array;
		ArrayList<StatementVO> sarray;
		String menu;			//switch��
		String aname;			//�����ָ� �Է�
		String stringBalance;	//�ܾ� ���� ���� ����
		String stringDate;		//��¥ ���� ���� ����
		String ano;				//���¹�ȣ �Է�
		String stringAmount;	//�ŷ��ݾ� ���� ���� ����
		String sel;				//���࿩�� ����
		boolean run = true;
		int newAno;				//���»��� �� ���¹�ȣ �ο�
		int trade;				//����ݾ� �Է�
		int balance;			//�ܾ� ������Ʈ
		
		while(run) {
			System.out.println("******************** �� �� �� �� ********************");
			System.out.println("������������������������������������������������������������������������������������������������������");
			System.out.println("1.���»��� �� 2.���¸�� �� 3.������ȸ �� 4.�Ա� �� 5.��� �� 0.����");
			System.out.println("������������������������������������������������������������������������������������������������������");
			
			System.out.print("�޴��� �������ּ���. : ");
			menu = scanner.nextLine();
			switch(menu) {
			case "0":
				run = false;
				System.out.println("���α׷��� �����մϴ�.\n");
				
				break;
				
			case "1":
				newAno = accountDAO.getNewNo() + 100;
				System.out.println("���¹�ȣ : " + newAno);
				
				System.out.print("�����ָ��� �Է����ּ���. : ");
				aname = scanner.nextLine();
				if(aname.equals("")) {
					System.out.println("�����ָ��� ���Ե��� �ʾ� ���� ������ ��ҵǾ����ϴ�.\n");
					break;
				}
				
				System.out.print("�ʱ��Աݾ��� �Է����ּ���. : ");
				stringBalance = scanner.nextLine();
				if(stringBalance.equals("")) {
					System.out.println("�ʱ��Աݾ��� ���Ե��� �ʾ� ���� ������ ��ҵǾ����ϴ�.\n");
					break;
				}
				
				accountVO = new AccountVO();
				accountVO.setAno(String.valueOf(newAno));
				accountVO.setAname(aname);
				accountVO.setBalance(Integer.valueOf(stringBalance));
				accountDAO.insert(accountVO);
				
				System.out.printf("%s ������ ���ο� ���°� �����Ǿ����ϴ�.\n", aname);
				System.out.println("");
				
				break;
				
			case "2":
				System.out.println("\n���¹�ȣ\t�� �����ָ�\t�� �ܾ�\t\t�� ���»�����");
				System.out.println("������������������������������������������������������������������������������������������������������");
				for(AccountVO account : accountDAO.list()) {
					stringBalance = dfWon.format(account.getBalance());
					System.out.printf("%s\t�� %s\t�� %s\t�� %s\n", account.getAno(), account.getAname(), stringBalance, account.getOdate());
				}
				System.out.println("");
				
				break;
				
			case "3":
				System.out.print("��ȸ�� ���¹�ȣ�� �Է����ּ���. : ");
				ano = scanner.nextLine();
				if(ano.equals("")) {
					System.out.println("�Էµ� ���¹�ȣ�� ���� ������ȸ�� ��ҵǾ����ϴ�.\n");
					break;
				}
				accountVO = accountDAO.read(ano);
				if(accountVO.getAname() == null) {
					System.out.println("�Է��Ͻ� ���¹�ȣ�� ������ �����ϴ�.\n");
					break;
				}
				//���� ���� ���
				System.out.println("\n[��������]");
				System.out.println("�����ָ�\t�� �ܾ�\t\t�� ���»�����");
				System.out.println("��������������������������������������������������������������������������������������");
				stringBalance = dfWon.format(accountVO.getBalance());
				System.out.printf("%s\t�� %s\t�� %s\n", accountVO.getAname(), stringBalance, accountVO.getOdate());

				System.out.println("\n[�ŷ�����]");
				System.out.println("�ŷ���(�ֱټ�)\t�� ����\t�� �ŷ��ݾ�");
				System.out.println("��������������������������������������������������������������������������������������");
				sarray = statementDAO.list(ano);
				for(StatementVO s : sarray) {
					stringAmount = dfWon.format(s.getAmount());
					System.out.printf("%s\t�� %s\t�� %s\n", s.getSdate(), s.getType(), stringAmount);
				}
				System.out.println("");
				
				break;
				
			case "4":
				System.out.print("�Ա��� ���¹�ȣ�� �Է����ּ���. : ");
				ano = scanner.nextLine();
				if(ano.equals("")) {
					System.out.println("�Էµ� ���¹�ȣ�� ���� �Ա��� ��ҵǾ����ϴ�.\n");
					break;
				}
				accountVO = accountDAO.read(ano);
				if(accountVO.getAname() == null) {
					System.out.println("�Է��Ͻ� ���¹�ȣ�� ������ �����ϴ�.\n");
					break;
				}
				//���� ���� ���
				System.out.println("\n�����ָ�\t�� �ܾ�");
				System.out.println("������������������������������������������������������������������������");
				stringBalance = dfWon.format(accountVO.getBalance());
				System.out.printf("%s\t�� %s\n", accountVO.getAname(), stringBalance);
				System.out.println("\n");
				//�Ա�
				System.out.print("�Աݾ��� �Է����ּ���. : ");
				trade = scanner.nextInt(); scanner.nextLine();
				
				System.out.printf("%s���� ���·� %s�� �Ա��Ͻðڽ��ϱ�? (�� : Y , �ƴϿ� : N) : ", accountVO.getAname(), dfWon.format(trade));
				sel = scanner.nextLine();
										
				if (sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
					balance = accountVO.getBalance() + trade;
					accountDAO.trade(balance, ano);
					
					statementVO = new StatementVO();
					statementVO.setAno(ano);
					statementVO.setSdate(sdf.format(new Date()));
					statementVO.setType("�Ա�");
					statementVO.setAmount(trade);
					
					statementDAO.insert(statementVO);
					
					System.out.printf("\n%s���� ���·� %s �ԱݵǾ����ϴ�.\n", accountVO.getAname(), dfWon.format(trade));
					
					System.out.printf("���� �ܾ��� %s �Դϴ�.\n\n", dfWon.format(balance));
				} else {
					System.out.println("�Ա��� ��ҵǾ����ϴ�.\n");
				}
				
				break;
				
			case "5":
				System.out.print("����� ���¹�ȣ�� �Է����ּ���. : ");
				ano = scanner.nextLine();
				if(ano.equals("")) {
					System.out.println("�Էµ� ���¹�ȣ�� ���� ����� ��ҵǾ����ϴ�.\n");
					break;
				}
				accountVO = accountDAO.read(ano);
				if(accountVO.getAname() == null) {
					System.out.println("�Է��Ͻ� ���¹�ȣ�� ������ �����ϴ�.\n");
					break;
				}
				//���� ���� ���
				System.out.println("\n�����ָ�\t�� �ܾ�");
				System.out.println("������������������������������������������������������������������������");
				stringBalance = dfWon.format(accountVO.getBalance());
				System.out.printf("%s\t�� %s\n", accountVO.getAname(), stringBalance);
				System.out.println("\n");
				//���
				System.out.print("��ݾ��� �Է����ּ���. : ");
				trade = scanner.nextInt(); scanner.nextLine();
				
				System.out.printf("%s���� ���¿��� %s�� ����Ͻðڽ��ϱ�? (�� : Y , �ƴϿ� : N) : ", accountVO.getAname(), dfWon.format(trade));
				sel = scanner.nextLine();
										
				if (sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
					balance = accountVO.getBalance() - trade;
					accountDAO.trade(balance, ano);
					
					statementVO = new StatementVO();
					statementVO.setAno(ano);
					statementVO.setSdate(sdf.format(new Date()));
					statementVO.setType("���");
					statementVO.setAmount(trade);
					
					statementDAO.insert(statementVO);
					
					System.out.printf("\n%s���� ���¿��� %s ��ݵǾ����ϴ�.\n", accountVO.getAname(), dfWon.format(trade));
					
					System.out.printf("���� �ܾ��� %s �Դϴ�.\n\n", dfWon.format(balance));
				} else {
					System.out.println("����� ��ҵǾ����ϴ�.\n");
				}
				
				break;
				
			default:
				System.out.println("0~5�� �޴� �� �������ּ���.\n");
			}
		}
	}
}
