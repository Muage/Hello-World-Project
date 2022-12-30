package ex17;

import java.sql.*;
import java.util.*;

public class FacilityDAO {
	Connection con = Database.getConnection();
	ArrayList<FacilityVO> array;
	FacilityVO facilityVO;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	String maxCode;
	String newCode;
	int code;
	boolean success;
	
	//특정 캠핑장에 특정 시설물 삭제
	public void delete(String code, String fcode) {
		try {
			sql = "delete from tbl_camp_facility where code = ? and fcode = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, code);
			ps.setString(2, fcode);
			ps.execute();
		} catch(Exception e) {
//			System.out.println("삭제를 확인해주세요. : " + e.toString());
		}
	}
	
	//등록
	public void insert(FacilityVO facilityVO) {
		try {
			sql = "insert into tbl_camp_facility(code, fcode) values(?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, facilityVO.getCode());
			ps.setString(2, facilityVO.getFcode());
			ps.execute();
		} catch(Exception e) {
			System.out.println("등록을 확인해주세요. : " + e.toString());
		}
	}
	
	//특정 캠핑장에 특정 시설물 조회
	public FacilityVO read(String code, String fcode) {
		facilityVO = new FacilityVO();
		try {
			sql = "select * from view_facility where code = ? and fcode = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, code);
			ps.setString(2, fcode);
			rs = ps.executeQuery();
			while(rs.next()) {
				facilityVO.setCode(rs.getString("code"));
				facilityVO.setFcode(rs.getString("fcode"));
				facilityVO.setFname(rs.getString("fname"));
			}
		} catch(Exception e) {
			System.out.println("조회를 확인해주세요. : " + e.toString());
		}
		return facilityVO;
	}
	
	public boolean delete(String fcode) {
		success = false;
		try {
			sql = "delete from tbl_facility where fcode = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, fcode);
			ps.execute();
			success = true;
		} catch(Exception e) {
//			System.out.println("삭제를 확인해주세요. : " + e.toString());
		}
		return success;
	}
	
	public FacilityVO read(String fcode) {
		facilityVO = new FacilityVO();
		try {
			sql = "select * from tbl_facility where fcode = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, fcode);
			rs = ps.executeQuery();
			while(rs.next()) {
				facilityVO.setFcode(rs.getString("fcode"));
				facilityVO.setFname(rs.getString("fname"));
			}
		} catch(Exception e) {
			System.out.println("조회를 확인해주세요. : " + e.toString());
		}
		return facilityVO;
	}
	//시설물 등록
	public void insert(String fcode, String fname) {
		try {
			sql = "insert into tbl_facility values(?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, fcode);
			ps.setString(2, fname);
			ps.execute();
		} catch(Exception e) {
			System.out.println("등록을 확인해주세요. : " + e.toString());
		}
	}
	
	//Max Code 가져오기
	public String getNewCode() {
		newCode = "";
		try {
			sql = "select max(fcode) mcode from tbl_facility";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				maxCode = rs.getString("mcode");
				code = Integer.parseInt(maxCode.substring(1)) + 10;
				newCode = "f" + code;
			}
		} catch (Exception e) {
			System.out.println("코드를 확인해주세요. : " + e.toString());
		}
		return newCode;
	}
	
	//전체 시설물 목록
	public ArrayList<FacilityVO> list() {
		array = new ArrayList<FacilityVO>();
		try {
			sql = "select * from tbl_facility";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				facilityVO = new FacilityVO();
				facilityVO.setFcode(rs.getString("fcode"));
				facilityVO.setFname(rs.getString("fname"));
				
				array.add(facilityVO);
			}
		} catch (Exception e) {
			System.out.println("전체 시설물 목록을 확인해주세요. : " + e.toString());
		}
		return array;
	}
	
	//특정 캠핑장의 시설물 목록
	public ArrayList<FacilityVO> list(String code) {
		array = new ArrayList<FacilityVO>();
		try {
			sql = "select * from view_facility where code = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, code);
			rs = ps.executeQuery();
			while(rs.next()) {
				facilityVO = new FacilityVO();
				facilityVO.setCode(rs.getString("code"));
				facilityVO.setFcode(rs.getString("fcode"));
				facilityVO.setFname(rs.getString("fname"));
				
				array.add(facilityVO);
			}
		} catch (Exception e) {
			System.out.println("시설물 목록을 확인해주세요. : " + e.toString());
		}
		return array;
	}
}
