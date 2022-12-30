package com.example.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.dao.ShopDAO;
import com.example.domain.ShopVO;

@RestController
@RequestMapping("/api/shop")
public class ShopRestController {

	@Autowired
	ShopDAO dao;
	
	// CKEditer image upload
	@RequestMapping(value="/ckUpload", method=RequestMethod.POST)
	public HashMap<String, Object> ckUpload(MultipartHttpServletRequest multi) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		MultipartFile file = multi.getFile("upload");
		
		if(!file.isEmpty()) {
			String path = "/upload/shop/ckupload";
			String name = file.getOriginalFilename();
			
			File newPath = new File("c:/" + path);
			if(!newPath.exists()) newPath.mkdir();
			
			File newFile = new File("c:/" + path + "/" + name);
			if(!newFile.exists()) file.transferTo(newFile);
			
			map.put("url", path + "/" + name);
			map.put("uploaded", 1);
		}
		return map;
	}
	
	@RequestMapping("/list")
	public List<ShopVO> list() {
		return dao.list();
	}
	
	@RequestMapping("/read/{code}")
	public ShopVO read(@PathVariable String code) {
		return dao.read(code);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void Update(ShopVO vo, MultipartHttpServletRequest multi) throws Exception {
		if(multi.getFile("file") != null) {
			MultipartFile file = multi.getFile("file");
			String path = "c:/upload/shop/";
			String name = file.getOriginalFilename();
			File newFile = new File(path + name);
			
			if(!newFile.exists()) file.transferTo(newFile);
			
			vo.setImage("/upload/shop/" + name);
		}
		dao.Update(vo);
	}
	
}
