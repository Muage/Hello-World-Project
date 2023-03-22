package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 ( Lv2. GBC )
// 글로벌 비즈니스 센터(GBC, Global Business Center)는 현대자동차그룹 통합 사옥이다.
// 지하 7층, 지상 105층, 높이 약 570m의 규모로 2026년 하반기에 완공을 목표로 현재 공사 중에 있다.
// 이러한 초고층 높이의 빌딩에는 초고층 승강기가 들어가야 한다.
// 엘리베이터 정비공인 광우는 0m 부터 100m까지 일정 구간들의 엘리베이터 속도를 검사하는 업무를 맡게 되었다.
// 빌딩에서 운영되는 엘리베이터 구간은 N개의 구간으로 나뉘며 해당 구간의 제한 속도이 주어진다.
// 구간의 총 합은 100m 이며 각 구간별 구간의 길이와 제한 속도 모두 양의 정수로 주어진다.
// 예를 들어보자. 구간이 3이라고 할 때,
// ▶ 첫 번째 구간의 길이는 50m 이고 제한 속도는 50m/s
// ▶ 두 번째 구간의 길이는 40m 이고 제한 속도는 40m/s
// ▶ 세 번째 구간의 길이는 10m 이고 제한 속도는 30m/s
// 이 구간에서 제한 속도를 벗어나면(즉 제한속도를 초과하면) 서버에 초과한만큼의 속도가 로그에 남는다.
// 불행하게도 현재 서버의 상태가 off 상태임으로 광우는 서버의 데이터를 받아볼 수가 없다.
// 광우는 임의의 구간의 길이와 속도를 정하여 시범운행 할 때, 가장 제한 속도가 크게 벗어난 값을 스스로 구해야 한다.
// M개의 구간을 검사한다고 할 때 예를 들면,
// ▶ 첫 번째 구간의 운행 길이는 60m 이고 속도는 76m/s
// ▶ 두 번째 구간의 운행 길이는 18m 이고 속도는 28m/s
// ▶ 세 번째 구간의 운행 길이는 22m 이고 속도는 50m/s이라고 했을 때, 제한 속도를 벗어나 가장 차이가 큰 속도를 구해 보자.
// 첫번째 구간 50m 까지에서 제한 속도와 실제 운행 속도를 비교했을 때, 제한 속도를 26m/s 초과했다.
// 이후 두번째 구간과 실 운행한 첫번째 구간이 10m 정도 겹치는데, 이때 제한 속도를 36m/s 초과하게 된다.
// 그 이후 구간들에서는 차이가 그보다 크지 않으므로 가장 큰 속도 차이는 36m/s임을 알 수 있다.
// 주어진 구간의 제한속도와 광우가 테스트한 구간의 속도를 기준으로 가장 크게 제한 속도를 넘어간 값이 얼마인지 구해보자.

// 제약조건
// 1 ≤ N, M ≤ 100

// 입력형식
// 첫 줄에 N과 M이 주어진다.
// 그 다음 줄부터 N개의 줄은 각 구간의 길이 및 해당 구간에서의 제한 속도가 주어지며, 다음 M개의 줄은 광우가 테스트하는 구간의 길이와 속도가 주어진다.

// 출력형식
// 광우가 시범운행을 하는 동안 제한 속도를 가장 크게 벗어난 값을 출력 한다.
// 단 제한 속도를 벗어나지 않은 경우는 0을 출력 한다.

// 입력예제1
// 3 3
// 50 50
// 40 40
// 10 30
// 60 76
// 18 28
// 22 50

// 출력예제1
// 36

// 입력예제2
// 3 3
// 50 90
// 10 90
// 40 50
// 50 40
// 10 100
// 40 40

// 출력예제2
// 10

public class Lv2_GBC {
	
	/*
	 * 다른 사람 코드
	 * 방법 1. 득점: 0.0		실행시간: 69ms		메모리: 10.37Mb
	 * test6_런타임에러
	 */
	public static int N, M;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		int max = 0;
		int[][] limit = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(reader.readLine());
			limit[i][0] = Integer.valueOf(st.nextToken());
			limit[i][1] = Integer.valueOf(st.nextToken());
		}
		
		int[][] race = new int[M][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(reader.readLine());
			race[i][0] = Integer.valueOf(st.nextToken());
			race[i][1] = Integer.valueOf(st.nextToken());
		}

		int temp = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = temp; j < M; j++) {
				if(limit[i][0] < race[j][0]) {
					race[j][0] -= limit[i][0];
					if(race[j][1] - limit[i][1] > 0) {
						max = Math.max(max, race[j][1] - limit[i][1]);
					}
					break;
				} else if(limit[i][0] > race[j][0]) {
					limit[i][0] -= race[j][0];
					if(race[j][1] - limit[i][1] > 0) {
						max = Math.max(max, race[j][1] - limit[i][1]);
					}
					temp++;
				} else {
					if(race[j][1] - limit[i][1] > 0) {
						max = Math.max(max, race[j][1] - limit[i][1]);
					}
					temp++;
					break;
				}
			}
		}
		
		System.out.println(max);
	}

}
