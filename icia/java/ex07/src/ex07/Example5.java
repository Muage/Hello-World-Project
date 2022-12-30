package ex07;

import java.util.*;

public class Example5 {
	public static void execute() {
	
		Scanner s = new Scanner(System.in);
		ArrayList<Address> array = new ArrayList<>();
		
		boolean run = true;
		
		int no = 10;
		
		Address a = new Address();
		a.setNo(no);
		a.setName("홍길동");
		a.setTel("010-0000-1111");
		a.setJuso("인천 서구 경서동");
		array.add(a);
		
		no++;
		a = new Address();
		a.setNo(no);
		a.setName("심청이");
		a.setTel("010-2222-3333");
		a.setJuso("서울 강남구 압구정동");
		array.add(a);
		
		while(run == true) {
			System.out.println("----------------------------------------------------");
			System.out.println("1. 등록 | 2. 검색 | 3. 수정 | 4. 삭제 | 5. 목록 | 0. 종료");
			System.out.println("----------------------------------------------------");
			System.out.print("선택 > ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("프로그램을 종료합니다.");
				
				break;
				
			case 1:
				no++;
				a = new Address();	//새로운 주소 객체 생성
				System.out.print("번호 : " + no);
				a.setNo(no);
				
				System.out.print("이름 : ");
				a.setName(s.nextLine());
				
				System.out.print("전화 : ");
				a.setTel(s.nextLine());
				
				System.out.print("주소 : ");
				a.setJuso(s.nextLine());
				
				array.add(a);	//ArrayList에 주소 객체 등록
				System.out.println("현재 등록된 인원은 총 " + array.size() + "명 입니다.\n");
				
				break;
				
			case 2:
				boolean find = false;
				
				System.out.print("검색할 번호 : ");
				int sno = s.nextInt(); s.nextLine();
				
				for(Address ad:array) {
					if(sno == ad.getNo()) {
						
						find = true;
						
						System.out.println("이름 : " + ad.getName());
						System.out.println("전화 : " + ad.getTel());
						System.out.println("주소 : " + ad.getJuso());
					}
				}
				if(find == false) {
					System.out.println(sno + "번에 해당하는 학생이 없습니다.\n");
				}
				
				break;
				
			case 3:
				System.out.print("수정할 번호 : ");
				int uno = s.nextInt(); s.nextLine();
				
				find = false;
				
				for(Address ad:array) {
					if(uno == ad.getNo()) {
						find = true;
						System.out.print("변경 전 이름 : " + ad.getName() + " > 변경할 이름 : ");
						String name = s.nextLine();
						
						System.out.print("변경 전 전화 : " + ad.getTel() + " > 변경할 전화 : ");
						String tel = s.nextLine();
						
						System.out.print("변경 전 주소 : " + ad.getJuso() + " > 변경할 주소 : ");
						String juso = s.nextLine();
						
						System.out.print(uno + "번 " + ad.getName() + " 학생의 정보를 수정하시겠습니까? (예 : Y, 아니요 : N)\n");
						String sel = s.nextLine();
						if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
							
							if(!name.equals("")) ad.setName(name);
							if(!tel.equals("")) ad.setName(tel);
							if(!juso.equals("")) ad.setName(juso);
							
							System.out.println(uno + "번 학생의 정보가 수정되었습니다.\n");
							break;
						} else {
							System.out.println("메뉴를 다시 선택해주세요.\n");
						}
					}
				}
				if(find == false) {
					System.out.println(uno + "번에 해당하는 학생이 없습니다.\n");
				}
				
				break;
				
			case 4:
				System.out.print("삭제할 번호 : ");
				int dno = s.nextInt(); s.nextLine();
				
				find = false;
				
				for(Address ad:array) {
					if(dno == ad.getNo()) {
						find = true;
						System.out.println("이름 : " + ad.getName());
						System.out.println("전화 : " + ad.getTel());
						System.out.println("주소 : " + ad.getJuso());
						
						System.out.print(dno + "번 " + ad.getName() + " 학생의 정보를 삭제하시겠습니까? (예 : Y, 아니요 : N)\n");
						String sel = s.nextLine();
						if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
							array.remove(ad);
							System.out.println(dno + "번 " + ad.getName() + " 학생의 정보가 삭제되었습니다.\n");
							break;
						} else {
							System.out.println("메뉴를 다시 선택해주세요.\n");
						}
					}
				}
				if(find == false) {
					System.out.println(dno + "번에 해당하는 학생이 없습니다.\n");
				}
				
				break;
				
			case 5:
				for(Address ad:array) {
					System.out.printf("%d\t%s\t%s\t%s\n", ad.getNo(), ad.getName(), ad.getTel(), ad.getJuso());
				}
				
				break;
				
			default:
				System.out.println("0~3번 메뉴를 선택하세요.");
			}	
		}
	}
}