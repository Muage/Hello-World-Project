package ex09;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Example5 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		File file = new File("C:/data/java/score.txt");
		
		boolean run = true;
		
		while(run == true) {
			System.out.println("-------------------------------------------");
			System.out.println("1.성적등록|2.성적검색|3.성적목록|4.성적삭제|0.종료");
			System.out.println("-------------------------------------------");
			System.out.print("선택 > ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("프로그램이 종료됩니다.\n");
				
				break;
				
			case 1:
				try {
					FileWriter writer = new FileWriter(file, true);
					
					Score score = new Score();
					
					System.out.print("이름 : ");
					score.setName(s.nextLine());
					
					System.out.print("국어 : ");
					score.setKor(s.nextInt()); s.nextLine();
					
					System.out.print("영어 : ");
					score.setEng(s.nextInt()); s.nextLine();
					
					System.out.print("수학 : ");
					score.setMat(s.nextInt()); s.nextLine();
					
					writer.write(score.getName() + "|" + score.getKor() + "|" + score.getEng() + "|" + score.getMat() + "\n");
					writer.flush();
					writer.close();
					
					System.out.println("성적이 등록되었습니다.");
					
				} catch (Exception e) {}
				
				break;
				
			case 2:
				System.out.print("검색할 이름 : ");
				String sname = s.nextLine();
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line = "";
					boolean find = false;
					while((line = reader.readLine()) != null) {
						StringTokenizer st = new StringTokenizer(line, "|");
						Score score = new Score();
						score.setName(st.nextToken());
						score.setKor(Integer.parseInt(st.nextToken()));
						score.setEng(Integer.parseInt(st.nextToken()));
						score.setMat(Integer.parseInt(st.nextToken()));
						if(sname.equals(score.getName())) {
							find = true;
							score.printList();
						}
					}
					if(find == false) {
						System.out.println("해당 학생의 성적이 없습니다.");
					}
				} catch(Exception e) {}
				
				break;
				
			case 3:
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line = "";
					while((line = reader.readLine()) != null) {
						StringTokenizer st = new StringTokenizer(line, "|");
						
						Score score = new Score();
						score.setName(st.nextToken());
						score.setKor(Integer.parseInt(st.nextToken()));
						score.setEng(Integer.parseInt(st.nextToken()));
						score.setMat(Integer.parseInt(st.nextToken()));						
						score.printList();
						
					}
				} catch(Exception e) {}
				
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
						StringTokenizer st = new StringTokenizer(line, "|");
						Score score = new Score();
						score.setName(st.nextToken());
						score.setKor(Integer.parseInt(st.nextToken()));
						score.setEng(Integer.parseInt(st.nextToken()));
						score.setMat(Integer.parseInt(st.nextToken()));		
						
						if(dname.equals(score.getName())) {	//삭제할 이름 같지 않을 때
							find = true;
						} else {
							//strLine = strLine + score.getName() + "|";
							strLine += score.getName() + "|";
							strLine += score.getKor() + "|";
							strLine += score.getEng() + "|";
							strLine += score.getMat() + "\n";
						}
					}
					if(find == false) {
						System.out.println(dname + "의 성적 정보가 존재하지 않습니다.");
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
