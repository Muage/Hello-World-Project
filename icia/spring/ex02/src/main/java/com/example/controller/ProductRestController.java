package com.example.controller;

import java.io.File;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.dao.ProductDAO;
import com.example.domain.ProductVO;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
	
	@Resource(name="uploadPath")
	private String path;
	
	@Autowired
	ProductDAO dao;	
	
	@RequestMapping("/list")
	public HashMap<String, Object> list(int page, int num, String word) {
		
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("list", dao.list(page, num, word));
		map.put("total", dao.total(word));
		
		return map;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public void insert(ProductVO vo, MultipartFile file) throws Exception {
		if(!file.isEmpty()) {
			String filePath = path + "/product/";
			String fileName = System.currentTimeMillis() + file.getOriginalFilename();
			FileCopyUtils.copy(file.getBytes(), new File(filePath + fileName));
			vo.setImage("/upload/product/" + fileName);
		}
		dao.insert(vo);
	}

}
