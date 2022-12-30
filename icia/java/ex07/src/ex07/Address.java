package ex07;

public class Address {	//ÀÚ¹Ùºó
	private int no;
	private String name;
	private String tel;
	private String juso;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getJuso() {
		return juso;
	}
	public void setJuso(String juso) {
		this.juso = juso;
	}
	
	@Override
	public String toString() {
		return "Address [no=" + no + ", name=" + name + ", tel=" + tel + ", juso=" + juso + "]";
	}
	
}
