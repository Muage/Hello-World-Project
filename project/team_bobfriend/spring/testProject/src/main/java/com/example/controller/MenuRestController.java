package com.example.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.dao.menu.MenuDAO;
import com.example.domain.MenuVO;
import com.example.domain.StoreVO;

@RestController
@RequestMapping("/api/menu")
public class MenuRestController {

	@Autowired
	MenuDAO menuDAO;
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public int insert(MenuVO menuVO, MultipartHttpServletRequest multi) {
		try {
			if(multi.getFile("file") != null) {
				MultipartFile file = multi.getFile("file");
				String path = "/upload/menu/";
				File newPath = new File("c:/" + path);
				if(!newPath.exists()) newPath.mkdir();
				
				String fileName = file.getOriginalFilename();
				File newFile = new File(newPath + "/" + fileName);
				if(!newFile.exists()) file.transferTo(newFile);
				
				menuVO.setM_photo(path + fileName);
			}
			menuVO.setM_code(menuDAO.newCode(menuVO.getS_code()));
			System.out.println(menuVO.toString());
			menuDAO.insert(menuVO);
			return 1;
		} catch(Exception e) {
			System.out.println(e.toString());
			return 2;
		}
	}
	
	@RequestMapping("/list")
	public List<MenuVO> list(String s_code) {
		return menuDAO.list(s_code);
	}
	
	@RequestMapping(value="/read", method=RequestMethod.POST)
	public MenuVO read(@RequestBody MenuVO menuVO) {
		return menuDAO.read(menuVO.getS_code(), menuVO.getM_code());
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void update(MenuVO menuVO, MultipartHttpServletRequest multi) throws Exception {
		if(multi.getFile("file") != null) {
			MultipartFile file = multi.getFile("file");
			
			// 수정 전 사진 삭제
			if(menuVO.getM_photo() != null) {
				File oldFile = new File("c:/" + menuVO.getM_photo());
				if(oldFile.exists()) oldFile.delete();
			}
			
			// 사진 등록
			String path = "/upload/menu/";
			File newPath = new File("c:/" + path);
			String fileName = file.getOriginalFilename();
			File newFile = new File(newPath + "/" + fileName);
			if(!newFile.exists()) file.transferTo(newFile);
			
			menuVO.setM_photo(path + fileName);
		}
//		System.out.println(menuVO.toString());
		menuDAO.update(menuVO);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public void delete(@RequestBody MenuVO menuVO) {
		File file = new File("c:/" + menuVO.getM_photo());
		if(file.exists()) file.delete();
		
		menuDAO.delete(menuVO.getS_code(), menuVO.getM_name());
	}
	
}
