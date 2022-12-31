package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {
	// 게시판 목록
	public ArrayList<BoardVO> list(int page, String type, String query) {
		ArrayList<BoardVO> array = new ArrayList<BoardVO>();
		PreparedStatement ps;
		ResultSet rs;
		BoardVO boardVO;
		String sql;
		String word;
		int start;
		
		try {
			word = "%" + query + "%";
			start = (page - 1) * 5;
			sql = "select *, date_format(writeDate, '%Y-%m-%d %T') fdate from board where " + type + " like ? order by id desc limit ?, 5";
			
			ps = Database.CON.prepareStatement(sql);
			ps.setString(1, word);
			ps.setInt(2, start);
			rs = ps.executeQuery();
			while(rs.next()) {
				boardVO = new BoardVO();
				boardVO.setId(rs.getInt("id"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setUserid(rs.getString("userid"));
				boardVO.setWriteDate(rs.getString("writeDate"));
				array.add(boardVO);
			}
//			System.out.println("word..." + word);
//			System.out.println("start..." + start);
//			System.out.println("sql..." + sql);
		} catch(Exception e) {
			System.out.println("BoardDAO-list 오류 : " + e.toString());
		}
		return array;
	}
	
	// 게시글 수
	public int count(String type, String query) {
		PreparedStatement ps;
		ResultSet rs;
		String sql;
		String word;
		int count = 0;
		
		try {
			word = "%" + query + "%";
			sql = "select count(*) cnt from board where " + type + " like ?";
			
			ps = Database.CON.prepareStatement(sql);
			ps.setString(1, word);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch(Exception e) {
			System.out.println("BoardDAO-count 오류 : " + e.toString());
		}
		return count;
	}
}
