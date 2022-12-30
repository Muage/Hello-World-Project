package ex10;

import java.util.ArrayList;

public interface StudentDAO {	//Database Access Object(DAO) : 데이터에 접근하기 위한 객체
	//데이터 목록 출력
	public ArrayList<StudentVO> list();
	
	//데이터 등록(C)
	public void insert(StudentVO vo);
	
	//데이터 수정(U)
	public void update(StudentVO vo);
	
	//데이터 검색(R)
	public StudentVO read(int no);
	
	//데이터 삭제(D)
	public void delete(int no);
	
}
