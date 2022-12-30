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
	// 병렬 처리
	public static void print(String str) {
		System.out.println(str + ": " + Thread.currentThread().getName());
	}
	
	// 정수 범위 소스 스트림
	public static int sum;
	
	// 병렬 처리 성능 - 순차 처리 VS 병렬 처리
	public static void work(int value) {
		try {
			Thread.sleep(100);	// sleep 값이 작을수록 처리 빠름
		} catch(InterruptedException e) {}
	}
	
	public static long testSequencial(List<Integer> list) {	// 순차 처리
		long start = System.nanoTime();
		list.stream().forEach((a) -> work(a));
		long end = System.nanoTime();
		long runTime = end - start;
		return runTime;
	}
	
	public static long testParallel(List<Integer> list) {	// 병렬 처리
		long start = System.nanoTime();
		list.stream().parallel().forEach((a) -> work(a));
		long end = System.nanoTime();
		long runTime = end - start;
		return runTime;
	}
	
	// 병렬 처리 성능 - 스트림 소스 VS 병렬 처리
	public static void work2(int value) {}
	
	public static long testParallel2(List<Integer> list) {	// 병렬 처리
		long start = System.nanoTime();
		list.stream().parallel().forEach((a) -> work2(a));
		long end = System.nanoTime();
		long runTime = end - start;
		return runTime;
	}
	
	public static void main(String[] args) throws IOException {
		// 반복자 스트림
		List<String> list = Arrays.asList("홍길동", "신용권", "김자바");
		
		Iterator<String> iterator = list.iterator();	// Iterator 이용
		while(iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);
		}
		System.out.println();
		
		Stream<String> stream = list.stream();	// Stream 이용
		stream.forEach(name -> System.out.println(name));
		
		// Student
		// 요소 처리를 위한 람다식
		List<Student> sList = Arrays.asList(
			new Student("홍길동", 90),
			new Student("신용권", 92)
		);
		
		Stream<Student> sStream = sList.stream();
		sStream.forEach(s -> {	// List 컬렉션에서 Student 가져와 람다식의 파라미터값으로 제공
			String name = s.getName();
			int score = s.getScore();
			System.out.println(name + "-" + score);
		});
		
		// 병렬 처리
		List<String> pList = Arrays.asList("홍길동", "신용권", "김자바", "람다식", "박병렬");
		
		Stream<String> pStream = pList.stream();	// 순차 처리
		pStream.forEach(Sample :: print);
		System.out.println();
		
		Stream<String> parallelStream = pList.parallelStream();	// 병렬 처리
		parallelStream.forEach(Sample :: print);
		
		// 중간 처리 & 최종 처리
		List<Student> studentList = Arrays.asList(
			new Student("홍길동", 10),
			new Student("신용권", 20),
			new Student("유미선", 30)
		);
		
		double avg = studentList.stream()
				.mapToInt(Student :: getScore)	// 중간 처리
				.average()	// 최종 처리
				.getAsDouble();
		
		System.out.println("평균 점수: " + avg);
		
		// 컬렉션으로부터 스트림 얻기
		Stream<Student> studentStream = studentList.stream();
		studentStream.forEach(s -> System.out.println(s.getName()));
		
		// 배열로부터 스트림 얻기
		String[] strArray = {"홍길동", "신용권", "김미나"};
		Stream<String> strStream = Arrays.stream(strArray);
		strStream.forEach(a -> System.out.print(a + ", "));
		System.out.println();
		int[] intArray = {1, 2, 3, 4, 5};
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(a -> System.out.print(a + ", "));
		System.out.println();
		
		// 정수 범위 소스 스트림
		IntStream iStream = IntStream.rangeClosed(1, 100);
		iStream.forEach(a -> sum += a);
		System.out.println("총합: " + sum);
		
		// 파일 내용 소스 스트림
		Path path = Paths.get("src/linedata.txt");	// 파일 경로 정보를 가지고 있는 Path 객체 생성
		Stream<String> pathStream;
		
		pathStream = Files.lines(path, Charset.defaultCharset());	// 운영 체제 기본 문자셋
		pathStream.forEach(System.out :: println);	// 메서드 참조, s -> System.out.println(s)와 동일
		System.out.println();
		
		File file = path.toFile();
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		pathStream = br.lines();
		pathStream.forEach(System.out :: println);
		
		// 디렉토리 내용 소스 스트림
		Path dPath = Paths.get("U:/코딩/java/javaChapter16");
		Stream<Path> dStream = Files.list(dPath);
		dStream.forEach(p -> System.out.println(p.getFileName()));
		
		// Member
		// 스트림 파이프라인
		List<Member> mList = Arrays.asList(
			new Member("홍길동", Member.MAIL, 30),
			new Member("김나리", Member.FEMAIL, 30),
			new Member("신용권", Member.MAIL, 45),
			new Member("박수미", Member.FEMAIL, 27)
		);
		
		double ageAvg = mList.stream()
				.filter(m -> m.getSex() == Member.MAIL)
				.mapToInt(Member :: getAge)
				.average()
				.getAsDouble();
		
		System.out.println("남자 평균 나이: " + ageAvg);
		
		// 필터링
		List<String> names = Arrays.asList("홍길동", "신용권", "김자바", "신용권", "신민철");
		names.stream()
				.distinct()	// 중복 제거
				.forEach(n -> System.out.println(n));
		System.out.println();
		
		names.stream()
				.filter(n -> n.startsWith("신"))	// 필터링
				.forEach(n -> System.out.println(n));
		System.out.println();
		
		names.stream()
				.distinct()
				.filter(n -> n.startsWith("신"))
				.forEach(n -> System.out.println(n));
		
		// 매핑
		// flastMAppXXX() 메서드
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
		
		// mapXXX() 메서드
		List<Student> stuList = Arrays.asList(
			new Student("홍길동", 10),
			new Student("신용권", 20),
			new Student("유미선", 30)
		);
		stuList.stream()
			.mapToInt(Student :: getScore)
			.forEach(score -> System.out.println(score));
		
		// asDoubleStream(), asLongStream(), boxed() 메서드
		int[] intAry = {1, 2, 3, 4, 5};
		
		IntStream intStrm = Arrays.stream(intAry);
		intStrm.asDoubleStream().forEach(d -> System.out.println(d));	// DoubleStream 생성
		System.out.println();
		
		intStrm = Arrays.stream(intAry);
		intStrm.boxed().forEach(obj -> System.out.println(obj.intValue()));
		
		// 정렬
		IntStream sortStream = Arrays.stream(new int[] {5, 3, 2, 1, 4});	// 숫자 요소
		sortStream.sorted().forEach(n -> System.out.print(n + ", "));
		System.out.println();
		
		List<Student> sortList = Arrays.asList(	// 객체 요소
				new Student("홍길동", 30),
				new Student("신용권", 10),
				new Student("유미선", 20)
			);
		
		sortList.stream()
				.sorted()
				.forEach(s -> System.out.print(s.getScore() + ", "));	// 점수 기준 오름차순
		System.out.println();
		
		sortList.stream()
				.sorted(Comparator.reverseOrder())
				.forEach(s -> System.out.print(s.getScore() + ", "));	// 점수 기준 내림차순
		System.out.println();
		
		// 루핑
		int[] loopArr = {1, 2, 3, 4, 5};
		System.out.println("[peek()를 마지막에 호출한 경우]");
		Arrays.stream(loopArr)
				.filter(a -> a % 2 == 0)
				.peek(n -> System.out.println(n));	// 동작하지 않음
		
		System.out.println("[최종 처리 메서드를 마지막에 호출한 경우]");
		int total = Arrays.stream(loopArr)
				.filter(a -> a % 2 == 0)
				.peek(n -> System.out.println(n)).sum();	// 동작
		System.out.println("총합: " + total);
		
		System.out.println("[forEach()를 마지막에 호출한 경우]");
		Arrays.stream(loopArr)
				.filter(a -> a % 2 == 0)
				.forEach(n -> System.out.println(n));	// 최종 메서드로 동작\
		
		// 매칭
		int[] matchArr = {2, 4, 6};
		boolean result = Arrays.stream(matchArr).allMatch(a -> a % 2 == 0);
		System.out.println("모두 2의 배수인가? " + result);
		
		result = Arrays.stream(matchArr).anyMatch(a -> a % 3 == 0);
		System.out.println("하나라도 3의 배수인가? " + result);
		
		result = Arrays.stream(matchArr).noneMatch(a -> a % 3 == 0);
		System.out.println("모두 3의 배수가 아닌가? " + result);
		
		// 기본 집계
		long count = Arrays.stream(new int[] {1, 2, 3, 4, 5})
				.filter(n -> n % 2 == 0).count();
		System.out.println("2의 배수 개수: " + count);
		
		long sum = Arrays.stream(new int[] {1, 2, 3, 4, 5})
				.filter(n -> n % 2 == 0).sum();
		System.out.println("2의 배수의 합: " + sum);
		
		double doubleAvg = Arrays.stream(new int[] {1, 2, 3, 4, 5})
				.filter(n -> n % 2 == 0).average().getAsDouble();
		System.out.println("2의 배수의 평균: " + doubleAvg);
		
		int max = Arrays.stream(new int[] {1, 2, 3, 4, 5})
				.filter(n -> n % 2 == 0).max().getAsInt();
		System.out.println("최대값: " + max);
		
		int min = Arrays.stream(new int[] {1, 2, 3, 4, 5})
				.filter(n -> n % 2 == 0).min().getAsInt();
		System.out.println("최소값: " + min);
		
		int first = Arrays.stream(new int[] {1, 2, 3, 4, 5})
				.filter(n -> n % 3 == 0).findFirst().getAsInt();
		System.out.println("첫번째 3의 배수: " + first);
		
		// Optional 클래스
		List<Integer> olist = new ArrayList<>();
