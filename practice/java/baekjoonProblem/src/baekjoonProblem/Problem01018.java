package baekjoonProblem;

// 문제 ( 브루트 포스 단계 )
// 지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다.
// 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다.
// 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.
// 체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다.
// 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다.
// 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다.
// 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
// 보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다.
// 당연히 8*8 크기는 아무데서나 골라도 된다.
// 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 N과 M이 주어진다.
// N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다.
// 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다.
// B는 검은색이며, W는 흰색이다.

// 출력
// 첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.

// 예제 입력
// (1)	8 8
// 		WBWBWBWB
// 		BWBWBWBW
// 		WBWBWBWB
// 		BWBBBWBW
// 		WBWBWBWB
// 		BWBWBWBW
// 		WBWBWBWB
// 		BWBWBWBW
// (2)	10 13
// 		BBBBBBBBWBWBW
// 		BBBBBBBBBWBWB
// 		BBBBBBBBWBWBW
// 		BBBBBBBBBWBWB
// 		BBBBBBBBWBWBW
// 		BBBBBBBBBWBWB
// 		BBBBBBBBWBWBW
// 		BBBBBBBBBWBWB
// 		WWWWWWWWWWBWB
// 		WWWWWWWWWWBWB
// (3)	8 8
// 		BWBWBWBW
// 		WBWBWBWB
// 		BWBWBWBW
// 		WBWBWBWB
// 		BWBWBWBW
// 		WBWBWBWB
// 		BWBWBWBW
// 		WBWBWBWB
// (4)	9 23
// 		BBBBBBBBBBBBBBBBBBBBBBB
// 		BBBBBBBBBBBBBBBBBBBBBBB
// 		BBBBBBBBBBBBBBBBBBBBBBB
// 		BBBBBBBBBBBBBBBBBBBBBBB
// 		BBBBBBBBBBBBBBBBBBBBBBB
// 		BBBBBBBBBBBBBBBBBBBBBBB
// 		BBBBBBBBBBBBBBBBBBBBBBB
// 		BBBBBBBBBBBBBBBBBBBBBBB
// 		BBBBBBBBBBBBBBBBBBBBBBW
// (5)	10 10
// 		BBBBBBBBBB
// 		BBWBWBWBWB
// 		BWBWBWBWBB
// 		BBWBWBWBWB
// 		BWBWBWBWBB
// 		BBWBWBWBWB
// 		BWBWBWBWBB
// 		BBWBWBWBWB
// 		BWBWBWBWBB
// 		BBBBBBBBBB
// (6)	8 8
// 		WBWBWBWB
// 		BWBWBWBW
// 		WBWBWBWB
// 		BWBBBWBW
// 		WBWBWBWB
// 		BWBWBWBW
// 		WBWBWWWB
// 		BWBWBWBW
// (7)	11 12
// 		BWWBWWBWWBWW
// 		BWWBWBBWWBWW
// 		WBWWBWBBWWBW
// 		BWWBWBBWWBWW
// 		WBWWBWBBWWBW
// 		BWWBWBBWWBWW
// 		WBWWBWBBWWBW
// 		BWWBWBWWWBWW
// 		WBWWBWBBWWBW
// 		BWWBWBBWWBWW
// 		WBWWBWBBWWBW

// 예제 출력
// (1)	1
// (2)	12
// (3)	0
// (4)	31
// (5)	0
// (6)	2
// (7)	15

import java.util.Scanner;

public class Problem01018 {
	
	public static boolean[][] arr;
	public static int min = 64;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int row = n - 7;
		int col = m - 7;
		
		arr = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			String str = scanner.next();
			
			for(int j = 0; j < m; j++) {
				if(str.charAt(j) == 'W') {
					arr[i][j] = true;
				} else {
					arr[i][j] = false;
				}
			}
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				find(i, j);
			}
		}
		
		System.out.println(min);
		
		scanner.close();
	}
	
	public static void find(int x, int y) {
		int end_x = x + 8;
		int end_y = y + 8;
		int count = 0;
		boolean color = arr[x][y];
		
		for(int i = x; i < end_x; i++) {
			for(int j = y; j < end_y; j++) {
				if(arr[i][j] != color) {
					count++;
				}
				
				color = (!color);
			}
			color = (!color);
		}
		
		count = Math.min(count, 64 - count);
		min = Math.min(min, count);
	}

}