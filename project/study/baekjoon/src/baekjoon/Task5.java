package baekjoon;

import java.util.*;

public class Task5 {
	public static void execute() {
//	static Long sum = 0l;
//	static Long temp = 0l;
//	public static void execute() {
//		Scanner scanner = new Scanner(System.in);
//		int intSumN = scanner.nextInt();
//		int[] a = new int[intSumN];
//		
//		for(int i=0; i<intSumN; i++) {
//			a[i] = scanner.nextInt();
//		}
//		
//		for(int i=0; i<a.length; i++) {
//			sum = Long.sum(a[i], temp);
//			temp = sum;
//		}
//		System.out.println(sum);
//	}
//}
//
//  long sum(int[] a) {
//	  Scanner scanner = new Scanner(System.in);
//	  long ans = 0;
//	  
//	  int intSumN = scanner.nextInt();
//	  int[] a = new int[intSumN];
//	
//	  for(int i=0; i<intSumN; i++) {
//		  a[i] = scanner.nextInt();
//	  }
//	
//	  long temp = 0l;
//	  for(int i=0; i<a.length; i++) {
//		  ans = Long.sum(a[i], temp);
//		  temp = ans;
//	  }
//
//	  return temp;
//  }
//}
//--------------------------------------------
//public class Task5 {
//	long sum(int[] a) {
//		long ans = 0;
//		long temp = 0l;
//	  
//		for(int i=0; i<a.length; i++) {
//			ans = Long.sum(a[i], temp);
//			temp = ans;
//		}
//		return temp;
//	}
	//--------------------------------------------
//		int temp, i, j, k;
//		int sum = 0, tot = 0;
//		String ans;
//		char charAns;
//		int[] sarray;
//		int[] array = new int[10000];
//		int[] totArray = new int[10000];
//		
//		for(i = 0; i < 10000; i++) {
//			sum = 0;
//			temp = i;
//			ans = Integer.toString(i);
//			
//			for(j = 0; j < ans.length(); j++) {
//				sarray = new int[ans.length()];
//				sarray[j] = ans.charAt(j) - '0';
//				
//				for(k = 0; k < sarray.length; k++) {
//					sum += sarray[k];
//				}
//			}
//			array[i] = temp + sum;
//			if((array[i] != i) && (i <= 10000)) {
//				totArray[i] = i;
//				
//				System.out.println(totArray[i]);
//			}
//		}
//		
//		int temp, i, j, k;
//		
//		boolean pass = true;
//		
//		for(i = 1; i <= 10000; i++) {
//			for(j = 1; j <= 10000; j++) {
//				if(i == selfNo(j)) {
//					pass = false;
//					break;
//				}
//			}
//			if(pass == true) {
//				System.out.println(i);
//			}
//			pass = true;
//		}
//	}
//	
//	static int selfNo(int x) {
//		String ans = Integer.toString(x);
//		
//		for(int i = 0; i < ans.length(); i++) {
//			x += Integer.parseInt(ans.substring(i, i+1));
//		}
//		return x;
//	}
		
		ArrayList<String> array = new ArrayList<>();
		
		int i, j, k, temp, sum;
		
		for(i = 1; i <= 10000; i++) {
			temp = i;
			String str = Integer.toString(i);
			sum = 0;
			for(j = 0; j < str.length(); j++) {
				char[] charArr = new char[str.length()];
				charArr[j] = str.charAt(j);
				sum += charArr[j] - '0';
			}
			int[] intArr = new int[str.length()];
			intArr[i-1] = temp + sum;
			
			for(i=0; i<=intArr.length; i++) {
				if(i == intArr[i]) {
					System.out.println(i);
				}
			}
		}
	}
}