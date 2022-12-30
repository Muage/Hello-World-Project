package student;

import java.util.*;

public class Example1 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		StudentDAO dao = new StudentDAOImpl();
		StudentVO vo = null;
		boolean run = true;
		
		while(run) {
			System.out.println("\n***************** 학 생 관 리 *****************");
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
				int newCode = dao.getCode() + 100;
				System.out.println("번호 : " + newCode);
				vo = new StudentVO();
				vo.setNo(newCode);
				System.out.print("이름 : ");
				vo.setName(s.nextLine());
				
				System.out.print("전화 : ");
				vo.setTel(s.nextLine());
				
				System.out.print("주소 : ");
				vo.setAddress(s.nextLine());
				
				dao.insert(vo);
				System.out.println(newCode + "번 학생이 등록되었습니다.\n");
				
				break;
				
			case 2:
				ArrayList<StudentVO> array = dao.list();
				for(StudentVO v : array) {
					System.out.printf("%d\t%s\t%s\t%s\n", v.getNo(), v.getName(), v.getTel(), v.getAddress());
				}
				System.out.printf("\n현재 등록된 학생은 %d명 입니다.\n\n", array.size());
				
				break;
				
			case 3:
				System.out.print("검색할 번호를 입력해주세요. : ");
				int sno = s.nextInt(); s.nextLine();
				
				vo = dao.read(sno);
				
				if(vo.getName() == null) {
					System.out.println("입력하신 번호로 등록된 학생이 없습니다.\n");
				} else {
					System.out.println(vo.toString());
				}
				
				break;
				
			case 4:
				System.out.print("수정할 번호를 입력해주세요. : ");
				int uno = s.nextInt(); s.nextLine();

				vo = dao.read(uno);
				String oldName = vo.getName();
				
				if(vo.getName() == null) {
					System.out.println("입력하신 번호로 등록된 학생이 없습니다.\n");
				} else {
					StudentVO v = new StudentVO();
					v.setNo(uno);
					
					System.out.print(vo.getName() + " > ");
					String name = s.nextLine();
					
					System.out.print(vo.getTel() + " > ");
					String tel = s.nextLine();
					
					System.out.print(vo.getAddress() + " > ");
					String address = s.nextLine();
					
					if(!name.equals("")) vo.setName(name);
					if(!tel.equals("")) vo.setTel(tel);
					if(!address.equals("")) vo.setAddress(address);
					
					dao.update(vo);
					System.out.printf("%d번 %s의 정보가 수정되었습니다.\n\n", uno, oldName);
				}
				
				break;
				
			case 5:
				System.out.print("삭제할 번호를 입력해주세요. : ");
				int dno = s.nextInt(); s.nextLine();
				
				vo = dao.read(dno);
				
				if(vo.getName() == null) {
					System.out.println("입력하신 번호로 등록된 학생이 없습니다.\n");
				} else {
					dao.delete(dno);
					System.out.printf("%d번 %s 학생이 삭제되었습니다.\n\n", dno, vo.getName());
				}
				
				break;
				
			default:
				System.out.println("0~5번 중 선택해주세요.\n");
			}
		}
	}
}
