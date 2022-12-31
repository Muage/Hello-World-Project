package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DAO {
	public JSONObject list(int start) {
		JSONArray jarray=new JSONArray();
		JSONObject jobj=new JSONObject();
		try {
			String sql="select * from view_info order by lecturecode limit ?,5";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setInt(1, start);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				JSONObject obj= new JSONObject();
				obj.put("lecturecode", rs.getString("lecturecode"));
				obj.put("professorsname", rs.getString("professorsname"));
				obj.put("lecturename", rs.getString("lecturename"));
				obj.put("lectureprofessors", rs.getString("lectureprofessors"));
				obj.put("lecturecontent", rs.getString("lecturecontent"));
				obj.put("lectureimage", rs.getString("lectureimage"));
				jarray.add(obj);
			}
			jobj.put("array", jarray);
		}  
		catch (Exception e) {
			System.out.println("강좌목록(main) 오류 : "+e.toString());
		}
		return jobj;
	}
	
	public LectureVO read(String lecturecode) {
		LectureVO vo = new LectureVO();		
		try {
			String sql = "SELECT * FROM view_info where lecturecode=? ";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, lecturecode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vo.setLecturecode(rs.getString("lecturecode"));
				vo.setLecturecontent(rs.getString("lecturecontent"));
				vo.setLectureimage(rs.getString("lectureimage"));
				vo.setLecturename(rs.getString("lecturename"));
				vo.setLectureprofessors(rs.getString("lectureprofessors"));
				vo.setProfessorsname(rs.getString("professorsname"));
			}
		}catch(Exception e) {
			System.out.println("상품정보"+e.toString());
		}
		System.out.println(vo);
		return vo;
		
	}
}
