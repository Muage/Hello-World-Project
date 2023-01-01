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
	
	// ���� insert �� �Խñ� insert
	@Transactional
	@Override
	public void insert(PostVO vo) {
		// ���� ���̺� ������ ���
		ConditionVO cvo = new ConditionVO();
		cvo.setHeadcount(vo.getHeadcount());
		cvo.setGender(vo.getGender());
		cvo.setAge(vo.getAge());
		System.out.println("PostService - insert : " + cvo.toString());
		cdao.insert(cvo);
//		cdao.insert(vo);
		
		// ���� ���̺��� ���� �ڵ� == �Խñ��� ���� �ڵ�
		// ������ ����� ���� �ڵ带 �Խñ��� ���� �ڵ�� ������ �� ��� 
		System.out.println("PostService - insert : " + vo.toString());
		pdao.insert(vo);		
	}
	
	// �Խñ� ���� �� ���� ����
	@Transactional
	@Override
	public void delete(int p_code) {
		// ���� ���̺��� ���� �ڵ� == �Խñ��� ���� �ڵ�
		// ������ �Խñ��� p_code�� ���� c_code�� ����
		int c_code = pdao.get_c_code(p_code);
		
		// �Խñ� ����
		pdao.delete(p_code);
		// ������ ���� c_code�� ���� ����
		cdao.delete(c_code);
	}

}