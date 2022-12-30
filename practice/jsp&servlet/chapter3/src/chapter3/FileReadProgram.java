package chapter3;

import java.io.*;

class FileReadProgram {
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("c:/Temp/input.txt"));
			while(true) {
				String str = reader.readLine();
				if(str == null) {
					break;
				}
				System.out.println(str);
			}
			reader.close();
		} catch(Exception e) {
			System.out.println("파일을 읽을 수 없습니다.");
		}
	}
}
