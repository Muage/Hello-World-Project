package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.report.ReportDAO;
import com.example.domain.ReportVO;


@RestController
@RequestMapping("/api/report")
public class ReportRestController {
	@Autowired
	ReportDAO reportDAO;
	
	@RequestMapping("/list")
	public List<ReportVO> list(){
		return reportDAO.list();
	}
	
	@RequestMapping("/read/{r_code}")
	public ReportVO read(@PathVariable String r_code){
		ReportVO vo = reportDAO.read(r_code);
		return vo;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public void insert(@RequestBody ReportVO vo){
		vo.setR_code(reportDAO.newCode());
		reportDAO.insert(vo);
	}	
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void update(@RequestBody ReportVO vo){
		reportDAO.update(vo);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public void delete(@RequestBody ReportVO vo){
		reportDAO.delete(vo.getR_code());
	}
}
