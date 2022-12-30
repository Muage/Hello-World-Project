package ex16;

import java.sql.*;
import java.util.*;

public class DeptDAO {
	Connection con = Database.getConnection();
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	//수정
	public void update(DeptVO deptVO) {
		try {
			sql = "update tbl_dept set dname = ? where dcode = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, deptVO.getDname());
			ps.setString(2, deptVO.getDcode());
			ps.execute();
		} catch(Exception e) {
			System.out.println("수정을 확인해주세요. : " + e.toString());
		}
	}
	
	//삭제
	public boolean delete(String dcode) {
		boolean success = false;
		try {
			sql = "delete from tbl_dept where dcode = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dcode);
			ps.execute();
			success = true;
		} catch(Exception e) {
//			System.out.println("삭제를 확인해주세요. : " + e.toString());
		}
		return success;
	}
	
	//조회
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
			System.out.println("조회를 확인해주세요. : " + e.toString());
		}
		return deptVO;
	}
	
	//입력
	public void insert(DeptVO deptVO) {
		try {
			sql = "insert into tbl_dept (dcode, dname) values(?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, deptVO.getDcode());
			ps.setString(2, deptVO.getDname());
			ps.execute();
		} catch(Exception e) {
			System.out.println("등록을 확인해주세요. : " + e.toString());
		}
	}
	
	//Max Code값 구하기
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
			System.out.println("마지막 코드를 확인해주세요. : " + e.toString());
		}
		return maxCode;
	}
	
	//목록
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
			System.out.println("목록을 확인해주세요 : " + e.toString());
		}
		return array;
	}
}
