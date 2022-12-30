package ex18;

import java.sql.*;
import java.text.*;
import java.util.*;

public class StatementDAO {
	Connection con = Database.getConnection();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	StatementVO statementVO;
	ArrayList<StatementVO> array;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	String sdate;
	
	//C-deposit
	public void insert(StatementVO statementVO) {
		try {
			sql = "insert into tbl_statement(ano, type, amount) values (?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, statementVO.getAno());
			ps.setString(2, statementVO.getType());
			ps.setInt(3, statementVO.getAmount());
			ps.execute();
		} catch(Exception e) {
			System.out.println("�Ա��� Ȯ�����ּ���. : " + e.toString());
		}
	}
	
	//R-balance
	public int getBalance(String ano) {
		int balance = 0;
		try {
			sql = "select sum(amount) from tbl_statement where ano = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ano);
			rs = ps.executeQuery();
			if(rs.next()) {
				balance = rs.getInt("sum(amount)");
			}
		} catch(Exception e) {
			System.out.println("�ܾ��� Ȯ�����ּ���. : " + e.toString());
		}
		return balance;
	}
	
	//R-list
	public ArrayList<StatementVO> list(String ano) {
		array = new ArrayList<StatementVO>();
		try {
			sql = "select * from tbl_statement where ano = ? order by sdate desc";
			ps = con.prepareStatement(sql);
			ps.setString(1, ano);
			rs = ps.executeQuery();
			while(rs.next()) {
				statementVO = new StatementVO();
				statementVO.setAno(rs.getString("ano"));
				sdate = sdf.format(rs.getDate("sdate"));
				statementVO.setSdate(sdate);
				statementVO.setType(rs.getString("type"));
				statementVO.setAmount(rs.getInt("amount"));
				
				array.add(statementVO);
			}
		} catch(Exception e) {
			System.out.println("�ŷ����� ����� Ȯ�����ּ���. : " + e.toString());
		}
		return array;
	}
}
