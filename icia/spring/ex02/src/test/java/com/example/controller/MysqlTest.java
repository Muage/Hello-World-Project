package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.dao.ProductDAO;
import com.example.domain.ProductVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class MysqlTest {
	
	@Autowired
//	BoardDAO dao;
//	ReplyDAO dao;
	ProductDAO dao;

	@Test
	public void insert() {
		ProductVO vo = new ProductVO();
		vo.setPname("Q7");
		dao.insert(vo);
	}
	
//	public void list() {
//		dao.list(511, 1, 3);
//		dao.total(511);
//	}
	
//	public void list(String word, int page) {
//		dao.list(word, page);
//	}
}