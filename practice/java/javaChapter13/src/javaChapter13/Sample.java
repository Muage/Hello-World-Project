package javaChapter13;

import java.util.Arrays;

public class Sample {
	//와일드카드
	public static void registerCourse(Course<?> course) {	// 모든 과정
		System.out.println(course.getName() + "수강생: " + Arrays.toString(course.getStudents()));
	}
	
	public static void registerCourseStudent(Course<? extends Student> course) {	// 학생 과정
		System.out.println(course.getName() + "수강생: " + Arrays.toString(course.getStudents()));
	}
	
	public static void registerCourseWorker(Course<? super Worker> course) {	// 직장인과 일반인 과정
		System.out.println(course.getName() + "수강생: " + Arrays.toString(course.getStudents()));
	}
	
	public static void main(String[] args) {
		// Box
		// 제네릭 타입(Generic type)
		Box<String> box1 = new Box<String>();
		box1.set("hello");
		String str = box1.get();
		System.out.println("str = " + str);
		
		Box<Integer> box2 = new Box<Integer>();
		box2.set(6);
		int value = box2.get();
		System.out.println("value = " + value);
		
		// TV
		// 멀티 타입 파라미터
		Product<TV, String> product1 = new Product<TV, String>();
		product1.setKind(new TV());
		product1.setModel("스마트TV");
		
		TV tv = product1.getKind();
		String tvModel = product1.getModel();
		System.out.println("TV종류: " + tvModel);
		
		Product<Car, String> product2 = new Product<Car, String>();
		product2.setKind(new Car());
		product2.setModel("디젤");
		
		Car car = product2.getKind();
		String carModel = product2.getModel();
		System.out.println("자동차종류: " + carModel);
		
		// Util		
		// 제네릭 메서드
		Box<Integer> utilBox1 = Util.<Integer>boxing(100);	// 명시적으로 구체적인 타입 지정
		int intValue = utilBox1.get();
		System.out.println("intValue = " + intValue);
		
		Box<String> utilBox2 = Util.boxing("홍길동");	// 파라미터값 보고 구체적인 타입 지정
		String strValue = utilBox2.get();
		System.out.println("strValue = " + strValue);
				
		// 제네릭 메서드
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "사과");
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "사과");
		
		boolean result1 = Util.<Integer, String>compare(p1, p2);
		if(result1) {
			System.out.println("논리적으로 동등한 객체입니다.");
		} else {
			System.out.println("논리적으로 동등하지 않은 객체입니다.");
		}
		
		Pair<String, String> p3 = new Pair<String, String>("user1", "홍길동");
		Pair<String, String> p4 = new Pair<String, String>("user2", "홍길동");
		
		boolean result2 = Util.compare(p3, p4);
		if(result2) {
			System.out.println();
		}
		
		// 제한된 타입 파라미터
//		String strUtil = Util.compare("a", "b");	// Number 타입 아니라서 오류
		int utilResult1 = Util.parameterCompare(10, 20);	// int를 Integer로 자동 Boxing
		System.out.println("utilResult1 = " + utilResult1);
		
		int utilResult2 = Util.parameterCompare(4.5, 3);	// double를 Double로 자동 Boxing
		System.out.println("utilResult2 = " + utilResult2);
		
		// Course
		//와일드카드
		Course<Person> personCourse = new Course<Person>("일반과정", 5);
		personCourse.add(new Person("일반인"));
		personCourse.add(new Worker("직장인"));
		personCourse.add(new Student("학생"));
		personCourse.add(new HighStudent("고등학생"));
		
		Course<Worker> workerCourse = new Course<Worker>("직장인과정", 5);
		workerCourse.add(new Worker("직장인"));
		
		Course<Student> studentCourse = new Course<Student>("학생과정", 5);
		studentCourse.add(new Student("학생"));
		studentCourse.add(new HighStudent("고등학생"));
		
		Course<HighStudent> highStudentCourse = new Course<HighStudent>("고등학생", 5);
		highStudentCourse.add(new HighStudent("고등학생"));
		
		registerCourse(personCourse);	// 모든 과정 등록 가능
		registerCourse(workerCourse);
		registerCourse(studentCourse);
		registerCourse(highStudentCourse);
		System.out.println();
		
//		registerCourseStudent(personCourse);	// 오류, 학생 과정만 등록 가능
//		registerCourseStudent(workerCourse);
		registerCourseStudent(studentCourse);
		registerCourseStudent(highStudentCourse);
		System.out.println();
		
		registerCourseWorker(personCourse);
		registerCourseWorker(workerCourse);
//		registerCourseWorker(studentCourse);	// 오류, 직장인과 일반인 과정만 등록 가능
//		registerCourseWorker(highStudentCourse);
		
		// Product
		// 제네릭 타입 상속
		ChildProduct<TV, String, String> product = new ChildProduct<>();
		product.setKind(new TV());
		product.setModel("SmartTV");
		product.setCompany("Samsung");
		
		Storage<TV> storage = new StorageImpl<TV>(100);
		storage.add(new TV(), 0);
		TV ptv = storage.get(0);
	}
}
