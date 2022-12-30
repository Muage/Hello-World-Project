package model;

import java.sql.*;
import java.util.*;

public class BookDAO {
	Connection con = Database.CON;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	//도서갯수
	public int count() {
		int count = 0;
		try {
			sql = "select count(*) cnt from books";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch(Exception e) {
			System.out.println("도서갯수 오류: " + e.toString());
		}
		return count;
	}
	
	//도서목록
	public ArrayList<BookVO> list(int page) {
		ArrayList<BookVO> array = new ArrayList<BookVO>();
		try {
			sql = "select *, date_format(wdate, '%Y-%m-%d %T') fdate from books order by id desc limit ?, 5";
			ps = con.prepareStatement(sql);
			ps.setInt(1, (page - 1) * 5);
			rs = ps.executeQuery();
			while(rs.next()) {
				BookVO bookVO = new BookVO();
				bookVO.setId(rs.getInt("id"));
				bookVO.setTitle(rs.getString("title"));
				bookVO.setContents(rs.getString("contents"));
				bookVO.setWdate(rs.getString("fdate"));
				bookVO.setImage(rs.getString("image"));
				bookVO.setPublisher(rs.getString("publisher"));
				bookVO.setAuthors(rs.getString("authors"));
				bookVO.setPrice(rs.getInt("price"));
				bookVO.setIsbn(rs.getString("isbn"));
				array.add(bookVO);
			}
			
		} catch(Exception e) {
			System.out.println("도서목록 오류: " + e.toString());
		}
		return array;
	}
	
	//도서등록
	public void insert(BookVO bookVO) {
		try {
			sql = "select * from books where isbn = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, bookVO.getIsbn());
			rs = ps.executeQuery();
			if(!rs.next()) {
				System.out.println(bookVO.toString());
				sql = "insert into books(title, contents, image, publisher, authors, price, isbn) values(?, ?, ?, ?, ?, ?, ?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, bookVO.getTitle());
				ps.setString(2, bookVO.getContents());
				ps.setString(3, bookVO.getImage());
				ps.setString(4, bookVO.getPublisher());
				ps.setString(5, bookVO.getAuthors());
				ps.setInt(6, bookVO.getPrice());
				ps.setString(7, bookVO.getIsbn());
				ps.execute();
			}
		} catch(Exception e) {
			System.out.println("도서등록 오류: " + e.toString());
		}
	}
}
