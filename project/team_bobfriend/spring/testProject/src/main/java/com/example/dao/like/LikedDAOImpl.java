package com.example.dao.like;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.LikedVO;

@Repository

public class LikedDAOImpl implements LikedDAO {
	
	@Autowired
	SqlSession session;
	
	String namespace = "com.example.mapper.LikedMapper";

	@Override
	public List<LikedVO> list(String s_code) {
		return session.selectList(namespace + ".list", s_code);
	}

	@Override
	public void delete(String s_code) {
		session.delete(namespace + ".delete", s_code);
	}

	@Override
	public void u_delete() {
		session.delete(namespace + ".u_delete");
	}
}
