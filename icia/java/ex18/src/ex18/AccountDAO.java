package ex18;

import java.sql.*;
import java.text.*;
import java.util.*;

public class AccountDAO {
	Connection con = Database.getConnection();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	AccountVO accountVO;
	ArrayList<AccountVO> array;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	String maxNo;
	String odate;
	int newAno;
	
	//C-Max No 가져오기
	public int getNewNo() {
		newAno = 0;
		try {
			sql = "select max(ano) from tbl_account";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				maxNo = rs.getString("max(ano)");
			}
			newAno = Integer.parseInt(maxNo) + 100;
			
		} catch(Exception e) {
			System.out.println("마지막 코드를 확인해주세요. : " + e.toString());
		}
		return newAno;
	}
	
	//C-insert
	public void insert(AccountVO accountVO) {
		try {
			sql = "insert into tbl_account (ano, aname, balance) values (?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, accountVO.getAno());
			ps.setString(2, accountVO.getAname());
			ps.setInt(3, accountVO.getBalance());
			ps.execute();
		} catch(Exception e) {
			System.out.println("계좌 생성을 확인해주세요. : " + e.toString());
		}
	}
	
	//C-입출금
	public void trade(int balance, String ano) {
		try {
			sql = "update tbl_account set balance = ? where ano = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, balance);
			ps.setString(2, ano);
			ps.execute();
		} catch(Exception e) {
			System.out.println("입출금을 확인해주세요. : " + e.toString());
		}
	}
	
	//R
	public AccountVO read(String ano) {
		accountVO = new AccountVO();
		try {
			sql = "select * from tbl_account where ano = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ano);
			rs = ps.executeQuery();
			if(rs.next()) {
				accountVO = new AccountVO();
				accountVO.setAno(rs.getString("ano"));
				accountVO.setAname(rs.getString("aname"));
				accountVO.setBalance(rs.getInt("balance"));
				odate = sdf.format(rs.getDate("odate"));
				accountVO.setOdate(odate);
			}
		} catch(Exception e) {
			System.out.println("계좌 조회를 확인해주세요. : " + e.toString());
		}
		return accountVO;
	}
	
	//R-list
	public ArrayList<AccountVO> list() {
		array = new ArrayList<AccountVO>();
		try {
			sql = "select * from tbl_account order by ano";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				accountVO = new AccountVO();
				accountVO.setAno(rs.getString("ano"));
				accountVO.setAname(rs.getString("aname"));
				accountVO.setBalance(rs.getInt("balance"));
				odate = sdf.format(rs.getDate("odate"));
				accountVO.setOdate(odate);
				
				array.add(accountVO);
			}
		} catch(Exception e) {
			System.out.println("계좌 목록을 확인해주세요. : " + e.toString());
		}
		return array;
	}
}
