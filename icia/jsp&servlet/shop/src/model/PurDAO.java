package model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PurDAO {
	DecimalFormat df=new DecimalFormat("#,###");
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	// 주문상품 등록
	public void insert(OrderVO vo) {
		try {
			String sql = "insert into orders(order_id, prod_id, price, quantity) values(?, ?, ?, ?)";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, vo.getOrder_id());
			ps.setString(2, vo.getProd_id());
			ps.setInt(3, vo.getPrice());
			ps.setInt(4, vo.getQnt());
			ps.execute();
		} catch(Exception e) {
			System.out.println("PurDAO insert(OrderVO): " + e.toString());
		}
	}
	
	// 등록
	public JSONObject insert(PurVO vo) {
		JSONObject obj = new JSONObject();
		try {
			String sql = "select concat('R', max(substr(order_id, 2, 3) + 1)) code from purchase";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vo.setOrder_id(rs.getString("code"));
				obj.put("code", vo.getOrder_id());
				sql = "insert into purchase(order_id, name, address, email, tel, payType) values(?, ?, ?, ?, ?, ?)";
				ps = Database.CON.prepareStatement(sql);
				ps.setString(1, vo.getOrder_id());
				ps.setString(2, vo.getName());
				ps.setString(3, vo.getAddress());
				ps.setString(4, vo.getEmail());
				ps.setString(5, vo.getTel());
				ps.setString(6, vo.getPayType());
				ps.execute();
			}
		} catch(Exception e) {
			System.out.println("PurDAO insert(PurVO): " + e.toString());
		}
		return obj;
	}
	
	// 상태변경
	public void updateStatus(String id, String status) {
		try {
			String sql = "update purchase set status = ? where order_id = ?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, status);
			ps.setString(2, id);
			ps.execute();
		} catch(Exception e) {
			System.out.println("PurDAO updateStatus: " + e.toString());
		}
	}
	
	// 정보
	public JSONObject read(String id) {
		JSONObject obj = new JSONObject();
		try {
			String sql = "call order_info(?)";
			CallableStatement cs = Database.CON.prepareCall(sql);
			cs.setString(1, id);
			cs.execute();
			
			ResultSet rs = cs.getResultSet();
			if(rs.next()) {
				JSONObject ob = new JSONObject();
				ob.put("order_id", rs.getString("order_id"));
				ob.put("name", rs.getString("name"));
				ob.put("address", rs.getString("address"));
				ob.put("email", rs.getString("email"));
				ob.put("tel", rs.getString("tel"));
				String pdate = sdf.format(rs.getTimestamp("pdate"));
				ob.put("pdate", pdate);
				ob.put("payType", rs.getString("payType"));
				ob.put("status", rs.getString("status"));
				obj.put("pur", ob);
			}
			
			cs.getMoreResults();
			rs = cs.getResultSet();
			JSONArray array = new JSONArray();
			int total = 0;
			while(rs.next()) {
				JSONObject ob = new JSONObject();
				ob.put("order_id", rs.getString("order_id"));
				ob.put("prod_id", rs.getString("prod_id"));
				ob.put("price", df.format(rs.getInt("price")));
				ob.put("qnt", df.format(rs.getInt("quantity")));
				ob.put("prod_name", rs.getString("prod_name"));
				ob.put("company", rs.getString("company"));
				ob.put("image", rs.getString("image"));
				ob.put("sum", df.format(rs.getInt("total")));
				total += rs.getInt("total");
				array.add(ob);
			}
			obj.put("array", array);
			obj.put("total", df.format(total));
		} catch(Exception e) {
			System.out.println("PurDAO read: " + e.toString());
		}
		return obj;
	}
	
	// 목록
	public JSONObject list(SqlVO svo) {
		JSONObject object = new JSONObject();
		try {
			String sql = "call list('purchase', ?, ?, ?, ?, ?, ?)";
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
				obj.put("order_id", rs.getString("order_id"));
				obj.put("name", rs.getString("name"));
				obj.put("address", rs.getString("address"));
				obj.put("email", rs.getString("email"));
				obj.put("tel", rs.getString("tel"));
				String pdate = sdf.format(rs.getTimestamp("pdate"));
				obj.put("pdate", pdate);
				obj.put("payType", rs.getString("payType"));
				obj.put("status", rs.getString("status"));
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
			System.out.println("PurDAO list: " + e.toString());
		}
		return object;
	}
}
