package ex08;

public class Example1 {
	public static void execute() {
		System.out.println("***** 상 속 연 습 *****");
		
		//기본생성자
		People p1 = new People();
		p1.setJno("000000-1111111");
		p1.setName("홍길동");
		p1.print();
		System.out.println("");
		
		//오버로딩생성자
		People p2 = new People("222222-3333333", "심청이");
		p2.print();
		System.out.println("");
		
		//기본생성자(학생 생성)
		Student s1 = new Student();
		s1.setJno("444444-5555555");
		s1.setName("강감찬");
		s1.setSno("12345");
//		System.out.println("주민번호 : " + s1.getJno());
//		System.out.println("이름 : " + s1.getName());
//		System.out.println("학번 : " + s1.getSno());
		
		s1.print();
		System.out.println("");
		
		//오버로딩생성자(학생 생성)
		Student s2 = new Student("666666-7777777", "이순신", "67890");
//		System.out.println("주민번호 : " + s2.getJno());
//		System.out.println("이름 : " + s2.getName());
//		System.out.println("학번 : " + s2.getSno());
		s2.print();
	}
}
