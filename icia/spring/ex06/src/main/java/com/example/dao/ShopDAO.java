package com.example.dao;

import java.util.List;

import com.example.domain.ShopVO;

public interface ShopDAO {
	
	public List<ShopVO> list();
	
	public ShopVO read(String code);
	
	public void Update(ShopVO vo);
	
	public void insert(ShopVO vo);
	
}
