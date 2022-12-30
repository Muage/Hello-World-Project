package ex08;

import java.util.Date;

public class Trans extends Account{
	private int no;
	private String type;	//입금 / 출금
	private Date date;		//입금, 출금일
	private int amount;		//입금, 출금액
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
