package com.example.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.condition.ConditionDAO;
import com.example.dao.post.PostDAO;
import com.example.domain.PostVO;
import com.example.domain.ConditionVO;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	PostDAO pdao;

	@Autowired
	ConditionDAO cdao;
	
	// 조건 insert 후 게시글 insert
	@Transactional
	@Override
	public void insert(PostVO vo) {
		// 조건 테이블에 데이터 등록
		ConditionVO cvo = new ConditionVO();
		cvo.setHeadcount(vo.getHeadcount());
		cvo.setGender(vo.getGender());
		cvo.setAge(vo.getAge());
		System.out.println("PostService - insert : " + cvo.toString());
		cdao.insert(cvo);
//		cdao.insert(vo);
		
		// 조건 테이블의 조건 코드 == 게시글의 조건 코드
		// 위에서 등록한 조건 코드를 게시글의 조건 코드로 설정한 후 등록 
		System.out.println("PostService - insert : " + vo.toString());
		pdao.insert(vo);		
	}
	
	// 게시글 삭제 후 조건 삭제
	@Transactional
	@Override
	public void delete(int p_code) {
		// 조건 테이블의 조건 코드 == 게시글의 조건 코드
		// 삭제할 게시글의 p_code를 통해 c_code를 얻음
		int c_code = pdao.get_c_code(p_code);
		
		// 게시글 삭제
		pdao.delete(p_code);
		// 위에서 얻은 c_code로 조건 삭제
		cdao.delete(c_code);
	}

}