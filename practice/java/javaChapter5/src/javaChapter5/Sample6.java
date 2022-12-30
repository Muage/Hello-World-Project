package javaChapter5;

public class Sample6 {
	public static void main(String[] args) {
		// 객체 참조 배열
		String[] strArray = new String[3];
		strArray[0] = "Java";
		strArray[1] = "Java";
		strArray[2] = new String("Java");
		System.out.println(strArray[0] == strArray[1]);
		System.out.println(strArray[0] == strArray[2]);
		System.out.println(strArray[0].equals(strArray[2]));
		
		// for문으로 배열 복사
		int[] oldIntArray = {1, 2, 3};
		int[] newIntArray = new int[5];
		for(int i = 0; i < oldIntArray.length; i++) {
			newIntArray[i] = oldIntArray[i];
		}
		
		for(int i = 0; i < newIntArray.length; i++) {
			System.out.print(newIntArray[i] + ",");
		}
		
		// arrayCopy
		String[] oldStrArray = {"java", "array", "copy"};
		String[] newStrArray = new String[5];
		System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
		
		for(int i = 0; i < newStrArray.length; i++) {
			System.out.print(newStrArray[i] + ",");
		}
	}
}
