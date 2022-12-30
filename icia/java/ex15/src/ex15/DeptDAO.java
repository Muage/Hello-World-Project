package ex15;

import java.sql.*;
import java.util.*;

public class DeptDAO {
	Connection con = Database.getConnection();
	
	//학과 등록
	public void insert(DeptVO deptVO) {
		try {
			String sql = "insert into tbl_dept(code, dname) values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, deptVO.getCode());
			ps.setString(2, deptVO.getDname());
			ps.execute();
		} catch(Exception e) {
			System.out.println("학과 등록을 확인해주세요. : " + e.toString());
		}
	}
	//MaxCode 가져오기
	public String getMaxCode() {
		String maxCode = "";
		
		try {
			String sql = "select max(code) mcode from tbl_dept";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) maxCode = rs.getString("mcode");
		} catch(Exception e) {
			System.out.println("마지막 코드를 확인해주세요. : " + e.toString());
		}
		
		
		return maxCode;
	}
	
	//목록 출력
	public ArrayList<DeptVO> list() {
		ArrayList<DeptVO> array = new ArrayList<>();
		
		try {
			String sql = "select * from tbl_dept";	//1
			PreparedStatement ps = con.prepareStatement(sql);	//2
			ResultSet rs = ps.executeQuery();	//3
			while(rs.next()) {
				DeptVO deptVO = new DeptVO();
				deptVO.setCode(rs.getString("code"));
				deptVO.setDname(rs.getString("dname"));
				array.add(deptVO);
			}
		} catch(Exception e) {
			System.out.println("학과 목록을 확인해주세요. : " + e.toString());
		}
		
		return array;
	}
}
