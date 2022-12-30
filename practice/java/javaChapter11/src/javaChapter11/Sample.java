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
		// 객체 동등 비교(equals() 메서드)
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		Member obj3 = new Member("red");
		if(obj1.equals(obj2)) {
			System.out.println("obj1과 obj2는 동등합니다.");
		} else {
			System.out.println("obj1과 obj2는 동등하지 않습니다.");
		}
		if(obj1.equals(obj3)) {
			System.out.println("obj1과 obj3은 동등합니다.");
		} else {
			System.out.println("obj1과 obj3은 동등하지 않습니다.");
		}
		
		// 객체의 문자 정보(toString() 메서드)
		Object obj4 = new Object();
		Date obj5 = new Date();
		System.out.println(obj4.toString());
		System.out.println(obj5.toString());
		
		// SmartPhone 객체의 문자 정보(toString() 메서드)
		SmartPhone myPhone = new SmartPhone("구글", "안드로이드");
		String strObj = myPhone.toString();
		System.out.println(strObj);
		System.out.println(myPhone);	// myPhone.toString() 자동 호출 리턴값 출력
		
		// String 생성자
		byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};
		String str1 = new String(bytes);
		System.out.println(str1);
		
		String str2 = new String(bytes, 6, 4);	// 6번째 인덱스부터 4개
		System.out.println(str2);
		
		// String 메서드 - 문자 추출
		String ssn = "010624-1230123";
		
		char sex = ssn.charAt(7);
		switch(sex) {
		case '1':
		case '3':
			System.out.println("남자 입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자 입니다.");
			break;
		}
		
		// String 메서드 - 문자열 비교
		String strVar1 = new String("신민철");
		String strVar2 = "신민철";
		
		if(strVar1 == strVar2) {
			System.out.println("같은 String 객체를 참조");
		} else {
			System.out.println("다른 String 객체를 참조");
		}
		
		if(strVar1.equals(strVar2)) {
			System.out.println("같은 문자열을 가짐");
		} else {
			System.out.println("다른 문자열을 가짐");
		}
		
		// String 메서드 - 바이트 배열로 변환
		String str = "안녕하세요";
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
		
		// String 메서드 - 문자열 찾기
		String subject = "자바 프로그래밍";
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		
		if(subject.indexOf("자바") != -1) {
			System.out.println("자바와 관련된 책이군요");
		} else {
			System.out.println("자바와 관련없는 책이군요");
		}
		
		// String 메서드 - 문자열 길이
		String lssn = "7306241230123";
		int length = lssn.length();
		
		if(length == 13) {
			System.out.println("주민번호 자리수가 맞습니다.");
		} else {
			System.out.println("주민번호 자리수가 틀립니다.");
		}
		
		// String 메서드 - 문자열 대치
		String oldStr = "자바는 객체지향언어 입니다. 자바는 풍부한 API를 지원합니다.";
		System.out.println(oldStr);
		String newStr = oldStr.replace("자바", "JAVA");
		System.out.println(newStr);
		
		// String 메서드 - 문자열 추출
		String bssn = "880815-1234567";
		String firstNum = bssn.substring(0, 6);
		System.out.println(firstNum);
		
		String secondNum = bssn.substring(7);
		System.out.println(secondNum);
		
		// String 메서드 - 대·소문자
		String cstr1 = "Java Programming";
		String cstr2 = "JAVA Programming";
		System.out.println(cstr1.equals(cstr2));
		
		String lowerStr1 = cstr1.toLowerCase();
		String lowerStr2 = cstr2.toLowerCase();
		System.out.println(lowerStr1.equals(lowerStr2));
		System.out.println(cstr1.equalsIgnoreCase(cstr2));
		
		// String 메서드 - 공백 제거
		String tel1 = "   02";
		String tel2 = "123   ";
		String tel3 = "  1234  ";
		String tel = tel1.trim() + tel2.trim() + tel3.trim();
		System.out.println(tel);
		
		// String 메서드 - 문자열 변환
		String vstr1 = String.valueOf(10);
		String vstr2 = String.valueOf(10.5);
		String vstr3 = String.valueOf(true);
		
		System.out.println(vstr1);
		System.out.println(vstr2);
		System.out.println(vstr3);
		
		// StringTokenizer - 토큰 분리
		String text = "홍길동/이수홍/박연수";
		
		StringTokenizer st = new StringTokenizer(text, "/");	// 전체 토큰 수를 얻어 for문으로 루핑
		int countTokens = st.countTokens();
		for(int i = 0; i < countTokens; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
		System.out.println();
		
		st = new StringTokenizer(text, "/");	// 남아 있는 토큰 확인 후 while문으로 루핑
		while(st.hasMoreElements()) {
			String token = st.nextToken();
			System.out.println(token);
		}
		
		// StringBuilder
		StringBuilder sb = new StringBuilder();	// StringBuilder 객체 생성
		
		sb.append("Java ");	// 문자열 끝에 추가
		sb.append("Program Study");
		System.out.println(sb.toString());
		
		sb.insert(4, "2");	// 4번째 문자 뒤에 2 삽입
		System.out.println(sb.toString());
		
		sb.setCharAt(4, '6');	// 4번째 문자 뒤의 문자 6으로 변경
		System.out.println(sb.toString());
		
		sb.replace(6, 13, "Book");	// 6번째 문자부터 13번째 문자까지 Book으로 문자열 대치
		System.out.println(sb.toString());
		
		sb.delete(4, 5);	// 5번째 문자 삭제
		System.out.println(sb.toString());
		
		int slength = sb.length();	// 총 문자 수
		System.out.println("총문자수: " + slength);
		
		String result = sb.toString();	// 버퍼에 있는 것을 String 타입으로 리턴
		System.out.println(result);
		
		// 정규식
		String regExp = "(02|010)-\\d{3,4}-\\d{4}";
		String data = "010-123-4567";
		boolean presult = Pattern.matches(regExp, data);
		if(presult) {
			System.out.println("정규식과 일치합니다.");
		} else {
			System.out.println("정규식과 일치하지 않습니다.");
		}
		
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		data = "angel@navercom";
		presult = Pattern.matches(regExp, data);
		if(presult) {
			System.out.println("정규식과 일치합니다.");
		} else {
			System.out.println("정규식과 일치하지 않습니다.");
		}
		
		// Arrays - 배열 복사
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
		
		// Arrays - 배열 항목 비교
		int[][] original = {{1, 2}, {3, 4}};
		
		System.out.println("[얕은 복사 후 비교]");
		int[][] cloned1 = Arrays.copyOf(original, original.length);
		System.out.println("배열 번지 비교: " + original.equals(cloned1));
		System.out.println("1차 배열 항목값 비교: " + Arrays.equals(original, cloned1));
		System.out.println("중첩 배열 항목값 비교: " + Arrays.deepEquals(original, cloned1));
		
		System.out.println("\n[깊은 복사 후 비교]");
		int[][] cloned2 = Arrays.copyOf(original, original.length);
		cloned2[0] = Arrays.copyOf(original[0], original[0].length);
		cloned2[1] = Arrays.copyOf(original[1], original[1].length);
		System.out.println("배열 번지 비교: " + original.equals(cloned2));
		System.out.println("1차 배열 항목값 비교: " + Arrays.equals(original, cloned2));
		System.out.println("중첩 배열 항목값 비교: " + Arrays.deepEquals(original, cloned2));
		
		// Arrays - 배열 항목 정렬
		int[] scores = {99, 97, 98};
		Arrays.sort(scores);
		for(int i = 0; i < scores.length; i++) {
			System.out.println("scores[" + i + "] = " + scores[i]);
		}
		System.out.println();
		
		String[] names = {"홍길동", "박동수", "김민수"};
		Arrays.parallelSort(names);
		for(int i = 0; i < names.length; i++) {
			System.out.println("names[" + i + "] = " + names[i]);
		}
		System.out.println();
		AMember m1 = new AMember("홍길동");
		AMember m2 = new AMember("박동수");
		AMember m3 = new AMember("김민수");
		AMember[] members = {m1, m2, m3};
		Arrays.parallelSort(members);
		for(int i = 0; i < members.length; i++) {
			System.out.println("members[" + i + "].name = " + members[i].name);
		}
		
		// Arrays - 배열 항목 검색
		int[] sscores = {99, 97, 98};
		Arrays.sort(sscores);
		int index = Arrays.binarySearch(sscores, 99);
		System.out.println("찾은 인덱스: " + index);
		
		String[] snames = {"홍길동", "박동수", "김민수"};
		Arrays.parallelSort(snames);
		index = Arrays.binarySearch(snames, "홍길동");
		System.out.println("찾은 인덱스: " + index);
		
		AMember sm1 = new AMember("홍길동");
		AMember sm2 = new AMember("박동수");
		AMember sm3 = new AMember("김민수");
		AMember[] smembers = {m1, m2, m3};
		Arrays.sort(smembers);
		index = Arrays.binarySearch(smembers, sm1);
		System.out.println("찾은 인덱스: " + index);
		
		// 포장(Wrapper) 클래스
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
		
		// 자동 박싱-자동 언박싱
		Integer obj = 100;	// 자동 Boxing
		System.out.println("value: " + obj.intValue());
		
		int value = obj;	// 대입 시 자동 Unboxing
		System.out.println("value: " + value);
		
		int uresult = obj + 100;
		System.out.println("uresult: " + uresult);
		
		// 문자열을 기본 타입 값으로 변환
		int wvalue1 = Integer.parseInt("10");
		double wvalue2 = Double.parseDouble("3.14");
		boolean wvalue3 = Boolean.parseBoolean("true");
		
		System.out.println("wvalue1: " + wvalue1);
		System.out.println("wvalue2: " + wvalue2);
		System.out.println("wvalue3: " + wvalue3);
		
		// 포장 객체 비교
		System.out.println("[-128 ~ 127 초과값일 경우]");
		Integer eobj1 = 300;
		Integer eobj2 = 300;
		System.out.println("==결과: " + (eobj1 == eobj2));
		System.out.println("언박싱후 ==결과: " +(eobj1.intValue() == eobj2.intValue()));
		System.out.println("equals() 결과: " + eobj1.equals(eobj2));
		System.out.println();
		
		System.out.println("[-128 ~ 127 범위값일 경우]");
		Integer eobj3 = 10;
		Integer eobj4 = 10;
		System.out.println("==결과: " + (eobj3 == eobj4));
		System.out.println("언박싱후 ==결과: " +(eobj3.intValue() == eobj4.intValue()));
		System.out.println("equals() 결과: " + eobj3.equals(eobj4));
		
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
		int num = (int)(Math.random() * 6) + 1;	// 임의의 주사위 눈 얻기
		System.out.println("주사위 눈: " + num);
		
		int lotto = (int)(Math.random() * 45) + 1;	// 임의의 로또 번호 얻기
		System.out.println("로또 번호: " + lotto);
		
		// Random 클래스
		int[] selectNumber = new int[6];
		Random random = new Random(3);
		System.out.print("선택 번호: ");
		for(int i = 0; i < 6; i++) {
			selectNumber[i] = random.nextInt(45) + 1;
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();
		
		int[] winningNumber = new int[6];
		random = new Random(5);
		System.out.print("당첨 번호: ");
		for(int i = 0; i < 6; i++) {
			winningNumber[i] = random.nextInt(45) + 1;
			System.out.print(winningNumber[i] + " ");
		}
		System.out.println();
		
		Arrays.sort(selectNumber);
		Arrays.sort(winningNumber);
		boolean lresult = Arrays.equals(selectNumber, winningNumber);
		System.out.print("당첨 여부: ");
		if(lresult) {
			System.out.println("1등에 당첨되셨습니다.");
		} else {
			System.out.println("당첨되지 않았습니다.");
		}
		
		// Date 클래스
		Date now = new Date();
		String strNow1 = now.toString();
		System.out.println(strNow1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
		
		// Calendar 클래스
		Calendar cnow = Calendar.getInstance();
		
		int year = cnow.get(Calendar.YEAR);
		int month = cnow.get(Calendar.MONTH) + 1;
		int day = cnow.get(Calendar.DAY_OF_MONTH);
		int week = cnow.get(Calendar.DAY_OF_WEEK);
		String strWeek = null;
		switch(week) {
		case Calendar.MONDAY:
			strWeek = "월";
			break;
		case Calendar.TUESDAY:
			strWeek = "화";
			break;
		case Calendar.WEDNESDAY:
			strWeek = "수";
			break;
		case Calendar.THURSDAY:
			strWeek = "목";
			break;
		case Calendar.FRIDAY:
			strWeek = "금";
			break;
		case Calendar.SATURDAY:
			strWeek = "토";
			break;
		default:
			strWeek = "일";
		}
		
		int amPm = cnow.get(Calendar.AM_PM);
		String strAmPm = null;
		if(amPm == Calendar.AM) {
			strAmPm = "오전";
		} else {
			strAmPm = "오후";
		}
		
		int hour = cnow.get(Calendar.HOUR);
		int minute = cnow.get(Calendar.MINUTE);
		int second = cnow.get(Calendar.SECOND);
		
		System.out.println(year + "년 " + month + "월 " + day + "일");
		System.out.print(strWeek + "요일 ");
		System.out.println(strAmPm);
		System.out.println(hour + "시 " + minute + "분 " + second + "초");
		
		// 미국 시간 출력
		TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
		Calendar lnow = Calendar.getInstance(timeZone);
		
		int lhour = lnow.get(Calendar.HOUR);
		int lminute = lnow.get(Calendar.MINUTE);
		int lsecond = lnow.get(Calendar.SECOND);
		
		System.out.println(lhour + "시 " + lminute + "분 " + lsecond + "초");
		
		// Format
		// 숫자 형식 클래스(DecimalFormat)
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
		
		// 날짜 형식 클래스(SimpledateFormat)
		Date snow = new Date();
		
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("[yyyy-MM-dd]: " + sdf.format(snow));
		
		sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println("[yyyy년 MM월 dd일]: " + sdf.format(snow));
		
		sdf = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
		System.out.println("[yyyy.MM.dd a HH:mm:ss]: " + sdf.format(snow));
		
		sdf = new SimpleDateFormat("오늘은 E요일");
		System.out.println("[오늘은 E요일]: " + sdf.format(snow));
		
		sdf = new SimpleDateFormat("올해의 D번째 날");
		System.out.println("[올해의 D번째 날]: " + sdf.format(snow));
		
		sdf = new SimpleDateFormat("이달의 d번째 날");
		System.out.println("[이달의 d번째 날]: " + sdf.format(snow));
		
		// 문자열 형식 클래스(MessageFormat)
		String id = "java";
		String name = "신용권";
		String mtel = "010-1234-5678";
		String mtext = "회원 ID: {0} \n회원 이름: {1} \n회원 전화: {2}";
		String mresult1 = MessageFormat.format(mtext, id, name, mtel);
		System.out.println(mresult1);
		System.out.println();
		
		String sql = "insert into number values({0}, {1}, {2})";
		Object[] arguments = {"java", "신용권", "010-1234-5678"};
		String mresult2 = MessageFormat.format(sql, arguments);
		System.out.println(mresult2);
		
		// java.time 패키지
		// 날짜와 시간 객체 생성
		LocalDate currDate = LocalDate.now();
		System.out.println("현재 날짜: " + currDate);
		
		LocalDate targetDate = LocalDate.of(2024, 5, 10);
		System.out.println("목표 날짜: " + targetDate + "\n");
		
		LocalTime currTime = LocalTime.now();
		System.out.println("현재 시간: " + currTime);
		
		LocalTime targetTime = LocalTime.of(6, 30, 0, 0);
		System.out.println("목표 시간: " + targetTime + "\n");
		
		LocalDateTime currDateTime = LocalDateTime.now();
		System.out.println("현재 날짜와 시간: " + currDate);
		
		LocalDateTime targetDateTime = LocalDateTime.of(2024, 5, 10, 6, 30, 0, 0);
		System.out.println("목표 날짜와 시간: " + targetDate + "\n");
		
		ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
		System.out.println("협정 세계시: " + utcDateTime);
		ZonedDateTime newyorkDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
		System.out.println("뉴욕 세계시: " + newyorkDateTime + "\n");
		
		Instant instant1 = Instant.now();
		Thread.sleep(10);
		Instant instant2 = Instant.now();
		if(instant1.isBefore(instant2)) {
			System.out.println("instant1이 빠릅니다.");
		} else if(instant1.isAfter(instant2)) {
			System.out.println("instant1이 늦습니다.");
		} else {
			System.out.println("동일한 시간입니다.");
		}
		System.out.println("차이(nanos): " + instant1.until(instant2, ChronoUnit.NANOS));
		
		// ZonedDateTime
		LocalDateTime znow = LocalDateTime.now();
		System.out.println(znow);
		
		String strDateTime = now.getYear() + "년 ";
		strDateTime += znow.getMonthValue() + "월 ";
		strDateTime += znow.getDayOfMonth() + "일 ";
		strDateTime += znow.getDayOfWeek() + " ";
		strDateTime += znow.getHour() + "시 ";
		strDateTime += znow.getMinute() + "분 ";
		strDateTime += znow.getSecond() + "초 ";
		strDateTime += znow.getNano() + "나노초 ";
		System.out.println(strDateTime + "\n");
		
		LocalDate nowDate = znow.toLocalDate();
		if(nowDate.isLeapYear()) {
			System.out.println("올해는 윤년: 2월은 29일까지 있습니다.\n");
		} else {
			System.out.println("올해는 평년: 2월은 28일까지 있습니다.\n");
		}
		
		ZonedDateTime zutcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
		System.out.println("협정 세계시: " + zutcDateTime);
		ZonedDateTime seoulDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
		System.out.println("서울 타임존: " + seoulDateTime);
		ZoneId seoulZoneId = seoulDateTime.getZone();
		System.out.println("서울 존아이디: " + seoulZoneId);
		ZoneOffset seoulZoneOffset = seoulDateTime.getOffset();
		System.out.println("서울 존오프셋: " + seoulZoneOffset + "\n");
		
		// 날짜와 시간 연산
		LocalDateTime onow = LocalDateTime.now();
		System.out.println("현재시: " + onow);
		
		LocalDateTime otargetDateTime = onow
			.plusYears(1)
			.minusMonths(2)
			.plusDays(3)
			.plusHours(4)
			.minusMinutes(5)
			.plusSeconds(6);
		System.out.println("연산후: " + targetDateTime);
		
		// 날짜와 시간 변경
		LocalDateTime tnow = LocalDateTime.now();
		System.out.println("현재: " + tnow);
		
		LocalDateTime ttargetDateTime = null;
		
		ttargetDateTime = tnow
				.withYear(2024)
				.withMonth(10)
				.withDayOfMonth(5)
				.withHour(13)
				.withMinute(30)
				.withSecond(20);
		System.out.println("직접 변경: " + ttargetDateTime);
		
		ttargetDateTime = tnow.with(TemporalAdjusters.firstDayOfYear());
		System.out.println("이번 해의 첫 일: " + ttargetDateTime);
		ttargetDateTime = tnow.with(TemporalAdjusters.lastDayOfYear());
		System.out.println("이번 해의 마지막 일: " + ttargetDateTime);
		ttargetDateTime = tnow.with(TemporalAdjusters.firstDayOfNextYear());
		System.out.println("다음 해의 첫 일: " + ttargetDateTime);
		
		ttargetDateTime = tnow.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("이번 달의 첫 일: " + ttargetDateTime);
		ttargetDateTime = tnow.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println("이번 달의 마지막 일: " + ttargetDateTime);
		ttargetDateTime = tnow.with(TemporalAdjusters.firstDayOfNextMonth());
		System.out.println("다음 달의 첫 일: " + ttargetDateTime);
		
		ttargetDateTime = tnow.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
		System.out.println("이번 달의 첫 월요일: " + ttargetDateTime);
		ttargetDateTime = tnow.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		System.out.println("돌아오는 월요일: " + ttargetDateTime);
		ttargetDateTime = tnow.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
		System.out.println("지난 월요일: " + ttargetDateTime);
		
		// Period & Duration
		LocalDateTime startDateTime = LocalDateTime.of(2023, 1, 1, 1, 9, 0, 0);
		System.out.println("시작일: " + startDateTime);
		
		LocalDateTime endDateTime = LocalDateTime.of(2024, 3, 31, 18, 9, 0, 0);
		System.out.println("종료일: " + endDateTime + "\n");
		
		if(startDateTime.isBefore(endDateTime)) {
			System.out.println("진행중입니다." + "\n");
		} else if(startDateTime.isEqual(endDateTime)) {
			System.out.println("종료합니다.\n");
		} else if(startDateTime.isAfter(endDateTime)) {
			System.out.println("종료했습니다.\n");
		}
		
		System.out.println("[종료까지 남은 시간]");
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
		
		System.out.println("남은 해: " + remainYear);
		System.out.println("남은 달: " + remainMonth);
		System.out.println("남은 일: " + remainDay);
		System.out.println("남은 시간: " + remainHour);
		System.out.println("남은 분: " + remainMinute);
		System.out.println("남은 초: " + remainSecond + "\n");
		
		System.out.println("[종료까지 남은 기간]");
		Period period = Period.between(startDateTime.toLocalDate(), endDateTime.toLocalDate());
		System.out.print("남은 기간: " + period.getYears() + "년 ");
		System.out.print(period.getMonths() + "달 ");
		System.out.print(period.getDays() + "일\n");
		
		Duration duration = Duration.between(startDateTime.toLocalTime(), endDateTime.toLocalTime());
		System.out.println("남은 초: " + duration.getSeconds());
		
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
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 a h시 m분");
		String nowString = fnow.format(dateTimeFormatter);
		System.out.println(nowString);
	}
}

