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
			System.out.println("[실행 방법]");
			System.out.println("java ArrayIndexOutOfBoundsException Example");
			System.out.println("값1 값2");
		}
		
		// NumberFormatException
//		String ndata1 = "100";
//		String ndata2 = "a100";
//		int value1 = Integer.parseInt(ndata1);
//		
//		int value2 = Integer.parseInt(ndata2);	// 예외 발생
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
			System.out.println("클래스가 존재하지 않습니다.");
		}
		
		String data1 = null;
		String data2 = null;
		try {
			data1 = args[0];
			data2 = args[1];
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개값의 수가 부족합니다.");
			System.out.println("[실행 방법]");
			System.out.println("java TryCatchFinallyRuntimeException Example num1 num2");
			return;
		}
		try {
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(data1 + " + " + data2 + " = " + result);
		} catch(NumberFormatException e) {
			System.out.println("숫자로 변환할 수 없습니다.");
		} finally {
			System.out.println("다시 실행하세요.");
		}
		
		// 다중 catch
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
			System.out.println("실행 매개값의 수가 부족합니다.");
			System.out.println("[실행 방법]");
			System.out.println("java TryCatchFinallyRuntimeException Example num1 num2");
		} catch(Exception e) {
			System.out.println("숫자로 변환할 수 없습니다.");
		} finally {
			System.out.println("다시 실행하세요.");
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
			System.out.println("실행 매개값의 수가 부족하거나 숫자를 변환할 수 없습니다.");
		} catch(Exception e) {
			System.out.println("숫자로 변환할 수 없습니다.");
		} finally {
			System.out.println("다시 실행하세요.");
		}
		
		// AutoCloseable
		try(FileInputStream fis = new FileInputStream("file.txt")) {
			fis.read();
			throw new Exception();	// 강제 예외 처리
		} catch(Exception e) {
			System.out.println("예외 처리 코드가 실행되었습니다.");
		}
		
		// 예외 처리 떠넘기기
		try {
			findClass();
		} catch(ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다.");
		}
		
		// 사용자 정의 예외
		Account account = new Account();
		
		account.deposit(10000);
		System.out.println("예금액: " + account.getBalance());
		
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
//			Dog dog = (Dog)animal;	// 예외 발생
//	}
	
	// 예외 처리 떠넘기기
	public static void findClass() throws ClassNotFoundException {
		Class clazz = Class.forName("java.lang.String2");
	}
}
	
class Animal {}

class Dog extends Animal {}

class Cat extends Animal {}