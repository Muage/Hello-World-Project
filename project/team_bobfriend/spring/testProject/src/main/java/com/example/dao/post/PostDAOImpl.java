package com.example.dao.post;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.PostVO;

@Repository
public class PostDAOImpl implements PostDAO{
	
	@Autowired
	SqlSession session;
	
	String namespace = "com.example.mapper.PostMapper";

	@Override
	public List<PostVO> list(String s_code) {
		return session.selectList(namespace + ".list", s_code);
	}
	
}
