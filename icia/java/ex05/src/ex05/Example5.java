package ex05;

public class Example5 {
	public static void execute() {
		//현대, 제네시스, 검정, 250 자동차 객체 생성
				Car car1 = new Car();	//기본생성자
				car1.company = "현대";	//속성
				car1.model = "제네시스";
				car1.color = "검정";
				car1.maxSpeed = 250;
				
				car1.carPrint();
				
				System.out.println("--------------------");
				
				//기아, K5, 흰색, 250 자동차 객체 생성
				Car car2 = new Car();
				car2.company = "기아";
				car2.model = "K5";
				car2.color = "흰색";
				car2.maxSpeed = 250;
				
				car2.carPrint();
				
				System.out.println("--------------------");

				//쌍용, 티볼리, 파랑, 200 두번째 생성자로 객체 생성
				Car car3 = new Car("티볼리", "파랑", 200);
				
				car3.carPrint();
				
				System.out.println("--------------------");
				
				//현대, GV80, 검정, 270 세번째 생성자로 객체 생성
				Car car4 = new Car("현대", "GV80", "검정", 270);
				
				car4.carPrint();
	}
}
