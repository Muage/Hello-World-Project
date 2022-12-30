package model;

import java.sql.*;
import java.util.*;

public class UserDAO {
	Connection CON = Database.CON;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	//전체 데이터 갯수
	public int count() {
		int count = 0;
		try {
			sql = "select count(*) cnt from userinfo";
			ps = CON.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch(Exception e) {
			System.out.println("전체데이터갯수 오류: " + e.toString());
		}
		return count;
	}
	
	//사용자수정
	public void update(UserVO userVO) {
		try {
			sql = "update userinfo set name = ?, password = ? where id = ?";
			ps = CON.prepareStatement(sql);
			ps.setString(1, userVO.getName());
			ps.setString(2, userVO.getPassword());
			ps.setString(3, userVO.getId());
			ps.execute();
		} catch(Exception e) {
			System.out.println("사용자수정 오류: " + e.toString());
		}
	}
	
	//사용자삭제
	public void delete(String id, String del) {
		try {
			sql = "update userinfo set del = ? where id = ?";
			ps = CON.prepareStatement(sql);
			ps.setString(1, del);
			ps.setString(2, id);
			ps.execute();
		} catch(Exception e) {
			System.out.println("사용자삭제 오류: " + e.toString());
		}
	}
	
	//사용자등록
	public void insert(UserVO userVO) {
		try {
			sql = "insert into userinfo(id, password, name) values(?, ?, ?)";
			ps = CON.prepareStatement(sql);
			ps.setString(1, userVO.getId());
			ps.setString(2, userVO.getPassword());
			ps.setString(3, userVO.getName());
			ps.execute();
		} catch(Exception e) {
			System.out.println("사용자등록 오류: " + e.toString());
		}
	}
	
	//사용자정보
	public UserVO read(String id) {
		UserVO userVO = new UserVO();
		try {
			sql = "select * from userinfo where id = ?";
			ps = CON.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				userVO.setId(rs.getString("id"));
				userVO.setPassword(rs.getString("password"));
				userVO.setName(rs.getString("name"));
			}
		} catch(Exception e) {
			System.out.println("사용자정보 오류: " + e.toString());
		}
		return userVO;
	}
	
	//사용자목록
	public ArrayList<UserVO> list(int page) {
		ArrayList<UserVO> array = new ArrayList<UserVO>();
		UserVO userVO;
		
		try {
			int start = (page - 1) * 3;
			sql = "select * from userinfo order by id limit ?, 3";
			ps = CON.prepareStatement(sql);
			ps.setInt(1, start);
			rs = ps.executeQuery();
			while(rs.next()) {
				userVO = new UserVO();
				userVO.setId(rs.getString("id"));
				userVO.setName(rs.getString("name"));
				userVO.setPassword(rs.getString("password"));
				userVO.setDel(rs.getString("del"));
				array.add(userVO);
			}
		} catch(Exception e) {
			System.out.println("사용자목록 오류: " + e.toString());
		}
		return array;
	}
}