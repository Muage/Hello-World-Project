package student;

import java.util.ArrayList;

public interface StudentDAO {
	//마지막 코드값 구하기
	public int getCode();
	
	//입력, 등록, Create
	public void insert(StudentVO vo);
	
	//검색, Read One
	public StudentVO read(int no);

	//삭제, Delete
	public void delete(int no);
	
	//수정, Update
	public void update(StudentVO vo);
	
	//목록, Read List
	public ArrayList<StudentVO> list();
}
