package fourthCommit;

import java.io.*;
import java.util.*;

public class StudentDAO {
	File file = new File("C:/Data/java/ex13/student.txt");
	StudentVO studentVO  = new StudentVO();
	ArrayList<StudentVO> array = new ArrayList<>();
	
	//마지막 학번 가져오기
	public int getLastNo() {
		int no = 0;
		BufferedReader reader;
		String line = "";
		StringTokenizer st;
		
		try {	//실행할 코드
			reader = new BufferedReader(new FileReader(file));	//파일 내용을 입력 받아 reader에 저장
			
			while((line = reader.readLine()) != null) {	//reader에 저장된 내용을 한 줄 읽어 line에 대입했을 때 null이 아닌 동안 반복
				st = new StringTokenizer(line, "|");	//line에 담긴 내용을 "|" 기준으로 나누어 인식 
				no = Integer.parseInt(st.nextToken());	//st로 나눈 내용 no에 저장
			}
		} catch(Exception e) {	//try에서 예외가 발생시 실행될 코드
			System.out.println("마지막 번호를 확인해주세요." + e.toString());
		}
		return no;	//int 타입 반환
	}
	
	//학생 입력
	public void insert(StudentVO vo) {
		try{	//실행할 코드
			FileWriter writer = new FileWriter(file, true);	//file에 이어쓰도록 true 지정
			
			writer.write(vo.getNo() + "|" + vo.getName() + "|" + vo.getAddress() + "\n");	//file에 저장할 형식 지정
			writer.flush();	//버퍼 내용을 지워줌
			writer.close();
			
		} catch(Exception e) {	//try에서 예외가 발생시 실행될 코드
			System.out.println("학생 입력을 확인해주세요." + e.toString());
		}
	}
	
	//학생 조회
	public StudentVO read(int no) {
		BufferedReader reader;
		String line = "";
		StringTokenizer st;
		try {	//실행할 코드
			reader = new BufferedReader(new FileReader(file));	//파일 내용을 입력 받아 reader에 저장
			line = "";
			
			while((line = reader.readLine()) != null) {	//reader에 저장된 내용을 한 줄 읽어 line에 대입했을 때 null이 아닌 동안 반복
				st = new StringTokenizer(line, "|");	//line에 담긴 내용을 "|" 기준으로 나누어 인식 
				int lineNo = Integer.parseInt(st.nextToken());	//st로 나눈 내용 lineNo에 저장
				if(no == lineNo) {	//만약 no와 lineNo의 값이 같으면 실행할 코드 (int 형이라서 .equals 안써도 됨)
					studentVO.setNo(lineNo);
					studentVO.setName(st.nextToken());
					studentVO.setAddress(st.nextToken());
					
					break;
				}
			}
		} catch(Exception e) {	//try에서 예외가 발생시 실행될 코드
			System.out.println("학생 조회를 확인해주세요." + e.toString());
		}
		return studentVO;
	}
	
	//학생 목록
	public ArrayList<StudentVO> list(){
		BufferedReader reader;
		String line = "";
		StringTokenizer st;
		StudentVO vo;
		try {
			reader = new BufferedReader(new FileReader(file));	//파일 내용을 입력 받아 reader에 저장
			line = "";
			
			while((line = reader.readLine()) != null) {	//reader에 저장된 내용을 한 줄 읽어 line에 대입했을 때 null이 아닌 동안 반복
				st = new StringTokenizer(line, "|");	//line에 담긴 내용을 "|" 기준으로 나누어 인식 
				vo = new StudentVO();
				
				vo.setNo(Integer.parseInt(st.nextToken()));		//st로 나눈 내용 각 vo.set 에 세팅
				vo.setName(st.nextToken());
				vo.setAddress(st.nextToken());
				
				array.add(vo);	//세팅된 vo array에 추가
			}
		} catch(Exception e) {
			System.out.println("학생 목록을 확인해주세요." + e.toString());
		}
		
		return array;
	}
	
}
