package com.example.service.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.like.LikedDAO;
import com.example.dao.menu.MenuDAO;
import com.example.dao.review.ReviewDAO;
import com.example.dao.store.StoreDAO;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	StoreDAO storeDAO;
	
	@Autowired
	MenuDAO menuDAO;
	
	@Autowired
	LikedDAO likedDAO;
	
	@Autowired
	ReviewDAO reviewDAO;

	@Transactional
	@Override
	public void delete(String s_code) {
		if(menuDAO.list(s_code) != null) {
			// �޴� ��ü ����
			menuDAO.allDelete(s_code);
//			return;
		}
		
		if(likedDAO.list(s_code) != null) {
			// ���ã�� ��ü ����
			likedDAO.delete(s_code);
//			return;
		}
		
		if(reviewDAO.read(s_code) != null) {
			// ���� ����
			reviewDAO.delete(s_code);
//			return;
		}
		
		// ���� ����
		storeDAO.delete(s_code);
	}

}
