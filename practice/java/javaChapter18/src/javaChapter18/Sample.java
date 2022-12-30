package javaChapter18;

import java.io.InputStream;
import java.io.OutputStream;

public class Sample {
	public static void main(String[] args) throws Exception {
		// 콘솔 입출력
		// System.in 필드
		System.out.println("--- 메 뉴 ---");
		System.out.println("1. 예금 조회");
		System.out.println("2. 예금 출금");
		System.out.println("3. 예금 입금");
		System.out.println("4. 종료 하기");
		System.out.print("메뉴를 선택하세요.");
		
		InputStream is = System.in;	// 키보드 입력 스트림 얻기
		char inputChar = (char)is.read();	// 아스키 코드 읽고 문자로 리턴
		switch(inputChar) {
		case '1':
			System.out.println("예금 조회를 선택하셨습니다.");
			break;
			
		case '2':
			System.out.println("예금 출금을 선택하셨습니다.");
			break;
			
		case '3':
			System.out.println("예금 입금을 선택하셨습니다.");
			break;
			
		case '4':
			System.out.println("종료 하기를 선택하셨습니다.");
			break;
		}
		
		InputStream ins = System.in;
		byte[] datas = new byte[100];
		
		System.out.print("이름: ");
		int nameBytes = ins.read(datas);
		String name = new String(datas, 0, nameBytes-2);
		
		System.out.print("하고 싶은 말: ");
		int commentBytes = ins.read(datas);
		String comment = new String(datas, 0, commentBytes-2);
		
		System.out.println("입력한 이름: " + name);
		System.out.println("입력한 하고 싶은 말: " + comment);
		
		// System.out 필드
		OutputStream os = System.out;
	}
}
