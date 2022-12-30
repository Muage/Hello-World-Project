package ex06;

import java.util.*;

public class Example4 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		ArrayList<Product> products = new ArrayList<>();
		
		Product p1 = new Product("냉장고", 7500, 150);
		products.add(p1);
		
		Product p2 = new Product("세탁기", 4000, 70);
		products.add(p2);
		
		Product p3 = new Product("에어컨", 5000, 100);
		products.add(p3);
		
		boolean run = true;
		
		System.out.println("******************** 상 품 관 리 ********************");
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
				
				System.out.print("등록할 상품의 이름 : ");
				String name = s.nextLine();
				
				boolean find = false;
				
				for(Product p:products) {
					if(name.equals(p.name)) {
						find = true;
						System.out.println("같은 이름으로 등록된 상품이 있습니다.");
						System.out.println("계속 등록하시겠습니까? ( 예 : Y, 아니요 : N)");
						String sel = s.nextLine();
						
						if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ") ) {
							find = false;
						}
					}
				}
				if(find == false) {
				
					System.out.print("상품 단가 : ");
					int price = s.nextInt(); s.nextLine();
					
					System.out.print("판매 수량 : ");
					int qnt = s.nextInt(); s.nextLine();
					
					Product product2 = new Product(name, price, qnt);
					products.add(product2);
					
					System.out.println("현재 총 " + products.size() + "개의 상품이 등록되어 있습니다.\n");
				}
				
				break;
				
			case 2:
				System.out.print("검색할 상품의 이름 : ");
				String sname = s.nextLine();
				
				find = false;
				
				for(Product p:products) {
					if(sname.equals(p.name)) {
						find = true;
						p.print();
					}
				}
				if(find == false) {
					System.out.println(sname + "에 대한 검색결과가 없습니다.\n");
				}
				
				break;
				
			case 3:
				for(Product p:products) {
					p.printList();
					System.out.println("---------------------------------------------------");
				}
				
				break;
				
			case 4:
				System.out.print("삭제할 상품의 이름 : ");
				String dname = s.nextLine();
				
				find = false;
				
				for(Product p:products) {
					if(dname.equals(p.name)) {
						find = true;
						p.print();
						
						System.out.println(dname + "의 정보를 삭제하시겠습니까? (예 : Y)");
						String sel = s.nextLine();
						
						if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ") ) {
							products.remove(p);
							System.out.println(dname + "의 정보가 삭제되었습니다.\n");
							break;
						}
					}
				}
				if(find == false) {
					System.out.println(dname + "에 대한 검색결과가 없습니다.\n");
				}
				
				break;
				
			case 5:
				System.out.print("수정할 상품의 이름 : ");
				String uname = s.nextLine();
				
				find = false;
				
				for(Product p:products) {
					if(uname.equals(p.name)) {
						find = true;
						
						System.out.print("변경 전 상품 이름 : " + p.name + " > 변경 후 상품 이름 : ");
						String nname = s.nextLine();
						
						System.out.print("변경 전 상품 단가 : " + p.price + " > 변경 후 상품 단가 : ");
						String nprice = s.nextLine();
						
						System.out.print("변경 전 상품 수량 : " + p.qnt + " > 변경 후 상품 수량 : ");
						String nqnt = s.nextLine();
						
						
						System.out.println(uname + "의 정보를 수정하시겠습니까? (예 : Y)");
						String sel = s.nextLine();
						
						if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
							if(!nname.equals("")) p.name = nname;
							if(!nprice.equals("")) p.price = Integer.parseInt(nprice);
							if(!nqnt.equals("")) p.qnt = Integer.parseInt(nqnt);
							
							p.print();
							System.out.println(nname + "의 정보가 수정되었습니다.\n");
							break;
						}
					}
				}
				if(find == false) {
					System.out.println(uname + "에 대한 검색결과가 없습니다.\n");
				}
				
				break;
				
			default:
				System.out.println("0~5번 메뉴를 선택해주세요.\n");				
			}	
		}
	}
}
