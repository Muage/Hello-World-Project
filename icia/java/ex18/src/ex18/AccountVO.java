package ex18;

public class AccountVO {
	private String ano;
	private String aname;
	private int balance;
	private String odate;
	
	public String getAno() {
		return ano;
	}
	
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public String getAname() {
		return aname;
	}
	
	public void setAname(String aname) {
		this.aname = aname;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public String getOdate() {
		return odate;
	}
	
	public void setOdate(String odate) {
		this.odate = odate;
	}

	@Override
	public String toString() {
		return "AccountVO [ano=" + ano + ", aname=" + aname + ", balance=" + balance + ", odate=" + odate + "]";
	}
}