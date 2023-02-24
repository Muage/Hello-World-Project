package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 ( Lv2. 비밀 메뉴 )
// 회사 식당에는 전설처럼 전해 내려오는 비밀 메뉴에 대한 소문이 있다.
// 소문의 내용은 대강 이러하다.
// 식권 자판기의 버튼을 특정 순서대로 누르고 결제를 하면, 평소와는 다른 색깔의 식권이 나온다.
// 이 식권을 배식대에 제출하면, 어떤 비밀 메뉴를 받을 수 있다는 것이다.
// 물론 이를 실제로 본 사람은 아무도 없어서, 어떤 메뉴가 나오는지는 커녕 눌러야 하는 버튼의 순서조차 알려져 있지 않다.
// 주방장인 당신은 이 소문의 실체를 알고 있다.
// 이는 분명한 사실이다!
// 정해진 버튼 조작법을 사용하면 비밀 메뉴의 식권을 얻을 수 있다.
// 그러나 얼마 전 식권 자판기가 고장으로 교체되면서, 새 자판기에서는 비밀 메뉴 조작법이 작동하지 않게 되었다.
// 당신은 프로그래밍 실력을 살려, 사용자의 버튼 조작 중 비밀 메뉴 조작법이 포함되어 있는지를 판단하는 회로를 추가하려 한다.
// 자판기에는 총 K개의 버튼이 있다.
// 각 버튼마다 1부터 K까지 번호가 붙어 있어서, 조작 과정은 1 이상 K 이하의 정수 여러 개로 나타낼 수 있다.
// 비밀 메뉴 조작법은 M개의 버튼 조작으로 이루어져 있으며, 이 순서대로 버튼을 누르면 반드시 비밀 메뉴 식권이 발매된다.
// 이때, 이 조작법 앞뒤로 다른 버튼 조작이 있어도 비밀 메뉴로 인정된다.
// 사용자가 누른 N개의 버튼 조작이 주어질 때, 사용자가 비밀 메뉴 식권을 받을 수 있는지를 확인하는 프로그램을 작성하여라.

// 제약조건
// 1 ≤ K ≤ 9
// 1 ≤ M ≤ 100
// 1 ≤ N ≤ 100
// 각 버튼의 번호는 1 이상 K 이하이다.

// 입력형식
// 첫째 줄에 M, N, K가 공백을 사이에 두고 주어진다.
// 둘째 줄에 비밀 메뉴 조작법을 나타내는 M개의 정수가 공백을 사이에 두고 주어진다.
// 각 정수는 1 이상 K 이하이다.
// 셋째 줄에 사용자의 버튼 조작을 나타내는 N개의 정수가 공백을 사이에 두고 주어진다.
// 각 정수는 1 이상 K 이하이다.

// 출력형식
// 사용자가 비밀 메뉴 식권을 받을 수 있다면 secret을, 그렇지 않다면 normal을 첫째 줄에 출력한다.

// 입력예제1
// 3 10 5
// 1 4 5
// 3 3 1 2 4 1 4 5 1 4

// 출력예제1
// secret

// 입력예제2
// 4 10 3
// 2 1 3 2
// 1 3 2 1 3 2 1 3 2 1

// 출력예제2
// secret

// 입력예제3
// 4 10 9
// 2 7 1 8
// 3 1 4 1 5 9 2 6 5 3

// 출력예제3
// normal

// 입력예제4
// 4 3 5
// 1 2 3 4
// 3 2 1

// 출력예제4
// normal

public class Lv2_secret_menu {
	
	public static void main(String[] args) throws Exception {
		/*
		 * 방법 2. 득점: 0.0		실행시간: 73ms		메모리: 10.23Mb
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int M = Integer.valueOf(st.nextToken());
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());
		int[] secret = new int[M];
		int[] user = new int[N];
		
		st = new StringTokenizer(reader.readLine());
		for(int i = 0; i < M; i++) {
			secret[i] = Integer.valueOf(st.nextToken());
		}
		
		st = new StringTokenizer(reader.readLine());
		for(int i = 0; i < N; i++) {
			user[i] = Integer.valueOf(st.nextToken());
		}
		
		int check = 0;
		int j = 0;
		
		for(int i = 0; i < N; i++) {
			if(user[i] == secret[j]) {
				check++;
				j++;
				if(secret.length == j) break;
			} else {
				check = 0;
				j = 0;
			}
		}
		
		if(secret.length == check) {
			System.out.println("secret");
		} else {
			System.out.println("normal");
		}
		
		
		/*
		 * 방법 1. 득점: 0.0		실행시간: 73ms		메모리: 10.23Mb
		 */
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(reader.readLine());
//		
//		int M = Integer.valueOf(st.nextToken());
//		int N = Integer.valueOf(st.nextToken());
//		int K = Integer.valueOf(st.nextToken());
//		int check = 0;
//		int[] secret = new int[M];
//		int[] user = new int[N];
//		
//		st = new StringTokenizer(reader.readLine());
//		for(int i = 0; i < M; i++) {
//			secret[i] = Integer.valueOf(st.nextToken());
//		}
//		
//		st = new StringTokenizer(reader.readLine());
//		for(int i = 0; i < N; i++) {
//			user[i] = Integer.valueOf(st.nextToken());
//		}
//		
//		for(int i = 0; i < M; i++) {
//			for(int j = 0; j < N; j++) {
//				if(secret[i] != user[j]) {
//					continue;
//				} else {
//					check++;
//					break;
//				}
//			}
//		}
//		
//		if(secret.length == check) {
//			System.out.println("secret");
//		} else {
//			System.out.println("normal");
//		}
	}

}
