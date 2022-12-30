package com.example.dao;

import java.util.List;

import com.example.domain.BoardVO;

public interface BoardDAO {
	
	public int total();
	
	public int stotal(String word);
	
	public List<BoardVO> list();
	
	public List<BoardVO> slist(String word, int page);
	
	public BoardVO read(int bno);
	
	public void insert(BoardVO vo);
	
	public void update(BoardVO vo);
	
	public void delete(int bno);
}
