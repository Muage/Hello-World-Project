package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EnrollDAO {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	// Ư�� ������ Ư�� �л� ���� ����
	public void update(String lcode, String scode, int grade) {
		try {
			String sql = "update enrollments set grade = ? where lcode = ? and scode = ?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setInt(1, grade);
			ps.setString(2, lcode);
			ps.setString(3, scode);
			ps.execute();
		} catch(Exception e) {
			System.out.println("Ư������ Ư���л� ��������: " + e.toString());
		}
	}
	
	// �������
	public void delete(String lcode, String scode) {
		try {
			String sql = "delete from enrollments where lcode = ? and scode = ?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, lcode);
			ps.setString(2, scode);
			ps.execute();
			
			sql = "update courses set persons = persons - 1 where lcode = ?";
			ps = Database.CON.prepareStatement(sql);
			ps.setString(1, lcode);
			ps.execute();
		} catch(Exception e) {
			System.out.println("�������: " + e.toString());
		}
	}
	
	// ������û
	public void insert(String lcode, String scode) {
		try {
			String sql = "insert into enrollments(lcode, scode) values(?, ?)";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, lcode);
			ps.setString(2, scode);
			ps.execute();
			
			sql = "update courses set persons = persons + 1 where lcode = ?";
			ps = Database.CON.prepareStatement(sql);
			ps.setString(1, lcode);
			ps.execute();
		} catch(Exception e) {
			System.out.println("������û: " + e.toString());
		}
	}
	
	// �ߺ�üũ
	public int check(String lcode, String scode) {
		int count = 0;
		try {
			String sql = "select count(*) from enrollments where lcode = ? and scode = ?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, lcode);
			ps.setString(2, scode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) count = rs.getInt("count(*)");
		} catch(Exception e) {
			System.out.println("�ߺ�üũ: " + e.toString());
		}
		return count;
	}
	
	// ���� ���
	public JSONArray alist() {
		JSONArray array = new JSONArray();
		try {
			String sql = "select * from cou";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("lcode", rs.getString("lcode"));
				obj.put("lname", rs.getString("lname"));
				obj.put("pname", rs.getString("pname"));
				obj.put("capacity", rs.getInt("capacity"));
				obj.put("persons", rs.getInt("persons"));

				array.add(obj);
			}
		} catch(Exception e) {
			System.out.println("���¸��: " + e.toString());
		}
		return array;
	}
	
	// Ư�� ������ �л� ���
	public JSONArray slist(String lcode) {
		JSONArray array = new JSONArray();
		try {
			String sql = "select * from estu where lcode = ?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, lcode);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("scode", rs.getString("scode"));
				obj.put("sname", rs.getString("sname"));
				obj.put("dept", rs.getString("dept"));
				obj.put("year", rs.getString("year"));
				String edate = sdf.format(rs.getDate("edate"));
				obj.put("edate", edate);
				obj.put("grade", rs.getString("grade"));
				
				array.add(obj);
			}
		} catch(Exception e) {
			System.out.println("Ư�������л����: " + e.toString());
		}
		return array;
	}
	
	// Ư�� �л��� ������û ���
	public JSONArray clist(String scode) {
		JSONArray array = new JSONArray();
		try {
			String sql = "select * from ecou where scode = ?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, scode);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("lcode", rs.getString("lcode"));
				obj.put("lname", rs.getString("lname"));
				obj.put("pname", rs.getString("pname"));
				obj.put("room", rs.getString("room"));
				obj.put("hours", rs.getString("hours"));
				obj.put("capacity", rs.getString("capacity"));
				obj.put("persons", rs.getString("persons"));
				String edate = sdf.format(rs.getDate("edate"));
				obj.put("edate", edate);
				
				array.add(obj);
			}
		} catch(Exception e) {
			System.out.println("���¸��: " + e.toString());
		}
		return array;
	}
}
