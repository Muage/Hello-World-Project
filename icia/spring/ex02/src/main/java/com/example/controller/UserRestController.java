package com.example.controller;

import java.io.File;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.dao.UserDAO;
import com.example.domain.UserVO;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
	
	@Resource(name="uploadPath")
	private String path;
	
	@Autowired
	UserDAO dao;
	
	@RequestMapping("/list")
	public HashMap<String, Object> list(String word, int page, int num) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("total", dao.total(word));
		map.put("list", dao.list(word, page, num));
		
		return map;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public void insert(UserVO vo, MultipartFile file) throws Exception {
		if(!file.isEmpty()) {
			String uploadPath = path + "photo/";
			String fileName = System.currentTimeMillis() + file.getOriginalFilename();
			FileCopyUtils.copy(file.getBytes(), new File(uploadPath + fileName));
			vo.setPhoto("/upload/photo/" + fileName);
		}
//		System.out.println(vo.toString());		
		dao.insert(vo);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void update(@RequestBody UserVO vo) {
		dao.update(vo);
	}
	
	@RequestMapping("/read/{uid}")
	public UserVO read(@PathVariable String uid) {
		return dao.read(uid);
	}
	
	@RequestMapping("/delete/{uid}")
	public void delete(@PathVariable String uid) {
		dao.delete(uid);
	}
}
