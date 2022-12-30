package ex10;

import java.util.ArrayList;

public class Example1 {
	public static void execute() {
		//학생목록출력
		StudentDAO dao = new StudentDAOImpl();
//		ArrayList<StudentVO> array = dao.list();
//		System.out.println("전체학생수 : " + array.size());
//		for(StudentVO vo : array) {
//			System.out.println(vo.toString());
//		}
//		
//		//학생검색출력
//		StudentVO vo = dao.read(200);
//		System.out.println(vo.toString());
//		
//		//학생입력
//		StudentVO vo = new StudentVO();
//		vo.setNo(400);
//		vo.setName("성춘향");
//		vo.setTel("010-7777-8888");
//		vo.setAddress("서울시 마포구 성수동");
//		dao.insert(vo);
//		
//		dao.read(400);
//		
//		//학생삭제
//		dao.delete(100);
		
		//학생수정
		StudentVO vo = new StudentVO();
		vo.setNo(100);
		vo.setName("김길동");
		vo.setTel("010-0000-1111");
		vo.setAddress("인천시 남구 학익동");
		
		dao.update(vo);
	}
}
