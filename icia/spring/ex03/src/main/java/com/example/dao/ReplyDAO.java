package com.example.dao;

import java.util.List;

import com.example.domain.ReplyVO;

public interface ReplyDAO {
	
	public int total(int bno);
	
	public List<ReplyVO> list(int bno);
	
	public ReplyVO read(int rno);
	
	public void insert(ReplyVO vo);
	
	public void delete(int rno);

}
