package model;

import java.sql.*;

import org.json.simple.*;

public class AddressDAO {
	Connection CON = Database.CON;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	// 주소 수정
		public void update(AddressVO vo) {
			try {
				sql = "update address set name = ?, tel = ?, address = ? where id = ?";
				ps = CON.prepareStatement(sql);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getTel());
				ps.setString(3, vo.getAddress());
				ps.setInt(4, vo.getId());
				ps.execute();
			} catch(Exception e) {
				System.out.println("주소수정을 확인해주세요. : " + e.toString());
			}
		}
		
	// 주소 정보
	public AddressVO read(int id) {
		AddressVO vo = new AddressVO();
		try {
			sql = "select * from address where id = ?";
			ps = CON.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setAddress(rs.getString("address"));
			}
		} catch(Exception e) {
			System.out.println("주소 정보를 확인해주세요. : " + e.toString());
		}
		return vo;
	}
	
	// 주소 삭제
	public void delete(int id) {
		try {
			sql = "delete from address where id = ?";
			ps = CON.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch(Exception e) {
			System.out.println("삭제를 확인해주세요. : " + e.toString());
		}
	}
	// 주소 목록 데이터 (JSON)
	public JSONObject list() {
		JSONObject object = new JSONObject();
		JSONArray array;
		JSONObject obj;
		
		try {
			sql = "select * from address order by name";
			ps = CON.prepareStatement(sql);
			rs = ps.executeQuery();
			array = new JSONArray();
			while(rs.next()) {
				obj = new JSONObject();
				obj.put("id", rs.getInt("id"));
				obj.put("name", rs.getString("name"));
				obj.put("tel", rs.getString("tel"));
				obj.put("address", rs.getString("address"));
				array.add(obj);
			}
			object.put("array", array);
		} catch(Exception e) {
			System.out.println("주소목록을 확인해주세요. : " + e.toString());
		}
		return object;
	}
	
	// 주소 등록
	public void insert(AddressVO vo) {
		try {
			sql = "insert into address(name, tel, address) values(?, ?, ?)";
			ps = CON.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getTel());
			ps.setString(3, vo.getAddress());
			ps.execute();
		} catch(Exception e) {
			System.out.println("주소등록을 확인해주세요. : " + e.toString());
		}
	}
}
