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
		// �÷��� �����ӿ�ũ - List �÷���
		// ArrayList
		List<String> list = new ArrayList<String>();
		list.add("Java");	// String ��ü ����
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("iBATIS");
		int size = list.size();
		System.out.println("�� ��ü��: " + size);
		System.out.println();
		
		String skill = list.get(2);	// 2�� �ε��� ��ü ���
		System.out.println("2: " + skill);
		System.out.println();
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ": " + str);
		}
		System.out.println();
		
		list.remove(2);	// 2�� �ε��� ��ü(Database) ����
		list.remove(2);	// 2�� �ε��� ��ü(Servlit/JSP) ����
		list.remove("iBATIS");
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ": " + str);
		}
		
		List<String> list1 = Arrays.asList("ȫ�浿", "�ſ��", "���ڹ�");
		for(String name : list1) {
			System.out.println(name);
		}
		
		List<Integer> list2 = Arrays.asList(1, 2, 3);
		for(int value : list2) {
			System.out.println(value);
		}
		
		// Vector
		List<Board> vlist = new Vector<Board>();
		
		vlist.add(new Board("����1", "����1", "�۾���1"));
		vlist.add(new Board("����2", "����2", "�۾���2"));
		vlist.add(new Board("����3", "����3", "�۾���3"));
		vlist.add(new Board("����4", "����4", "�۾���4"));
		vlist.add(new Board("����5", "����5", "�۾���5"));
		
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
		System.out.println("ArrayList �ɸ��ð�: " + (endTime - startTime) + "ns");
		
		startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			llist2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList �ɸ��ð�: " + (endTime - startTime) + "ns");
		
		// �÷��� �����ӿ�ũ - Set �÷���
		// HashSet
		Set<String> set = new HashSet<String>();
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("iBATIS");
		int hsize = set.size();
		System.out.println("�� ��ü��: " + hsize);
		
		Iterator<String> iterator = set.iterator();	// �ݺ��� ���
		while(iterator.hasNext()) {	// ��ü ����ŭ ����
			String element = iterator.next();	// �� ���� ��ü ��������
			System.out.println("\t" + element);
		}
		set.remove("JDBC");
		set.remove("iBATIS");
		System.out.println("�� ��ü��: " + set.size());
		iterator = set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		set.clear();
		if(set.isEmpty()) {
			System.out.println("�������");
		}
		
		// HashSet - Member
		Set<Member> mset = new HashSet<Member>();
		
		mset.add(new Member("ȫ�浿", 30));	// �ν��Ͻ� �ٸ����� ���� ������ ������ ��ü 1���� ������
		mset.add(new Member("ȫ�浿", 30));
		
		System.out.println("�� ��ü��: " + mset.size());
		
		// �÷��� �����ӿ�ũ - Map �÷���
		// HashMap
		Map<String, Integer> map = new HashMap<String, Integer>();	// Map �÷��� ����
		map.put("�ſ��", 85);	// ��ü ����
		map.put("ȫ�浿", 90);
		map.put("���屺", 80);
		map.put("ȫ�浿", 95);
		System.out.println("�� Entry ��: " + map.size());
		System.out.println("\tȫ�浿: " + map.get("ȫ�浿"));	// ��ü ã��, �̸�(Ű)�� ����(��) �˻�
		System.out.println();
		
		Set<String> keySet = map.keySet();	// ��ü �ϳ��� ó��, Key Set ����
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {	// �ݺ��ؼ� Ű�� ��� ���� Map���� ����
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println("\t" + key + ": " + value);
		}
		System.out.println();
		map.remove("ȫ�浿");	// ��ü ����, Ű�� Map.Entry ����
		System.out.println("�� Entry ��: " + map.size());
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();	// Map.Entry Set ����
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()) {	// �ݺ��ؼ� Map.Entry ��� Ű�� �� ����
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t" + key + ": " + value);
		}
		System.out.println();
		map.clear();	// ��� Map.Entry ��ü ����
		System.out.println("�� Entry ��: " + map.size());
		
		// Student - hashCode()�� equals() ������
		Map<Student, Integer> smap = new HashMap<Student, Integer>();
		smap.put(new Student(1, "ȫ�浿"), 95);	// �й��� �̸� ������ Student Ű�� ����
		smap.put(new Student(1, "ȫ�浿"), 95);
		System.out.println("�� Entry ��: " + smap.size());
		
		// Hashtable
		Map<String, String> tmap = new Hashtable<String, String>();
		tmap.put("spring", "12");	// ���̵�� ��й�ȣ ����
		tmap.put("summer", "123");
		tmap.put("fall", "1234");
		tmap.put("winter", "12345");
		
		Scanner scanner = new Scanner(System.in);	// Ű���� �Է� �ޱ�
		while(true) {
			System.out.println("���̵�� ��й�ȣ�� �Է����ּ���");
			System.out.print("���̵�: ");
			String id = scanner.nextLine();
			System.out.print("��й�ȣ: ");
			String password = scanner.nextLine();
			System.out.println();
			
			if(tmap.containsKey(id)) {	// ���̵� ���翩�� Ȯ��
				if(tmap.get(id).equals(password)) {
					System.out.println("�α��� �Ǿ����ϴ�.");
					break;
				} else {
					System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				}
			} else {
				System.out.println("�Է��Ͻ� ���̵� �������� �ʽ��ϴ�.");
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
		
		// �˻� ��� ��ȭ��Ų �÷���
		// ���� Ʈ�� ����(binary tree) - TreeSet
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(new Integer(87));
		scores.add(new Integer(98));
		scores.add(new Integer(75));
		scores.add(new Integer(95));
		scores.add(new Integer(80));
		
		Integer score = null;
		
		score = scores.first();
		System.out.println("���� ���� ����: " + score);
		
		score = scores.last();
		System.out.println("���� ���� ����: " + score + "\n");
		
		score = scores.lower(new Integer(95));
		System.out.println("95�� �Ʒ� ����: " + score);
		
		score = scores.higher(new Integer(95));
		System.out.println("95�� ���� ����: " + score + "\n");
		
		score = scores.floor(new Integer(95));
		System.out.println("95���̰ų� �ٷ� �Ʒ� ����: " + score);
		
		score = scores.ceiling(new Integer(85));
		System.out.println("85���̰ų� �ٷ� ���� ����: " + score + "\n");
		
		while(!scores.isEmpty()) {
			score = scores.pollFirst();
			System.out.println(score + " (���� ��ü �� : " + scores.size() + ")");
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
		
		System.out.println("[c~f ������ �ܾ� �˻�]");
		NavigableSet<String> rangeSet = treeSet.subSet("c", true, "f", true);
		
		for(String word : rangeSet) {
			System.out.println(word);
		}
		
		// ���� Ʈ�� ����(binary tree) - TreeMap
		TreeMap<Integer, String> mapScores = new TreeMap<Integer, String>();
		mapScores.put(new Integer(87), "ȫ�浿");
		mapScores.put(new Integer(98), "�̵���");
		mapScores.put(new Integer(75), "�ڱ��");
		mapScores.put(new Integer(95), "�ſ��");
		mapScores.put(new Integer(80), "���ڹ�");
		
		Map.Entry<Integer, String> entry = null;
		entry = mapScores.firstEntry();
		System.out.println("���� ���� ����: " + entry.getKey() + "-" + entry.getValue());
		entry = mapScores.lastEntry();
		System.out.println("���� ���� ����: " + entry.getKey() + "-" + entry.getValue() + "\n");
		
		entry = mapScores.lowerEntry(new Integer(95));
		System.out.println("95�� �Ʒ� ����: " + entry.getKey() + "-" + entry.getValue());
		entry = mapScores.higherEntry(new Integer(95));
		System.out.println("95�� ���� ����: " + entry.getKey() + "-" + entry.getValue() + "\n");
		
		entry = mapScores.floorEntry(new Integer(95));
		System.out.println("95�� �̰ų� �ٷ� �Ʒ� ����: " + entry.getKey() + "-" + entry.getValue());
		entry = mapScores.ceilingEntry(new Integer(85));
		System.out.println("85�� �̰ų� �ٷ� �Ʒ� ����: " + entry.getKey() + "-" + entry.getValue() + "\n");
		
		while(!mapScores.isEmpty()) {
			entry = mapScores.pollFirstEntry();
			System.out.println(entry.getKey() + "-" + entry.getValue() + "(���� ��ü ��: " + mapScores.size() + ")");
		}
		
		TreeMap<Integer, String> mSortingScores = new TreeMap<Integer, String>();
		mSortingScores.put(new Integer(87), "ȫ�浿");
		mSortingScores.put(new Integer(98), "�̵���");
		mSortingScores.put(new Integer(75), "�ڱ��");
		mSortingScores.put(new Integer(95), "�ſ��");
		mSortingScores.put(new Integer(80), "���ڹ�");
		
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
		
		System.out.println("[c~f ������ �ܾ� �˻�]");
		NavigableMap<String, Integer> rangeMap = treeMap.subMap("c", true, "f", true);
		for(Map.Entry<String, Integer> mEntry : rangeMap.entrySet()) {
			System.out.println(mEntry.getKey() + "-" + mEntry.getValue() + "������");
		}
		
		// Person - Comparable
		TreeSet<Person> cTreeSet = new TreeSet<Person>();
		cTreeSet.add(new Person("ȫ�浿", 45));
		cTreeSet.add(new Person("���ڹ�", 25));
		cTreeSet.add(new Person("������", 31));
		
		Iterator<Person> pIterator = cTreeSet.iterator();	// ���� ������ ��忡�� ������ ������ ������ �ݺ��ؼ� ��������
		while(pIterator.hasNext()) {
			Person person = pIterator.next();
			System.out.println(person.name + ": " + person.age);
		}
		
		// Fruit - compare()
//		TreeSet<Fruit> fTreeSet = new TreeSet<Fruit>();	// Fruit�� Comparable�� �������� �ʾұ� ������ ���� �߻�
//		fTreeSet.add(new Fruit("����", 3000));
//		fTreeSet.add(new Fruit("����", 10000));
//		fTreeSet.add(new Fruit("����", 6000));
		
		TreeSet<Fruit> fTreeSet2 = new TreeSet<Fruit>(new DescendingComparator());	// �������� ������ ����
		fTreeSet2.add(new Fruit("����", 3000));
		fTreeSet2.add(new Fruit("����", 10000));
		fTreeSet2.add(new Fruit("����", 6000));
		
		Iterator<Fruit> fIterator = fTreeSet2.iterator();
		while(fIterator.hasNext()) {
			Fruit fruit = fIterator.next();
			System.out.println(fruit.name + ": " + fruit.price);
		}
		
		// Stack Ŭ����	*LIFO(Last In First Out) �ڷᱸ��
		// Coin
		Stack<Coin> coinBox = new Stack<Coin>();
		
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
		
		while(!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println("������ ����: " + coin.getValue() + "��");
		}
		
		// Queue �������̽�	*FIFO(First In First Out) �ڷᱸ��
		// Message
		Queue<Message> messageQ = new LinkedList<Message>();
		
		messageQ.offer(new Message("sendMail", "ȫ�浿"));
		messageQ.offer(new Message("sendSMS", "�ſ��"));
		messageQ.offer(new Message("sendKakaotalk", "ȫ�α�"));
		
		while(!messageQ.isEmpty()) {
			Message message = messageQ.poll();
			switch(message.command) {
			case "sendMail":
				System.out.println(message.to + "�Կ��� ������ �����ϴ�.");
				break;
				
			case "sendSMS":
				System.out.println(message.to + "�Կ��� SMS�� �����ϴ�.");
				break;
				
			case "sendKakaotalk":
				System.out.println(message.to + "�Կ��� īī������ �����ϴ�.");
				break;
			}
		}
	}
}