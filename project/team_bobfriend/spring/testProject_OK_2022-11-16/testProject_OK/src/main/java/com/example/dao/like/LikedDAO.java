package com.example.dao.like;

import java.util.List;

import com.example.domain.LikedVO;

public interface LikedDAO {
	
	public List<LikedVO> list(String s_code);
	
	public void delete(String s_code);
	
	public void u_delete();
	
}