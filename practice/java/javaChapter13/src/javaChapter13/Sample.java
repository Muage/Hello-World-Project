package javaChapter13;

import java.util.Arrays;

public class Sample {
	//���ϵ�ī��
	public static void registerCourse(Course<?> course) {	// ��� ����
		System.out.println(course.getName() + "������: " + Arrays.toString(course.getStudents()));
	}
	
	public static void registerCourseStudent(Course<? extends Student> course) {	// �л� ����
		System.out.println(course.getName() + "������: " + Arrays.toString(course.getStudents()));
	}
	
	public static void registerCourseWorker(Course<? super Worker> course) {	// �����ΰ� �Ϲ��� ����
		System.out.println(course.getName() + "������: " + Arrays.toString(course.getStudents()));
	}
	
	public static void main(String[] args) {
		// Box
		// ���׸� Ÿ��(Generic type)
		Box<String> box1 = new Box<String>();
		box1.set("hello");
		String str = box1.get();
		System.out.println("str = " + str);
		
		Box<Integer> box2 = new Box<Integer>();
		box2.set(6);
		int value = box2.get();
		System.out.println("value = " + value);
		
		// TV
		// ��Ƽ Ÿ�� �Ķ����
		Product<TV, String> product1 = new Product<TV, String>();
		product1.setKind(new TV());
		product1.setModel("����ƮTV");
		
		TV tv = product1.getKind();
		String tvModel = product1.getModel();
		System.out.println("TV����: " + tvModel);
		
		Product<Car, String> product2 = new Product<Car, String>();
		product2.setKind(new Car());
		product2.setModel("����");
		
		Car car = product2.getKind();
		String carModel = product2.getModel();
		System.out.println("�ڵ�������: " + carModel);
		
		// Util		
		// ���׸� �޼���
		Box<Integer> utilBox1 = Util.<Integer>boxing(100);	// ��������� ��ü���� Ÿ�� ����
		int intValue = utilBox1.get();
		System.out.println("intValue = " + intValue);
		
		Box<String> utilBox2 = Util.boxing("ȫ�浿");	// �Ķ���Ͱ� ���� ��ü���� Ÿ�� ����
		String strValue = utilBox2.get();
		System.out.println("strValue = " + strValue);
				
		// ���׸� �޼���
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "���");
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "���");
		
		boolean result1 = Util.<Integer, String>compare(p1, p2);
		if(result1) {
			System.out.println("�������� ������ ��ü�Դϴ�.");
		} else {
			System.out.println("�������� �������� ���� ��ü�Դϴ�.");
		}
		
		Pair<String, String> p3 = new Pair<String, String>("user1", "ȫ�浿");
		Pair<String, String> p4 = new Pair<String, String>("user2", "ȫ�浿");
		
		boolean result2 = Util.compare(p3, p4);
		if(result2) {
			System.out.println();
		}
		
		// ���ѵ� Ÿ�� �Ķ����
//		String strUtil = Util.compare("a", "b");	// Number Ÿ�� �ƴ϶� ����
		int utilResult1 = Util.parameterCompare(10, 20);	// int�� Integer�� �ڵ� Boxing
		System.out.println("utilResult1 = " + utilResult1);
		
		int utilResult2 = Util.parameterCompare(4.5, 3);	// double�� Double�� �ڵ� Boxing
		System.out.println("utilResult2 = " + utilResult2);
		
		// Course
		//���ϵ�ī��
		Course<Person> personCourse = new Course<Person>("�Ϲݰ���", 5);
		personCourse.add(new Person("�Ϲ���"));
		personCourse.add(new Worker("������"));
		personCourse.add(new Student("�л�"));
		personCourse.add(new HighStudent("����л�"));
		
		Course<Worker> workerCourse = new Course<Worker>("�����ΰ���", 5);
		workerCourse.add(new Worker("������"));
		
		Course<Student> studentCourse = new Course<Student>("�л�����", 5);
		studentCourse.add(new Student("�л�"));
		studentCourse.add(new HighStudent("����л�"));
		
		Course<HighStudent> highStudentCourse = new Course<HighStudent>("����л�", 5);
		highStudentCourse.add(new HighStudent("����л�"));
		
		registerCourse(personCourse);	// ��� ���� ��� ����
		registerCourse(workerCourse);
		registerCourse(studentCourse);
		registerCourse(highStudentCourse);
		System.out.println();
		
//		registerCourseStudent(personCourse);	// ����, �л� ������ ��� ����
//		registerCourseStudent(workerCourse);
		registerCourseStudent(studentCourse);
		registerCourseStudent(highStudentCourse);
		System.out.println();
		
		registerCourseWorker(personCourse);
		registerCourseWorker(workerCourse);
//		registerCourseWorker(studentCourse);	// ����, �����ΰ� �Ϲ��� ������ ��� ����
//		registerCourseWorker(highStudentCourse);
		
		// Product
		// ���׸� Ÿ�� ���
		ChildProduct<TV, String, String> product = new ChildProduct<>();
		product.setKind(new TV());
		product.setModel("SmartTV");
		product.setCompany("Samsung");
		
		Storage<TV> storage = new StorageImpl<TV>(100);
		storage.add(new TV(), 0);
		TV ptv = storage.get(0);
	}
}
