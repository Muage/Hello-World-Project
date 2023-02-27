package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ���� ( Lv2. ��� �޴� )
// ȸ�� �Ĵ翡�� ����ó�� ���� �������� ��� �޴��� ���� �ҹ��� �ִ�.
// �ҹ��� ������ �밭 �̷��ϴ�.
// �ı� ���Ǳ��� ��ư�� Ư�� ������� ������ ������ �ϸ�, ��ҿʹ� �ٸ� ������ �ı��� ���´�.
// �� �ı��� ��Ĵ뿡 �����ϸ�, � ��� �޴��� ���� �� �ִٴ� ���̴�.
// ���� �̸� ������ �� ����� �ƹ��� ���, � �޴��� ���������� Ŀ�� ������ �ϴ� ��ư�� �������� �˷��� ���� �ʴ�.
// �ֹ����� ����� �� �ҹ��� ��ü�� �˰� �ִ�.
// �̴� �и��� ����̴�!
// ������ ��ư ���۹��� ����ϸ� ��� �޴��� �ı��� ���� �� �ִ�.
// �׷��� �� �� �ı� ���ǱⰡ �������� ��ü�Ǹ鼭, �� ���Ǳ⿡���� ��� �޴� ���۹��� �۵����� �ʰ� �Ǿ���.
// ����� ���α׷��� �Ƿ��� ���, ������� ��ư ���� �� ��� �޴� ���۹��� ���ԵǾ� �ִ����� �Ǵ��ϴ� ȸ�θ� �߰��Ϸ� �Ѵ�.
// ���Ǳ⿡�� �� K���� ��ư�� �ִ�.
// �� ��ư���� 1���� K���� ��ȣ�� �پ� �־, ���� ������ 1 �̻� K ������ ���� ���� ���� ��Ÿ�� �� �ִ�.
// ��� �޴� ���۹��� M���� ��ư �������� �̷���� ������, �� ������� ��ư�� ������ �ݵ�� ��� �޴� �ı��� �߸ŵȴ�.
// �̶�, �� ���۹� �յڷ� �ٸ� ��ư ������ �־ ��� �޴��� �����ȴ�.
// ����ڰ� ���� N���� ��ư ������ �־��� ��, ����ڰ� ��� �޴� �ı��� ���� �� �ִ����� Ȯ���ϴ� ���α׷��� �ۼ��Ͽ���.

// ��������
// 1 �� K �� 9
// 1 �� M �� 100
// 1 �� N �� 100
// �� ��ư�� ��ȣ�� 1 �̻� K �����̴�.

// �Է�����
// ù° �ٿ� M, N, K�� ������ ���̿� �ΰ� �־�����.
// ��° �ٿ� ��� �޴� ���۹��� ��Ÿ���� M���� ������ ������ ���̿� �ΰ� �־�����.
// �� ������ 1 �̻� K �����̴�.
// ��° �ٿ� ������� ��ư ������ ��Ÿ���� N���� ������ ������ ���̿� �ΰ� �־�����.
// �� ������ 1 �̻� K �����̴�.

// �������
// ����ڰ� ��� �޴� �ı��� ���� �� �ִٸ� secret��, �׷��� �ʴٸ� normal�� ù° �ٿ� ����Ѵ�.

// �Է¿���1
// 3 10 5
// 1 4 5
// 3 3 1 2 4 1 4 5 1 4

// ��¿���1
// secret

// �Է¿���2
// 4 10 3
// 2 1 3 2
// 1 3 2 1 3 2 1 3 2 1

// ��¿���2
// secret

// �Է¿���3
// 4 10 9
// 2 7 1 8
// 3 1 4 1 5 9 2 6 5 3

// ��¿���3
// normal

// �Է¿���4
// 4 3 5
// 1 2 3 4
// 3 2 1

// ��¿���4
// normal

public class Lv2_secret_menu {
	
	public static void main(String[] args) throws Exception {
		/*
		 * ��� 3. ����: 100.0		����ð�: 70ms		�޸�: 10.29Mb
		 * contains ���� �ٽ� ���
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int M = Integer.valueOf(st.nextToken());
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());
		
		StringBuilder secret = new StringBuilder();
		st = new StringTokenizer(reader.readLine());
		for(int i = 0; i < M; i++) {
			secret.append(st.nextToken());
		}
		
		StringBuilder user = new StringBuilder();
		st = new StringTokenizer(reader.readLine());
		for(int i = 0; i < N; i++) {
			user.append(st.nextToken());
		}
		
		if (user.toString().contains(secret.toString())) System.out.println("secret");
		else System.out.println("normal");
		
		
		/*
		 * ��� 2. ����: 30.0		����ð�: 69ms		�޸�: 10.22Mb
		 */
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(reader.readLine());
//		
//		int M = Integer.valueOf(st.nextToken());
//		int N = Integer.valueOf(st.nextToken());
//		int K = Integer.valueOf(st.nextToken());
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
//		int check = 0;
//		int j = 0;
//		
//		for(int i = 0; i < N; i++) {
//			if(user[i] == secret[j]) {
//				check++;
//				j++;
//				if(secret.length == j) break;
//			} else {
//				check = 0;
//				j = 0;
//			}
//		}
//		
//		if(secret.length == check) {
//			System.out.println("secret");
//		} else {
//			System.out.println("normal");
//		}
		
		
		/*
		 * ��� 1. ����: 0.0		����ð�: 73ms		�޸�: 10.23Mb
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