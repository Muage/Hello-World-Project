package baekjoon;

import java.util.*;

public class Task4 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		
//		System.out.println("--------------------");
//		
//		int noa = s.nextInt();
//		int nob = s.nextInt();
//		int noc = s.nextInt();
//		int nomul = noa * nob * noc;
//		int i, j;
//		int ncount = 0;
//		
//		String strno = Integer.toString(nomul);
//		
//		for(i = 0; i < 10; i++) {
//			ncount = 0;
//			for(j = 0; j < strno.length(); j++) {
//				if((strno.charAt(j)-48) == i) {
//					ncount++;
//				}
//			}
//			System.out.println(ncount);
//		}
//		System.out.println("--------------------");
//		
//		int i, j, k;
//		int[] arr = new int[10];
//		boolean tcount;
//		int count = 0;
//		
//		for(i = 0; i < 10; i++) {
//			int a = s.nextInt();
//			int revalue = a % 42;
//			arr[i] = revalue;
//		}
//		for(j = 0; j < 10; j++) {
//			tcount = true;
//			for(k = j+1; k < 10; k++) {
//				if(arr[j] == arr[k]) {
//					tcount = false;
//				}
//			}
//			if(tcount == true) {
//				count++;
//			}
//		}
//		System.out.println(count);
//		System.out.println("--------------------");
//		
//		double calscore;
//		double sum = 0;
//		
//		int subn = s.nextInt();
//		int[] score = new int[subn];
//		double[] arrcalscore = new double[subn];
//		
//		for(int i = 0; i < subn; i++) {
//			score[i] = s.nextInt();
//		}
//		
//		Arrays.sort(score);
//		
//		for(int j = 0; j < subn; j++) {
//			arrcalscore[j] = (100. * score[j]) / score[subn-1];
//			sum += arrcalscore[j];
//		}
//		
//		System.out.println(sum / subn);

//		System.out.println("--------------------");
//		
//		int q = s.nextInt();
//		String ox;
//		
//		for(int i = 0; i < q; i++) {
//			ox = s.next();
//			int count = 0;
//			int sum = 0;
//			for(int j = 0; j < ox.length(); j++) {
//				if(ox.charAt(j) == 'O') {
//					count++;
//				} else {
//					count = 0;
//				}
//				sum = sum + count;
//			}
//			System.out.println(sum);
//		}
//		System.out.println("--------------------");
//		
//		int i, j, k;
//		double[] sco;
//		
//		int tc = s.nextInt();
//		for(i = 0; i < tc; i++) {
//			double sum = 0;
//			double avg = 0;
//			int count = 0;
//			int student = s.nextInt();
//			sco = new double[student];
//			for(j = 0; j < student; j++) {
//				double score = s.nextInt();
//				sco[j] = score;
//				sum += score;
//			}
//			avg = (double)sum / student;
//			
//			for(k = 0; k < sco.length; k++) {
//				if(sco[k] > avg) {
//					count++;
//				}
//			}
//			double percent = 100 * (double)count / student;
//			System.out.printf("%.3f%%\n", percent);
//		}
//		System.out.println("--------------------");
	}
}
