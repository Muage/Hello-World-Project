package com.example.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.dao.UserDAO;
import com.example.domain.UserVO;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
	
	@Autowired
	UserDAO dao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public int login(@RequestBody UserVO vo) {
		int result = 0;
		UserVO readVO = dao.read(vo.getUid());
		
		if(readVO != null) {
			if(passwordEncoder.matches(vo.getUpass(), readVO.getUpass())) {
				result = 1;
			} else {
				result = 2;
			}
		}
		
		return result;
	}
	
	@RequestMapping("/list")
	public List<UserVO> list(int page) {
		return dao.list(page);
	}
	
	@RequestMapping("/read/{uid}")
	public UserVO read(@PathVariable String uid) {
		UserVO vo = dao.read(uid);
		return vo;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public void insert(UserVO vo, MultipartFile file) throws Exception {
		if(!file.isEmpty()) {
			String path = "/upload/photo/";
			File newFile = new File("c:" + path + file.getOriginalFilename());
			
			if(!newFile.exists()) file.transferTo(newFile);
			
			vo.setPhoto(path + file.getOriginalFilename());
		}
		String password = passwordEncoder.encode(vo.getUpass());
		vo.setUpass(password);
		
		dao.insert(vo);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void update(UserVO vo, MultipartHttpServletRequest multi) throws Exception {
		if(multi.getFile("file") != null) {
			MultipartFile file = multi.getFile("file");
			// 수정 전 사진 삭제
			if(vo.getPhoto() != null) {
				File oldFile = new File("c:" + vo.getPhoto());
				if(oldFile.exists()) oldFile.delete();
			}
			// 수정 후 사진 등록
			String path = "/upload/photo/";
			File newFile = new File("c:" + path + file.getOriginalFilename());
			
			if(!newFile.exists()) file.transferTo(newFile);
			
			vo.setPhoto(path + file.getOriginalFilename());
		}
		dao.update(vo);
	}
	
	@RequestMapping(value="/update/password", method=RequestMethod.POST)
	public void updatePassword(@RequestBody UserVO vo) {
		String password = passwordEncoder.encode(vo.getUpass());
		vo.setUpass(password);
		
		dao.updatePassword(vo);
	}

}
