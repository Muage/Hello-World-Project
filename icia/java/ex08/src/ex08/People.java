package ex08;

public class People {
	private String jno;
	private String name;
	
	//기본생성자
	public People() {
		
	}

	//생성자(오버로딩 : 매개변수의 개수가 다를 때 사용)
	public People(String jno, String name) {
		this.jno = jno;
		this.name = name;
	}
	
	//정보 출력 메소드
	public void print() {
		System.out.println("주민번호 : " + jno);
		System.out.println("이름 : " + name);
	}

	public String getJno() {
		return jno;
	}

	public void setJno(String jno) {
		this.jno = jno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
