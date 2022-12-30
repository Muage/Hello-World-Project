package ex17;

import java.sql.*;
import java.util.*;

public class TypeDAO {
	Connection con = Database.getConnection();
	ArrayList<TypeVO> array;
	TypeVO typeVO;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	String newCode;
	String maxCode;
	int code;
	
	//유형 등록
		public void insert(String tcode, String tname) {
			try {
				sql = "insert into tbl_type(tcode, tname) values (?, ?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, tcode);
				ps.setString(2, tname);
				ps.execute();
			} catch(Exception e) {
				System.out.println("유형 등록을 확인해주세요. : " + e.toString());
			}
		}
	
	//캠핑장 유형 등록
	public void insert(TypeVO typeVO) {
		try {
			sql = "insert into view_type (code, tcode, qnt) values (?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, typeVO.getCode());
			ps.setString(2, typeVO.getTcode());
			ps.setInt(3, typeVO.getQnt());
			ps.execute();
		} catch(Exception e) {
			System.out.println("캠핑장 유형 등록을 확인해주세요. : " + e.toString());
		}
	}
	
	//Max Code 구하기
		public String getNewCode() {
			newCode = "";
			try {
				sql = "select max(tcode) mcode from tbl_type";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				if(rs.next()) {
					maxCode = rs.getString("mcode");
					code = Integer.parseInt(maxCode.substring(1)) + 10;
					newCode = "t" + code;
				}
			} catch(Exception e) {
				System.out.println("마지막 코드를 확인해주세요. : " + e.toString());
			}
			return newCode;
		}
	
	//유형 조회
	public TypeVO read(String tcode) {
		typeVO = new TypeVO();
		try {
			sql = "select * from tbl_type where tcode = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, tcode);
			rs = ps.executeQuery();
			if(rs.next()) {
				typeVO = new TypeVO();
				typeVO.setTcode(rs.getString("tcode"));
				typeVO.setTname(rs.getString("tname"));
			}
		} catch(Exception e) {
			System.out.println("유형 조회를 확인해주세요. : " + e.toString());
		}
		return typeVO;
	}
	
	//특정 캠핑장 특정 유형 조회
		public TypeVO read(String code, String tcode) {
			typeVO = new TypeVO();
			try {
				sql = "select * from view_type where code = ? and tcode = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, code);
				ps.setString(2, tcode);
				rs = ps.executeQuery();
				if(rs.next()) {
					typeVO = new TypeVO();
					typeVO.setCode(rs.getString("code"));
					typeVO.setTcode(rs.getString("tcode"));
					typeVO.setTname(rs.getString("tname"));
					typeVO.setQnt(rs.getInt("qnt"));
				}
			} catch(Exception e) {
				System.out.println("유형 조회를 확인해주세요. : " + e.toString());
			}
			return typeVO;
		}
	
	//유형 목록
	public ArrayList<TypeVO> list() {
		array = new ArrayList<TypeVO>();
		try {
			sql = "select * from tbl_type order by tcode";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				typeVO = new TypeVO();
				typeVO.setTcode(rs.getString("tcode"));
				typeVO.setTname(rs.getString("tname"));
				
				array.add(typeVO);
			}
		} catch(Exception e) {
			System.out.println("유형 목록을 확인해주세요. : " + e.toString());
		}
		return array;
	}
	
	//특정 캠핑장의 유형 목록
	public ArrayList<TypeVO> list(String code) {
		array = new ArrayList<TypeVO>();
		try {
			sql = "select * from view_type where code = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, code);
			rs = ps.executeQuery();
			while(rs.next()) {
				typeVO = new TypeVO();
				typeVO.setCode(rs.getString("code"));
				typeVO.setTcode(rs.getString("tcode"));
				typeVO.setTname(rs.getString("tname"));
				typeVO.setQnt(rs.getInt("qnt"));
				
				array.add(typeVO);
			}
		} catch(Exception e) {
			System.out.println("특정 캠핑장 유형 목록을 확인해주세요. : " + e.toString());
		}
		return array;
	}
	
	//유형 삭제
	public boolean delete(String tcode) {
		
		try {
			sql = "delete from tbl_type where tcode = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, tcode);
			ps.execute();
			System.out.println("유형 삭제가 완료되었습니다.\n");
			return true;
		} catch(Exception e) {
			System.out.println("이 유형을 사용중인 캠핑장이 있어 삭제할 수 없습니다.\n");
//				System.out.println("유형 삭제를 확인해주세요. : " + e.toString());
		}
		return false;
	}
	//캠핑장 유형 삭제
	public boolean delete(String code, String tcode) {
		try {
			sql = "delete from tbl_camp_type where code = ? and tcode = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, code);
			ps.setString(2, tcode);
			ps.execute();
			return true;
		} catch(Exception e) {
				System.out.println("캠핑장 유형 삭제를 확인해주세요. : " + e.toString());
		}
		return false;
	}	
}