//		double oavg = olist.stream().mapToInt(Integer :: intValue).average().getAsDouble();	// 예외 발생
		OptionalDouble optional = olist.stream()
				.mapToInt(Integer :: intValue)
				.average();
		if(optional.isPresent()) {
			System.out.println("방법1 평균: " + optional.getAsDouble());
		} else {
			System.out.println("방법1 평균 : 0.0 ");
		}
		
		double oavg = olist.stream()
				.mapToInt(Integer :: intValue)
				.average()
				.orElse(0.0);
		System.out.println("방법2 평균: " + oavg);
		
		olist.stream()
				.mapToInt(Integer :: intValue)
				.average()
				.ifPresent(a -> System.out.println("방법3 평균: " + a));
		
		// 커스텀 집계 - reduce()
		List<Student> rlist = Arrays.asList(
				new Student("홍길동", 92),
				new Student("신용권", 95),
				new Student("김자바", 88)
			);
		
		int sum1 = rlist.stream().mapToInt(Student :: getScore).sum();
		int sum2 = rlist.stream().map(Student :: getScore).reduce((a, b) -> a + b).get();
		int sum3 = rlist.stream().map(Student :: getScore).reduce(0, (a, b) -> a + b);
		
		System.out.println("sum1: " + sum1);
		System.out.println("sum2: " + sum2);
		System.out.println("sum3: " + sum3);
		
		// 수집
		List<Student> totalList = Arrays.asList(
					new Student("홍길동", 10, Student.Sex.MALE),
					new Student("김수애", 6, Student.Sex.FEMALE),
					new Student("신용권", 10, Student.Sex.MALE),
					new Student("박수미", 6, Student.Sex.FEMALE)
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
		// 사용자 정의 컨테이너에 수집하기
		MaleStudent maleStudent = totalList.stream()
				.filter(s -> s.getSex() == Student.Sex.MALE)
				.collect(MaleStudent :: new, MaleStudent :: accumulate, MaleStudent :: combine);
		maleStudent.getList().stream().forEach(s -> System.out.println(s.getName()));
		
		// 요소를 그룹핑해서 수집
		List<Student> totList = Arrays.asList(
				new Student("홍길동", 10, Student.Sex.MALE, Student.City.Seoul),
				new Student("김수애", 6, Student.Sex.FEMALE, Student.City.Pusan),
				new Student("신용권", 10, Student.Sex.MALE, Student.City.Pusan),
				new Student("박수미", 6, Student.Sex.FEMALE, Student.City.Seoul)
			);
		
		Map<Student.Sex, List<Student>> mapBySex = totList.stream()
				.collect(Collectors.groupingBy(Student :: getSex));
		
		System.out.print("[남학생]");
		mapBySex.get(Student.Sex.MALE).stream()
				.forEach(s -> System.out.print(s.getName() + " "));
		
		System.out.print("\n[여학생]");
		mapBySex.get(Student.Sex.FEMALE).stream()
				.forEach(s -> System.out.print(s.getName() + " "));
		System.out.println();
		
		Map<Student.City, List<String>> mapByCity = totList.stream()
				.collect(Collectors.groupingBy(Student :: getCity,
						Collectors.mapping(Student :: getName, Collectors.toList())));
		
		System.out.print("\n[서울]");
		mapByCity.get(Student.City.Seoul).stream()
				.forEach(s -> System.out.print(s + " "));
		
		System.out.print("\n[부산]");
		mapByCity.get(Student.City.Pusan).stream()
				.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		// 그룹핑 후 리덕션
		Map<Student.Sex, Double> mapBySex2 = totalList.stream()	// 성별로 평균 점수 저장하는 Map 얻기
				.collect(Collectors.groupingBy(Student :: getSex,
						Collectors.averagingDouble(Student :: getScore)));
		System.out.println("남학생 평균 점수: " + mapBySex2.get(Student.Sex.MALE));
		System.out.println("여학생 평균 점수: " + mapBySex2.get(Student.Sex.FEMALE));
		
		Map<Student.Sex, String> mapByName = totalList.stream()	// 성별로 평균 점수 저장하는 Map 얻기
				.collect(Collectors.groupingBy(Student :: getSex,
						Collectors.mapping(Student :: getName, Collectors.joining(", "))));
		System.out.println("남학생 전체 이름: " + mapByName.get(Student.Sex.MALE));
		System.out.println("여학생 전체 이름: " + mapByName.get(Student.Sex.FEMALE));
		
		// 병렬 처리
		MaleStudent mStudent = totalList.parallelStream()
				.filter(s -> s.getSex() == Student.Sex.MALE)
				.collect(MaleStudent :: new, MaleStudent :: accumulate, MaleStudent :: combine);
		mStudent.getList().stream().forEach(s -> System.out.println(s.getName()));
		
		// 병렬 처리 성능 - 순차 처리 VS 병렬 처리
		List<Integer> testList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);	// 소스 컬렉션
		long timeSequencial = testSequencial(testList);	// 순차 스트림 처리 시간 구하기
		long timeParallel = testParallel(testList);	// 병렬 스트림 처리 시간 구하기
		if(timeSequencial < timeParallel) {
			System.out.println("성능 테스트 결과: 순차 처리가 더 빠름");
		} else {
			System.out.println("성능 테스트 결과: 병렬 처리가 더 빠름");
		}
		
		// 병렬 처리 성능 - 스트림 소스 VS 병렬 처리
		List<Integer> arrayList = new ArrayList<Integer>();	// 소스 컬렉션
		List<Integer> linkedList = new LinkedList<Integer>();
		for(int i = 0; i < 1000000; i++) {
			arrayList.add(i);
			linkedList.add(i);
		}
		
		long arrayListParallel = testParallel2(arrayList);	// 워밍업
		long linkedListParallel = testParallel2(linkedList);
		
		arrayListParallel = testParallel2(arrayList);	// 순차 스트림 처리 시간 구하기
		linkedListParallel = testParallel2(linkedList);
		if(arrayListParallel < linkedListParallel) {
			System.out.println("성능 테스트 결과: ArrayList 처리가 더 빠름");
		} else {
			System.out.println("성능 테스트 결과: LinkedList 처리가 더 빠름");
		}
	}
}