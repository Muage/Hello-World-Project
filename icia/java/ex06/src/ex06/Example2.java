package ex06;

import java.util.*;

public class Example2 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		
		boolean run = true;
		ArrayList<Car> cars = new ArrayList<>();

		Car car = new Car("기아", "K7", 250);
		cars.add(car);
		
		car = new Car("기아", "K5", 200);
		cars.add(car);
		
		while(run) {
			System.out.println("---------------------------------------------------");
			System.out.println("1. 등록 | 2. 검색 | 3. 목록 | 4. 삭제 | 5. 수정 | 0. 종료");
			System.out.println("---------------------------------------------------");
			System.out.print("선택 > ");
			int menu = s.nextInt(); s.nextLine();
			switch(menu) {
			case 0:
				run = false;
				System.out.println("프로그램을 종료합니다.\n");
				
				break;
				
			case 1:
				System.out.print("회사명 > ");
				String company = s.next(); s.nextLine();
				
				System.out.print("모델명 > ");
				String model = s.next(); s.nextLine();
				
				System.out.print("최대속도 > ");
				int maxSpeed = s.nextInt(); s.nextLine();
				
				car = new Car(company, model, maxSpeed);
				cars.add(car);
				System.out.println("현재 차량이 " + cars.size() + "대 등록되어 있습니다.\n");
				
				break;
				
			case 2:
				System.out.print("모델명 > ");
				String smodel = s.next(); s.nextLine();
				
				boolean find = false;
				
				for(Car c:cars) {
					if(smodel.equals(c.model)) {
						c.infoPrint();
						find = true;
					}
				}
				
				if(find == false) {
					System.out.println("등록된 차량이 아닙니다.\n");
				}
				
				break;
				
			case 3:
				for(Car c:cars) {
//				for(int i=0; i<cars.size(); i++) {
//					Car c = cars.get(i);
					System.out.println(c.company + "\t" + c.model + "\t" + c.maxSpeed);
				}
				
				break;
				
			case 4:
				System.out.print("삭제할 모델명 : ");
				String dmodel = s.next(); s.nextLine();
				
				find = false;

				for(Car c:cars) {
					if(dmodel.equals(c.model)) {
						find = true;
						c.infoPrint();
						
						System.out.println("삭제하시겠습니까?(Y)?");
						String sel = s.next(); s.nextLine();
						
						if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
							cars.remove(c);
							System.out.println("삭제가 완료되었습니다.");
							System.out.println("현재 차량이 " + cars.size() + "대 등록되어 있습니다.\n");
							break;
						}
					}
				}
				if(find == false) {
					System.out.println("등록된 차량이 아닙니다.\n");
				}
				
				break;
				
			case 5:
				System.out.print("수정할 모델명 : ");
				String umodel = s.next(); s.nextLine();
				
				find = false;

				for(Car c:cars) {
					if(umodel.equals(c.model)) {
						find = true;
						
						System.out.print(c.company + " > ");
						String ncompany = s.nextLine();
						
						System.out.print(c.model + " > ");
						String nmodel = s.nextLine();
						
						System.out.print(c.maxSpeed + " > ");
						String nmaxSpeed = s.nextLine();
						
						
						System.out.println("수정하시겠습니까?(Y)?");
						String sel = s.next(); s.nextLine();
						
						if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
							//if문 처리할 문장이 하나라서 {} 생략 가능
							if(!ncompany.equals("")) c.company = ncompany;
							
							if(!nmodel.equals("")) c.model = nmodel;
							
							if(!nmaxSpeed.equals("")) c.maxSpeed = Integer.parseInt(nmaxSpeed);
							
							System.out.println("");
							
							c.infoPrint();
							System.out.println("수정이 완료되었습니다.\n");
						}
						
						System.out.println("전체 차량 목록을 확인하시겠습니까?(Y)?");
						String yes = s.next(); s.nextLine();
						
						if(yes.equals("Y") || yes.equals("y") || yes.equals("ㅛ")) {
							System.out.println("회사\t모델\t최대속도");
							for(Car r:cars) {
								System.out.println(r.company + "\t" + r.model + "\t" + r.maxSpeed);
							}
						}
							break;
					}
				}
				if(find == false) {
					System.out.println("등록된 차량이 아닙니다.\n");
				}
				
				break;
			
			default:
				System.out.println("0~3번 메뉴를 선택하세요.\n");
			}
		}
	}
}
