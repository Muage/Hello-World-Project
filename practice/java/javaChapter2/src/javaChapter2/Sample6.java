package javaChapter2;

public class Sample6 {
	public static void main(String[] args) {
		char charValue = 'A';
		int intValue = charValue;
		System.out.println("A�� �����ڵ� = " + intValue);
		
		intValue = 200;
		double doubleValue = intValue;
		System.out.println(doubleValue);
		
		intValue = 65;
		charValue = (char)intValue;
		System.out.println(charValue);
		
		doubleValue = 3.14;
		intValue = (int)doubleValue;
		System.out.println(intValue);
		
		int i = 128;
		
		if(i < Byte.MIN_VALUE || (i > Byte.MAX_VALUE)) {
			System.out.println("byte Ÿ������ ��ȯ�� �� �����ϴ�.");
			System.out.println("���� �ٽ� Ȯ���� �ּ���.");
		} else {
			byte b = (byte)i;
			System.out.println(b);
		}
		
		int num1 = 123456780;
		int num2 = 123456780;
		
		float floatNum = num2;
		num2 = (int)floatNum;
		
		int result1 = num1 - num2;
		System.out.println("������ float Ÿ������ ��ȯ�� ���: " + result1);
		
		int intNum1 = 123456780;
		int intNum2 = 123456780;
		
		double doubleNum = intNum2;
		intNum2 = (int)doubleNum;
		
		int result2 = intNum1 - intNum2;
		System.out.println("������ double Ÿ������ ��ȯ�� ���: " + result2);
		
		char charValue1 = 'A';
		int intValue1 = 1;
		
		int intValue2 = charValue1 + intValue1;
		System.out.println("�����ڵ� = " + intValue2);
		System.out.println("��¹��� = " + (char)intValue2);
		
		int intValue3 = 10;
		doubleValue = intValue3 / 4.0;
		System.out.println(doubleValue);
	}
}
