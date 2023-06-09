package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 문제 ( Lv2. 회의실 예약 )
// 회사에는 N개의 회의실이 있다.
// 수많은 팀이 모여 토론하고 업무를 처리하기 위해서는 회의실이 필수적이다.
// 내부망에 아주 간단한 회의실 예약 시스템이 있지만 편의성이 매우 떨어진다.
// 단순히 예약된 회의의 목록만 표시되기 때문에, 방 별로 비어 있는 시간이 언제인지를 확인하기가 힘든 것이다.
// 당신은 이를 직접 해결해 보기로 마음 먹었다.
// 회의실 이용 규칙은 다음과 같다:
// 	- 회의실은 9시부터 18시까지만 사용 가능하다. 모든 회의의 시간은 이 안에 완전히 포함되어야 한다.
// 	- 회의는 정확히 한 회의실을 연속한 일정 시간 동안만 점유한다. 즉 각 회의는 (회의실, 시작 시각, 종료 시각)의 정보로 나타낼 수 있다.
// 	- 회의의 시작과 종료 시각은 시(時, hour) 단위로만 설정 가능하다. 같은 회의실을 사용하는 회의 시간은 서로 겹칠 수 없다. 여기서 겹친다는 것은, 두 회의 모두에 포함되는 시간이 1시간 이상 존재한다는 것을 의미한다. 예를 들어, 10시-12시의 회의와 11시-13시의 회의는 겹치는데, 11시-12시의 시간이 두 회의 모두에 포함되기 때문이다.
// 	- 한 회의가 끝나는 시각에, 같은 회의실에서 다른 회의가 시작하는 것은 허용된다. 이 경우 두 회의가 겹치지 않기 때문이다.
// 	- 길이가 0인 회의, 즉 시작 시각과 종료 시각이 동일한 회의는 예약된 바 없으며, 새롭게 잡을 수도 없다.
// 이미 예약된 M개의 회의에 대한 정보가 주어지면, 회의실별로 비어 있는 시간대를 정리해 출력하는 프로그램을 작성해 보자.
// 구체적인 형식은 아래를 참고하시오.

// 제약조건
// 1 ≤ N ≤ 50
// 1 ≤ M ≤ 100
// 회의실의 이름은 영문 알파벳 소문자로만 이루어져 있으며 길이는 1 이상 10 이하이다.
// 주어지는 모든 시각은 9 이상 18 이하이다.
// 회의의 시작 시각은 회의의 종료 시각을 1시간 이상 앞선다.

// 입력형식
// 첫째 줄에 회의실의 수와 예약된 회의의 수를 나타내는 정수 N과 M이 공백을 사이에 두고 주어진다.
// 이어 N개의 줄에는 각 회의실의 이름이 주어진다.
// 이어 M개의 줄에는 각 회의가 배정된 회의실의 이름 r과 시작 시각 s, 그리고 종료 시각 t가 공백을 사이에 두고 주어진다.

// 출력형식
// 각 회의실에 대한 정보를 회의실 이름의 오름차순으로 출력한다.
// 각 회의실에 대한 정보는 다음과 같다.
// 첫째 줄에는 { Room 회의실이름: } (중괄호 제외)을 출력한다.
// 둘째 줄에는 예약가능 시간을 출력한다.
// 	- 예약 가능한 시간대의 개수를 n이라고 할 때, { n available: } (중괄호 제외)을 출력하고, 뒤따른 n개의 줄에 예약 가능한 시간대를 { 09-18 } (하이픈 한개, 중괄호 제외)형태로 출력해야 한다. 한 자리 수의 경우 앞에 0을 붙여 두 자리 수로 만들어야 함에 유의하라.
// 	- 예약 가능한 시간이 없다면, Not available을 출력한다.
// 각 회의실에 대한 정보 사이에는 ----- (하이픈 다섯 개)로 구분선이 출력되어야 한다.

// 입력예제1
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

// 출력예제1
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

// 입력예제2
// 3 2
// santafe
// aerocity
// porter
// santafe 9 12
// porter 9 18

// 출력예제2
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
	 * 방법 2. 득점: 100.0		실행시간: 76ms		메모리: 10.36Mb
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
//	 * 방법 1. 득점: 0.0		실행시간: 180ms		메모리: 14.85Mb
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