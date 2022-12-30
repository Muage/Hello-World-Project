package model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MallDAO {
	DecimalFormat df=new DecimalFormat("#,###원");
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	// 목록
		public JSONObject list(SqlVO svo) {
			JSONObject object = new JSONObject();
			try {
				String sql = "call list('mall', ?, ?, ?, ?, ?, ?)";
				CallableStatement cs = Database.CON.prepareCall(sql);
				cs.setString(1, svo.getKey());
				cs.setString(2, svo.getWord());
				cs.setString(3, svo.getOrder());
				cs.setString(4, svo.getDesc());
				cs.setInt(5, svo.getPage());
				cs.setInt(6, svo.getPer());
				cs.execute();
				
				ResultSet rs = cs.getResultSet();
				JSONArray jArray = new JSONArray();
				while(rs.next()) {
					JSONObject obj = new JSONObject();
					obj.put("mall_id", rs.getString("mall_id"));
					obj.put("mall_name", rs.getString("mall_name"));
					obj.put("manager", rs.getString("manager"));
					obj.put("address", rs.getString("address"));
					obj.put("tel", rs.getString("tel"));
					obj.put("email", rs.getString("email"));
					jArray.add(obj);
				}
				object.put("array", jArray);
				
				cs.getMoreResults();
				rs = cs.getResultSet();
				int total = 0;
				if(rs.next()) total = rs.getInt("total");
				object.put("total", total);
				
				int last = total % svo.getPer() == 0 ? total / svo.getPer() : total / svo.getPer() + 1;
				object.put("last", last);
			} catch(Exception e) {
				System.out.println("MallDAO 목록: " + e.toString());
			}
			return object;
		}
}
