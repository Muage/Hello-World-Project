package fourthCommit;

import java.util.*;

public class StudentScore {
	public static void execute() {
		Scanner scanner = new Scanner(System.in);
		StudentVO studentVO = null;
		StudentDAO studentDAO = new StudentDAO();
		ScoreVO scoreVO = null;
		ScoreDAO scoreDAO = new ScoreDAO();
		String switchMenu;
		String sno;
		String no;
		String sel;
		String type;
		String kor;
		String eng;
		String mat;
		int newNo;
		boolean run = true;
		boolean isNumber;
		
		while(run) {	//사용자가 프로그램을 직접 종료할 때까지 반복하기 위한 반복문
			System.out.println("\n[성적관리 프로그램]");	//메뉴 목록 출력
			System.out.println("┌──────────┬──────────┬──────────┬──────────┬───────┐");
			System.out.println("│ 1.학생등록 │ 2.학생조회 │ 3.학생목록 │ 4.성적등록 │ 0.종료 │");
			System.out.println("└──────────┴──────────┴──────────┴──────────┴───────┘");
			
			System.out.print("원하시는 업무를 선택해주세요. > ");	//메뉴 목록 선택
			switchMenu = scanner.nextLine();
			
			switch(switchMenu) {	//메뉴 선택에 따라 실행하기 위한 조건문
			case "0":
				run = false;	//while 반복문 종료
				System.out.println("프로그램을 종료합니다.");
				
				break;
				
			case "1":
				newNo = studentDAO.getLastNo() + 100;	//등록할 때마다 마지막 학생의 다음 학번으로 자동 지정
				System.out.println("학번: " + newNo);
				
				studentVO = new StudentVO();
				studentVO.setNo(newNo);	//자동 지정된 학번으로 세팅 후
				
				System.out.print("이름을 입력해주세요. : ");
				studentVO.setName(scanner.nextLine());	//이름 입력
				
				System.out.print("주소를 입력해주세요. : ");
				studentVO.setAddress(scanner.nextLine());	//주소 입력
				
				studentDAO.insert(studentVO);	//세팅 된 StudentVO를 가지고 studentDAO의 insert메소드 실행
				System.out.printf("\n%d번 %s 학생이 등록되었습니다.\n", newNo, studentVO.getName());
				
				break;
				
			case "2":
				sno = "";
				isNumber = false;
				
				do {	//do 코드를 한 번은 무조건 실행할 수 있도록 do while문 사용
					System.out.print("성적을 조회할 학번을 입력해주세요. : ");
					sno = scanner.nextLine();	//sno 입력
					isNumber = sno.matches("-?\\d+(\\.\\d+)?");	//sno 정규식(숫자인지 아닌지) 비교
					if(!isNumber) System.out.println("성적 조회할 학번을 숫자로 입력해주세요.\n");	//만약 isNumber가 false면 프린트
				} while(isNumber == false);	//isNumber가 false인 동안 do 코드 반복
				
				studentVO = studentDAO.read(Integer.parseInt(sno));	//String sno를 int로 형변환 한 값으로 StudentDAO의 read 메소드 실행
				
				if(studentVO.getName() == null) {	//만약 StudentVO에서 가져온 이름 값이 null이면 실행할 코드
					System.out.println("입력하신 학번으로 등록된 학생이 없습니다.");
					System.out.println("성적을 등록하시려면 메뉴에서 4번을 선택해주세요.");
				} else {	//만약 StudentVO에서 가져온 이름 값이 null이 아니면 실행할 코드
					System.out.printf("이름: %s(%s)\n", studentVO.getName(), studentVO.getAddress());	//학생 정보 출력
					
					//성적 목록 출력
					scoreVO = scoreDAO.read(Integer.parseInt(sno));	//String sno를 int로 형변환 한 값으로 ScoreDAO의 read 메소드 실행
					
					if(scoreVO.getType() != null) {	//만약 ScoreVO에서 가져온 타입 값이 null이 아니면 실행할 코드
						System.out.println("┌───────┬───────┬───────┬───────┬───────┬─────┐");
						System.out.println("│구분\t│국어\t│영어\t│수학\t│총점\t│평균  │");
						System.out.println("├───────┼───────┼───────┼───────┼───────┼─────┤");
						ArrayList<ScoreVO> tarray = scoreDAO.list(Integer.parseInt(sno));	//String sno를 int로 형변환 한 값으로 ScoreDAO의 list 메소드 실행한 값을 tarray에 추가
						for(ScoreVO v : tarray) {	//tarray의 내용 하나씩 ScoreVO 타입인 v에 대입
							v.print();	//ScoreVO의 print 메소드 실행
						}
						System.out.println("└───────┴───────┴───────┴───────┴───────┴─────┘");
					} else {	//만약 ScoreVO에서 가져온 타입 값이 null이면 실행할 코드
						System.out.printf("%s 학생의 등록된 성적이 없습니다.\n", studentVO.getName());
					}
				}
					
				break;
				
			case "3":
				System.out.println("");
				
				ArrayList<StudentVO> array = studentDAO.list();	//StudentDAO의 list 메소드 실행한 값을 array에 추가
				for(StudentVO v : array) {	//array의 내용 하나씩 StudentVO 타입인 v에 대입
					System.out.printf("학번: %s\t이름: %s\t주소: %s\n", v.getNo(), v.getName(), v.getAddress());
				}
					System.out.println("─────────────────────────────────────────────────────");
					System.out.printf("현재 등록된 학생은 총 %d명 입니다.\n", array.size());
				
				break;
				
			case "4":
				no = "";
				isNumber = false;
				do {	//do 코드를 한 번은 무조건 실행할 수 있도록 do while문 사용
					System.out.print("성적을 등록할 학번을 입력해주세요. : ");
					no = scanner.nextLine();
					isNumber = no.matches("-?\\d+(\\.\\d+)?");	//no 정규식(숫자인지 아닌지) 비교
					
					if(!isNumber) System.out.println("성적 등록할 학번을 숫자로 입력해주세요.\n");	//만약 isNumber가 false면 프린트
				} while(isNumber == false);	//isNumber가 false인 동안 do 코드 반복
				
				//학생 정보 읽기
				studentVO = studentDAO.read(Integer.parseInt(no));	//String no를 int로 형변환 한 값으로 StudentDAO의 read 메소드 실행
				if(studentVO.getName() == null) {	//만약 StudentVO에서 가져온 이름 값이 null이면 실행할 코드
					System.out.println("입력하신 학번으로 등록된 학생이 없습니다.");
				} else {	//만약 StudentVO에서 가져온 이름 값이 null이 아니면 실행할 코드
					//학생 정보 출력
					System.out.printf("이름: %s(%s)\n", studentVO.getName(), studentVO.getAddress());
					
					//성적 목록 출력
					scoreVO = scoreDAO.read(Integer.parseInt(no));	//String no를 int로 형변환 한 값으로 ScoreDAO의 read 메소드 실행
					if(scoreVO.getType() == null) {	//만약 ScoreVO에서 가져온 타입 값이 null이면 실행할 코드
						System.out.printf("%s 학생의 등록된 성적이 없습니다.\n", studentVO.getName());
						
						//등록된 성적이 없을 때 성적을 등록할 것인지
						System.out.printf("%s 학생의 성적을 등록하시겠습니까? ( 예 : Y , 아니요 : N) > ", studentVO.getName());
						sel = scanner.nextLine();
						
						if (sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {	//만약 sel에서 받은 입력이 y키 와 동일한지 확인
							System.out.println("");
							System.out.print("구분(중간/기말/모의)을 입력해주세요. : ");
							type = scanner.nextLine();
							
							//숫자 입력이 아니면 다시 입력할 수 있도록 do-while문 사용
							isNumber = false;
							do {
								System.out.print("국어 점수를 입력해주세요. : ");
								kor = scanner.nextLine();
								isNumber = kor.matches("-?\\d+(\\.\\d+)?");
								
								if(!isNumber) System.out.println("국어 점수를 숫자로 입력해주세요.\n");
							} while(isNumber == false);
							
							isNumber = false;
							do {
								System.out.print("영어 점수를 입력해주세요. : ");
								eng = scanner.nextLine();
								isNumber = eng.matches("-?\\d+(\\.\\d+)?");
								
								if(!isNumber) System.out.println("영어 점수를 숫자로 입력해주세요.\n");
							} while(isNumber == false);
							
							isNumber = false;
							do {
								System.out.print("수학 점수를 입력해주세요. : ");
								mat = scanner.nextLine();
								isNumber = mat.matches("-?\\d+(\\.\\d+)?");
								
								if(!isNumber) System.out.println("수학 점수를 숫자로 입력해주세요.\n");
							} while(isNumber == false);
							
							//VO에 입력된 값 세팅
							scoreVO = new ScoreVO();
							scoreVO.setNo(Integer.parseInt(no));
							scoreVO.setType(type);
							scoreVO.setKor(Integer.parseInt(kor));
							scoreVO.setEng(Integer.parseInt(eng));
							scoreVO.setMat(Integer.parseInt(mat));
							
							//세팅된 값 file에 추가 및 출력
							scoreDAO.insert(scoreVO);
							System.out.printf("%s 학생의 %s 성적이 등록되었습니다.\n", studentVO.getName() , type);
							
							break;
						}
					} else {	//만약 ScoreVO에서 가져온 타입 값이 null이 아니면 실행할 코드
						System.out.println("┌───────┬───────┬───────┬───────┬───────┬─────┐");
						System.out.println("│구분\t│국어\t│영어\t│수학\t│총점\t│평균  │");
						System.out.println("├───────┼───────┼───────┼───────┼───────┼─────┤");
						ArrayList<ScoreVO> tarray = scoreDAO.list(Integer.parseInt(no));	//기존에 입력되어 있던 성적 목록 출력
						for(ScoreVO v : tarray) {
							v.print();
						}
						System.out.println("└───────┴───────┴───────┴───────┴───────┴─────┘");
					}
				
					//새로운 성적 등록
					//구분 입력
					System.out.print("구분(중간/기말/모의)을 입력해주세요. : ");
					type = scanner.nextLine();
					
					//국어 점수
					
					isNumber = false;
					do {
						System.out.print("국어 점수를 입력해주세요. : ");
						kor = scanner.nextLine();
						isNumber = kor.matches("-?\\d+(\\.\\d+)?");
						
						if(!isNumber) System.out.println("국어 점수를 숫자로 입력해주세요.\n");
					} while(isNumber == false);
					
					//영어 점수
					
					isNumber = false;
					do {
						System.out.print("영어 점수를 입력해주세요. : ");
						eng = scanner.nextLine();
						isNumber = eng.matches("-?\\d+(\\.\\d+)?");
						
						if(!isNumber) System.out.println("영어 점수를 숫자로 입력해주세요.\n");
					} while(isNumber == false);
					
					//수학 점수
					
					isNumber = false;
					do {
						System.out.print("수학 점수를 입력해주세요. : ");
						mat = scanner.nextLine();
						isNumber = mat.matches("-?\\d+(\\.\\d+)?");
						
						if(!isNumber) System.out.println("수학 점수를 숫자로 입력해주세요.\n");
					} while(isNumber == false);
					
					scoreVO = new ScoreVO();
					scoreVO.setNo(Integer.parseInt(no));
					scoreVO.setType(type);
					scoreVO.setKor(Integer.parseInt(kor));
					scoreVO.setEng(Integer.parseInt(eng));
					scoreVO.setMat(Integer.parseInt(mat));
					
					scoreDAO.insert(scoreVO);
					System.out.printf("%s 학생의 %s 성적이 등록되었습니다.\n", studentVO.getName() , type);
				}
				
				break;
				
			//메뉴 선택시 0, 1, 2, 3, 4가 아닌 다른 것이 입력될 때 출력할 내용
			default:
				System.out.println("0~4번 중 선택해주세요.");
			}
		}
	}
}
