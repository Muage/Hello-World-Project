package com.example.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ReplyDAO;
import com.example.domain.ReplyVO;

@RestController
@RequestMapping("/api/reply")
public class ReplyRestController {
	
	@Autowired
	ReplyDAO dao;
	
	@RequestMapping("/list/{bno}")
	public HashMap<String, Object> list(@PathVariable int bno, int page, int num) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("total", dao.total(bno));
		map.put("list", dao.list(bno, page, num));
		
		return map;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public void insert(@RequestBody ReplyVO vo) {
		dao.insert(vo);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void update(@RequestBody ReplyVO vo) {
		dao.update(vo);
	}
	
	@RequestMapping("/delete/{rno}")
	public void delete(@PathVariable int rno) {
		dao.delete(rno);
	}
}
