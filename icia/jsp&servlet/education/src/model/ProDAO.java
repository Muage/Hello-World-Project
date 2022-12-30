package model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ProDAO {
	DecimalFormat df=new DecimalFormat("#,###��");
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	// �������� ����
	public void update(ProVO proVO) {
		try {
			String sql = "update professors set pname = ?, dept = ?, title = ?, salary = ?, hiredate = ? where pcode = ?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, proVO.getPname());
			ps.setString(2, proVO.getDept());
			ps.setString(3, proVO.getTitle());
			ps.setInt(4, proVO.getSalary());
			ps.setString(5, proVO.getHiredate());
			ps.setString(6, proVO.getPcode());
			ps.execute();
		} catch(Exception e) {
			System.out.println("�������� ����: " + e.toString());
		}
	}
	
	// Ư�� ������ ����ϴ� �л����
	public JSONArray slist(String pcode) {
		JSONArray array = new JSONArray();
		try {
			String sql = "select * from students where advisor = ?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, pcode);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("scode", rs.getString("scode"));
				obj.put("sname", rs.getString("sname"));
				obj.put("dept", rs.getString("dept"));
				obj.put("year", rs.getString("year"));
				String birthday = sdf.format(rs.getDate("birthday"));
				obj.put("birthday", birthday);
				array.add(obj);
			}
		} catch(Exception e) {
			System.out.println("���Ǹ��: " + e.toString());
		}
		return array;
	}
		
	// Ư�� ������ �����ϴ� ���Ǹ��
	public JSONArray clist(String pcode) {
		JSONArray array = new JSONArray();
		try {
			String sql = "select * from courses where instructor = ?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, pcode);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("lcode", rs.getString("lcode"));
				obj.put("lname", rs.getString("lname"));
				obj.put("hours", rs.getString("hours"));
				obj.put("room", rs.getString("room"));
				obj.put("instructor", rs.getString("instructor"));
				obj.put("capacity", rs.getInt("capacity"));
				obj.put("persons", rs.getInt("persons"));
				array.add(obj);
			}
		} catch(Exception e) {
			System.out.println("���Ǹ��: " + e.toString());
		}
		return array;
	}
	
	// ��������
	public ProVO read(String pcode) {
		ProVO proVO = new ProVO();
		try {
			String sql = "select * from professors where pcode = ?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, pcode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				proVO.setPcode(rs.getString("pcode"));
				proVO.setPname(rs.getString("pname"));
				proVO.setDept(rs.getString("dept"));
				proVO.setTitle(rs.getString("title"));
				proVO.setSalary(rs.getInt("salary"));
				proVO.setHiredate(sdf.format(rs.getDate("hiredate")));
			}
		} catch(Exception e) {
			System.out.println("��������: " + e.toString());
		}
		return proVO;
	}
	
	// �������
	public void insert(ProVO proVO) {
		try {
			String sql = "insert into professors(pcode, pname, dept, title, salary, hiredate) values(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, proVO.getPcode());
			ps.setString(2, proVO.getPname());
			ps.setString(3, proVO.getDept());
			ps.setString(4, proVO.getTitle());
			ps.setInt(5, proVO.getSalary());
			ps.setString(6, proVO.getHiredate());
			ps.execute();
		} catch(Exception e) {
			System.out.println("�������: " + e.toString());
		}
	}
	
	// ���ο� �����ڵ�
	public String getCode() {
		String code = "";
		try {
			String sql = "select max(pcode)+1 code from professors";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) code = rs.getString("code");
		} catch(Exception e) {
			System.out.println("���ο� �����ڵ�: " + e.toString());
		}
		return code;
	}
	
	// �������
	public JSONObject list(SqlVO sqlVO) {
		JSONObject object = new JSONObject();
		try {
			String sql = "call list('professors', ?, ?, ?, ?, ?, ?)";
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
				obj.put("pcode", rs.getString("pcode"));
				obj.put("pname", rs.getString("pname"));
				obj.put("dept", rs.getString("dept"));
				obj.put("title", rs.getString("title"));
				obj.put("hiredate", sdf.format(rs.getDate("hiredate")));
	            obj.put("salary", df.format(rs.getInt("salary")));
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
			System.out.println("�������: " + e.toString());
		}
		return object;
	}
}
