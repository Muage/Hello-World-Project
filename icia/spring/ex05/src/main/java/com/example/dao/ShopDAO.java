package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.domain.ShopVO;

public interface ShopDAO {
	
	public int total();
	
	public List<ShopVO> list(int page, int num);
	
	public void insert(ShopVO vo);
	
	public ShopVO read(String code);
	
	public void addAttach(String code, String image);
	
	public List<HashMap<String, Object>> getAttach(String code);
	
	public void delAttach(int id);
	
	public void addSale(String code);
	
	public List<ShopVO> getSale(String code);

}
