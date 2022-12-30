package model;

import java.sql.*;
import java.util.*;

public class LocalDAO {
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	//전체데이터
	public int count() {
		int count = 0;
		try {
			sql = "select count(*) from local";
			ps = Database.CON.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch(Exception e) {
			System.out.println("전체데이터 오류:" + e.toString());
		}
		return count;
	}
	
	//지역목록
	public ArrayList<LocalVO> list(int page) {
		ArrayList<LocalVO> array = new ArrayList<LocalVO>();
		try {
			sql = "select * from local order by wdate desc limit ?, 7";
			ps = Database.CON.prepareStatement(sql);
			ps.setInt(1, (page - 1) * 7);
			rs = ps.executeQuery();
			while(rs.next()) {
				LocalVO localVO = new LocalVO();
				localVO.setId(rs.getString("id"));
				localVO.setName(rs.getString("name"));
				localVO.setPhone(rs.getString("phone"));
				localVO.setAddress(rs.getString("address"));
				localVO.setKeyword(rs.getString("keyword"));
				localVO.setX(rs.getDouble("x"));
				localVO.setY(rs.getDouble("y"));
				localVO.setWdate(rs.getTimestamp("wdate"));
				array.add(localVO);
			}
		} catch(Exception e) {
			System.out.println("지역목록 오류:" + e.toString());
		}
		return array;
	}
	
	//지역등록
	public void insert(LocalVO localVO) {
		try {
			sql = "select * from local where id = ?";
			ps = Database.CON.prepareStatement(sql);
			ps.setString(1, localVO.getId());
			rs = ps.executeQuery();
			if(!rs.next()) {
				System.out.println(localVO.toString());
				sql = "insert into local(id, name, address, phone, keyword, x, y) values(?, ?, ?, ?, ?, ?, ?)";
				ps = Database.CON.prepareStatement(sql);
				ps.setString(1, localVO.getId());
				ps.setString(2, localVO.getName());
				ps.setString(3, localVO.getAddress());
				ps.setString(4, localVO.getPhone());
				ps.setString(5, localVO.getKeyword());
				ps.setDouble(6, localVO.getX());
				ps.setDouble(7, localVO.getY());
				ps.execute();
			}
		} catch(Exception e) {
			System.out.println("지역등록 오류: " + e.toString());
		}
	}
}