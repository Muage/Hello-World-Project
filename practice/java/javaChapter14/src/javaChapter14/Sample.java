package javaChapter14;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.ObjIntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

public class Sample {
	// MyFunctionalInterface3
	public static int sum(int x, int y) {
		return (x + y);
	}
	
	// Function - Student
	private static List<Student> list = Arrays.asList(new Student("ȫ�浿", 90, 96), new Student("�ſ��", 95, 93));
	
	public static void printString(Function<Student, String> function) {
		for(Student student : list) {
			System.out.println(function.apply(student) + " ");
		}
		System.out.println();
	}
	
	public static void printInt(ToIntFunction<Student> function) {
		for(Student student : list) {
			System.out.println(function.applyAsInt(student) + " ");
		}
		System.out.println();
	}
	
	public static double avg(ToIntFunction<Student> function) {
		int sum = 0;
		for(Student student : list) {
			sum += function.applyAsInt(student);
		}
		
		double avg = (double)sum / list.size();
		return avg;
	}
	
	// Operator
	private static int[] scores = {92, 95, 87};
	
	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		
		for(int score : scores) {
			result = operator.applyAsInt(result, score);
		}
		return result;
	}
	
	// Predicate
	private static List<Student> list2 = Arrays.asList(
		new Student("ȫ�浿", "����", 90),
		new Student("�����", "����", 90),
		new Student("���ڹ�", "����", 95),
		new Student("���ѳ�", "����", 92)
	);
	
	public static double avg2(Predicate<Student> predicate) {
		int count = 0, sum = 0;
		
		for(Student student : list2) {
			if(predicate.test(student)) {
				count++;
				sum += student.getScore();
			}
		}
		return (double)sum / count;
	}
	
	// �Ķ���� �޼��� ����
	public static void print(int order) {
		if(order < 0) {
			System.out.println("������ ���ڿ��Դϴ�.");
		} else if(order == 0) {
			System.out.println("������ ���ڿ��Դϴ�.");
		} else {
			System.out.println("���������� ���߿� �ø��ϴ�.");
		}
	}
	
	public static void main(String[] args) {
		// MyFunctionalInterface
		// �Ķ���Ϳ� ���ϰ��� ���� ���ٽ�
		MyFunctionalInterface fi;
		
		fi = () -> {
			String str = "method call1";
			System.out.println(str);
		};
		
		fi.method();
		fi = () -> {
			System.out.println("method call2");
		};
		fi.method();
		fi = () -> System.out.println("method call3");
		fi.method();
		
		// MyFunctionalInterface2
		// �Ķ���Ͱ� �ִ� ���ٽ�
		MyFunctionalInterface2 fi2;
		
		fi2 = (x) -> {
			int result = x * 5;
			System.out.println(result);
		};
		
		fi2.method(2);
		fi2 = (x) -> {
			System.out.println(x * 5);
		};
		fi2.method(2);
		fi2 = (x) -> System.out.println(x * 5);
		fi2.method(2);
		
		// MyFunctionalInterface3
		// �Ķ���Ϳ� ���ϰ��� �ִ� ���ٽ�
		MyFunctionalInterface3 fi3;
		
		fi3 = (x, y) -> {
			int result2 = x + y;
			return result2;
		};
		System.out.println(fi3.method(2, 5));
		
		fi3 = (x, y) -> {
			return x + y;
		};
		System.out.println(fi3.method(2, 5));
		
		fi3 = (x, y) -> x + y;	// return���� ���� ��� �߰�ȣ�� return�� ���� ����
		System.out.println(fi3.method(2, 5));
		
		fi3 = (x, y) -> sum(x, y);
		System.out.println(fi3.method(2, 5));
		
		// MyFunctionalInterface4
		// UsingThis - this ���
		UsingThis usingThis = new UsingThis();
		UsingThis.Inner inner = usingThis.new Inner();
		inner.method();
		
		// MyFunctionalInterface4
		// UsingLocalVariable - ���� ���� ���
		usingLocalVariable ulv = new usingLocalVariable();
		ulv.method(20);
		
		// Runnable
		// �Լ��� �������̽��� ���ٽ�
		Runnable runnable = () -> {	// ���ٽ�, �����尡 �����ϴ� �ڵ�
			for(int i = 0; i < 10; i++) {
				System.out.println(i);
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
		
		// ǥ�� API�� �Լ��� �������̽�
		// Consumer
		Consumer<String> consumer = t -> System.out.println(t + "8");
		consumer.accept("java");
		
		BiConsumer<String, String> bigConsumer = (t, u) -> System.out.println(t + u);
		bigConsumer.accept("java", "8");
		
		DoubleConsumer doubleConsumer = d -> System.out.println("java" + d);
		doubleConsumer.accept(8.0);
		
		ObjIntConsumer<String> ObjIntConsumer = (t, i) -> System.out.println(t + i);
		ObjIntConsumer.accept("java", 8);
		
		// Supplier
		IntSupplier intSupplier = () -> {
			int num = (int)(Math.random() * 6) + 1;
			return num;
		};
		
		int num = intSupplier.getAsInt();
		System.out.println("���� ��: " + num);
		
		// Function - Student
		System.out.println("[�л� �̸�]");
		printString(t -> t.getName());
		System.out.println("[���� ����]");
		printInt(t -> t.getEnglishScore());
		System.out.println("[���� ����]");
		printInt(t -> t.getMathScore());
		
		double englishAvg = avg(s -> s.getEnglishScore());
		System.out.println("���� ��� ����: " + englishAvg);
		double mathAvg = avg(s -> s.getMathScore());
		System.out.println("���� ��� ����: " + mathAvg);
		
		// Operator
		int max = maxOrMin (
			(a, b) -> {
				if(a >= b) return a;
				else return b;
			}
		);
		System.out.println("�ִ밪: " + max);
		
		int min = maxOrMin (
			(a, b) -> {
				if(a <= b) return a;
				else return b;
			}
		);
		System.out.println("�ּҰ�: " + min);
		
		// Predicate
		double maleAvg = avg2(t -> t.getSex().equals("����"));
		System.out.println("���� ��� ����: " + maleAvg);
		
		double femaleAvg = avg2(t -> t.getSex().equals("����"));
		System.out.println("���� ��� ����: " + femaleAvg);
		
		// Member - andThen() & compose()
		Consumer<Member> consumerA = (m) -> {
			System.out.println("consumerA: " + m.getName());
		};
		
		Consumer<Member> consumerB = (m) -> {
			System.out.println("consumerB: " + m.getId());
		};
		
		Consumer<Member> consumerAB = consumerA.andThen(consumerB);
		consumerAB.accept(new Member("ȫ�浿", "hong", null));
		
		IntPredicate predicateA = a -> a % 2 == 0;	//2�� ��� �˻�
		IntPredicate predicateB = (a) -> a % 3 == 0;	//3�� ��� �˻�
		IntPredicate predicateAB;
		boolean result;
		
		predicateAB = predicateA.and(predicateB);
		result = predicateAB.test(9);
		System.out.println("9�� 2�� 3�� ����Դϱ�? " + result);
		
		predicateAB = predicateA.or(predicateB);
		result = predicateAB.test(9);
		System.out.println("9�� 2 �Ǵ� 3�� ����Դϱ�? " + result);
		
		predicateAB = predicateA.negate();
		result = predicateAB.test(9);
		System.out.println("9�� Ȧ���Դϱ�? " + result);
		
		// Function�� ������ ����
		Function<Member, Address> functionA;
		Function<Address, String> functionB;
		Function<Member, String> functionAB;
		
		String city;
		functionA = (m) -> m.getAddress();
		functionB = (a) -> a.getCity();
		functionAB = functionA.andThen(functionB);
		city = functionAB.apply(
			new Member("ȫ�浿", "hong", new Address("�ѱ�", "����"))
		);
		System.out.println("���� ����: " + city);
		
		functionAB = functionB.compose(functionA);
		city = functionAB.apply(
			new Member("ȫ�浿", "hong", new Address("�ѱ�", "����"))
		);
		System.out.println("���� ����: " + city);
		
		// isEqual() ���� �޼���
		Predicate<String> predicate;
		predicate = Predicate.isEqual(null);
		System.out.println("null, null: " + predicate.test(null));
		predicate = Predicate.isEqual("Java8");
		System.out.println("null, Java8: " + predicate.test(null));
		predicate = Predicate.isEqual(null);
		System.out.println("Java8, null: " + predicate.test("Java8"));
		predicate = Predicate.isEqual("Java8");
		System.out.println("Java8, Java8: " + predicate.test("Java8"));
		predicate = Predicate.isEqual("Java7");
		System.out.println("Java7, Java8: " + predicate.test("Java8"));
		
		// Fruit
		// minBy() & maxBy() ���� �޼���
		BinaryOperator<Fruit> binaryOperator;
		Fruit fruit;
		binaryOperator = BinaryOperator.minBy((f1, f2) -> Integer.compare(f1.price, f2.price));
		fruit = binaryOperator.apply(new Fruit("����", 6000), new Fruit("����", 10000));
		System.out.println(fruit.name);
		
		binaryOperator = BinaryOperator.maxBy((f1, f2) -> Integer.compare(f1.price, f2.price));
		fruit = binaryOperator.apply(new Fruit("����", 6000), new Fruit("����", 10000));
		System.out.println(fruit.name);
		
		// Calculator
		// ���� �� �ν��Ͻ� �޼��� ����
		IntBinaryOperator operator;
		
		operator = (x, y) -> Calculator.staticMethod(x, y);	// ���� �޼��� ����
		System.out.println("���1: " + operator.applyAsInt(1, 2));
		operator = Calculator :: staticMethod;
		System.out.println("���2: " + operator.applyAsInt(3, 4));
		
		Calculator obj = new Calculator();	// �ν��Ͻ� �޼��� ����
		operator = (x, y) -> obj.instanceMethod(x, y);
		System.out.println("���3: " + operator.applyAsInt(5, 6));
		operator = obj :: instanceMethod;
		System.out.println("���4: " + operator.applyAsInt(7, 8));
		
		// �Ķ���� �޼��� ����
		ToIntBiFunction<String, String> function;
		
		function = (a, b) -> a.compareToIgnoreCase(b);
		print(function.applyAsInt("Java8", "JAVA8"));
		function = String :: compareToIgnoreCase;
		print(function.applyAsInt("Java8", "JAVA8"));
		
		// ������ ����
		Function<String, Member> function1 = Member :: new;
		Member member1 = function1.apply("angle");	// �Ķ���� �� 1��
		
		BiFunction<String, String, Member> function2 = Member :: new;
		Member member2 = function2.apply("��õ��", "angel");	// �Ķ���� �� 2��
	}
}
