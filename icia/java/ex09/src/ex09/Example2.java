package ex09;

import java.io.*;

public class Example2 {
	public static void execute() {
		System.out.println("******************** 주소관리 ********************");
		File file = new File("c://data/java/address.txt");	//파일 열기
		
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write("홍길동, 010-0000-1111, 인천 서구 경서동\n");
			writer.write("심청이, 010-2222-3333, 서울 강남구 압구정동\n");
			writer.flush();	//버퍼 내용 삭제
			writer.close();	//파일 닫기
			System.out.println("저장 완료");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
