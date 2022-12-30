package javaChapter11;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class Sample {
	public static void main(String[] args) throws Exception {
		// Member
		// ��ü ���� ��(equals() �޼���)
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		Member obj3 = new Member("red");
		if(obj1.equals(obj2)) {
			System.out.println("obj1�� obj2�� �����մϴ�.");
		} else {
			System.out.println("obj1�� obj2�� �������� �ʽ��ϴ�.");
		}
		if(obj1.equals(obj3)) {
			System.out.println("obj1�� obj3�� �����մϴ�.");
		} else {
			System.out.println("obj1�� obj3�� �������� �ʽ��ϴ�.");
		}
		
		// ��ü�� ���� ����(toString() �޼���)
		Object obj4 = new Object();
		Date obj5 = new Date();
		System.out.println(obj4.toString());
		System.out.println(obj5.toString());
		
		// SmartPhone ��ü�� ���� ����(toString() �޼���)
		SmartPhone myPhone = new SmartPhone("����", "�ȵ���̵�");
		String strObj = myPhone.toString();
		System.out.println(strObj);
		System.out.println(myPhone);	// myPhone.toString() �ڵ� ȣ�� ���ϰ� ���
		
		// String ������
		byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};
		String str1 = new String(bytes);
		System.out.println(str1);
		
		String str2 = new String(bytes, 6, 4);	// 6��° �ε������� 4��
		System.out.println(str2);
		
		// String �޼��� - ���� ����
		String ssn = "010624-1230123";
		
		char sex = ssn.charAt(7);
		switch(sex) {
		case '1':
		case '3':
			System.out.println("���� �Դϴ�.");
			break;
		case '2':
		case '4':
			System.out.println("���� �Դϴ�.");
			break;
		}
		
		// String �޼��� - ���ڿ� ��
		String strVar1 = new String("�Ź�ö");
		String strVar2 = "�Ź�ö";
		
		if(strVar1 == strVar2) {
			System.out.println("���� String ��ü�� ����");
		} else {
			System.out.println("�ٸ� String ��ü�� ����");
		}
		
		if(strVar1.equals(strVar2)) {
			System.out.println("���� ���ڿ��� ����");
		} else {
			System.out.println("�ٸ� ���ڿ��� ����");
		}
		
		// String �޼��� - ����Ʈ �迭�� ��ȯ
		String str = "�ȳ��ϼ���";
		byte[] bytes1 = str.getBytes();
		System.out.println("bytes1.length: " + bytes1.length);
		String sstr1 = new String(bytes1);
		System.out.println("bytes1 -> String: " + sstr1);
		
		try {
			byte[] bytes2 = str.getBytes("EUC-KR");
			System.out.println("bytes2.length: " + bytes2.length);
			String sstr2 = new String(bytes2);
			System.out.println("bytes2 -> String: " + sstr2);
			
			byte[] bytes3 = str.getBytes("UTF-8");
			System.out.println("bytes3.length: " + bytes3.length);
			String sstr3 = new String(bytes3, "UTF-8");
			System.out.println("bytes3 -> String: " + sstr3);
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		
		// String �޼��� - ���ڿ� ã��
		String subject = "�ڹ� ���α׷���";
		int location = subject.indexOf("���α׷���");
		System.out.println(location);
		
		if(subject.indexOf("�ڹ�") != -1) {
			System.out.println("�ڹٿ� ���õ� å�̱���");
		} else {
			System.out.println("�ڹٿ� ���þ��� å�̱���");
		}
		
		// String �޼��� - ���ڿ� ����
		String lssn = "7306241230123";
		int length = lssn.length();
		
		if(length == 13) {
			System.out.println("�ֹι�ȣ �ڸ����� �½��ϴ�.");
		} else {
			System.out.println("�ֹι�ȣ �ڸ����� Ʋ���ϴ�.");
		}
		
		// String �޼��� - ���ڿ� ��ġ
		String oldStr = "�ڹٴ� ��ü������ �Դϴ�. �ڹٴ� ǳ���� API�� �����մϴ�.";
		System.out.println(oldStr);
		String newStr = oldStr.replace("�ڹ�", "JAVA");
		System.out.println(newStr);
		
		// String �޼��� - ���ڿ� ����
		String bssn = "880815-1234567";
		String firstNum = bssn.substring(0, 6);
		System.out.println(firstNum);
		
		String secondNum = bssn.substring(7);
		System.out.println(secondNum);
		
		// String �޼��� - �롤�ҹ���
		String cstr1 = "Java Programming";
		String cstr2 = "JAVA Programming";
		System.out.println(cstr1.equals(cstr2));
		
		String lowerStr1 = cstr1.toLowerCase();
		String lowerStr2 = cstr2.toLowerCase();
		System.out.println(lowerStr1.equals(lowerStr2));
		System.out.println(cstr1.equalsIgnoreCase(cstr2));
		
		// String �޼��� - ���� ����
		String tel1 = "   02";
		String tel2 = "123   ";
		String tel3 = "  1234  ";
		String tel = tel1.trim() + tel2.trim() + tel3.trim();
		System.out.println(tel);
		
		// String �޼��� - ���ڿ� ��ȯ
		String vstr1 = String.valueOf(10);
		String vstr2 = String.valueOf(10.5);
		String vstr3 = String.valueOf(true);
		
		System.out.println(vstr1);
		System.out.println(vstr2);
		System.out.println(vstr3);
		
		// StringTokenizer - ��ū �и�
		String text = "ȫ�浿/�̼�ȫ/�ڿ���";
		
		StringTokenizer st = new StringTokenizer(text, "/");	// ��ü ��ū ���� ��� for������ ����
		int countTokens = st.countTokens();
		for(int i = 0; i < countTokens; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
		System.out.println();
		
		st = new StringTokenizer(text, "/");	// ���� �ִ� ��ū Ȯ�� �� while������ ����
		while(st.hasMoreElements()) {
			String token = st.nextToken();
			System.out.println(token);
		}
		
		// StringBuilder
		StringBuilder sb = new StringBuilder();	// StringBuilder ��ü ����
		
		sb.append("Java ");	// ���ڿ� ���� �߰�
		sb.append("Program Study");
		System.out.println(sb.toString());
		
		sb.insert(4, "2");	// 4��° ���� �ڿ� 2 ����
		System.out.println(sb.toString());
		
		sb.setCharAt(4, '6');	// 4��° ���� ���� ���� 6���� ����
		System.out.println(sb.toString());
		
		sb.replace(6, 13, "Book");	// 6��° ���ں��� 13��° ���ڱ��� Book���� ���ڿ� ��ġ
		System.out.println(sb.toString());
		
		sb.delete(4, 5);	// 5��° ���� ����
		System.out.println(sb.toString());
		
		int slength = sb.length();	// �� ���� ��
		System.out.println("�ѹ��ڼ�: " + slength);
		
		String result = sb.toString();	// ���ۿ� �ִ� ���� String Ÿ������ ����
		System.out.println(result);
		
		// ���Խ�
		String regExp = "(02|010)-\\d{3,4}-\\d{4}";
		String data = "010-123-4567";
		boolean presult = Pattern.matches(regExp, data);
		if(presult) {
			System.out.println("���Խİ� ��ġ�մϴ�.");
		} else {
			System.out.println("���Խİ� ��ġ���� �ʽ��ϴ�.");
		}
		
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		data = "angel@navercom";
		presult = Pattern.matches(regExp, data);
		if(presult) {
			System.out.println("���Խİ� ��ġ�մϴ�.");
		} else {
			System.out.println("���Խİ� ��ġ���� �ʽ��ϴ�.");
		}
		
		// Arrays - �迭 ����
		char[] arr1 = {'J', 'A', 'V', 'A'};
		
		char[] arr2 = Arrays.copyOf(arr1, arr1.length);
		System.out.println(Arrays.toString(arr2));
		
		char[] arr3 = Arrays.copyOfRange(arr1, 1, 3);
		System.out.println(Arrays.toString(arr3));
		
		char[] arr4 = new char[arr1.length];
		System.arraycopy(arr1, 0, arr4, 0, arr1.length);
		for(int i = 0; i < arr4.length; i++) {
			System.out.println("arr4[" + i + "] = " + arr4[i]);
		}
		
		// Arrays - �迭 �׸� ��
		int[][] original = {{1, 2}, {3, 4}};
		
		System.out.println("[���� ���� �� ��]");
		int[][] cloned1 = Arrays.copyOf(original, original.length);
		System.out.println("�迭 ���� ��: " + original.equals(cloned1));
		System.out.println("1�� �迭 �׸� ��: " + Arrays.equals(original, cloned1));
		System.out.println("��ø �迭 �׸� ��: " + Arrays.deepEquals(original, cloned1));
		
		System.out.println("\n[���� ���� �� ��]");
		int[][] cloned2 = Arrays.copyOf(original, original.length);
		cloned2[0] = Arrays.copyOf(original[0], original[0].length);
		cloned2[1] = Arrays.copyOf(original[1], original[1].length);
		System.out.println("�迭 ���� ��: " + original.equals(cloned2));
		System.out.println("1�� �迭 �׸� ��: " + Arrays.equals(original, cloned2));
		System.out.println("��ø �迭 �׸� ��: " + Arrays.deepEquals(original, cloned2));
		
		// Arrays - �迭 �׸� ����
		int[] scores = {99, 97, 98};
		Arrays.sort(scores);
		for(int i = 0; i < scores.length; i++) {
			System.out.println("scores[" + i + "] = " + scores[i]);
		}
		System.out.println();
		
		String[] names = {"ȫ�浿", "�ڵ���", "��μ�"};
		Arrays.parallelSort(names);
		for(int i = 0; i < names.length; i++) {
			System.out.println("names[" + i + "] = " + names[i]);
		}
		System.out.println();
		AMember m1 = new AMember("ȫ�浿");
		AMember m2 = new AMember("�ڵ���");
		AMember m3 = new AMember("��μ�");
		AMember[] members = {m1, m2, m3};
		Arrays.parallelSort(members);
		for(int i = 0; i < members.length; i++) {
			System.out.println("members[" + i + "].name = " + members[i].name);
		}
		
		// Arrays - �迭 �׸� �˻�
		int[] sscores = {99, 97, 98};
		Arrays.sort(sscores);
		int index = Arrays.binarySearch(sscores, 99);
		System.out.println("ã�� �ε���: " + index);
		
		String[] snames = {"ȫ�浿", "�ڵ���", "��μ�"};
		Arrays.parallelSort(snames);
		index = Arrays.binarySearch(snames, "ȫ�浿");
		System.out.println("ã�� �ε���: " + index);
		
		AMember sm1 = new AMember("ȫ�浿");
		AMember sm2 = new AMember("�ڵ���");
		AMember sm3 = new AMember("��μ�");
		AMember[] smembers = {m1, m2, m3};
		Arrays.sort(smembers);
		index = Arrays.binarySearch(smembers, sm1);
		System.out.println("ã�� �ε���: " + index);
		
		// ����(Wrapper) Ŭ����
		// Boxing-Unboxing
		Integer object1 = new Integer(100);	// Boxing
		Integer object2 = new Integer("200");
		Integer object3 = Integer.valueOf("300");
		
		int value1 = object1.intValue();	// Unboxing
		int value2 = object2.intValue();
		int value3 = object3.intValue();
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		
		// �ڵ� �ڽ�-�ڵ� ��ڽ�
		Integer obj = 100;	// �ڵ� Boxing
		System.out.println("value: " + obj.intValue());
		
		int value = obj;	// ���� �� �ڵ� Unboxing
		System.out.println("value: " + value);
		
		int uresult = obj + 100;
		System.out.println("uresult: " + uresult);
		
		// ���ڿ��� �⺻ Ÿ�� ������ ��ȯ
		int wvalue1 = Integer.parseInt("10");
		double wvalue2 = Double.parseDouble("3.14");
		boolean wvalue3 = Boolean.parseBoolean("true");
		
		System.out.println("wvalue1: " + wvalue1);
		System.out.println("wvalue2: " + wvalue2);
		System.out.println("wvalue3: " + wvalue3);
		
		// ���� ��ü ��
		System.out.println("[-128 ~ 127 �ʰ����� ���]");
		Integer eobj1 = 300;
		Integer eobj2 = 300;
		System.out.println("==���: " + (eobj1 == eobj2));
		System.out.println("��ڽ��� ==���: " +(eobj1.intValue() == eobj2.intValue()));
		System.out.println("equals() ���: " + eobj1.equals(eobj2));
		System.out.println();
		
		System.out.println("[-128 ~ 127 �������� ���]");
		Integer eobj3 = 10;
		Integer eobj4 = 10;
		System.out.println("==���: " + (eobj3 == eobj4));
		System.out.println("��ڽ��� ==���: " +(eobj3.intValue() == eobj4.intValue()));
		System.out.println("equals() ���: " + eobj3.equals(eobj4));
		
		// Math
		int v1 = Math.abs(-5);
		double v2 = Math.abs(-3.14);
		System.out.println("v1 = " + v1);
		System.out.println("v2 = " + v2);
		
		double v3 = Math.ceil(5.3);
		double v4 = Math.ceil(-5.3);
		System.out.println("v3 = " + v3);
		System.out.println("v4 = " + v4);
		
		double v5 = Math.floor(5.3);
		double v6 = Math.floor(-5.3);
		System.out.println("v5 = " + v5);
		System.out.println("v6 = " + v6);
		
		int v7 = Math.max(5, 9);
		double v8 = Math.max(5.3, 2.5);
		System.out.println("v7 = " + v7);
		System.out.println("v8 = " + v8);
		
		int v9 = Math.min(5, 9);
		double v10 = Math.min(5.3, 2.5);
		System.out.println("v9 = " + v9);
		System.out.println("v10 = " + v10);
		
		double v11 = Math.random();
		System.out.println("v11 = " + v11);
		
		double v12 = Math.rint(5.3);
		double v13 = Math.rint(5.7);
		System.out.println("v12 = " + v12);
		System.out.println("v13 = " + v13);
		
		double v14 = Math.round(5.3);
		double v15 = Math.round(5.7);
		System.out.println("v14 = " + v14);
		System.out.println("v15 = " + v15);
		
		double dvalue = 12.3456;
		double temp1 = dvalue * 100;
		long temp2 = Math.round(temp1);
		double v16 = temp2 / 100.0;
		System.out.println("v16 = " + v16);
		
		// Math.random()
		int num = (int)(Math.random() * 6) + 1;	// ������ �ֻ��� �� ���
		System.out.println("�ֻ��� ��: " + num);
		
		int lotto = (int)(Math.random() * 45) + 1;	// ������ �ζ� ��ȣ ���
		System.out.println("�ζ� ��ȣ: " + lotto);
		
		// Random Ŭ����
		int[] selectNumber = new int[6];
		Random random = new Random(3);
		System.out.print("���� ��ȣ: ");
		for(int i = 0; i < 6; i++) {
			selectNumber[i] = random.nextInt(45) + 1;
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();
		
		int[] winningNumber = new int[6];
		random = new Random(5);
		System.out.print("��÷ ��ȣ: ");
		for(int i = 0; i < 6; i++) {
			winningNumber[i] = random.nextInt(45) + 1;
			System.out.print(winningNumber[i] + " ");
		}
		System.out.println();
		
		Arrays.sort(selectNumber);
		Arrays.sort(winningNumber);
		boolean lresult = Arrays.equals(selectNumber, winningNumber);
		System.out.print("��÷ ����: ");
		if(lresult) {
			System.out.println("1� ��÷�Ǽ̽��ϴ�.");
		} else {
			System.out.println("��÷���� �ʾҽ��ϴ�.");
		}
		
		// Date Ŭ����
		Date now = new Date();
		String strNow1 = now.toString();
		System.out.println(strNow1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� hh�� mm�� ss��");
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
		
		// Calendar Ŭ����
		Calendar cnow = Calendar.getInstance();
		
		int year = cnow.get(Calendar.YEAR);
		int month = cnow.get(Calendar.MONTH) + 1;
		int day = cnow.get(Calendar.DAY_OF_MONTH);
		int week = cnow.get(Calendar.DAY_OF_WEEK);
		String strWeek = null;
		switch(week) {
		case Calendar.MONDAY:
			strWeek = "��";
			break;
		case Calendar.TUESDAY:
			strWeek = "ȭ";
			break;
		case Calendar.WEDNESDAY:
			strWeek = "��";
			break;
		case Calendar.THURSDAY:
			strWeek = "��";
			break;
		case Calendar.FRIDAY:
			strWeek = "��";
			break;
		case Calendar.SATURDAY:
			strWeek = "��";
			break;
		default:
			strWeek = "��";
		}
		
		int amPm = cnow.get(Calendar.AM_PM);
		String strAmPm = null;
		if(amPm == Calendar.AM) {
			strAmPm = "����";
		} else {
			strAmPm = "����";
		}
		
		int hour = cnow.get(Calendar.HOUR);
		int minute = cnow.get(Calendar.MINUTE);
		int second = cnow.get(Calendar.SECOND);
		
		System.out.println(year + "�� " + month + "�� " + day + "��");
		System.out.print(strWeek + "���� ");
		System.out.println(strAmPm);
		System.out.println(hour + "�� " + minute + "�� " + second + "��");
		
		// �̱� �ð� ���
		TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
		Calendar lnow = Calendar.getInstance(timeZone);
		
		int lhour = lnow.get(Calendar.HOUR);
		int lminute = lnow.get(Calendar.MINUTE);
		int lsecond = lnow.get(Calendar.SECOND);
		
		System.out.println(lhour + "�� " + lminute + "�� " + lsecond + "��");
		
		// Format
		// ���� ���� Ŭ����(DecimalFormat)
		double dnum = 1234567.89;
		
		DecimalFormat df = new DecimalFormat("0");
		System.out.println("[0]: " + df.format(dnum));
		
		df = new DecimalFormat("0.0");
		System.out.println("[0.0]: " + df.format(dnum));
		
		df = new DecimalFormat("0000000000.00000");
		System.out.println("[0000000000.00000]: " + df.format(dnum));
		
		df = new DecimalFormat("#");
		System.out.println("[#]: " + df.format(dnum));
		
		df = new DecimalFormat("##########.##");
		System.out.println("[##########.##]: " + df.format(dnum));
		
		df = new DecimalFormat("#.0");
		System.out.println("[#.0]: " + df.format(dnum));
		
		df = new DecimalFormat("+#.0");
		System.out.println("[+#.0]: " + df.format(dnum));
		
		df = new DecimalFormat("-#.0");
		System.out.println("[-#.0]: " + df.format(dnum));
		
		df = new DecimalFormat("#,###.0");
		System.out.println("[#,###.0]: " + df.format(dnum));
		
		df = new DecimalFormat("0.0E0");
		System.out.println("[0.0E0]: " + df.format(dnum));
		
		df = new DecimalFormat("+#,###; -#,###");
		System.out.println("[+#,###; -#,###]: " + df.format(dnum));
		
		df = new DecimalFormat("#.#%");
		System.out.println("[#.#%]: " + df.format(dnum));
		
		df = new DecimalFormat("\u00A4 #,###");
		System.out.println("[\u00A4 #,###]: " + df.format(dnum));
		
		// ��¥ ���� Ŭ����(SimpledateFormat)
		Date snow = new Date();
		
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("[yyyy-MM-dd]: " + sdf.format(snow));
		
		sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
		System.out.println("[yyyy�� MM�� dd��]: " + sdf.format(snow));
		
		sdf = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
		System.out.println("[yyyy.MM.dd a HH:mm:ss]: " + sdf.format(snow));
		
		sdf = new SimpleDateFormat("������ E����");
		System.out.println("[������ E����]: " + sdf.format(snow));
		
		sdf = new SimpleDateFormat("������ D��° ��");
		System.out.println("[������ D��° ��]: " + sdf.format(snow));
		
		sdf = new SimpleDateFormat("�̴��� d��° ��");
		System.out.println("[�̴��� d��° ��]: " + sdf.format(snow));
		
		// ���ڿ� ���� Ŭ����(MessageFormat)
		String id = "java";
		String name = "�ſ��";
		String mtel = "010-1234-5678";
		String mtext = "ȸ�� ID: {0} \nȸ�� �̸�: {1} \nȸ�� ��ȭ: {2}";
		String mresult1 = MessageFormat.format(mtext, id, name, mtel);
		System.out.println(mresult1);
		System.out.println();
		
		String sql = "insert into number values({0}, {1}, {2})";
		Object[] arguments = {"java", "�ſ��", "010-1234-5678"};
		String mresult2 = MessageFormat.format(sql, arguments);
		System.out.println(mresult2);
		
		// java.time ��Ű��
		// ��¥�� �ð� ��ü ����
		LocalDate currDate = LocalDate.now();
		System.out.println("���� ��¥: " + currDate);
		
		LocalDate targetDate = LocalDate.of(2024, 5, 10);
		System.out.println("��ǥ ��¥: " + targetDate + "\n");
		
		LocalTime currTime = LocalTime.now();
		System.out.println("���� �ð�: " + currTime);
		
		LocalTime targetTime = LocalTime.of(6, 30, 0, 0);
		System.out.println("��ǥ �ð�: " + targetTime + "\n");
		
		LocalDateTime currDateTime = LocalDateTime.now();
		System.out.println("���� ��¥�� �ð�: " + currDate);
		
		LocalDateTime targetDateTime = LocalDateTime.of(2024, 5, 10, 6, 30, 0, 0);
		System.out.println("��ǥ ��¥�� �ð�: " + targetDate + "\n");
		
		ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
		System.out.println("���� �����: " + utcDateTime);
		ZonedDateTime newyorkDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
		System.out.println("���� �����: " + newyorkDateTime + "\n");
		
		Instant instant1 = Instant.now();
		Thread.sleep(10);
		Instant instant2 = Instant.now();
		if(instant1.isBefore(instant2)) {
			System.out.println("instant1�� �����ϴ�.");
		} else if(instant1.isAfter(instant2)) {
			System.out.println("instant1�� �ʽ��ϴ�.");
		} else {
			System.out.println("������ �ð��Դϴ�.");
		}
		System.out.println("����(nanos): " + instant1.until(instant2, ChronoUnit.NANOS));
		
		// ZonedDateTime
		LocalDateTime znow = LocalDateTime.now();
		System.out.println(znow);
		
		String strDateTime = now.getYear() + "�� ";
		strDateTime += znow.getMonthValue() + "�� ";
		strDateTime += znow.getDayOfMonth() + "�� ";
		strDateTime += znow.getDayOfWeek() + " ";
		strDateTime += znow.getHour() + "�� ";
		strDateTime += znow.getMinute() + "�� ";
		strDateTime += znow.getSecond() + "�� ";
		strDateTime += znow.getNano() + "������ ";
		System.out.println(strDateTime + "\n");
		
		LocalDate nowDate = znow.toLocalDate();
		if(nowDate.isLeapYear()) {
			System.out.println("���ش� ����: 2���� 29�ϱ��� �ֽ��ϴ�.\n");
		} else {
			System.out.println("���ش� ���: 2���� 28�ϱ��� �ֽ��ϴ�.\n");
		}
		
		ZonedDateTime zutcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
		System.out.println("���� �����: " + zutcDateTime);
		ZonedDateTime seoulDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
		System.out.println("���� Ÿ����: " + seoulDateTime);
		ZoneId seoulZoneId = seoulDateTime.getZone();
		System.out.println("���� �����̵�: " + seoulZoneId);
		ZoneOffset seoulZoneOffset = seoulDateTime.getOffset();
		System.out.println("���� ��������: " + seoulZoneOffset + "\n");
		
		// ��¥�� �ð� ����
		LocalDateTime onow = LocalDateTime.now();
		System.out.println("�����: " + onow);
		
		LocalDateTime otargetDateTime = onow
			.plusYears(1)
			.minusMonths(2)
			.plusDays(3)
			.plusHours(4)
			.minusMinutes(5)
			.plusSeconds(6);
		System.out.println("������: " + targetDateTime);
		
		// ��¥�� �ð� ����
		LocalDateTime tnow = LocalDateTime.now();
		System.out.println("����: " + tnow);
		
		LocalDateTime ttargetDateTime = null;
		
		ttargetDateTime = tnow
				.withYear(2024)
				.withMonth(10)
				.withDayOfMonth(5)
				.withHour(13)
				.withMinute(30)
				.withSecond(20);
		System.out.println("���� ����: " + ttargetDateTime);
		
		ttargetDateTime = tnow.with(TemporalAdjusters.firstDayOfYear());
		System.out.println("�̹� ���� ù ��: " + ttargetDateTime);
		ttargetDateTime = tnow.with(TemporalAdjusters.lastDayOfYear());
		System.out.println("�̹� ���� ������ ��: " + ttargetDateTime);
		ttargetDateTime = tnow.with(TemporalAdjusters.firstDayOfNextYear());
		System.out.println("���� ���� ù ��: " + ttargetDateTime);
		
		ttargetDateTime = tnow.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("�̹� ���� ù ��: " + ttargetDateTime);
		ttargetDateTime = tnow.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println("�̹� ���� ������ ��: " + ttargetDateTime);
		ttargetDateTime = tnow.with(TemporalAdjusters.firstDayOfNextMonth());
		System.out.println("���� ���� ù ��: " + ttargetDateTime);
		
		ttargetDateTime = tnow.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
		System.out.println("�̹� ���� ù ������: " + ttargetDateTime);
		ttargetDateTime = tnow.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		System.out.println("���ƿ��� ������: " + ttargetDateTime);
		ttargetDateTime = tnow.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
		System.out.println("���� ������: " + ttargetDateTime);
		
		// Period & Duration
		LocalDateTime startDateTime = LocalDateTime.of(2023, 1, 1, 1, 9, 0, 0);
		System.out.println("������: " + startDateTime);
		
		LocalDateTime endDateTime = LocalDateTime.of(2024, 3, 31, 18, 9, 0, 0);
		System.out.println("������: " + endDateTime + "\n");
		
		if(startDateTime.isBefore(endDateTime)) {
			System.out.println("�������Դϴ�." + "\n");
		} else if(startDateTime.isEqual(endDateTime)) {
			System.out.println("�����մϴ�.\n");
		} else if(startDateTime.isAfter(endDateTime)) {
			System.out.println("�����߽��ϴ�.\n");
		}
		
		System.out.println("[������� ���� �ð�]");
		long remainYear = startDateTime.until(endDateTime, ChronoUnit.YEARS);
		long remainMonth = startDateTime.until(endDateTime, ChronoUnit.MONTHS);
		long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);
		long remainHour = startDateTime.until(endDateTime, ChronoUnit.HOURS);
		long remainMinute = startDateTime.until(endDateTime, ChronoUnit.MINUTES);
		long remainSecond = startDateTime.until(endDateTime, ChronoUnit.SECONDS);
		
		remainYear = ChronoUnit.YEARS.between(startDateTime, endDateTime);
		remainMonth = ChronoUnit.MONTHS.between(startDateTime, endDateTime);
		remainDay = ChronoUnit.DAYS.between(startDateTime, endDateTime);
		remainHour = ChronoUnit.HOURS.between(startDateTime, endDateTime);
		remainMinute = ChronoUnit.MINUTES.between(startDateTime, endDateTime);
		remainSecond = ChronoUnit.SECONDS.between(startDateTime, endDateTime);
		
		System.out.println("���� ��: " + remainYear);
		System.out.println("���� ��: " + remainMonth);
		System.out.println("���� ��: " + remainDay);
		System.out.println("���� �ð�: " + remainHour);
		System.out.println("���� ��: " + remainMinute);
		System.out.println("���� ��: " + remainSecond + "\n");
		
		System.out.println("[������� ���� �Ⱓ]");
		Period period = Period.between(startDateTime.toLocalDate(), endDateTime.toLocalDate());
		System.out.print("���� �Ⱓ: " + period.getYears() + "�� ");
		System.out.print(period.getMonths() + "�� ");
		System.out.print(period.getDays() + "��\n");
		
		Duration duration = Duration.between(startDateTime.toLocalTime(), endDateTime.toLocalTime());
		System.out.println("���� ��: " + duration.getSeconds());
		
		// Parsing
		DateTimeFormatter formatter;
		LocalDate localDate;
		
		localDate = LocalDate.parse("2024-05-21");
		System.out.println(localDate);
		
		formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		localDate = LocalDate.parse("2024-05-21", formatter);
		System.out.println(localDate);
		
		formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		localDate = LocalDate.parse("2024/05/21", formatter);
		System.out.println(localDate);
		
		formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		localDate = LocalDate.parse("2024.05.21", formatter);
		System.out.println(localDate);
		
		// Formatting
		LocalDateTime fnow = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy�� M�� d�� a h�� m��");
		String nowString = fnow.format(dateTimeFormatter);
		System.out.println(nowString);
	}
}

