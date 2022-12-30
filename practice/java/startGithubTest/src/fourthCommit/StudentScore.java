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
		
		while(run) {	//����ڰ� ���α׷��� ���� ������ ������ �ݺ��ϱ� ���� �ݺ���
			System.out.println("\n[�������� ���α׷�]");	//�޴� ��� ���
			System.out.println("����������������������������������������������������������������������������������������������������������");
			System.out.println("�� 1.�л���� �� 2.�л���ȸ �� 3.�л���� �� 4.������� �� 0.���� ��");
			System.out.println("����������������������������������������������������������������������������������������������������������");
			
			System.out.print("���Ͻô� ������ �������ּ���. > ");	//�޴� ��� ����
			switchMenu = scanner.nextLine();
			
			switch(switchMenu) {	//�޴� ���ÿ� ���� �����ϱ� ���� ���ǹ�
			case "0":
				run = false;	//while �ݺ��� ����
				System.out.println("���α׷��� �����մϴ�.");
				
				break;
				
			case "1":
				newNo = studentDAO.getLastNo() + 100;	//����� ������ ������ �л��� ���� �й����� �ڵ� ����
				System.out.println("�й�: " + newNo);
				
				studentVO = new StudentVO();
				studentVO.setNo(newNo);	//�ڵ� ������ �й����� ���� ��
				
				System.out.print("�̸��� �Է����ּ���. : ");
				studentVO.setName(scanner.nextLine());	//�̸� �Է�
				
				System.out.print("�ּҸ� �Է����ּ���. : ");
				studentVO.setAddress(scanner.nextLine());	//�ּ� �Է�
				
				studentDAO.insert(studentVO);	//���� �� StudentVO�� ������ studentDAO�� insert�޼ҵ� ����
				System.out.printf("\n%d�� %s �л��� ��ϵǾ����ϴ�.\n", newNo, studentVO.getName());
				
				break;
				
			case "2":
				sno = "";
				isNumber = false;
				
				do {	//do �ڵ带 �� ���� ������ ������ �� �ֵ��� do while�� ���
					System.out.print("������ ��ȸ�� �й��� �Է����ּ���. : ");
					sno = scanner.nextLine();	//sno �Է�
					isNumber = sno.matches("-?\\d+(\\.\\d+)?");	//sno ���Խ�(�������� �ƴ���) ��
					if(!isNumber) System.out.println("���� ��ȸ�� �й��� ���ڷ� �Է����ּ���.\n");	//���� isNumber�� false�� ����Ʈ
				} while(isNumber == false);	//isNumber�� false�� ���� do �ڵ� �ݺ�
				
				studentVO = studentDAO.read(Integer.parseInt(sno));	//String sno�� int�� ����ȯ �� ������ StudentDAO�� read �޼ҵ� ����
				
				if(studentVO.getName() == null) {	//���� StudentVO���� ������ �̸� ���� null�̸� ������ �ڵ�
					System.out.println("�Է��Ͻ� �й����� ��ϵ� �л��� �����ϴ�.");
					System.out.println("������ ����Ͻ÷��� �޴����� 4���� �������ּ���.");
				} else {	//���� StudentVO���� ������ �̸� ���� null�� �ƴϸ� ������ �ڵ�
					System.out.printf("�̸�: %s(%s)\n", studentVO.getName(), studentVO.getAddress());	//�л� ���� ���
					
					//���� ��� ���
					scoreVO = scoreDAO.read(Integer.parseInt(sno));	//String sno�� int�� ����ȯ �� ������ ScoreDAO�� read �޼ҵ� ����
					
					if(scoreVO.getType() != null) {	//���� ScoreVO���� ������ Ÿ�� ���� null�� �ƴϸ� ������ �ڵ�
						System.out.println("����������������������������������������������������������������������������������������������");
						System.out.println("������\t������\t������\t������\t������\t�����  ��");
						System.out.println("����������������������������������������������������������������������������������������������");
						ArrayList<ScoreVO> tarray = scoreDAO.list(Integer.parseInt(sno));	//String sno�� int�� ����ȯ �� ������ ScoreDAO�� list �޼ҵ� ������ ���� tarray�� �߰�
						for(ScoreVO v : tarray) {	//tarray�� ���� �ϳ��� ScoreVO Ÿ���� v�� ����
							v.print();	//ScoreVO�� print �޼ҵ� ����
						}
						System.out.println("����������������������������������������������������������������������������������������������");
					} else {	//���� ScoreVO���� ������ Ÿ�� ���� null�̸� ������ �ڵ�
						System.out.printf("%s �л��� ��ϵ� ������ �����ϴ�.\n", studentVO.getName());
					}
				}
					
				break;
				
			case "3":
				System.out.println("");
				
				ArrayList<StudentVO> array = studentDAO.list();	//StudentDAO�� list �޼ҵ� ������ ���� array�� �߰�
				for(StudentVO v : array) {	//array�� ���� �ϳ��� StudentVO Ÿ���� v�� ����
					System.out.printf("�й�: %s\t�̸�: %s\t�ּ�: %s\n", v.getNo(), v.getName(), v.getAddress());
				}
					System.out.println("����������������������������������������������������������������������������������������������������������");
					System.out.printf("���� ��ϵ� �л��� �� %d�� �Դϴ�.\n", array.size());
				
				break;
				
			case "4":
				no = "";
				isNumber = false;
				do {	//do �ڵ带 �� ���� ������ ������ �� �ֵ��� do while�� ���
					System.out.print("������ ����� �й��� �Է����ּ���. : ");
					no = scanner.nextLine();
					isNumber = no.matches("-?\\d+(\\.\\d+)?");	//no ���Խ�(�������� �ƴ���) ��
					
					if(!isNumber) System.out.println("���� ����� �й��� ���ڷ� �Է����ּ���.\n");	//���� isNumber�� false�� ����Ʈ
				} while(isNumber == false);	//isNumber�� false�� ���� do �ڵ� �ݺ�
				
				//�л� ���� �б�
				studentVO = studentDAO.read(Integer.parseInt(no));	//String no�� int�� ����ȯ �� ������ StudentDAO�� read �޼ҵ� ����
				if(studentVO.getName() == null) {	//���� StudentVO���� ������ �̸� ���� null�̸� ������ �ڵ�
					System.out.println("�Է��Ͻ� �й����� ��ϵ� �л��� �����ϴ�.");
				} else {	//���� StudentVO���� ������ �̸� ���� null�� �ƴϸ� ������ �ڵ�
					//�л� ���� ���
					System.out.printf("�̸�: %s(%s)\n", studentVO.getName(), studentVO.getAddress());
					
					//���� ��� ���
					scoreVO = scoreDAO.read(Integer.parseInt(no));	//String no�� int�� ����ȯ �� ������ ScoreDAO�� read �޼ҵ� ����
					if(scoreVO.getType() == null) {	//���� ScoreVO���� ������ Ÿ�� ���� null�̸� ������ �ڵ�
						System.out.printf("%s �л��� ��ϵ� ������ �����ϴ�.\n", studentVO.getName());
						
						//��ϵ� ������ ���� �� ������ ����� ������
						System.out.printf("%s �л��� ������ ����Ͻðڽ��ϱ�? ( �� : Y , �ƴϿ� : N) > ", studentVO.getName());
						sel = scanner.nextLine();
						
						if (sel.equals("Y") || sel.equals("y") || sel.equals("��")) {	//���� sel���� ���� �Է��� yŰ �� �������� Ȯ��
							System.out.println("");
							System.out.print("����(�߰�/�⸻/����)�� �Է����ּ���. : ");
							type = scanner.nextLine();
							
							//���� �Է��� �ƴϸ� �ٽ� �Է��� �� �ֵ��� do-while�� ���
							isNumber = false;
							do {
								System.out.print("���� ������ �Է����ּ���. : ");
								kor = scanner.nextLine();
								isNumber = kor.matches("-?\\d+(\\.\\d+)?");
								
								if(!isNumber) System.out.println("���� ������ ���ڷ� �Է����ּ���.\n");
							} while(isNumber == false);
							
							isNumber = false;
							do {
								System.out.print("���� ������ �Է����ּ���. : ");
								eng = scanner.nextLine();
								isNumber = eng.matches("-?\\d+(\\.\\d+)?");
								
								if(!isNumber) System.out.println("���� ������ ���ڷ� �Է����ּ���.\n");
							} while(isNumber == false);
							
							isNumber = false;
							do {
								System.out.print("���� ������ �Է����ּ���. : ");
								mat = scanner.nextLine();
								isNumber = mat.matches("-?\\d+(\\.\\d+)?");
								
								if(!isNumber) System.out.println("���� ������ ���ڷ� �Է����ּ���.\n");
							} while(isNumber == false);
							
							//VO�� �Էµ� �� ����
							scoreVO = new ScoreVO();
							scoreVO.setNo(Integer.parseInt(no));
							scoreVO.setType(type);
							scoreVO.setKor(Integer.parseInt(kor));
							scoreVO.setEng(Integer.parseInt(eng));
							scoreVO.setMat(Integer.parseInt(mat));
							
							//���õ� �� file�� �߰� �� ���
							scoreDAO.insert(scoreVO);
							System.out.printf("%s �л��� %s ������ ��ϵǾ����ϴ�.\n", studentVO.getName() , type);
							
							break;
						}
					} else {	//���� ScoreVO���� ������ Ÿ�� ���� null�� �ƴϸ� ������ �ڵ�
						System.out.println("����������������������������������������������������������������������������������������������");
						System.out.println("������\t������\t������\t������\t������\t�����  ��");
						System.out.println("����������������������������������������������������������������������������������������������");
						ArrayList<ScoreVO> tarray = scoreDAO.list(Integer.parseInt(no));	//������ �ԷµǾ� �ִ� ���� ��� ���
						for(ScoreVO v : tarray) {
							v.print();
						}
						System.out.println("����������������������������������������������������������������������������������������������");
					}
				
					//���ο� ���� ���
					//���� �Է�
					System.out.print("����(�߰�/�⸻/����)�� �Է����ּ���. : ");
					type = scanner.nextLine();
					
					//���� ����
					
					isNumber = false;
					do {
						System.out.print("���� ������ �Է����ּ���. : ");
						kor = scanner.nextLine();
						isNumber = kor.matches("-?\\d+(\\.\\d+)?");
						
						if(!isNumber) System.out.println("���� ������ ���ڷ� �Է����ּ���.\n");
					} while(isNumber == false);
					
					//���� ����
					
					isNumber = false;
					do {
						System.out.print("���� ������ �Է����ּ���. : ");
						eng = scanner.nextLine();
						isNumber = eng.matches("-?\\d+(\\.\\d+)?");
						
						if(!isNumber) System.out.println("���� ������ ���ڷ� �Է����ּ���.\n");
					} while(isNumber == false);
					
					//���� ����
					
					isNumber = false;
					do {
						System.out.print("���� ������ �Է����ּ���. : ");
						mat = scanner.nextLine();
						isNumber = mat.matches("-?\\d+(\\.\\d+)?");
						
						if(!isNumber) System.out.println("���� ������ ���ڷ� �Է����ּ���.\n");
					} while(isNumber == false);
					
					scoreVO = new ScoreVO();
					scoreVO.setNo(Integer.parseInt(no));
					scoreVO.setType(type);
					scoreVO.setKor(Integer.parseInt(kor));
					scoreVO.setEng(Integer.parseInt(eng));
					scoreVO.setMat(Integer.parseInt(mat));
					
					scoreDAO.insert(scoreVO);
					System.out.printf("%s �л��� %s ������ ��ϵǾ����ϴ�.\n", studentVO.getName() , type);
				}
				
				break;
				
			//�޴� ���ý� 0, 1, 2, 3, 4�� �ƴ� �ٸ� ���� �Էµ� �� ����� ����
			default:
				System.out.println("0~4�� �� �������ּ���.");
			}
		}
	}
}
