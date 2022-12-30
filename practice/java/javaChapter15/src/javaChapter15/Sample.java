package javaChapter15;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class Sample {
	public static void main(String[] args) throws Exception {
		// 컬렉션 프레임워크 - List 컬렉션
		// ArrayList
		List<String> list = new ArrayList<String>();
		list.add("Java");	// String 객체 저장
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("iBATIS");
		int size = list.size();
		System.out.println("총 객체수: " + size);
		System.out.println();
		
		String skill = list.get(2);	// 2번 인덱스 객체 얻기
		System.out.println("2: " + skill);
		System.out.println();
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ": " + str);
		}
		System.out.println();
		
		list.remove(2);	// 2번 인덱스 객체(Database) 삭제
		list.remove(2);	// 2번 인덱스 객체(Servlit/JSP) 삭제
		list.remove("iBATIS");
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ": " + str);
		}
		
		List<String> list1 = Arrays.asList("홍길동", "신용권", "김자바");
		for(String name : list1) {
			System.out.println(name);
		}
		
		List<Integer> list2 = Arrays.asList(1, 2, 3);
		for(int value : list2) {
			System.out.println(value);
		}
		
		// Vector
		List<Board> vlist = new Vector<Board>();
		
		vlist.add(new Board("제목1", "내용1", "글쓴이1"));
		vlist.add(new Board("제목2", "내용2", "글쓴이2"));
		vlist.add(new Board("제목3", "내용3", "글쓴이3"));
		vlist.add(new Board("제목4", "내용4", "글쓴이4"));
		vlist.add(new Board("제목5", "내용5", "글쓴이5"));
		
		vlist.remove(2);
		vlist.remove(3);
		
		for(int i = 0; i < vlist.size(); i++) {
			Board board = vlist.get(i);
			System.out.println(board.subject + "\t" + board.content + "\t" + board.writer);
		}
		
		// LinkedList
		List<String> llist1 = new ArrayList<String>();
		List<String> llist2 = new LinkedList<String>();
		long startTime;
		long endTime;
		startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			llist1.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList 걸린시간: " + (endTime - startTime) + "ns");
		
		startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			llist2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList 걸린시간: " + (endTime - startTime) + "ns");
		
		// 컬렉션 프레임워크 - Set 컬렉션
		// HashSet
		Set<String> set = new HashSet<String>();
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("iBATIS");
		int hsize = set.size();
		System.out.println("총 객체수: " + hsize);
		
		Iterator<String> iterator = set.iterator();	// 반복자 얻기
		while(iterator.hasNext()) {	// 객체 수만큼 루핑
			String element = iterator.next();	// 한 개의 객체 가져오기
			System.out.println("\t" + element);
		}
		set.remove("JDBC");
		set.remove("iBATIS");
		System.out.println("총 객체수: " + set.size());
		iterator = set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		set.clear();
		if(set.isEmpty()) {
			System.out.println("비어있음");
		}
		
		// HashSet - Member
		Set<Member> mset = new HashSet<Member>();
		
		mset.add(new Member("홍길동", 30));	// 인스턴스 다르지만 내부 데이터 동일해 객체 1개만 저장함
		mset.add(new Member("홍길동", 30));
		
		System.out.println("총 객체수: " + mset.size());
		
		// 컬렉션 프레임워크 - Map 컬렉션
		// HashMap
		Map<String, Integer> map = new HashMap<String, Integer>();	// Map 컬렉션 생성
		map.put("신용권", 85);	// 객체 저장
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95);
		System.out.println("총 Entry 수: " + map.size());
		System.out.println("\t홍길동: " + map.get("홍길동"));	// 객체 찾기, 이름(키)로 점수(값) 검색
		System.out.println();
		
		Set<String> keySet = map.keySet();	// 객체 하나씩 처리, Key Set 얻음
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {	// 반복해서 키를 얻고 값을 Map에서 얻음
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println("\t" + key + ": " + value);
		}
		System.out.println();
		map.remove("홍길동");	// 객체 삭제, 키로 Map.Entry 제거
		System.out.println("총 Entry 수: " + map.size());
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();	// Map.Entry Set 얻음
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()) {	// 반복해서 Map.Entry 얻고 키와 값 얻음
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t" + key + ": " + value);
		}
		System.out.println();
		map.clear();	// 모든 Map.Entry 객체 삭제
		System.out.println("총 Entry 수: " + map.size());
		
		// Student - hashCode()와 equals() 재정의
		Map<Student, Integer> smap = new HashMap<Student, Integer>();
		smap.put(new Student(1, "홍길동"), 95);	// 학번과 이름 동일한 Student 키로 저장
		smap.put(new Student(1, "홍길동"), 95);
		System.out.println("총 Entry 수: " + smap.size());
		
		// Hashtable
		Map<String, String> tmap = new Hashtable<String, String>();
		tmap.put("spring", "12");	// 아이디와 비밀번호 저장
		tmap.put("summer", "123");
		tmap.put("fall", "1234");
		tmap.put("winter", "12345");
		
		Scanner scanner = new Scanner(System.in);	// 키보드 입력 받기
		while(true) {
			System.out.println("아이디와 비밀번호를 입력해주세요");
			System.out.print("아이디: ");
			String id = scanner.nextLine();
			System.out.print("비밀번호: ");
			String password = scanner.nextLine();
			System.out.println();
			
			if(tmap.containsKey(id)) {	// 아이디 존재여부 확인
				if(tmap.get(id).equals(password)) {
					System.out.println("로그인 되었습니다.");
					break;
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			} else {
				System.out.println("입력하신 아이디가 존재하지 않습니다.");
			}
		}
		
		// Properties
		Properties properties = new Properties();
		
		String path = Sample.class.getResource("database.properties").getPath();
		path = URLDecoder.decode(path, "UTF-8");
		properties.load(new FileReader(path));
		
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		System.out.println("driver: " + driver);
		System.out.println("url: " + url);
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		
		// 검색 기능 강화시킨 컬렉션
		// 이진 트리 구조(binary tree) - TreeSet
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(new Integer(87));
		scores.add(new Integer(98));
		scores.add(new Integer(75));
		scores.add(new Integer(95));
		scores.add(new Integer(80));
		
		Integer score = null;
		
		score = scores.first();
		System.out.println("가장 낮은 점수: " + score);
		
		score = scores.last();
		System.out.println("가장 높은 점수: " + score + "\n");
		
		score = scores.lower(new Integer(95));
		System.out.println("95점 아래 점수: " + score);
		
		score = scores.higher(new Integer(95));
		System.out.println("95점 위의 점수: " + score + "\n");
		
		score = scores.floor(new Integer(95));
		System.out.println("95점이거나 바로 아래 점수: " + score);
		
		score = scores.ceiling(new Integer(85));
		System.out.println("85점이거나 바로 위의 점수: " + score + "\n");
		
		while(!scores.isEmpty()) {
			score = scores.pollFirst();
			System.out.println(score + " (남은 객체 수 : " + scores.size() + ")");
		}
		
		TreeSet<Integer> sortingScores = new TreeSet<Integer>();
		
		sortingScores.add(new Integer(87));
		sortingScores.add(new Integer(98));
		sortingScores.add(new Integer(75));
		sortingScores.add(new Integer(95));
		sortingScores.add(new Integer(80));
		
		NavigableSet<Integer> descendingSet = sortingScores.descendingSet();
		for(Integer sortingScore : descendingSet) {
			System.out.println(sortingScore);
		}
		System.out.println();
		
		NavigableSet<Integer> ascendingSet = descendingSet.descendingSet();
		for(Integer sortingScore : ascendingSet) {
			System.out.println(sortingScore);
		}
		
		TreeSet<String> treeSet = new TreeSet<String>();
		
		treeSet.add("apple");
		treeSet.add("forever");
		treeSet.add("description");
		treeSet.add("ever");
		treeSet.add("zoo");
		treeSet.add("base");
		treeSet.add("guess");
		treeSet.add("cherry");
		
		System.out.println("[c~f 사이의 단어 검색]");
		NavigableSet<String> rangeSet = treeSet.subSet("c", true, "f", true);
		
		for(String word : rangeSet) {
			System.out.println(word);
		}
		
		// 이진 트리 구조(binary tree) - TreeMap
		TreeMap<Integer, String> mapScores = new TreeMap<Integer, String>();
		mapScores.put(new Integer(87), "홍길동");
		mapScores.put(new Integer(98), "이동수");
		mapScores.put(new Integer(75), "박길순");
		mapScores.put(new Integer(95), "신용권");
		mapScores.put(new Integer(80), "김자바");
		
		Map.Entry<Integer, String> entry = null;
		entry = mapScores.firstEntry();
		System.out.println("가장 낮은 점수: " + entry.getKey() + "-" + entry.getValue());
		entry = mapScores.lastEntry();
		System.out.println("가장 높은 점수: " + entry.getKey() + "-" + entry.getValue() + "\n");
		
		entry = mapScores.lowerEntry(new Integer(95));
		System.out.println("95점 아래 점수: " + entry.getKey() + "-" + entry.getValue());
		entry = mapScores.higherEntry(new Integer(95));
		System.out.println("95점 위의 점수: " + entry.getKey() + "-" + entry.getValue() + "\n");
		
		entry = mapScores.floorEntry(new Integer(95));
		System.out.println("95점 이거나 바로 아래 점수: " + entry.getKey() + "-" + entry.getValue());
		entry = mapScores.ceilingEntry(new Integer(85));
		System.out.println("85점 이거나 바로 아래 점수: " + entry.getKey() + "-" + entry.getValue() + "\n");
		
		while(!mapScores.isEmpty()) {
			entry = mapScores.pollFirstEntry();
			System.out.println(entry.getKey() + "-" + entry.getValue() + "(남은 객체 수: " + mapScores.size() + ")");
		}
		
		TreeMap<Integer, String> mSortingScores = new TreeMap<Integer, String>();
		mSortingScores.put(new Integer(87), "홍길동");
		mSortingScores.put(new Integer(98), "이동수");
		mSortingScores.put(new Integer(75), "박길순");
		mSortingScores.put(new Integer(95), "신용권");
		mSortingScores.put(new Integer(80), "김자바");
		
		NavigableMap<Integer, String> descendingMap = mSortingScores.descendingMap();
		Set<Map.Entry<Integer, String>> descendingEntrySet = descendingMap.entrySet();
		for(Map.Entry<Integer, String> mEntry : descendingEntrySet) {
			System.out.print(mEntry.getKey() + "-" + mEntry.getValue() + " ");
		}
		System.out.println();
		
		NavigableMap<Integer, String> ascendingMap = descendingMap.descendingMap();
		Set<Map.Entry<Integer, String>> ascendingEntrySet = ascendingMap.entrySet();
		for(Map.Entry<Integer, String> mEntry : ascendingEntrySet) {
			System.out.print(mEntry.getKey() + "-" + mEntry.getValue() + " ");
		}
		
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		treeMap.put("apple", new Integer(10));
		treeMap.put("forever", new Integer(60));
		treeMap.put("description", new Integer(40));
		treeMap.put("ever", new Integer(50));
		treeMap.put("zoo", new Integer(10));
		treeMap.put("base", new Integer(20));
		treeMap.put("guess", new Integer(70));
		treeMap.put("cherry", new Integer(30));
		
		System.out.println("[c~f 사이의 단어 검색]");
		NavigableMap<String, Integer> rangeMap = treeMap.subMap("c", true, "f", true);
		for(Map.Entry<String, Integer> mEntry : rangeMap.entrySet()) {
			System.out.println(mEntry.getKey() + "-" + mEntry.getValue() + "페이지");
		}
		
		// Person - Comparable
		TreeSet<Person> cTreeSet = new TreeSet<Person>();
		cTreeSet.add(new Person("홍길동", 45));
		cTreeSet.add(new Person("김자바", 25));
		cTreeSet.add(new Person("박지원", 31));
		
		Iterator<Person> pIterator = cTreeSet.iterator();	// 왼쪽 마지막 노드에서 오른쪽 마지막 노드까지 반복해서 가져오기
		while(pIterator.hasNext()) {
			Person person = pIterator.next();
			System.out.println(person.name + ": " + person.age);
		}
		
		// Fruit - compare()
//		TreeSet<Fruit> fTreeSet = new TreeSet<Fruit>();	// Fruit이 Comparable을 구현하지 않았기 때문에 예외 발생
//		fTreeSet.add(new Fruit("포도", 3000));
//		fTreeSet.add(new Fruit("수박", 10000));
//		fTreeSet.add(new Fruit("딸기", 6000));
		
		TreeSet<Fruit> fTreeSet2 = new TreeSet<Fruit>(new DescendingComparator());	// 내림차순 정렬자 제공
		fTreeSet2.add(new Fruit("포도", 3000));
		fTreeSet2.add(new Fruit("수박", 10000));
		fTreeSet2.add(new Fruit("딸기", 6000));
		
		Iterator<Fruit> fIterator = fTreeSet2.iterator();
		while(fIterator.hasNext()) {
			Fruit fruit = fIterator.next();
			System.out.println(fruit.name + ": " + fruit.price);
		}
		
		// Stack 클래스	*LIFO(Last In First Out) 자료구조
		// Coin
		Stack<Coin> coinBox = new Stack<Coin>();
		
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
		
		while(!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println("꺼내온 동전: " + coin.getValue() + "원");
		}
		
		// Queue 인터페이스	*FIFO(First In First Out) 자료구조
		// Message
		Queue<Message> messageQ = new LinkedList<Message>();
		
		messageQ.offer(new Message("sendMail", "홍길동"));
		messageQ.offer(new Message("sendSMS", "신용권"));
		messageQ.offer(new Message("sendKakaotalk", "홍두깨"));
		
		while(!messageQ.isEmpty()) {
			Message message = messageQ.poll();
			switch(message.command) {
			case "sendMail":
				System.out.println(message.to + "님에게 메일을 보냅니다.");
				break;
				
			case "sendSMS":
				System.out.println(message.to + "님에게 SMS를 보냅니다.");
				break;
				
			case "sendKakaotalk":
				System.out.println(message.to + "님에게 카카오톡을 보냅니다.");
				break;
			}
		}
	}
}