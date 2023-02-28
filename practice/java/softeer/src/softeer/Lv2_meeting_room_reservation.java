package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

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
	
	/*
	 * ��� 2. ����: 100.0		����ð�: 76ms		�޸�: 10.36Mb
	 */
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		Map<String, int[][]> reserve = new TreeMap<>();
		
		for(int i = 0; i < N; i++) {
			int[][] temp = new int[9][2];
			
			for(int j = 0; j < 9; j++) {
				temp[j][0] = j;
				temp[j][1] = j + 1;
			}
			
			reserve.put(reader.readLine(), temp);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(reader.readLine());
			
			String room = st.nextToken();
			int start = Integer.valueOf(st.nextToken());
			int end = Integer.valueOf(st.nextToken());
			
			int[][] current = reserve.get(room);
			
			for(int j = start; j < end; j++) {
				current[j - 9][0] = -1;
				current[j - 9][1] = -1;
			}
		}
		
		for(Map.Entry<String, int[][]> entry : reserve.entrySet()) {
			sb.append("Room ").append(entry.getKey()).append(":").append("\n");
			
			StringBuilder temp = new StringBuilder();
			int total = 0;
			int start = -1;
			int end = -1;
			int[][] current = entry.getValue();
			
			for(int i = 0; i < 9; i++) {
				if(current[i][0] != -1) {
					if(start == -1) {
						start = current[i][0];
					}
				} else {
					if(start != -1) {
						end = current[i - 1][1];
					}
				}
				
				if(start != -1 && end != -1) {
					temp.append(start == 0 ? "09" : start + 9).append("-");
					temp.append(end + 9).append("\n");
					start = end = -1;
					total++;
				}
			}
			
			if(start != -1) {
				total++;
				temp.append(start + 9 == 9 ? "09" : start + 9).append("-").append(18).append("\n");
			}
			
			if(total == 0) {
				sb.append("Not available").append("\n");
			} else {
				sb.append(total).append(" available:").append("\n");
				sb.append(temp);
			}
			
			sb.append("-----").append("\n");
		}
		sb.setLength(sb.length() - 6);
		System.out.println(sb);
	}
	
	
//	/*
//	 * ��� 1. ����: 0.0		����ð�: 180ms		�޸�: 14.85Mb
//	 */
//	private static HashMap<String, String[]> current = new HashMap<>();
//	private static ArrayList<String[]> available;
//	
//	private static void reserve(String room, int start, int end) {
//		String[] time = current.get(room);
//		int index = start - 9;
//		boolean run = true;
//		
//		while(run) {
//			time[index] = "1";
//			index += 1;
//			
//			current.replace(room, time);
//			
//			if((index + 9) == end) run = false;
//		}
//	}
//	
//	private static void result(String[] time) {
//		String start = "";
//		String end = "";
//		
//		available = new ArrayList<>();
//		
//		for(int i = 0; i < 9; i++) {
//			if(i < 8) {
//				if(start.equals("") && end.equals("")) {
//					if(!time[i].equals("1")) {
//						start = time[i];
//					}
//					continue;
//				} else if(!start.equals("") && end.equals("")) {
//					if(time[i].equals("1")) {
//						end = String.valueOf(Integer.valueOf(time[i - 1]) + 1);
//						available.add(new String[] {start, end});
//						start = "";
//						end = "";
//					}
//					continue;
//				}
//			} else {
//				if(!time[i].equals("1")) {
//					end = String.valueOf(Integer.valueOf(time[i]) + 1);
//					available.add(new String[] {start, end});
//				}
//			}
//		}
//		
//		if(available.size() == 0) {
//			System.out.println("Not available");
//		} else {
//			System.out.println(available.size() + " available:");
//		}
//		
//		for(int i = 0; i < available.size(); i++) {
//			System.out.println(available.get(i)[0] + "-" + available.get(i)[1]);
//		}
//	}
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(reader.readLine());
//		
//		int N = Integer.valueOf(st.nextToken());
//		int M = Integer.valueOf(st.nextToken());
//		
//		String[] meetingRoom = new String[N];
//		ArrayList<String[]> reserve = new ArrayList<>();
//		
//		for(int i = 0; i < N; i++) {
//			String[] time = {"09", "10", "11", "12", "13", "14", "15", "16", "17"};
//			
//			st = new StringTokenizer(reader.readLine());
//			meetingRoom[i] = st.nextToken();
//			
//			current.put(meetingRoom[i], time);
//		}
//		
//		for(int i = 0; i < M; i++) {
//			st = new StringTokenizer(reader.readLine());
//			reserve.add(new String[] {st.nextToken(), st.nextToken(), st.nextToken()});
//			
//			String room = reserve.get(i)[0];
//			int start = Integer.valueOf(reserve.get(i)[1]);
//			int end = Integer.valueOf(reserve.get(i)[2]);
//			
//			reserve(room, start, end);
//		}
//		
//		ArrayList<String> keyList = new ArrayList<>(current.keySet());
//		keyList.sort((s1, s2) -> s1.compareTo(s2));
//		
//		for(int i = 0; i < keyList.size(); i++) {
//			System.out.println("Room " + keyList.get(i) + ":");
//			
//			result(current.get(keyList.get(i)));
//			
//			if(i < keyList.size() - 1) {
//				System.out.println("-----");
//			}
//		}
//	}

}