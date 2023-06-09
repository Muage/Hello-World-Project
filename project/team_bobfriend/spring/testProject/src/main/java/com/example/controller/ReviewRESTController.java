package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.review.ReviewDAO;
import com.example.dao.store.StoreDAO;
import com.example.dao.user.UserDAO;
import com.example.domain.ReviewVO;
import com.example.service.review.ReviewService;

@RestController
@RequestMapping("/api/review")
public class ReviewRESTController {
	
	@Autowired
	ReviewDAO dao;
	
	@Autowired
	UserDAO udao;
	
	@Autowired
	StoreDAO sdao;
	
	@Autowired
	ReviewService service;
	
	@RequestMapping("/list")
	public List<ReviewVO> list(){
		return dao.list();
	}
	
	@RequestMapping("/uread/{u_code}")
	public HashMap<String,Object> uread(@PathVariable String u_code){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("review", dao.uread(u_code));
		map.put("user", udao.read(u_code));
		
		return map;
	}

	@RequestMapping("/sread/{s_code}")
	public HashMap<String, Object> sread(@PathVariable String s_code) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("review", dao.sread(s_code));
		map.put("store", sdao.read(s_code));
		return map;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public void insert(@RequestBody ReviewVO vo){
		service.insert(vo);
	}
	
	@RequestMapping(value="/delete/{u_code}", method=RequestMethod.POST)
	public void delete(@PathVariable String u_code){
		service.delete(u_code);
	}
	
	@RequestMapping(value="/storeinsert", method=RequestMethod.POST)
	public void storeinsert(@RequestBody ReviewVO vo){
		dao.storeinsert(vo);
	}
	
	@RequestMapping(value="/reviewupdate/{r_code}", method=RequestMethod.POST)
	public void update(@PathVariable String r_code){
		dao.reviewupdate(r_code);
	}
	
}
