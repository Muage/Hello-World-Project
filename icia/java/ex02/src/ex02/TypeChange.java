package ex02;

public class TypeChange {
	public static void change() {
		//�ڵ� Ÿ�Ժ�ȯ
		int intValue = 65;								//int : 4byte
		char charValue = 'Z';							//char : 2byte
		intValue = charValue;							//ASCII Code 'A' -> 65, 'a' -> 97
		System.out.println(intValue);
		
		intValue = 5;
		double dubValue = 3.14;							//double : 8byte
		dubValue = intValue;
		System.out.println(dubValue);
		
		//���� Ÿ�Ժ�ȯ (ū �� -> ���� ��)
		intValue = 5;
		dubValue = 3.14;
		intValue = (int)dubValue;
		System.out.println(intValue);
		
		intValue = 97;
		charValue = (char)intValue;
		System.out.println(charValue);
		
		double number = (double)7 / 3;					//or double number = 7 / 3.;
		System.out.println(number);
	}
}
