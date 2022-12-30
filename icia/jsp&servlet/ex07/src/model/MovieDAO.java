package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MovieDAO {
	String sql;
	PreparedStatement ps;
	ResultSet rs;
	
	// 영화 삭제
	public void delete(int id) {
		try {
			sql = "delete from movie where id = ?";
			ps = Database.CON.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			
		} catch(Exception e) {
			System.out.println("영화삭제 오류: " + e.toString());
		}
	}
	
	// 영화 목록
	public ArrayList<MovieVO> list(int page) {
		ArrayList<MovieVO> array = new ArrayList<MovieVO>();
		try {
			sql = "select * from movie order by wdate desc limit ?, 5";
			ps = Database.CON.prepareStatement(sql);
			ps.setInt(1, (page - 1) * 5);
			rs = ps.executeQuery();
			while(rs.next()) {
				MovieVO movieVO = new MovieVO();
				movieVO.setId(rs.getInt("id"));
				movieVO.setTitle(rs.getString("title"));
				movieVO.setImage(rs.getString("image"));
				movieVO.setActor(rs.getString("actor"));
				movieVO.setDirector(rs.getString("director"));
				movieVO.setLink(rs.getString("link"));
				movieVO.setPubDate(rs.getString("pubDate"));
				movieVO.setWdate(rs.getTimestamp("wdate"));
				
				array.add(movieVO);
			}
		} catch(Exception e) {
			System.out.println("데이터수: " + e.toString());
		}
		return array;
	}
	
	// 데이터수
	public int count() {
		int count = 0;
		try {
			sql = "select count(*) from movie";
			ps = Database.CON.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) count = rs.getInt("count(*)");
		} catch(Exception e) {
			System.out.println("데이터수: " + e.toString());
		}
		return count;
	}
	
	// 영화 등록
	public void insert(MovieVO movieVO) {
		try {
			sql = "select * from movie where link = ?";
			ps = Database.CON.prepareStatement(sql);
			ps.setString(1, movieVO.getLink());
			rs = ps.executeQuery();
			if(!rs.next()) {
				sql = "insert into movie(title, image, actor, director, link, pubDate) values(?, ?, ?, ?, ?, ?)";
				ps = Database.CON.prepareStatement(sql);
				ps.setString(1, movieVO.getTitle());
				ps.setString(2, movieVO.getImage());
				ps.setString(3, movieVO.getActor());
				ps.setString(4, movieVO.getDirector());
				ps.setString(5, movieVO.getLink());
				ps.setString(6, movieVO.getPubDate());
				ps.execute();
			}
			
		} catch(Exception e) {
			System.out.println("영화등록 오류: " + e.toString());
		}
	}
}
