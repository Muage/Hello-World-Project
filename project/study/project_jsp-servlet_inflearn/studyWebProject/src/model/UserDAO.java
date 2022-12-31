package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class UserDAO {
	// userid primary key여야 하지 않은지 확인
	
	// 로그인 확인
	public UserVO login(String userid) {
		UserVO userVo = new UserVO();
		try {
			String sql = "select * from users where userid = ?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, userid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				userVo.setUserid(rs.getString("userid"));
				userVo.setUserpassword(rs.getString("userpassword"));
				userVo.setUsername(rs.getString("username"));
			}
		} catch(Exception e) {
			System.out.println("UserDAO login: " + e.toString());
		}
		return userVo;
	}
	
	// 로그인 된 사용자의 강의목록
	public JSONArray list(String userid) {
		JSONArray array = new JSONArray();
		PreparedStatement ps;
		ResultSet rs;
		String sql;
		
		try {
			sql = "select * from user_enrollments where userid = ?";
			ps = Database.CON.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("userid", rs.getString("userid"));
				obj.put("username", rs.getString("username"));
				obj.put("lecturename", rs.getString("lecturename"));
				obj.put("lectureimage", rs.getString("lectureimage"));
				array.add(obj);
			}
		} catch(Exception e) {
			System.out.println("UserDAO-list: " + e.toString());
		}
		return array;
	}
	
//	public JSONObject list(SqlVO sqlVO) {
//		CallableStatement cs;
//		ResultSet rs;
//		JSONObject object = new JSONObject();
//		String sql;
//		
//		try {
//			sql = "call list('user_enrollments', ?, ?, ?, ?, ?, ?)";
//			cs = Database.CON.prepareCall(sql);
//			cs.setString(1, sqlVO.getKey());
//			cs.setString(2, sqlVO.getWord());
//			cs.setString(3, sqlVO.getOrder());
//			cs.setString(4, sqlVO.getDesc());
//			cs.setInt(5, sqlVO.getPage());
//			cs.setInt(6, sqlVO.getPer());
//			cs.execute();
//			
//			rs = cs.getResultSet();
//			JSONArray jArray = new JSONArray();
//			while(rs.next()) {
//				JSONObject obj = new JSONObject();
//				obj.put("userid", rs.getString("userid"));
//				obj.put("usercode", rs.getString("usercode"));
//				obj.put("username", rs.getString("username"));
//				obj.put("lecturename", rs.getString("lecturename"));
//				obj.put("lectureimage", rs.getString("lectureimage"));
//				jArray.add(obj);
//			}
//			object.put("array", jArray);
//			
//			cs.getMoreResults();
//			rs = cs.getResultSet();
//			
//			int total = 0;
//			if(rs.next()) total = rs.getInt("total");
//			object.put("total", total);
//			
//			int last = total % sqlVO.getPer() == 0 ? total / sqlVO.getPer() : total / sqlVO.getPer() + 1;
//			object.put("last", last);
//		} catch(Exception e) {
//			System.out.println("UserDAO-list: " + e.toString());
//		}
//		return object;
//	}
}