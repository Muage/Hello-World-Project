package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	@Autowired
	SqlSession session;
	String namespace = "com.example.mapper.ReplyMapper";
	
	@Override
	public int total(int bno) {
		return session.selectOne(namespace + ".total", bno);
	}

	@Override
	public List<ReplyVO> list(int bno) {
		return session.selectList(namespace + ".list", bno);
	}
	
	@Override
	public ReplyVO read(int rno) {
		return session.selectOne(namespace + ".read", rno);
	}

	@Override
	public void insert(ReplyVO vo) {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public void delete(int rno) {
		session.delete(namespace + ".delete", rno);
	}
	
}
