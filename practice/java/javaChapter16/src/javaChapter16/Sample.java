package javaChapter16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sample {
	// ���� ó��
	public static void print(String str) {
		System.out.println(str + ": " + Thread.currentThread().getName());
	}
	
	// ���� ���� �ҽ� ��Ʈ��
	public static int sum;
	
	// ���� ó�� ���� - ���� ó�� VS ���� ó��
	public static void work(int value) {
		try {
			Thread.sleep(100);	// sleep ���� �������� ó�� ����
		} catch(InterruptedException e) {}
	}
	
	public static long testSequencial(List<Integer> list) {	// ���� ó��
		long start = System.nanoTime();
		list.stream().forEach((a) -> work(a));
		long end = System.nanoTime();
		long runTime = end - start;
		return runTime;
	}
	
	public static long testParallel(List<Integer> list) {	// ���� ó��
		long start = System.nanoTime();
		list.stream().parallel().forEach((a) -> work(a));
		long end = System.nanoTime();
		long runTime = end - start;
		return runTime;
	}
	
	// ���� ó�� ���� - ��Ʈ�� �ҽ� VS ���� ó��
	public static void work2(int value) {}
	
	public static long testParallel2(List<Integer> list) {	// ���� ó��
		long start = System.nanoTime();
		list.stream().parallel().forEach((a) -> work2(a));
		long end = System.nanoTime();
		long runTime = end - start;
		return runTime;
	}
	
	public static void main(String[] args) throws IOException {
		// �ݺ��� ��Ʈ��
		List<String> list = Arrays.asList("ȫ�浿", "�ſ��", "���ڹ�");
		
		Iterator<String> iterator = list.iterator();	// Iterator �̿�
		while(iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);
		}
		System.out.println();
		
		Stream<String> stream = list.stream();	// Stream �̿�
		stream.forEach(name -> System.out.println(name));
		
		// Student
		// ��� ó���� ���� ���ٽ�
		List<Student> sList = Arrays.asList(
			new Student("ȫ�浿", 90),
			new Student("�ſ��", 92)
		);
		
		Stream<Student> sStream = sList.stream();
		sStream.forEach(s -> {	// List �÷��ǿ��� Student ������ ���ٽ��� �Ķ���Ͱ����� ����
			String name = s.getName();
			int score = s.getScore();
			System.out.println(name + "-" + score);
		});
		
		// ���� ó��
		List<String> pList = Arrays.asList("ȫ�浿", "�ſ��", "���ڹ�", "���ٽ�", "�ں���");
		
		Stream<String> pStream = pList.stream();	// ���� ó��
		pStream.forEach(Sample :: print);
		System.out.println();
		
		Stream<String> parallelStream = pList.parallelStream();	// ���� ó��
		parallelStream.forEach(Sample :: print);
		
		// �߰� ó�� & ���� ó��
		List<Student> studentList = Arrays.asList(
			new Student("ȫ�浿", 10),
			new Student("�ſ��", 20),
			new Student("���̼�", 30)
		);
		
		double avg = studentList.stream()
				.mapToInt(Student :: getScore)	// �߰� ó��
				.average()	// ���� ó��
				.getAsDouble();
		
		System.out.println("��� ����: " + avg);
		
		// �÷������κ��� ��Ʈ�� ���
		Stream<Student> studentStream = studentList.stream();
		studentStream.forEach(s -> System.out.println(s.getName()));
		
		// �迭�κ��� ��Ʈ�� ���
		String[] strArray = {"ȫ�浿", "�ſ��", "��̳�"};
		Stream<String> strStream = Arrays.stream(strArray);
		strStream.forEach(a -> System.out.print(a + ", "));
		System.out.println();
		int[] intArray = {1, 2, 3, 4, 5};
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(a -> System.out.print(a + ", "));
		System.out.println();
		
		// ���� ���� �ҽ� ��Ʈ��
		IntStream iStream = IntStream.rangeClosed(1, 100);
		iStream.forEach(a -> sum += a);
		System.out.println("����: " + sum);
		
		// ���� ���� �ҽ� ��Ʈ��
		Path path = Paths.get("src/linedata.txt");	// ���� ��� ������ ������ �ִ� Path ��ü ����
		Stream<String> pathStream;
		
		pathStream = Files.lines(path, Charset.defaultCharset());	// � ü�� �⺻ ���ڼ�
		pathStream.forEach(System.out :: println);	// �޼��� ����, s -> System.out.println(s)�� ����
		System.out.println();
		
		File file = path.toFile();
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		pathStream = br.lines();
		pathStream.forEach(System.out :: println);
		
		// ���丮 ���� �ҽ� ��Ʈ��
		Path dPath = Paths.get("U:/�ڵ�/java/javaChapter16");
		Stream<Path> dStream = Files.list(dPath);
		dStream.forEach(p -> System.out.println(p.getFileName()));
		
		// Member
		// ��Ʈ�� ����������
		List<Member> mList = Arrays.asList(
			new Member("ȫ�浿", Member.MAIL, 30),
			new Member("�質��", Member.FEMAIL, 30),
			new Member("�ſ��", Member.MAIL, 45),
			new Member("�ڼ���", Member.FEMAIL, 27)
		);
		
		double ageAvg = mList.stream()
				.filter(m -> m.getSex() == Member.MAIL)
				.mapToInt(Member :: getAge)
				.average()
				.getAsDouble();
		
		System.out.println("���� ��� ����: " + ageAvg);
		
		// ���͸�
		List<String> names = Arrays.asList("ȫ�浿", "�ſ��", "���ڹ�", "�ſ��", "�Ź�ö");
		names.stream()
				.distinct()	// �ߺ� ����
				.forEach(n -> System.out.println(n));
		System.out.println();
		
		names.stream()
				.filter(n -> n.startsWith("��"))	// ���͸�
				.forEach(n -> System.out.println(n));
		System.out.println();
		
		names.stream()
				.distinct()
				.filter(n -> n.startsWith("��"))
				.forEach(n -> System.out.println(n));
		
		// ����
		// flastMAppXXX() �޼���
		List<String> inputList1 = Arrays.asList("java8 lambda", "stream mapping");
		inputList1.stream()
				.flatMap(data -> Arrays.stream(data.split(" ")))
				.forEach(word -> System.out.println(word));
		System.out.println();
		
		List<String> inputList2 = Arrays.asList("10, 20, 30", "40, 50, 60");
		inputList2.stream()
				.flatMapToInt(data -> {
					String[] strArr = data.split(",");
					int[] intArr = new int[strArr.length];
					for(int i = 0; i < strArr.length; i++) {
						intArr[i] = Integer.parseInt(strArr[i].trim());
					}
					return Arrays.stream(intArr);
				})
				.forEach(number -> System.out.println(number));
		
		// mapXXX() �޼���
		List<Student> stuList = Arrays.asList(
			new Student("ȫ�浿", 10),
			new Student("�ſ��", 20),
			new Student("���̼�", 30)
		);
		stuList.stream()
			.mapToInt(Student :: getScore)
			.forEach(score -> System.out.println(score));
		
		// asDoubleStream(), asLongStream(), boxed() �޼���
		int[] intAry = {1, 2, 3, 4, 5};
		
		IntStream intStrm = Arrays.stream(intAry);
		intStrm.asDoubleStream().forEach(d -> System.out.println(d));	// DoubleStream ����
		System.out.println();
		
		intStrm = Arrays.stream(intAry);
		intStrm.boxed().forEach(obj -> System.out.println(obj.intValue()));
		
		// ����
		IntStream sortStream = Arrays.stream(new int[] {5, 3, 2, 1, 4});	// ���� ���
		sortStream.sorted().forEach(n -> System.out.print(n + ", "));
		System.out.println();
		
		List<Student> sortList = Arrays.asList(	// ��ü ���
				new Student("ȫ�浿", 30),
				new Student("�ſ��", 10),
				new Student("���̼�", 20)
			);
		
		sortList.stream()
				.sorted()
				.forEach(s -> System.out.print(s.getScore() + ", "));	// ���� ���� ��������
		System.out.println();
		
		sortList.stream()
				.sorted(Comparator.reverseOrder())
				.forEach(s -> System.out.print(s.getScore() + ", "));	// ���� ���� ��������
		System.out.println();
		
		// ����
		int[] loopArr = {1, 2, 3, 4, 5};
		System.out.println("[peek()�� �������� ȣ���� ���]");
		Arrays.stream(loopArr)
				.filter(a -> a % 2 == 0)
				.peek(n -> System.out.println(n));	// �������� ����
		
		System.out.println("[���� ó�� �޼��带 �������� ȣ���� ���]");
		int total = Arrays.stream(loopArr)
				.filter(a -> a % 2 == 0)
				.peek(n -> System.out.println(n)).sum();	// ����
		System.out.println("����: " + total);
		
		System.out.println("[forEach()�� �������� ȣ���� ���]");
		Arrays.stream(loopArr)
				.filter(a -> a % 2 == 0)
				.forEach(n -> System.out.println(n));	// ���� �޼���� ����\
		
		// ��Ī
		int[] matchArr = {2, 4, 6};
		boolean result = Arrays.stream(matchArr).allMatch(a -> a % 2 == 0);
		System.out.println("��� 2�� ����ΰ�? " + result);
		
		result = Arrays.stream(matchArr).anyMatch(a -> a % 3 == 0);
		System.out.println("�ϳ��� 3�� ����ΰ�? " + result);
		
		result = Arrays.stream(matchArr).noneMatch(a -> a % 3 == 0);
		System.out.println("��� 3�� ����� �ƴѰ�? " + result);
		
		// �⺻ ����
		long count = Arrays.stream(new int[] {1, 2, 3, 4, 5})
				.filter(n -> n % 2 == 0).count();
		System.out.println("2�� ��� ����: " + count);
		
		long sum = Arrays.stream(new int[] {1, 2, 3, 4, 5})
				.filter(n -> n % 2 == 0).sum();
		System.out.println("2�� ����� ��: " + sum);
		
		double doubleAvg = Arrays.stream(new int[] {1, 2, 3, 4, 5})
				.filter(n -> n % 2 == 0).average().getAsDouble();
		System.out.println("2�� ����� ���: " + doubleAvg);
		
		int max = Arrays.stream(new int[] {1, 2, 3, 4, 5})
				.filter(n -> n % 2 == 0).max().getAsInt();
		System.out.println("�ִ밪: " + max);
		
		int min = Arrays.stream(new int[] {1, 2, 3, 4, 5})
				.filter(n -> n % 2 == 0).min().getAsInt();
		System.out.println("�ּҰ�: " + min);
		
		int first = Arrays.stream(new int[] {1, 2, 3, 4, 5})
				.filter(n -> n % 3 == 0).findFirst().getAsInt();
		System.out.println("ù��° 3�� ���: " + first);
		
		// Optional Ŭ����
		List<Integer> olist = new ArrayList<>();
//		double oavg = olist.stream().mapToInt(Integer :: intValue).average().getAsDouble();	// ���� �߻�
		OptionalDouble optional = olist.stream()
				.mapToInt(Integer :: intValue)
				.average();
		if(optional.isPresent()) {
			System.out.println("���1 ���: " + optional.getAsDouble());
		} else {
			System.out.println("���1 ��� : 0.0 ");
		}
		
		double oavg = olist.stream()
				.mapToInt(Integer :: intValue)
				.average()
				.orElse(0.0);
		System.out.println("���2 ���: " + oavg);
		
		olist.stream()
				.mapToInt(Integer :: intValue)
				.average()
				.ifPresent(a -> System.out.println("���3 ���: " + a));
		
		// Ŀ���� ���� - reduce()
		List<Student> rlist = Arrays.asList(
				new Student("ȫ�浿", 92),
				new Student("�ſ��", 95),
				new Student("���ڹ�", 88)
			);
		
		int sum1 = rlist.stream().mapToInt(Student :: getScore).sum();
		int sum2 = rlist.stream().map(Student :: getScore).reduce((a, b) -> a + b).get();
		int sum3 = rlist.stream().map(Student :: getScore).reduce(0, (a, b) -> a + b);
		
		System.out.println("sum1: " + sum1);
		System.out.println("sum2: " + sum2);
		System.out.println("sum3: " + sum3);
		
		// ����
		List<Student> totalList = Arrays.asList(
					new Student("ȫ�浿", 10, Student.Sex.MALE),
					new Student("�����", 6, Student.Sex.FEMALE),
					new Student("�ſ��", 10, Student.Sex.MALE),
					new Student("�ڼ���", 6, Student.Sex.FEMALE)
				);
		
		List<Student> maleList = totalList.stream()
				.filter(s -> s.getSex() == Student.Sex.MALE)
				.collect(Collectors.toList());
		maleList.stream().forEach(s -> System.out.println(s.getName()));
		System.out.println();
		
		Set<Student> femaleSet = totalList.stream()
				.filter(s -> s.getSex() == Student.Sex.FEMALE)
				.collect(Collectors.toCollection(HashSet :: new));
		femaleSet.stream().forEach(s -> System.out.println(s.getName()));
		
		// MaleStudent
		// ����� ���� �����̳ʿ� �����ϱ�
		MaleStudent maleStudent = totalList.stream()
				.filter(s -> s.getSex() == Student.Sex.MALE)
				.collect(MaleStudent :: new, MaleStudent :: accumulate, MaleStudent :: combine);
		maleStudent.getList().stream().forEach(s -> System.out.println(s.getName()));
		
		// ��Ҹ� �׷����ؼ� ����
		List<Student> totList = Arrays.asList(
				new Student("ȫ�浿", 10, Student.Sex.MALE, Student.City.Seoul),
				new Student("�����", 6, Student.Sex.FEMALE, Student.City.Pusan),
				new Student("�ſ��", 10, Student.Sex.MALE, Student.City.Pusan),
				new Student("�ڼ���", 6, Student.Sex.FEMALE, Student.City.Seoul)
			);
		
		Map<Student.Sex, List<Student>> mapBySex = totList.stream()
				.collect(Collectors.groupingBy(Student :: getSex));
		
		System.out.print("[���л�]");
		mapBySex.get(Student.Sex.MALE).stream()
				.forEach(s -> System.out.print(s.getName() + " "));
		
		System.out.print("\n[���л�]");
		mapBySex.get(Student.Sex.FEMALE).stream()
				.forEach(s -> System.out.print(s.getName() + " "));
		System.out.println();
		
		Map<Student.City, List<String>> mapByCity = totList.stream()
				.collect(Collectors.groupingBy(Student :: getCity,
						Collectors.mapping(Student :: getName, Collectors.toList())));
		
		System.out.print("\n[����]");
		mapByCity.get(Student.City.Seoul).stream()
				.forEach(s -> System.out.print(s + " "));
		
		System.out.print("\n[�λ�]");
		mapByCity.get(Student.City.Pusan).stream()
				.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		// �׷��� �� ������
		Map<Student.Sex, Double> mapBySex2 = totalList.stream()	// ������ ��� ���� �����ϴ� Map ���
				.collect(Collectors.groupingBy(Student :: getSex,
						Collectors.averagingDouble(Student :: getScore)));
		System.out.println("���л� ��� ����: " + mapBySex2.get(Student.Sex.MALE));
		System.out.println("���л� ��� ����: " + mapBySex2.get(Student.Sex.FEMALE));
		
		Map<Student.Sex, String> mapByName = totalList.stream()	// ������ ��� ���� �����ϴ� Map ���
				.collect(Collectors.groupingBy(Student :: getSex,
						Collectors.mapping(Student :: getName, Collectors.joining(", "))));
		System.out.println("���л� ��ü �̸�: " + mapByName.get(Student.Sex.MALE));
		System.out.println("���л� ��ü �̸�: " + mapByName.get(Student.Sex.FEMALE));
		
		// ���� ó��
		MaleStudent mStudent = totalList.parallelStream()
				.filter(s -> s.getSex() == Student.Sex.MALE)
				.collect(MaleStudent :: new, MaleStudent :: accumulate, MaleStudent :: combine);
		mStudent.getList().stream().forEach(s -> System.out.println(s.getName()));
		
		// ���� ó�� ���� - ���� ó�� VS ���� ó��
		List<Integer> testList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);	// �ҽ� �÷���
		long timeSequencial = testSequencial(testList);	// ���� ��Ʈ�� ó�� �ð� ���ϱ�
		long timeParallel = testParallel(testList);	// ���� ��Ʈ�� ó�� �ð� ���ϱ�
		if(timeSequencial < timeParallel) {
			System.out.println("���� �׽�Ʈ ���: ���� ó���� �� ����");
		} else {
			System.out.println("���� �׽�Ʈ ���: ���� ó���� �� ����");
		}
		
		// ���� ó�� ���� - ��Ʈ�� �ҽ� VS ���� ó��
		List<Integer> arrayList = new ArrayList<Integer>();	// �ҽ� �÷���
		List<Integer> linkedList = new LinkedList<Integer>();
		for(int i = 0; i < 1000000; i++) {
			arrayList.add(i);
			linkedList.add(i);
		}
		
		long arrayListParallel = testParallel2(arrayList);	// ���־�
		long linkedListParallel = testParallel2(linkedList);
		
		arrayListParallel = testParallel2(arrayList);	// ���� ��Ʈ�� ó�� �ð� ���ϱ�
		linkedListParallel = testParallel2(linkedList);
		if(arrayListParallel < linkedListParallel) {
			System.out.println("���� �׽�Ʈ ���: ArrayList ó���� �� ����");
		} else {
			System.out.println("���� �׽�Ʈ ���: LinkedList ó���� �� ����");
		}
	}
}