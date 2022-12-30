package semi01;

import java.sql.*;
import java.text.*;
import java.util.*;

public class AccountDAO {

	public static String[][] getlist() {
		Connection con = Database.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		DecimalFormat dfWon = new DecimalFormat("#,###원");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		AccountVO accountVO;
		ArrayList<String[]> list;
		String[][] array;
		String sql;
		String accountDate;
		
		try {
			sql = "select * from tbl_account order by accountNo";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[] {
					rs.getString("accountNo"),
					rs.getString("accountName"),
					dfWon.format(rs.getInt("balance")),
					rs.getString("accountTypeNo"),
					sdf.format(rs.getDate("accountDate"))				
				});
			}
			array = new String[list.size()][5];
			return list.toArray(array);
		} catch(Exception e) {
			System.out.println("ArrayList를 확인해주세요. : " + e.toString());
			return null;
		}
	}
}