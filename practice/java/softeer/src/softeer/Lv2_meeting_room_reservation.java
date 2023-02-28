package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

// ���� ( Lv2. ȸ�ǽ� ���� )
// ȸ�翡�� N���� ȸ�ǽ��� �ִ�.
// ������ ���� �� ����ϰ� ������ ó���ϱ� ���ؼ��� ȸ�ǽ��� �ʼ����̴�.
// ���θ��� ���� ������ ȸ�ǽ� ���� �ý����� ������ ���Ǽ��� �ſ� ��������.
// �ܼ��� ����� ȸ���� ��ϸ� ǥ�õǱ� ������, �� ���� ��� �ִ� �ð��� ���������� Ȯ���ϱⰡ ���� ���̴�.
// ����� �̸� ���� �ذ��� ����� ���� �Ծ���.
// ȸ�ǽ� �̿� ��Ģ�� ������ ����:
// 	- ȸ�ǽ��� 9�ú��� 18�ñ����� ��� �����ϴ�. ��� ȸ���� �ð��� �� �ȿ� ������ ���ԵǾ�� �Ѵ�.
// 	- ȸ�Ǵ� ��Ȯ�� �� ȸ�ǽ��� ������ ���� �ð� ���ȸ� �����Ѵ�. �� �� ȸ�Ǵ� (ȸ�ǽ�, ���� �ð�, ���� �ð�)�� ������ ��Ÿ�� �� �ִ�.
// 	- ȸ���� ���۰� ���� �ð��� ��(��, hour) �����θ� ���� �����ϴ�. ���� ȸ�ǽ��� ����ϴ� ȸ�� �ð��� ���� ��ĥ �� ����. ���⼭ ��ģ�ٴ� ����, �� ȸ�� ��ο� ���ԵǴ� �ð��� 1�ð� �̻� �����Ѵٴ� ���� �ǹ��Ѵ�. ���� ���, 10��-12���� ȸ�ǿ� 11��-13���� ȸ�Ǵ� ��ġ�µ�, 11��-12���� �ð��� �� ȸ�� ��ο� ���ԵǱ� �����̴�.
// 	- �� ȸ�ǰ� ������ �ð���, ���� ȸ�ǽǿ��� �ٸ� ȸ�ǰ� �����ϴ� ���� ���ȴ�. �� ��� �� ȸ�ǰ� ��ġ�� �ʱ� �����̴�.
// 	- ���̰� 0�� ȸ��, �� ���� �ð��� ���� �ð��� ������ ȸ�Ǵ� ����� �� ������, ���Ӱ� ���� ���� ����.
// �̹� ����� M���� ȸ�ǿ� ���� ������ �־�����, ȸ�ǽǺ��� ��� �ִ� �ð��븦 ������ ����ϴ� ���α׷��� �ۼ��� ����.
// ��ü���� ������ �Ʒ��� �����Ͻÿ�.

// ��������
// 1 �� N �� 50
// 1 �� M �� 100
// ȸ�ǽ��� �̸��� ���� ���ĺ� �ҹ��ڷθ� �̷���� ������ ���̴� 1 �̻� 10 �����̴�.
// �־����� ��� �ð��� 9 �̻� 18 �����̴�.
// ȸ���� ���� �ð��� ȸ���� ���� �ð��� 1�ð� �̻� �ռ���.

// �Է�����
// ù° �ٿ� ȸ�ǽ��� ���� ����� ȸ���� ���� ��Ÿ���� ���� N�� M�� ������ ���̿� �ΰ� �־�����.
// �̾� N���� �ٿ��� �� ȸ�ǽ��� �̸��� �־�����.
// �̾� M���� �ٿ��� �� ȸ�ǰ� ������ ȸ�ǽ��� �̸� r�� ���� �ð� s, �׸��� ���� �ð� t�� ������ ���̿� �ΰ� �־�����.

