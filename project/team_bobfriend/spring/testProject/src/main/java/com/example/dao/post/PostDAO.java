package com.example.dao.post;

import java.util.List;

import com.example.domain.PostVO;

public interface PostDAO {
	
	public List<PostVO> list(String s_code);
	
}
