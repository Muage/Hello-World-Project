package ex17;

import java.sql.*;
import java.util.*;

public class CampDAO {
	Connection con = Database.getConnection();
	ArrayList<CampVO> array;
	CampVO campVO;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	String newCode;
	String maxCode;
	int code;
	
	//ķ���� ���
	public void insert(CampVO campVO) {
		try {
			sql = "insert into tbl_camp (code, cname, address) values (?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, campVO.getCode());
			ps.setString(2, campVO.getCname());
			ps.setString(3, campVO.getAddress());
			ps.execute();
		} catch(Exception e) {
			System.out.println("ķ���� ����� Ȯ�����ּ���. : " + e.toString());
		}
	}
	
	//newCode ���ϱ�
	public String getNewCode() {
		newCode = "";
		try {
			sql = "select max(code) mcode from tbl_camp";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				maxCode = rs.getString("mcode");
				code = Integer.parseInt(maxCode.trim().substring(1)) + 100;
				newCode = "c" + code;
			}
		} catch(Exception e) {
			System.out.println("������ �ڵ带 Ȯ�����ּ���. : " + e.toString());
		}
		return newCode;
	}
	
	//ķ���� ��ȸ
	public CampVO read(String code) {
		campVO = new CampVO();
		try {
			sql = "select * from tbl_camp where code = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, code);
			rs = ps.executeQuery();
			while(rs.next()) {
				campVO.setCode(rs.getString("code"));
				campVO.setCname(rs.getString("cname"));
				campVO.setAddress(rs.getString("address"));
			}
		} catch(Exception e) {
			System.out.println("ķ���� ��ȸ�� Ȯ�����ּ���. : " + e.toString());
		}
		return campVO;
	}
	
	public ArrayList<CampVO> list() {
		array = new ArrayList<CampVO>();
		try {
			sql = "select * from tbl_camp order by code";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				campVO = new CampVO();
				campVO.setCode(rs.getString("code"));
				campVO.setCname(rs.getString("cname"));
				campVO.setAddress(rs.getString("address"));
				
				array.add(campVO);
			}
		} catch(Exception e) {
			System.out.println("����� Ȯ�����ּ���. : " + e.toString());
		}
		return array;
	}	
}
