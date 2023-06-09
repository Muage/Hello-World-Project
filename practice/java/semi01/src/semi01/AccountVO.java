package semi01;

public class AccountVO {
	
	//field
	private String accountNo;
	private String accountName;
	private int balance;
	private String accountTypeNo;
	private String accountDate;
	
	
	//getter setter toString method
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAccountTypeNo() {
		return accountTypeNo;
	}
	public void setAccountTypeNo(String accountTypeNo) {
		this.accountTypeNo = accountTypeNo;
	}
	public String getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(String accountDate) {
		this.accountDate = accountDate;
	}
	
	@Override
	public String toString() {
		return "AccountVO [accountNo=" + accountNo + ", accountName=" + accountName + ", balance=" + balance
				+ ", accountTypeNo=" + accountTypeNo + ", accountDate=" + accountDate + "]";
	}
	
	
}
