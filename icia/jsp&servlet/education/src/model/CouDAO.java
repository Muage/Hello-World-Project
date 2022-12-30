package model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CouDAO {
	
	// 강좌정보 수정
	public void update(CouVO couVO) {
		try {
			String sql = "update courses set lname = ?, hours = ?, room = ?, capacity = ? where lcode = ?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, couVO.getLname());
			ps.setInt(2, couVO.getHours());
			ps.setString(3, couVO.getRoom());
			ps.setInt(4, couVO.getCapacity());
			ps.setString(5, couVO.getLcode());
			ps.execute();
		} catch(Exception e) {
			System.out.println("강좌정보 수정: " + e.toString());
		}
	}
	
	// 강좌 등록
	public void insert(CouVO couVO) {
		try {
			String sql = "insert into courses(lcode, lname, hours, room, instructor, capacity) values(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, couVO.getLcode());
			ps.setString(2, couVO.getLname());
			ps.setInt(3, couVO.getHours());
			ps.setString(4, couVO.getRoom());
			ps.setString(5, couVO.getInstructor());
			ps.setInt(6, couVO.getCapacity());
			ps.execute();
		} catch(Exception e) {
			System.out.println("강좌등록: " + e.toString());
		}
	}
	
	// 새로운 강좌코드
	public String getCode() {
		String code = "";
		try {
			String sql = "select max(lcode) code from courses";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String scode = rs.getString("code");
				scode = scode.substring(1);
				int icode = Integer.valueOf(scode) + 1;
				code = "N" + icode;
			}
		} catch(Exception e) {
			System.out.println("새로운 강좌코드: " + e.toString());
		}
		return code;
	}
	
	// 강좌 정보
	public CouVO read(String lcode) {
		CouVO couVO = new CouVO();
		try {
			String sql = "select * from cou where lcode = ?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, lcode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				couVO.setLcode(rs.getString("lcode"));
				couVO.setLname(rs.getString("lname"));
				couVO.setHours(rs.getInt("hours"));
				couVO.setRoom(rs.getString("room"));
				couVO.setInstructor(rs.getString("instructor"));
				couVO.setCapacity(rs.getInt("capacity"));
				couVO.setPersons(rs.getInt("persons"));
				couVO.setPname(rs.getString("pname"));
				couVO.setDept(rs.getString("dept"));
			}
		} catch(Exception e) {
			System.out.println("강좌정보: " + e.toString());
		}
		return couVO;
	}
	
	// 강좌 목록
	public JSONObject list(SqlVO sqlVO) {
		JSONObject object = new JSONObject();
		try {
			String sql = "call list('cou', ?, ?, ?, ?, ?, ?)";
			CallableStatement cs = Database.CON.prepareCall(sql);
			cs.setString(1, sqlVO.getKey());
			cs.setString(2, sqlVO.getWord());
			cs.setString(3, sqlVO.getOrder());
			cs.setString(4, sqlVO.getDesc());
			cs.setInt(5, sqlVO.getPage());
			cs.setInt(6, sqlVO.getPer());
			cs.execute();
			
			ResultSet rs = cs.getResultSet();
			JSONArray jArray = new JSONArray();
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("lcode", rs.getString("lcode"));
				obj.put("lname", rs.getString("lname"));
				obj.put("hours", rs.getString("hours"));
				obj.put("room", rs.getString("room"));
				obj.put("instructor", rs.getString("instructor"));
				obj.put("capacity", rs.getString("capacity"));
				obj.put("persons", rs.getString("persons"));
				obj.put("pname", rs.getString("pname"));
				obj.put("dept", rs.getString("dept"));
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
			System.out.println("강좌목록: " + e.toString());
		}
		return object;
	}
}