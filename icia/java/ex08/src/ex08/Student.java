package ex08;

public class Student extends People {
	private String sno;
	
	//기본생성자
	public Student() {
		
	}

	//오버로딩 생성자
	public Student(String jno, String name, String sno) {
		super(jno, name);
		this.sno = sno;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	@Override // Override : 재정의
	public void print() {
		super.print();
		System.out.println("학번 : " + sno);
	}
	
	
}
