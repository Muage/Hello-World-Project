package ex10;

import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {

	@Override	//재정의
	public ArrayList<StudentVO> list() {
		ArrayList<StudentVO> array = new ArrayList();
		StudentVO vo = new StudentVO();
		
		vo.setNo(100);
		vo.setName("홍길동");
		vo.setTel("010-1111-2222");
		vo.setAddress("인천시 남동구 구월동");
		array.add(vo);
		
		vo = new StudentVO();
		vo.setNo(200);
		vo.setName("심청이");
		vo.setTel("010-3333-4444");
		vo.setAddress("서울시 양천구 목동");
		array.add(vo);
		
		vo = new StudentVO();
		vo.setNo(300);
		vo.setName("강감찬");
		vo.setTel("010-5555-6666");
		vo.setAddress("수원시 권선구 탑동");
		array.add(vo);
		
		return array;
	}

	@Override
	public StudentVO read(int no) {
		ArrayList<StudentVO> array = list();
		StudentVO vo = new StudentVO();
		
		for(StudentVO v : array) {
			if(no == v.getNo()) {
				vo.setNo(no);
				vo.setName(v.getName());
				vo.setTel(v.getTel());
				vo.setAddress(v.getAddress());
			}
		}
		return vo;
	}

	@Override
	public void insert(StudentVO vo) {
		ArrayList<StudentVO> array = list();
		array.add(vo);
		
		//입력 확인
		for(StudentVO v : array) {
			System.out.println(v.toString());
		}
	}

	@Override
	public void delete(int no) {
		ArrayList<StudentVO> array = list();
		for(StudentVO v : array) {
			if(no == v.getNo()) {
				array.remove(v);
				break;
			}
		}
		//삭제 확인
		for(StudentVO v : array) {
			System.out.println(v.toString());
		}
	}

	@Override
	public void update(StudentVO vo) {
		ArrayList<StudentVO> array = list();
		
		for(StudentVO v : array) {
			if(vo.getNo() == v.getNo()) {
				v.setName(vo.getName());
				v.setTel(vo.getTel());
				v.setAddress(vo.getAddress());
				break;
			}
		}
		//수정 확인
		for(StudentVO v : array) {
			System.out.println(v.toString());
		}
	}
}