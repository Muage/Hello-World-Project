package ex08;

public class Example1 {
	public static void execute() {
		System.out.println("***** �� �� �� �� *****");
		
		//�⺻������
		People p1 = new People();
		p1.setJno("000000-1111111");
		p1.setName("ȫ�浿");
		p1.print();
		System.out.println("");
		
		//�����ε�������
		People p2 = new People("222222-3333333", "��û��");
		p2.print();
		System.out.println("");
		
		//�⺻������(�л� ����)
		Student s1 = new Student();
		s1.setJno("444444-5555555");
		s1.setName("������");
		s1.setSno("12345");
//		System.out.println("�ֹι�ȣ : " + s1.getJno());
//		System.out.println("�̸� : " + s1.getName());
//		System.out.println("�й� : " + s1.getSno());
		
		s1.print();
		System.out.println("");
		
		//�����ε�������(�л� ����)
		Student s2 = new Student("666666-7777777", "�̼���", "67890");
//		System.out.println("�ֹι�ȣ : " + s2.getJno());
//		System.out.println("�̸� : " + s2.getName());
//		System.out.println("�й� : " + s2.getSno());
		s2.print();
	}
}
