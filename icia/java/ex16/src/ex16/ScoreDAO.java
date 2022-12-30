package ex16;

import java.sql.*;
import java.util.*;
import java.text.*;

public class ScoreDAO {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Connection con = Database.getConnection();
	ArrayList<ScoreVO> array;
	ScoreVO scoreVO = null;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	String tdate;
	int count;
	
	//성적 삭제
	public void delete(String sno, String tcode) {
		try {
			sql = "delete from tbl_score where sno = ? and tcode = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, sno);
			ps.setString(2, tcode);
			ps.execute();			
		} catch(Exception e) {
			System.out.println("삭제를 확인해주세요. : " + e.toString());
		}
	}
	
	//성적 등록
	public void insert(ScoreVO scoreVO) {
		try {
			sql = "insert into tbl_score(sno, tcode, grade) values(?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, scoreVO.getSno());
			ps.setString(2, scoreVO.getTcode());
			ps.setInt(3, scoreVO.getGrade());
			ps.execute();			
		} catch(Exception e) {
			System.out.println("등록을 확인해주세요. : " + e.toString());
		}
	}
	
	//특정 학생의 특정 유형 검색
	public int read(String sno, String tcode) {
		count = 0;
		try {
			sql = "select count(*) cnt from tbl_score where sno = ? and tcode = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, sno);
			ps.setString(2, tcode);
			rs = ps.executeQuery();
			if(rs.next()) count = rs.getInt("cnt");
		} catch(Exception e) {
			System.out.println("검색을 확인해주세요. : " + e.toString());
		}
		return count;
	}
	
	
	//특정 성적 목록
	public ArrayList<ScoreVO> list(String sno) {
		array = new ArrayList<ScoreVO>();
		try {
			sql = "select * from view_score where sno = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, sno);
			rs = ps.executeQuery();
			while(rs.next()) {
				scoreVO = new ScoreVO();
				scoreVO.setSno(rs.getString("sno"));
				scoreVO.setTcode(rs.getString("tcode"));
				scoreVO.setTname(rs.getString("tname"));
				tdate = sdf.format(rs.getDate("tdate"));
				scoreVO.setTdate(tdate);
				scoreVO.setGrade(rs.getInt("grade"));
				array.add(scoreVO);
			}
		} catch (Exception e) {
			System.out.println("목록을 확인해주세요. : " + e.toString());
		}
		return array;
	}
}

