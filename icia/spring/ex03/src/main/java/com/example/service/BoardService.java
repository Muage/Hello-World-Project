package com.example.service;

import org.springframework.stereotype.Service;

import com.example.domain.BoardVO;

@Service
public interface BoardService {
	
	public BoardVO read(int bno);
}
