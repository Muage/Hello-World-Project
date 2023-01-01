package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.cart.CartDAO;
import com.example.domain.CartVO;
import com.example.service.cart.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartRESTController {

	@Autowired
	CartDAO dao;
	
	@Autowired
	CartService service;
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public void insert(@RequestBody CartVO vo){
//		System.out.println("CartRestController - insert : " + vo);
		CartVO read = dao.read(vo);
		System.out.println("CartRestController - insert : " + dao.read(vo));
		
		if(read.getM_name().equals(vo.getM_name())){
			System.out.println("CartRestController - insert :: 기존값 : " + read.getAmount());
			System.out.println("CartRestController - insert :: 추가되는 값 : " + vo.getAmount());
			vo.setAmount(read.getAmount() + vo.getAmount());
			System.out.println("CartRestController - insert :: 총합  : " + vo.getAmount());
			dao.update(vo);
		} else {
			dao.insert(vo);
		}
			
//		if(read.equals("")) {
//			dao.insert(vo);
//		}
//		try{
//			if(read.getM_name().equals(vo.getM_name())){
//				System.out.println("기존값 : "+read.getAmount());
//				System.out.println("추가되는 값 : "+vo.getAmount());
//				vo.setAmount(read.getAmount()+vo.getAmount());
//				System.out.println("총합  : "+vo.getAmount());
//				dao.update(vo);
//			}
//		} catch(NullPointerException e) {
//			dao.insert(vo);
//		}
	}
	
	@RequestMapping(value="/new_insert", method=RequestMethod.POST)
	public void new_insert(@RequestBody CartVO vo){
		service.new_insert(vo);
	}
	
	@RequestMapping("/getS_code/{u_code}")
	public String getS_code(@PathVariable String u_code){
//		System.out.println("CartRestController - getS_code : " + u_code);
		return dao.getS_code(u_code);
	}
	
	@RequestMapping("/list/{u_code}")
	public List<CartVO> list(@PathVariable String u_code){
		return dao.list(u_code);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void update(@RequestBody CartVO vo){
		dao.update(vo);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public void delete(@RequestBody CartVO vo){
		dao.delete(vo);
	}
	
}
