package sale;

import java.io.FileWriter;
import java.util.*;

public class Example2 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		SaleDAO dao = new SaleDAO();
		SaleVO vo = null;
		
		boolean run = true;
		
		while(run) {
			System.out.println("\n***************** 매 출 관 리 *****************");
			System.out.println("---------------------------------------------");
			System.out.println("1.등록 | 2.목록 | 3.검색 | 4.수정 | 5.삭제 | 0.종료");
			System.out.println("---------------------------------------------");
			
			System.out.print("원하시는 업무를 선택해주세요. > ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("프로그램을 종료합니다.\n");
				
				break;
				
			case 1:
				int newNo = dao.getNo() + 100;
				System.out.println("상품 번호 : " + newNo);
				vo = new SaleVO();
				vo.setNo(newNo);
				System.out.print("상품명을 입력해주세요. : ");
				vo.setName(s.nextLine());
				
				System.out.print("상품 단가를 입력해주세요. : ");
				vo.setPrice(s.nextInt()); s.nextLine();
				
				System.out.print("판매 수량을 입력해주세요. : ");
				vo.setQnt(s.nextInt()); s.nextLine();
				
				dao.insert(vo);
				System.out.printf("%d번 상품이 등록되었습니다.\n", newNo);
				
				break;
				
			case 2:
				for(SaleVO v : dao.list()) {
					System.out.println(v.toString());
				}
				
				break;
				
			case 3:
				String no = "";
				boolean isNumber = false;
				do {
					System.out.print("검색할 번호를 입력해주세요. : ");
					no = s.nextLine();
					isNumber = no.matches("-?\\d+(\\.\\d+)?");	//정규식
					if(!isNumber) System.out.println("숫자로 입력하세요.");
				} while(isNumber == false);
				
				vo = dao.read(Integer.parseInt(no));
				
				if(vo.getName() == null) {
					System.out.println("입력하신 번호로 등록된 상품이 없습니다.\n");
				} else {
					System.out.println(vo.toString());
				}
				
				break;
				
			case 4:
				no = "";
				isNumber = false;
				do {
					System.out.print("수정할 번호를 입력해주세요. : ");
					no = s.nextLine();
					isNumber = no.matches("-?\\d+(\\.\\d+)?");	//정규식
					if(!isNumber) System.out.println("숫자로 입력하세요.");
				} while(isNumber == false);
				
				vo = dao.read(Integer.parseInt(no));
				
				if(vo.getName() == null) {
					System.out.println("입력하신 번호로 등록된 상품이 없습니다.\n");
				} else {
					System.out.print("상품명 : " + vo.getName() + " > ");
					String name = s.nextLine();
					
					System.out.print("상품단가 : " + vo.getPrice() + " > ");
					String price = s.nextLine();
					
					System.out.print("판매수량 : " + vo.getQnt() + " > ");
					String qnt = s.nextLine();
					
					System.out.printf("상품번호 %s번의 정보를 수정하시겠습니까? ( 예 : Y , 아니요 : N) > ", no);
					String sel = s.nextLine();
					if (sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
						if(!name.equals("")) vo.setName(name);
						if(!price.equals("")) vo.setPrice(Integer.parseInt(price));
						if(!qnt.equals("")) vo.setQnt(Integer.parseInt(qnt));
						
						dao.update(vo);
						System.out.printf("상품번호 %s번의 정보가 수정되었습니다.\n", no);
					}
					break;
				}
				
				break;
				
			case 5:
				System.out.print("삭제할 번호를 입력해주세요. : ");
				int dno = s.nextInt(); s.nextLine();
				
				vo = dao.read(dno);
				
				if(vo.getName() == null) {
					System.out.println("입력하신 번호로 등록된 상품이 없습니다.\n");
				} else {
					dao.delete(dno);
					System.out.printf("%d번 %s 상품이 삭제되었습니다.\n", dno, vo.getName());
				}
				
				break;
				
			default:
				System.out.println("0~5번 중 선택해주세요.\n");
			}
		}
	}
}
