package baekjoonProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// ���� ( ���հ� �� �ܰ� )
// �� N���� ���ڿ��� �̷���� ���� S�� �־�����.
// �Է����� �־����� M���� ���ڿ� �߿��� ���� S�� ���ԵǾ� �ִ� ���� �� �� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� ���ڿ��� ���� N�� M (1 �� N �� 10,000, 1 �� M �� 10,000)�� �־�����.
// ���� N���� �ٿ��� ���� S�� ���ԵǾ� �ִ� ���ڿ����� �־�����.
// ���� M���� �ٿ��� �˻��ؾ� �ϴ� ���ڿ����� �־�����.
// �Է����� �־����� ���ڿ��� ���ĺ� �ҹ��ڷθ� �̷���� ������, ���̴� 500�� ���� �ʴ´�.
// ���� S�� ���� ���ڿ��� ���� �� �־����� ���� ����.

// ���
// ù° �ٿ� M���� ���ڿ� �߿� �� �� ���� ���� S�� ���ԵǾ� �ִ��� ����Ѵ�.

// ���� �Է�
// 5 11
// baekjoononlinejudge
// startlink
// codeplus
// sundaycoding
// codingsh
// baekjoon
// codeplus
// codeminus
// startlink
// starlink
// sundaycoding
// codingsh
// codinghs
// sondaycoding
// startrink
// icerink

// ���� ���
// 4

public class Problem14425 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			map.put(reader.readLine(), 0);
		}
		
		for(int i = 0; i < m; i++) {
			if(map.containsKey(reader.readLine())) count++;
		}
		System.out.println(count);
	}

}