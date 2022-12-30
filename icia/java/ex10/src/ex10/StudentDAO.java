package ex10;

import java.util.ArrayList;

public interface StudentDAO {	//Database Access Object(DAO) : �����Ϳ� �����ϱ� ���� ��ü
	//������ ��� ���
	public ArrayList<StudentVO> list();
	
	//������ ���(C)
	public void insert(StudentVO vo);
	
	//������ ����(U)
	public void update(StudentVO vo);
	
	//������ �˻�(R)
	public StudentVO read(int no);
	
	//������ ����(D)
	public void delete(int no);
	
}
