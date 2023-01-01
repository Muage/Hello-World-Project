package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.post.PostDAO;
import com.example.domain.PostVO;
import com.example.service.post.PostService;

@RestController
@RequestMapping("/api/post")
public class PostRestController {
	
	@Autowired
	PostDAO postDAO;
	
	@Autowired
	PostService service;
	
	// 조건 insert 후 게시글 insert
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public void insert(@RequestBody PostVO vo){
		service.insert(vo);
	}
	
	// 특정 가계의 게시글 목록
	@RequestMapping("/list/{s_code}")
	public List<PostVO> list(@PathVariable String s_code) {
		return postDAO.list(s_code);
	}
	
	//특정 게시글 정보
	@RequestMapping("/read/{p_code}")
		public PostVO read(@PathVariable int p_code){
			PostVO vo = postDAO.read(p_code);
			return vo;
		}
	
	// 게시글 삭제 후 조건 삭제
	@RequestMapping(value="/delete/{p_code}", method=RequestMethod.POST)
	public void delete(@PathVariable int p_code){
		service.delete(p_code);
	}
	
}
