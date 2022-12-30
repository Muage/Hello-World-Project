package ex07;

public class Example1 {
	public static void execute() {
		System.out.println("***** 연습1 *****");
		
		Area a1 = new Area();
		
		Area a2 = new Area();
		System.out.println("면적 : " + a2.area(5));
		System.out.println("");
		
		Area a3 = new Area();
		System.out.println("면적 : " + a3.area(3, 4));
		System.out.println("");
	}
}
