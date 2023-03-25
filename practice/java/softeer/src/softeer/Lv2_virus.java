package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 ( Lv2. 바이러스 )
// 바이러스가 숙주의 몸속에서 1초당 P배씩 증가한다.
// 처음에 바이러스 K마리가 있었다면 N초 후에는 총 몇 마리의 바이러스로 불어날까?
// N초 동안 죽는 바이러스는 없다고 가정한다.

// 제약조건
// 1 ≤ K ≤ 108인 정수
// 1 ≤ P ≤ 108인 정수
// 1 ≤ N ≤ 106인 정수

// 입력형식
// 첫 번째 줄에 처음 바이러스의 수 K, 증가율 P, 총 시간 N(초)이 주어진다.

// 출력형식
// 최종 바이러스 개수를 1000000007로 나눈 나머지를 출력하라.

// 입력예제1
// 2 3 2

// 출력예제1
// 18

public class Lv2_virus {
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int K = Integer.valueOf(st.nextToken());
		int P = Integer.valueOf(st.nextToken());
		int N = Integer.valueOf(st.nextToken());
		
		long virus = K;
		
		for(int i = 0; i < N; i++) {
			virus = (virus * P) % 1000000007;
		}
		
		System.out.println(virus);
	}

}
