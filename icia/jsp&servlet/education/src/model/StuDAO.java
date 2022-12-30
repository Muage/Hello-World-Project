package model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class StuDAO {
	DecimalFormat df=new DecimalFormat("#,###원");
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	// 학생정보 수정
	public void update(StuVO stuVO) {
		try {
			String sql = "update students set sname = ?, year = ?, birthday = ?, advisor = ? where scode = ?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, stuVO.getSname());
			ps.setString(2, stuVO.getYear());
			ps.setString(3, stuVO.getBirthday());
			ps.setString(4, stuVO.getAdvisor());
			ps.setString(5, stuVO.getScode());
			ps.execute();
		} catch(Exception e) {
			System.out.println("학생정보 수정: " + e.toString());
		}
	}
	
	// 학생정보
	public ProVO read(String scode) {
		StuVO stuVO = new StuVO();
		try {
			String sql = "select * from stu where scode = ?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, scode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				stuVO.setScode(rs.getString("scode"));
				stuVO.setSname(rs.getString("sname"));
				stuVO.setDept(rs.getString("dept"));
				stuVO.setAdvisor(rs.getString("advisor"));
				stuVO.setYear(rs.getString("year"));
				String birthday = sdf.format(rs.getDate("birthday"));
				stuVO.setBirthday(birthday);
				stuVO.setPname(rs.getString("pname"));
			}
		} catch(Exception e) {
			System.out.println("학생정보: " + e.toString());
		}
		return stuVO;
	}
	
	// 학생등록
	public void insert(StuVO stuVO) {
		try {
			String sql = "insert into students(scode, sname, dept, advisor, birthday, year) values(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, stuVO.getScode());
			ps.setString(2, stuVO.getSname());
			ps.setString(3, stuVO.getDept());
			ps.setString(4, stuVO.getAdvisor());
			ps.setString(5, stuVO.getBirthday());
			ps.setString(6, stuVO.getYear());
			ps.execute();
		} catch(Exception e) {
			System.out.println("학생등록: " + e.toString());
		}
	}
	
	// 새로운 학생코드
	public String getCode() {
		String code = "";
		try {
			String sql = "select max(scode)+1 code from students";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) code = rs.getString("code");
		} catch(Exception e) {
			System.out.println("새로운 학생코드: " + e.toString());
		}
		return code;
	}
	
	// 학생목록
	public JSONObject list(SqlVO sqlVO) {

		JSONObject object = new JSONObject();
		try {
			String sql = "call list('stu', ?, ?, ?, ?, ?, ?)";
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
				obj.put("scode", rs.getString("scode"));
				obj.put("sname", rs.getString("sname"));
				obj.put("dept", rs.getString("dept"));
				obj.put("year", rs.getString("year"));
				obj.put("birthday", sdf.format(rs.getDate("birthday")));
				obj.put("advisor", rs.getString("advisor"));
				obj.put("pname", rs.getString("pname"));
				obj.put("pdept", rs.getString("pdept"));
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
			System.out.println("학생목록: " + e.toString());
		}
		return object;
	}
}
