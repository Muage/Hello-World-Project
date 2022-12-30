package hankook;

public class SnowTire {	//카멜표시법 (자바 빈)
	private String color = "검정";
	private int size = 20;
	private int life = 3;
	
	
	
//	//필드값 변경 메소드
//	public void setColor(String color) {
//		this.color = color;	//this.color의 color : 필드의 color
//							//color의 color : 메소드 (String color)의 color
//	}
//	
//	//필드값 가져오는 메소드
//	public String getColor() {
//		return color;
//	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void print() {
		System.out.println("한국타이어의 스노우타이어 입니다.");
	}
	
	public void printInfo() {
		System.out.println("색상 : " + color);
		System.out.println("사이즈 : " + size);
		System.out.println("수명 : " + life);
	}
}
