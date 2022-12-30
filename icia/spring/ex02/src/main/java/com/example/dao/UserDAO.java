package com.example.dao;

import java.util.List;

import com.example.domain.UserVO;

public interface UserDAO {
	
	public List<UserVO> list(String word, int page, int num);
	
	public int total(String word);
	
	public void insert(UserVO vo);
	
	public void update(UserVO vo);
	
	public UserVO read(String uid);
	
	public void delete(String uid);
}
