package model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class LoginDAO {	
	// 로그인 확인
	public UsersVO login(String userid) {
		UsersVO userVO = new UsersVO();
		try {
			String sql = "select * from users where userid = ?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, userid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				userVO.setUserid(rs.getString("userid"));
				userVO.setUserpassword(rs.getString("userpassword"));
				userVO.setUsername(rs.getString("username"));
			}
		} catch(Exception e) {
			System.out.println("UserDAO login: " + e.toString());
		}
		return userVO;
	}
}