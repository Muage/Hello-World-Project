package ex16;

import java.sql.*;
import java.util.*;

public class DeptDAO {
	Connection con = Database.getConnection();
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	//����
	public void update(DeptVO deptVO) {
		try {
			sql = "update tbl_dept set dname = ? where dcode = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, deptVO.getDname());
			ps.setString(2, deptVO.getDcode());
			ps.execute();
		} catch(Exception e) {
			System.out.println("������ Ȯ�����ּ���. : " + e.toString());
		}
	}
	
	//����
	public boolean delete(String dcode) {
		boolean success = false;
		try {
			sql = "delete from tbl_dept where dcode = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dcode);
			ps.execute();
			success = true;
		} catch(Exception e) {
//			System.out.println("������ Ȯ�����ּ���. : " + e.toString());
		}
		return success;
	}
	
	//��ȸ
	public DeptVO read(String dcode) {
		DeptVO deptVO = new DeptVO();
		try {
			sql = "select * from tbl_dept where dcode=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dcode);
			rs = ps.executeQuery();
			if(rs.next()) {
				deptVO.setDcode(rs.getString("dcode"));
				deptVO.setDname(rs.getString("dname"));
			}
		} catch(Exception e) {
			System.out.println("��ȸ�� Ȯ�����ּ���. : " + e.toString());
		}
		return deptVO;
	}
	
	//�Է�
	public void insert(DeptVO deptVO) {
		try {
			sql = "insert into tbl_dept (dcode, dname) values(?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, deptVO.getDcode());
			ps.setString(2, deptVO.getDname());
			ps.execute();
		} catch(Exception e) {
			System.out.println("����� Ȯ�����ּ���. : " + e.toString());
		}
	}
	
	//Max Code�� ���ϱ�
	public String getMaxCode() {
		String maxCode = "";
		try {
			sql = "select max(dcode) mcode from tbl_dept";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				maxCode = rs.getString("mcode");
			}
		} catch(Exception e) {
			System.out.println("������ �ڵ带 Ȯ�����ּ���. : " + e.toString());
		}
		return maxCode;
	}
	
	//���
	public ArrayList<DeptVO> list() {
		ArrayList<DeptVO> array = new ArrayList<>();
		try {
			sql = "select * from tbl_dept";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				DeptVO deptVO = new DeptVO();
				deptVO.setDcode(rs.getString("dcode"));
				deptVO.setDname(rs.getString("dname"));
				array.add(deptVO);
			}
		} catch(Exception e) {
			System.out.println("����� Ȯ�����ּ��� : " + e.toString());
		}
		return array;
	}
}
