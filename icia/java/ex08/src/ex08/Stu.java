package ex08;

public class Stu {
	//필드
	private int no;
	private String name;
	private String dept;
	private double avg;
	
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	//메소드
	public void print() {
		String strNo = "학번 : " + no;
		System.out.println(strNo);
		System.out.println("이름 : " + name);
		System.out.println("학과 : " + dept);
	}
}
