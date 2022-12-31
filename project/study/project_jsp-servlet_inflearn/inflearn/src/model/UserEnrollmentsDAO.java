package model;

import java.sql.CallableStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class UserEnrollmentsDAO {
	// 로그인 된 사용자의 강의목록
	public JSONObject list(SqlVO sqlVO) {
		CallableStatement cs;
		ResultSet rs;
		JSONObject object = new JSONObject();
		String sql;
		
		try {
			sql = "call userEnrollmentsList('view_user_enrollments', ?, ?, ?, ?, ?, ?)";
			cs = Database.CON.prepareCall(sql);
			cs.setString(1, sqlVO.getKey());
			cs.setString(2, sqlVO.getWord());
			cs.setString(3, sqlVO.getOrder());
			cs.setString(4, sqlVO.getDesc());
			cs.setInt(5, sqlVO.getPage());
			cs.setInt(6, sqlVO.getPer());
			cs.execute();
			
			rs = cs.getResultSet();
			JSONArray jArray = new JSONArray();
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("lecturename", rs.getString("lecturename"));
				obj.put("lectureimage", rs.getString("lectureimage"));
				obj.put("signup", rs.getString("signup"));
				obj.put("learndate", rs.getString("learndate"));
				obj.put("progress", rs.getInt("progress"));
				jArray.add(obj);
			}
			object.put("array", jArray);
			
			cs.getMoreResults();
			rs = cs.getResultSet();
			
			int total = 0;
			if(rs.next()) total = rs.getInt("total");
			object.put("total", total);
			
			int last = total % sqlVO.getPer() == 0 ? total / sqlVO.getPer() : total / sqlVO.getPer() + 1;
			object.put("last", last);
		} catch(Exception e) {
			System.out.println("UserEnrollmentsDAO-list: " + e.toString());
		}
		return object;
	}
}
