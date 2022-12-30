package ex05;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Example2 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("###.00");
		
		String[] name = new String[100];
		int[] kor = new int [100];
		int[] eng = new int [100];
		int[] mat = new int [100];
		
		int count = 0;
		
		boolean run = true;
		while(run) {
		
			System.out.println("****************** 성적관리 ******************");
			System.out.println("---------------------------------------------");
			System.out.println("1. 성적등록 | 2. 성적검색 | 3. 성적표출력 | 0. 종료");
			System.out.println("---------------------------------------------");
			System.out.print("선택 > ");
			int menu = s.nextInt();
			
			switch(menu) {
			case 1:
				System.out.print("이름 > ");
				name[count] = s.next();
				
				System.out.print("국어 > ");
				kor[count] = s.nextInt();
				
				System.out.print("영어 > ");
				eng[count] = s.nextInt();
				
				System.out.print("수학 > ");
				mat[count] = s.nextInt();
				
				count = count + 1; 
				System.out.println(count + "명 학생이 입력되었습니다.\n");
				break;
				
			case 2:
				System.out.print("이름 > ");
				String sname = s.next();	//검색할 이름 저장
				
				boolean find = false;
				
				for(int i=0; i<count; i++) {
					if(sname.equals(name[i])) {	//if(sname == name[i])는 주소를 비교하는 문장이라서 검색이 안된다.
						find = true;
						
						int sum = kor[i] + eng[i] + mat[i];
						double avg = sum / 3.;
						String strAvg = df.format(avg);
						
						System.out.println("국어\t영어\t수학\t총점\t평균");
						System.out.println(kor[i] + "\t" + eng[i] + "\t" + mat[i] + "\t" + sum + "\t" + strAvg + "\n");
					}
				}
				
				if(find == false) {
					System.out.println("학생이 존재하지 않습니다.\n");
				}
				
				break;
				
			case 3:
				
				System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
				for(int i=0; i<count; i++) {
					int sum = kor[i] + eng[i] + mat[i];
					double avg = sum / 3.;
					String strAvg = df.format(avg);
					
					System.out.println(name[i] + "\t" + kor[i] + "\t" + eng[i] + "\t" + mat[i] + "\t" + sum + "\t" + strAvg);
				}
				System.out.println("");
				
				break;
				
			case 0:
				run = false;
				System.out.println("프로그램이 종료됩니다.\n");
				
				break;
				
			default:
				System.out.println("0~3번 메뉴를 선택해주세요.\n");
			}
		}
	}
}
