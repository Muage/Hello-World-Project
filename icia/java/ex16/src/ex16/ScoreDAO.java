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
	
	//���� ����
	public void delete(String sno, String tcode) {
		try {
			sql = "delete from tbl_score where sno = ? and tcode = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, sno);
			ps.setString(2, tcode);
			ps.execute();			
		} catch(Exception e) {
			System.out.println("������ Ȯ�����ּ���. : " + e.toString());
		}
	}
	
	//���� ���
	public void insert(ScoreVO scoreVO) {
		try {
			sql = "insert into tbl_score(sno, tcode, grade) values(?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, scoreVO.getSno());
			ps.setString(2, scoreVO.getTcode());
			ps.setInt(3, scoreVO.getGrade());
			ps.execute();			
		} catch(Exception e) {
			System.out.println("����� Ȯ�����ּ���. : " + e.toString());
		}
	}
	
	//Ư�� �л��� Ư�� ���� �˻�
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
			System.out.println("�˻��� Ȯ�����ּ���. : " + e.toString());
		}
		return count;
	}
	
	
	//Ư�� ���� ���
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
			System.out.println("����� Ȯ�����ּ���. : " + e.toString());
		}
		return array;
	}
}