// �������
// �� ȸ�ǽǿ� ���� ������ ȸ�ǽ� �̸��� ������������ ����Ѵ�.
// �� ȸ�ǽǿ� ���� ������ ������ ����.
// ù° �ٿ��� { Room ȸ�ǽ��̸�: } (�߰�ȣ ����)�� ����Ѵ�.
// ��° �ٿ��� ���డ�� �ð��� ����Ѵ�.
// 	- ���� ������ �ð����� ������ n�̶�� �� ��, { n available: } (�߰�ȣ ����)�� ����ϰ�, �ڵ��� n���� �ٿ� ���� ������ �ð��븦 { 09-18 } (������ �Ѱ�, �߰�ȣ ����)���·� ����ؾ� �Ѵ�. �� �ڸ� ���� ��� �տ� 0�� �ٿ� �� �ڸ� ���� ������ �Կ� �����϶�.
// 	- ���� ������ �ð��� ���ٸ�, Not available�� ����Ѵ�.
// �� ȸ�ǽǿ� ���� ���� ���̿��� ----- (������ �ټ� ��)�� ���м��� ��µǾ�� �Ѵ�.

// �Է¿���1
// 3 7
// grandeur
// avante
// sonata
// sonata 14 16
// grandeur 11 12
// avante 15 18
// sonata 10 11
// avante 9 12
// grandeur 16 18
// avante 12 15

// ��¿���1
// Room avante:
// Not available
// -----
// Room grandeur:
// 2 available:
// 09-11
// 12-16
// -----
// Room sonata:
// 3 available:
// 09-10
// 11-14
// 16-18

// �Է¿���2
// 3 2
// santafe
// aerocity
// porter
// santafe 9 12
// porter 9 18

// ��¿���2
// Room aerocity:
// 1 available:
// 09-18
// -----
// Room porter:
// Not available
// -----
// Room santafe:
// 1 available:
// 12-18

public class Lv2_meeting_room_reservation {
	
	private static HashMap<String, String[]> current = new HashMap<>();
	private static ArrayList<String[]> available;
	
	private static void reserve(String room, int start, int end) {
		String[] time = current.get(room);
		int index = start - 9;
		boolean run = true;
		
		while(run) {
			time[index] = "1";
			index += 1;
			
			current.replace(room, time);
			
			if((index + 9) == end) run = false;
			
//			System.out.println(room + " " + Arrays.toString(time));
		}
	}
	
	private static void result(String[] time) {
		String start = "";
		String end = "";
		
		available = new ArrayList<>();
		
		System.out.println(Arrays.toString(time));
		
		for(int i = 0; i < 9; i++) {
			if(i < 8) {
				if(start.equals("") && end.equals("")) {
					if(!time[i].equals("1")) {
						start = time[i];
					}
					continue;
				} else if(!start.equals("") && end.equals("")) {
					if(time[i].equals("1")) {
						end = String.valueOf(Integer.valueOf(time[i - 1]) + 1);
						available.add(new String[] {start, end});
						System.out.println(start + "-" + end);
						start = "";
						end = "";
					}
					continue;
				}
			} else {
				if(!time[i].equals("1")) {
					end = String.valueOf(Integer.valueOf(time[i]) + 1);
					available.add(new String[] {start, end});
					System.out.println(start + "-" + end);
				}
			}
			
		}
		
		System.out.println(available.size());
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		String[] meetingRoom = new String[N];
		ArrayList<String[]> reserve = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			String[] time = {"09", "10", "11", "12", "13", "14", "15", "16", "17"};
			
			st = new StringTokenizer(reader.readLine());
			meetingRoom[i] = st.nextToken();
			
			current.put(meetingRoom[i], time);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(reader.readLine());
			reserve.add(new String[] {st.nextToken(), st.nextToken(), st.nextToken()});
			
//			System.out.println(reserve.get(i)[0]);
			String room = reserve.get(i)[0];
			int start = Integer.valueOf(reserve.get(i)[1]);
			int end = Integer.valueOf(reserve.get(i)[2]);
			
			reserve(room, start, end);
		}
		
		ArrayList<String> keyList = new ArrayList<>(current.keySet());
		keyList.sort((s1, s2) -> s1.compareTo(s2));
		for(String key : keyList) {
			System.out.println("Room " + key + ":");
//			System.out.println(Arrays.toString(current.get(key)));
			result(current.get(key));
			System.out.println("-----");
		}
		
//		for(int i = 0; i < current.size(); i++) {
//			System.out.println(meetingRoom[i]);
//			System.out.println(Arrays.toString(current.get(meetingRoom[i])));
//		}
	}

}