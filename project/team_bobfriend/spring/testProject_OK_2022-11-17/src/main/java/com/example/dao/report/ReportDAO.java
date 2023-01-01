package com.example.dao.report;

import java.util.List;

import com.example.domain.ReportVO;

public interface ReportDAO {
	
	public String newCode();
	
	public void insert(ReportVO vo);

	public List<ReportVO> list();
	
	public ReportVO read(String r_code);

	public void update(ReportVO vo);

	public void delete(String r_code);

	public void update_del();
	
}
