package ex16;

import java.sql.*;
import java.text.*;
import java.util.*;

public class TypeDAO {
	Connection con = Database.getConnection();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	String maxCode;
	String tdate;
	
	//����
	public void update(TypeVO typeVO) {
		try {
			sql = "update tbl_type set tname = ?, tdate = ? where tcode = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, typeVO.getTname());
			ps.setString(2, typeVO.getTdate());
			ps.setString(3, typeVO.getTcode());
			
			ps.execute();
		} catch(Exception e) {
			System.out.println("������ Ȯ�����ּ���. : " + e.toString());
		}
	}
	
	//����
	public boolean delete(String tcode) {
		boolean success = false;
		try {
			sql = "delete from tbl_type where tcode = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, tcode);
			ps.execute();
			success = true;
		} catch(Exception e) {}
		return success;
	}
	
	//��ȸ
	public TypeVO read(String tcode) {
		TypeVO typeVO = new TypeVO();
		try {
			sql = "select * from tbl_type where tcode = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, tcode);
			rs = ps.executeQuery();
			if(rs.next()) {
				typeVO.setTcode(rs.getString("tcode"));
				typeVO.setTname(rs.getString("tname"));
				tdate = sdf.format(rs.getDate("tdate"));
				typeVO.setTdate(tdate);
			}
			
		} catch(Exception e) {
			System.out.println("��ȸ�� Ȯ�����ּ���. : " + e.toString());
		}
		return typeVO;
	}
	//���
	public void insert(TypeVO typeVO) {
		try {
			sql = "insert into tbl_type (tcode, tname) values (?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, typeVO.getTcode());
			ps.setString(2, typeVO.getTname());
			ps.execute();
		} catch(Exception e) {
			System.out.println("����� Ȯ�����ּ���. : " + e.toString());
		}
	}
	//Max Code ��������
	public String getMaxCode() {
		maxCode = "";
		try {
			sql = "select max(tcode) from tbl_type";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				maxCode = rs.getString("max(tcode)");
			}
			
		} catch(Exception e) {
			System.out.println("������ �ڵ带 Ȯ�����ּ���. : " + e.toString());
		}
		return maxCode;
	}
	
	//���
	public ArrayList<TypeVO> list(){
		ArrayList<TypeVO> array = new ArrayList<TypeVO>();
		try {
			sql = "select * from tbl_type";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				TypeVO typeVO = new TypeVO();
				typeVO.setTcode(rs.getString("tcode"));
				typeVO.setTname(rs.getString("tname"));
				tdate = sdf.format(rs.getDate("tdate"));
				typeVO.setTdate(tdate);
				
				array.add(typeVO);
			}
			
		} catch(Exception e) {
			System.out.println("����� Ȯ�����ּ���. : " + e.toString());
		}
		return array;
	}
}
