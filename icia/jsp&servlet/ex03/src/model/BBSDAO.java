package model;

import java.sql.*;
import java.util.*;

public class BBSDAO {
	Connection con = Database.CON;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	//게시글 삭제
	public void delete(int no) {
		try {
			sql = "delete from bbs where no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			ps.execute();
		} catch(Exception e) {
			System.out.println("게시글수정 오류 : " + e.toString());
		}
	}
		
	//게시글 수정
	public void update(BBSVO bbsVO) {
		try {
			sql = "update bbs set title = ?, content = ?, wdate = now() where no = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, bbsVO.getTitle());
			ps.setString(2, bbsVO.getContent());
			ps.setInt(3, bbsVO.getNo());
			ps.execute();
		} catch(Exception e) {
			System.out.println("게시글수정 오류 : " + e.toString());
		}
	}
	
	//게시글 정보
	public BBSVO read(int no) {
		BBSVO bbsVO = new BBSVO();
		try {
			sql = "select *, date_format(wdate, '%Y-%m-%d %T') fdate from bbs where no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if(rs.next()) {
				bbsVO.setNo(rs.getInt("no"));
				bbsVO.setTitle(rs.getString("title"));
				bbsVO.setContent(rs.getString("content"));
				bbsVO.setWriter(rs.getString("writer"));
				bbsVO.setWdate(rs.getString("fdate"));
			}
		} catch(Exception e) {
			System.out.println("게시글정보 오류 : " + e.toString());
		}
		return bbsVO;
	}
	
	//전체글수
	public int count(String type, String query) {
		int count = 0;
		try {
			sql = "select count(*) cnt from bbs where " + type + " like ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + query + "%");
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch(Exception e) {
			System.out.println("전체글수 오류 : " + e.toString());
		}
		return count;
	}
	
	//게시글 목록
	public ArrayList<BBSVO> list(int page, String type, String query) {
		ArrayList<BBSVO> array = new ArrayList<BBSVO>();
		BBSVO bbsVO;
		
		try {
			sql = "select *, date_format(wdate, '%Y-%m-%d %T') fdate from bbs where " + type + " like ? order by no desc limit ?, 5";
			int start = (page - 1) * 5;
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + query + "%");
			ps.setInt(2, start);
			rs = ps.executeQuery();
			while(rs.next()) {
				bbsVO = new BBSVO();
				bbsVO.setNo(rs.getInt("no"));
				bbsVO.setTitle(rs.getString("title"));
				bbsVO.setContent(rs.getString("content"));
				bbsVO.setWriter(rs.getString("writer"));
				bbsVO.setWdate(rs.getString("fdate"));
				array.add(bbsVO);
			}
		} catch(Exception e) {
			System.out.println("게시글목록 오류 : " + e.toString());
		}
		return array;
	}
	
	//게시글 등록
	public void insert(BBSVO bbsVO) {
		try {
			sql = "insert into bbs(title, content, writer) values(?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, bbsVO.getTitle());
			ps.setString(2, bbsVO.getContent());
			ps.setString(3, bbsVO.getWriter());
			ps.execute();
		} catch(Exception e) {
			System.out.println("게시글등록 오류 : " + e.toString());
		}
	}
}
