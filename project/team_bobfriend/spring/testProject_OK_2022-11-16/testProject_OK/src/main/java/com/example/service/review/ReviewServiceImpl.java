package com.example.service.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.review.ReviewDAO;
import com.example.dao.user.UserDAO;
import com.example.domain.ReviewVO;

@Repository
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDAO rdao;

	@Autowired
	UserDAO udao;

	@Transactional
	@Override
	public void insert(ReviewVO vo) {
		rdao.insert(vo);
	}

	@Transactional
	@Override
	public void delete(String u_code) {
		rdao.delete(u_code);
	}

}
