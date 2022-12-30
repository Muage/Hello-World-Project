package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ShopDAO {
	String sql;
	PreparedStatement ps;
	ResultSet rs;
	
	// New ID 구하기
	public String newId( ) {
		String newId = "";
		try {
			sql = "select max(id) from shop";
			ps = Database.CON.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String maxId = rs.getString("max(id)".trim());
				long id = Long.valueOf(maxId) + 1;
				newId = String.valueOf(id);
			}
		} catch(Exception e) {
			System.out.println("ID 오류: " + e.toString());
		}
		return newId;
	}
	
	// 전체데이터
	public int count() {
		int count = 0;
		try {
			sql = "select count(*) cnt from shop";
			ps = Database.CON.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch(Exception e) {
			System.out.println("전체데이터 오류: " + e.toString());
		}
		return count;
	}
	
	// 상품목록
	public ArrayList<ShopVO> list(int page) {
		ArrayList<ShopVO> array = new ArrayList<ShopVO>();
		try {
			sql = "select *, date_format(wdate, '%Y-%m-%d %T') fdate from shop order by wdate desc limit ?, 5";
			ps = Database.CON.prepareStatement(sql);
			ps.setInt(1, (page - 1) * 5);
			rs = ps.executeQuery();
			while(rs.next()) {
				ShopVO shopVO = new ShopVO();
				shopVO.setId(rs.getString("id"));
				shopVO.setTitle(rs.getString("title"));
				shopVO.setPrice(rs.getInt("price"));
				shopVO.setBrand(rs.getString("brand"));
				shopVO.setImage(rs.getString("image"));
				shopVO.setWdate(rs.getString("fdate"));
				array.add(shopVO);
			}
		} catch(Exception e) {
			System.out.println("상품목록 오류: " + e.toString());
		}
		return array;
	}

	// 상품등록
	public void insert(ShopVO shopVO) {
		
		try {
			sql = "select * from shop where id = ?";
			ps = Database.CON.prepareStatement(sql);
			ps.setString(1, shopVO.getId());
			rs = ps.executeQuery();
			if(!rs.next()) {
				sql = "insert into shop(id, title, image, price, brand) values(?, ?, ?, ?, ?)";
				ps = Database.CON.prepareStatement(sql);
				ps.setString(1, shopVO.getId());
				ps.setString(2, shopVO.getTitle());
				ps.setString(3, shopVO.getImage());
				ps.setInt(4, shopVO.getPrice());
				ps.setString(5, shopVO.getBrand());
				ps.execute();
			}
		} catch(Exception e) {
			System.out.println("상품등록 오류: " + e.toString());
		}
	}
}
