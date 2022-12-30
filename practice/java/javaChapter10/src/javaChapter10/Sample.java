package javaChapter10;

public class Sample {
	public static void main(String[] args) {
		// NullPonterException
//		String data = null;
//		System.out.println(data.toString());
		
		// ArrayIndexOutOfBoundsException
//		String data1 = args[0];
//		String data2 = args[1];
//		
//		System.out.println("args[0]: " + data1);
//		System.out.println("args[1]: " + data2);
		
		// Program arguments
		if(args.length == 2) {
			String data1 = args[0];
			String data2 = args[1];
			
			System.out.println("args[0]: " + data1);
			System.out.println("args[1]: " + data2);
		} else {
			System.out.println("[���� ���]");
			System.out.println("java ArrayIndexOutOfBoundsException Example");
			System.out.println("��1 ��2");
		}
		
		// NumberFormatException
//		String ndata1 = "100";
//		String ndata2 = "a100";
//		int value1 = Integer.parseInt(ndata1);
//		
//		int value2 = Integer.parseInt(ndata2);	// ���� �߻�
//		int result = value1 + value2;
//		System.out.println(ndata1 + " + " + ndata2 + " = " + result);
		
		// ClassCastException
//		Dog dog = new Dog();
//		changeDog(dog);
//		Cat cat = new Cat();
//		changeDog(cat);
		
		// try-catch-finally
		try {
			Class clazz = Class.forName("java.lang.String2");
		} catch(ClassNotFoundException e) {
			System.out.println("Ŭ������ �������� �ʽ��ϴ�.");
		}
		
		String data1 = null;
		String data2 = null;
		try {
			data1 = args[0];
			data2 = args[1];
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("���� �Ű����� ���� �����մϴ�.");
			System.out.println("[���� ���]");
			System.out.println("java TryCatchFinallyRuntimeException Example num1 num2");
			return;
		}
		try {
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(data1 + " + " + data2 + " = " + result);
		} catch(NumberFormatException e) {
			System.out.println("���ڷ� ��ȯ�� �� �����ϴ�.");
		} finally {
			System.out.println("�ٽ� �����ϼ���.");
		}
		
		// ���� catch
		String cdata1 = null;
		String cdata2 = null;
		try {
			cdata1 = args[0];
			cdata2 = args[1];
			int cvalue1 = Integer.parseInt(cdata1);
			int cvalue2 = Integer.parseInt(cdata2);
			int cresult = cvalue1 + cvalue2;
			System.out.println(cdata1 + " + " + cdata2 + " = " + cresult);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("���� �Ű����� ���� �����մϴ�.");
			System.out.println("[���� ���]");
			System.out.println("java TryCatchFinallyRuntimeException Example num1 num2");
		} catch(Exception e) {
			System.out.println("���ڷ� ��ȯ�� �� �����ϴ�.");
		} finally {
			System.out.println("�ٽ� �����ϼ���.");
		}
		
		// multi catch
		String mdata1 = null, mdata2 = null;
		try {
			mdata1 = args[0];
			mdata2 = args[1];
			int mvalue1 = Integer.parseInt(mdata1);
			int mvalue2 = Integer.parseInt(mdata2);
			int mresult = mvalue1 + mvalue2;
			System.out.println(mdata1 + " + " + mdata2 + " = " + mresult);
		} catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("���� �Ű����� ���� �����ϰų� ���ڸ� ��ȯ�� �� �����ϴ�.");
		} catch(Exception e) {
			System.out.println("���ڷ� ��ȯ�� �� �����ϴ�.");
		} finally {
			System.out.println("�ٽ� �����ϼ���.");
		}
		
		// AutoCloseable
		try(FileInputStream fis = new FileInputStream("file.txt")) {
			fis.read();
			throw new Exception();	// ���� ���� ó��
		} catch(Exception e) {
			System.out.println("���� ó�� �ڵ尡 ����Ǿ����ϴ�.");
		}
		
		// ���� ó�� ���ѱ��
		try {
			findClass();
		} catch(ClassNotFoundException e) {
			System.out.println("Ŭ������ �������� �ʽ��ϴ�.");
		}
		
		// ����� ���� ����
		Account account = new Account();
		
		account.deposit(10000);
		System.out.println("���ݾ�: " + account.getBalance());
		
		try {
			account.withdraw(30000);
		} catch(BalanceInsufficientException e) {
			String message = e.getMessage();
			System.out.println(message);
			System.out.println();
			e.printStackTrace();
		}
	}
	
	// ClassCastException
//	public static void changeDog(Animal animal) {
////		if(animal instanceof Dog) {
//			Dog dog = (Dog)animal;	// ���� �߻�
//	}
	
	// ���� ó�� ���ѱ��
	public static void findClass() throws ClassNotFoundException {
		Class clazz = Class.forName("java.lang.String2");
	}
}
	
class Animal {}

class Dog extends Animal {}

class Cat extends Animal {}