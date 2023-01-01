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
			// 메뉴 전체 삭제
			menuDAO.allDelete(s_code);
//			return;
		}
		
		if(likedDAO.list(s_code) != null) {
			// 즐겨찾기 전체 삭제
			likedDAO.delete(s_code);
//			return;
		}
		
		if(reviewDAO.read(s_code) != null) {
			// 리뷰 삭제
			reviewDAO.delete(s_code);
//			return;
		}
		
		// 매장 삭제
		storeDAO.delete(s_code);
	}

}
