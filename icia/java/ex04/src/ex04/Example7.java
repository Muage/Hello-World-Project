package ex04;

import java.util.Scanner;

public class Example7 {
	public static void execute() {
		
		Scanner s = new Scanner(System.in);
		
		int[] no = new int[100];	//0~99
		String[] name = new String[100];
		int[] kor = new int[100];
		int[] eng = new int[100];
		int[] mat = new int[100];
		int cnt = 0;	//입력한 학생 수 저장
		
		boolean run = true;
		while(run) {
			System.out.println("------------------------------------------------------------");
			System.out.println("1. 성적입력 | 2. 성적검색 | 3. 성적수정 | 4. 성적표출력 | 0. 종료");
			System.out.println("------------------------------------------------------------");
			
			System.out.print("선택 > ");
			int sel = s.nextInt();
			
			switch(sel) {
			case 1:	//성적입력
				cnt++; //cnt = cnt + 1;
				System.out.println("학번 : " + cnt);
				no[cnt] = cnt;
				
				System.out.print("이름 > ");
				name[cnt] = s.next();
				
				System.out.print("국어 > ");
				kor[cnt] = s.nextInt();
				
				System.out.print("영어 > ");
				eng[cnt] = s.nextInt();
				
				System.out.print("수학 > ");
				mat[cnt] = s.nextInt();
				
				break;
				
			case 2:	//성적검색
				System.out.println("학번 > ");
				int num = s.nextInt();
				if(num<1 || num>cnt ) {
					System.out.println("학생이 존재하지 않습니다.\n");
				} else {
					System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
					int tot = kor[num] + eng[num] + mat[num];
					double avg = tot / 3.;
					System.out.print(name[num] + "\t" + kor[num] + "\t" + eng[num] + "\t" + mat[num]);
					System.out.println("\t" + tot + "\t" + avg + "\n");
				}
				
				break;
				
			case 3:
				
				break;
				
			case 4:	//성적표출력
				System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
				for(int i=1; i<=cnt; i++) {
					int tot = kor[i] + eng[i] + mat[i];
					double avg = tot / 3.;
					System.out.print(name[i] + "\t" + kor[i] + "\t" + eng[i] + "\t" + mat[i]);
					System.out.println("\t" + tot + "\t" + avg);
				}
				System.out.println("");
				break;
				
			case 0:
				System.out.println("프로그램을 종료합니다!\n");
				run = false;
				break;
			default:
				System.out.println("0~4번 메뉴를 선택하세요!\n");
				break;
			}
		}
	}
}
