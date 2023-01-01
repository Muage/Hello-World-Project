package com.example.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.dao.review.ReviewDAO;
import com.example.dao.store.StoreDAO;
import com.example.dao.user.UserDAO;
import com.example.domain.ReviewVO;
import com.example.service.review.ReviewService;

@RestController
@RequestMapping("/api/review")
public class ReviewRESTController {
	
	@Autowired
	ReviewDAO reviewDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	StoreDAO storeDAO;
	
	@Autowired
	ReviewService reviewService;
	
	
	@RequestMapping("/list")
	public List<ReviewVO> list(){
		return reviewDAO.list();
	}
	
	@RequestMapping("/uread/{u_code}")
	public HashMap<String, Object> uread(@PathVariable String u_code){
		HashMap<String, Object> map = new HashMap<>();
		map.put("review", reviewDAO.uread(u_code));
		map.put("user", userDAO.read(u_code));
		
		return map;
	}

	@RequestMapping("/sread/{s_code}")
	public HashMap<String, Object> sread(@PathVariable String s_code) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("review", reviewDAO.sread(s_code));
		map.put("store", storeDAO.read(s_code));
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public void insert(
			@RequestParam(value="r_content", required=true) String r_content,
			@RequestParam(value="r_rating", required=true) String r_rating,
			@RequestParam(value="u_id", required=true) String u_id,
			@RequestParam(value="u_code", required=true) String u_code,
			@RequestParam(value="s_code", required=true) String s_code, MultipartHttpServletRequest multi) throws Exception {
		
//		System.out.println("ReviewRestController - insert :: content : " + r_content);
//		System.out.println("ReviewRestController - insert :: content : " + r_rating);
//		System.out.println("ReviewRestController - insert :: content : " + u_id);
//		System.out.println("ReviewRestController - insert :: content : " + u_code);
//		System.out.println("ReviewRestController - insert :: content : " + s_code);
		
		ReviewVO vo = new ReviewVO();
		vo.setR_content(r_content);
		vo.setR_rating(3.5);
		vo.setU_id(u_id);
		vo.setS_code(u_code);
		vo.setU_code(s_code);

		if (multi.getFile("partImage") != null) {
			MultipartFile file = multi.getFile("partImage");

			// 해당 주소에 폴더가 없으면 폴더 생성
			String path = "/upload/store/review/";
			File newPath = new File("c:/" + path);
			if (!newPath.exists())
				newPath.mkdir();

			// 새로운 파일을 업로드 하고 vo에 데이터 입력
			String fileName = file.getOriginalFilename();
			File newFile = new File(newPath + "/" + fileName);
			if (!newFile.exists())
				file.transferTo(newFile);
			vo.setR_photo(path + fileName);
		}
		
		List<ReviewVO> reviewvo = reviewDAO.read(vo.getS_code());
		vo.setR_code(reviewDAO.newCode(vo.getS_code()));
//		System.out.println("ReviewRestController - insert : " + vo);
		reviewService.insert(vo);
	}
	
	@RequestMapping(value="/photoupdate", method=RequestMethod.POST)
	public void update(ReviewVO vo, MultipartHttpServletRequest multi) throws Exception {
		if(multi.getFile("file") != null) {
			MultipartFile file = multi.getFile("file");
			String path = "/upload/store/review";
			File newPath = new File("c:/" + path);
			if(!newPath.exists()) newPath.mkdir();
			
			String fileName = file.getOriginalFilename();
			File newFile = new File(newPath + "/" + fileName);
			if(!newFile.exists()) file.transferTo(newFile);
			vo.setR_photo(path + fileName);
		}
		reviewDAO.photoupdate(vo.getR_code());
	}
	
	@RequestMapping(value="/delete/{u_code}", method=RequestMethod.POST)
	public void delete(@PathVariable String u_code){
		reviewService.delete(u_code);
	}
	
	@RequestMapping(value="/storeinsert", method=RequestMethod.POST)
	public void storeinsert(@RequestBody ReviewVO vo){
		reviewDAO.storeinsert(vo);
	}
	
	@RequestMapping(value="/reviewupdate/{r_code}", method=RequestMethod.POST)
	public void update(@PathVariable String r_code){
		reviewDAO.reviewupdate(r_code);
	}
	
}
