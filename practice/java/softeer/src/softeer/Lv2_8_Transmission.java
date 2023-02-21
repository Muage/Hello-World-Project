package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 문제 ( Lv2. 8단 변속기 )
// 현대자동차에서는 부드럽고 빠른 변속이 가능한 8단 습식 DCT 변속기를 개발하여 N라인 고성능차에 적용하였다.
// 관련하여 SW 엔지니어인 당신에게 연속적으로 변속이 가능한지 점검할 수 있는 프로그램을 만들라는 임무가 내려왔다.
// 당신은 변속기가 1단에서 8단으로 연속적으로 변속을 한다면 ascending, 8단에서 1단으로 연속적으로 변속한다면 descending, 둘다 아니라면 mixed 라고 정의했다.
// 변속한 순서가 주어졌을 때 이것이 ascending인지, descending인지, 아니면 mixed인지 출력하는 프로그램을 작성하시오.

// 제약조건
// 주어지는 숫자는 문제 설명에서 설명한 변속 정도이며, 1부터 8까지 숫자가 한번씩 등장한다.

// 입력형식
// 첫째 줄에 8개 숫자가 주어진다.

// 출력형식
// 첫째 줄에 ascending, descending, mixed 중 하나를 출력한다.

// 입력예제
// 1 2 3 4 5 6 7 8

// 출력예제
// ascending

public class Lv2_8_Transmission {
	
	public static void main(String[] args) throws Exception {
		/*
		 * 방법 3. 득점: 100.0		실행시간: 70ms		메모리: 10.22Mb
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		String result = "";
		int[] ascending = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] descending = {8, 7, 6, 5, 4, 3, 2, 1};
		int[] arr = new int[8];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		
		for(int i = 0; i < 8; i++) {
			if(Arrays.equals(arr, ascending)) {
				result = "ascending";
			} else if(Arrays.equals(arr, descending)) {
				result = "descending";
			} else {
				result = "mixed";
			}
		}
		
		System.out.println(result);
		
		
		/*
		 * 방법 2. 득점: 100.0		실행시간: 75ms		메모리: 10.25Mb
		 */
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(reader.readLine());
//		Integer[] arr = new Integer[8];
//		Integer[] sort = new Integer[8];
//		String result = "";
//		
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = Integer.valueOf(st.nextToken());
//			sort[i] = arr[i];
//		}
//		
//		for(int i = 0; i < 8; i++) {
//			Arrays.sort(sort);
//			if(Arrays.equals(arr, sort)) {
//				result = "ascending";
//			} else {
//				Arrays.sort(sort, Collections.reverseOrder());
//				if(Arrays.equals(arr, sort))
//					result = "descending";
//				else
//					result = "mixed";
//			}
//		}
//		
//		System.out.println(result);
		
		
		/*
		 * 방법 1. 득점: 0.0		실행시간: 72ms		메모리: 10.21Mb
		 */
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(reader.readLine());
//		Integer[] sort = new Integer[8];
//		int[] arr = new int[8];
//		String result = "";
//		
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = Integer.valueOf(st.nextToken());
//			sort[i] = arr[i];
//		}
//		
//		for(int i = 0; i < 8; i++) {
//			Arrays.sort(sort);
//			if(arr[i] == sort[i]) {
//				result = "ascending";
//			} else {
//				Arrays.sort(sort, Collections.reverseOrder());
//				if(arr[i] == sort[i])
//					result = "descending";
//				else
//					result = "mixed";
//			}
//		}
//		
//		System.out.println(result);
	}

}
