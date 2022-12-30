package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.dao.BoardDAO;
import com.example.dao.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class MysqlTest {
	@Autowired
	BoardDAO dao;

	@Test
	public void testList() {
		dao.list();
	}
	
	@Test
	public void testRead() {
		dao.read(511);
	}
	
	@Test
	public void testUpdateReplycnt() {
		dao.updateReplycnt(511,-1);
	}
	
	
	
	@Autowired
	UserDAO udao;
	
	@Test
	public void test() {
		udao.list();
	}
}