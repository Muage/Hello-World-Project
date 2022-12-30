package ex08;

public class Score extends Stu {
	private int no;
	private String type;
	private int grade;
	
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
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("구분 : " + type);
		System.out.println("점수 : " + grade);
	}
	
	
	
}
