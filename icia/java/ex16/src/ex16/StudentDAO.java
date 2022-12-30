package ex16;

import java.sql.*;
import java.util.*;

public class StudentDAO {
	Connection con = Database.getConnection();
	ArrayList<StudentVO> array;
	PreparedStatement ps;
	ResultSet rs;
	StudentVO studentVO;
	String sql;
	String maxNo;
	boolean success;
	
	//삭제
	public boolean delete(String sno) {
		success = false;
		try {
			sql = "delete from tbl_student where sno = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, sno);
			ps.execute();
			success = true;
			
		} catch(Exception e) {
//			System.out.println("삭제를 확인해주세요. : " + e.toString());
		}
		return success;
	}
	
	//수정
	public void update(StudentVO studentVO) {
		try {
			sql = "update tbl_student set sname = ?, dcode = ? where sno = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, studentVO.getSname());
			ps.setString(2, studentVO.getDcode());
			ps.setString(3, studentVO.getSno());
			ps.execute();
		} catch(Exception e) {
			System.out.println("입력을 확인해주세요. : " + e.toString());
		}
	}
	
	//Max 학번 구하기
	public String maxNo() {
		maxNo = "";
		try {
			sql = "select max(sno) mno from view_student";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				maxNo = rs.getString("mno");
			}
		} catch(Exception e) {
			System.out.println("마지막 학번을 확인해주세요. : " + e.toString());
		}
		
		return maxNo;
	}
	//입력
	public void insert(StudentVO studentVO) {
		try {
			sql = "insert into tbl_student(sno, sname, dcode) values(?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, studentVO.getSno());
			ps.setString(2, studentVO.getSname());
			ps.setString(3, studentVO.getDcode());
			ps.execute();
		} catch(Exception e) {
			System.out.println("입력을 확인해주세요. : " + e.toString());
		}
	}
	
	//조회
	public StudentVO read(String sno) {
		StudentVO studentVO = new StudentVO();
		try {
			sql = "select * from view_student where sno = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, sno);
			rs = ps.executeQuery();
			while(rs.next()) {
				studentVO = new StudentVO();
				studentVO.setSno(rs.getString("sno"));
				studentVO.setSname(rs.getString("sname"));
				studentVO.setDcode(rs.getString("dcode"));
				studentVO.setDname(rs.getString("dname"));
			}
		} catch(Exception e) {
			System.out.println("조회를 확인해주세요. : " + e.toString());
		}
		return studentVO;
	}
	
	//목록
	public ArrayList<StudentVO> list() {
		array = new ArrayList<StudentVO>();
		try {
			sql = "select * from view_student order by sno";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				studentVO = new StudentVO();
				studentVO.setSno(rs.getString("sno"));
				studentVO.setSname(rs.getString("sname"));
				studentVO.setDcode(rs.getString("dcode"));
				studentVO.setDname(rs.getString("dname"));
				array.add(studentVO);
			}
		} catch(Exception e) {
			System.out.println("목록을 확인해주세요. : " + e.toString());
		}
		return array;
	}
}
