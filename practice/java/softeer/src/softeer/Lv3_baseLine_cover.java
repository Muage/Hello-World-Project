package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 ( Lv3. 염기서열 커버 )
// 생명 공학을 연구하는 찬홍이는 요즘 DNA 염기서열을 연구하고 있다.
// DNA 염기서열이란 4종류의 핵염기 a(아데닌), c(사이토신), g(구아닌), t(티민)이 일자로 연결된 가닥이다.
// 문자열로는 a, c, g, t 네 문자의 나열로 나타낸다.
// 찬홍이는 인간에게 좋게 작용하는 좋은 염기서열 N개를 가지고 있고 이 모든 좋은 염기서열의 길이는 M이다.
// 주어진 좋은 염기서열은 몇 개의 와일드 카드(.)를 가지고 있어, 이 부분에는 a, c, g, t의 어떤 염기가 들어가도 좋은 염기서열로 작용한다고 하자.
// 주어진 좋은 염기서열의 조건을 만족할 수 있는 염기서열을 초염기서열이라고 한다.
// 그러나 주어진 모든 좋은 염기서열을 만족하는 것은 불가능할 수 있어서, 여러 초염기서열을 만들어서 여러 그룹의 좋은 염기서열을 커버할 수 있도록 하고자 한다.
// 주어진 모든 좋은 염기서열을 커버하기 위해 필요한 최소 갯수의 초염기서열은 몇 개일까?

// 제약조건
// * 1 ≤ N ≤ 15
// * 1 ≤ M ≤ 20
// * 주어지는 염기서열의 길이는 M이다.
// * 염기서열은 'a','c', 'g', 't', '.'으로 이루어져 있다.

// 입력형식
// 첫 번째 줄에는 좋은 염기서열의 개수과 그들의 길이 N, M이 주어진다.
// 다음 N개의 줄의 각 줄에는 좋은 염기서열이 주어진다.

// 출력형식
// 첫 번째 줄에 모든 염기서열을 커버하기 위한 초염기서열의 최소 갯수를 출력한다.

// 입력예제1
// 4 5
// a..tt
// gc...
// a.g.t
// .c.ag

// 출력예제1
// 2

// 입력예제2
// 4 1
// a
// g
// c
// t

// 출력예제2
// 4

// 입력예제3
// 4 4
// a...
// .c..
// ..g.
// ...t

// 출력예제3
// 1

public class Lv3_baseLine_cover {
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		char[][] base = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(reader.readLine());
			
			String temp = st.nextToken();
			
			for(int j = 0; j < temp.length(); j++) {
				base[i][j] = temp.charAt(j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(base[i][j] == base[i + 1][j]) {
					
				}
			}
		}
		
	}

}
