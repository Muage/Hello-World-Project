package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.AccountDAO;
import com.example.dao.TradeDAO;
import com.example.domain.TradeVO;

@Service
public class TradeServiceImpl implements TradeService {
	
	@Autowired
	AccountDAO adao;
	
	@Autowired
	TradeDAO tdao;

	@Transactional
	@Override
	public void trade(TradeVO vo) {
		// 계좌이체 시
		// 본인 계좌 잔액 변경
		adao.updateAmount(vo.getAno(), vo.getAmount() * -1);
		// 이체 계좌 잔액 변경
		adao.updateAmount(vo.getTno(), vo.getAmount());
		// 본인 계좌 거래 정보 입력
		vo.setType("출금");
		tdao.insert(vo);
		// 이체 계좌 거래 정보 입력
		vo.setType("입금");
		String ano = vo.getTno();
		String tno = vo.getAno();
		
		vo.setType("입금");
		vo.setAno(ano);
		vo.setTno(tno);
		tdao.insert(vo);
	}

}
