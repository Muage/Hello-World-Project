package ex09;

import java.io.*;
import java.util.*;

public class Example4 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		
		File file = new File("c://data/java/address.txt");
		
		boolean run = true;
		
		while(run == true) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1. 주소등록 | 2. 주소검색 | 3. 주소목록 | 4. 주소삭제 | 0. 종료");
			System.out.println("-----------------------------------------------------");
			System.out.print("선택 > ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("프로그램이 종료됩니다.\n");
				
				break;
				
			case 1:
				Address add = new Address();
				
				System.out.print("이름 : ");
				add.setName(s.nextLine());
				
				System.out.print("전화 : ");
				add.setTel(s.nextLine());
				
				System.out.print("주소 : ");
				add.setJuso(s.nextLine());
				
				try {
					FileWriter writer = new FileWriter(file, true);
					writer.write(add.getName() + " | " + add.getTel() + " | " + add.getJuso() + "\n");
					writer.flush();
					writer.close();
					System.out.println("주소가 등록되었습니다.\n");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				

				break;

			case 2:
				System.out.print("검색할 이름 : ");
				String sname = s.nextLine();
				
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line = "";
					boolean find = false;
					while((line = reader.readLine()) != null) {
						StringTokenizer st = new StringTokenizer(line, " | ");
						add = new Address();
						add.setName(st.nextToken());
						add.setTel(st.nextToken());
						add.setJuso(st.nextToken());

						if(sname.equals(add.getName())) {
							find = true;
							add.printList();
						}
					}
					if(find == false) {
						System.out.println("일치하는 정보가 없습니다.\n");
					}
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
				
			case 3:
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line = "";
					while((line = reader.readLine()) != null) {
						StringTokenizer st = new StringTokenizer(line, " | ");
						add = new Address();
						add.setName(st.nextToken());
						add.setTel(st.nextToken());
						add.setJuso(st.nextToken());
						add.printList();
					}
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
				
			case 4:
				System.out.print("삭제할 이름 : ");
				String dname = s.nextLine();
				
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					
					String line = "";
					String strLine = "";
					boolean find = false;
					
					while((line = reader.readLine()) != null) {
						StringTokenizer st = new StringTokenizer(line, " | ");
						add = new Address();
						add.setName(st.nextToken());
						add.setTel(st.nextToken());
						add.setJuso(st.nextToken());
						
						if(dname.equals(add.getName())) {	//삭제할 이름 같지 않을 때
							find = true;
						} else {
							//strLine = strLine + score.getName() + "|";
							strLine += add.getName() + "|";
							strLine += add.getTel() + "|";
							strLine += add.getJuso() + "\n";
						}
					}
					
					if(find == false) {
						System.out.println(dname + "의 주소가 존재하지 않습니다.");
					} else {
						System.out.print("삭제하시겠습니까? ( 예 : Y )");
						String sel = s.nextLine();
						if (sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
							FileWriter writer = new FileWriter(file, false);
							writer.write(strLine);
							writer.flush();
							writer.close();
							System.out.println(dname + "의 정보가 삭제되었습니다.");
						}
					}
				} catch(Exception e) {}

				break;
				
			default:

				System.out.println("0~3번 메뉴 중 선택하세요.\n");
				
			}
		}
	}
}
