package ex03;

import java.util.Scanner;

public class Example1 {
	public static void execute() {
		//¼ıÀÚ1, ¼ıÀÚ2 ÀÔ·Â ¹Ş¾Æ
		//µ¡¼À(1), »¬¼À(2), °ö¼À(3), ³ª´°¼À(4) ¼±ÅÃ
		//°è»ê °á°ú Ãâ·Â
		Scanner s = new Scanner(System.in);
		
		System.out.print("¼ıÀÚ1 > ");
		int num1 = s.nextInt();
		
		System.out.print("¼ıÀÚ2 > ");
		int num2 = s.nextInt();
		
		System.out.println("µ¡¼À(1) / »¬¼À(2) / °ö¼À(3) / ³ª´°¼À(4) > ");
		int sel = s.nextInt();
		double result = 0;
		
		switch(sel) {
			case 1:
				result = num1 + num2;
				break;
			case 2:
				result = num1 - num2;
				break;
			case 3:
				result = num1 * num2;
				break;
			case 4:
				result = num1 / num2;
				break;
			default:
				System.out.println("Àß¸øµÈ ÀÔ·ÂÀÔ´Ï´Ù.");
		}
		System.out.println("°è»ê°á°ú:" + result);
	}
}
