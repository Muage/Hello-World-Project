package model;

import java.sql.*;

import org.json.simple.*;

public class AddressDAO {
	Connection CON = Database.CON;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	// �ּ� ����
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
				System.out.println("�ּҼ����� Ȯ�����ּ���. : " + e.toString());
			}
		}
		
	// �ּ� ����
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
			System.out.println("�ּ� ������ Ȯ�����ּ���. : " + e.toString());
		}
		return vo;
	}
	
	// �ּ� ����
	public void delete(int id) {
		try {
			sql = "delete from address where id = ?";
			ps = CON.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch(Exception e) {
			System.out.println("������ Ȯ�����ּ���. : " + e.toString());
		}
	}
	// �ּ� ��� ������ (JSON)
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
			System.out.println("�ּҸ���� Ȯ�����ּ���. : " + e.toString());
		}
		return object;
	}
	
	// �ּ� ���
	public void insert(AddressVO vo) {
		try {
			sql = "insert into address(name, tel, address) values(?, ?, ?)";
			ps = CON.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getTel());
			ps.setString(3, vo.getAddress());
			ps.execute();
		} catch(Exception e) {
			System.out.println("�ּҵ���� Ȯ�����ּ���. : " + e.toString());
		}
	}
}
