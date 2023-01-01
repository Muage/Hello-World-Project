package com.example.domain;

public class PostVO {
	
	private int p_code;
	private String s_code;
	private String u_code;
	private String m_name;
	private String m_photo;

	public int getP_code() {
		return p_code;
	}

	public void setP_code(int p_code) {
		this.p_code = p_code;
	}

	public String getS_code() {
		return s_code;
	}

	public void setS_code(String s_code) {
		this.s_code = s_code;
	}

	public String getU_code() {
		return u_code;
	}

	public void setU_code(String u_code) {
		this.u_code = u_code;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_photo() {
		return m_photo;
	}

	public void setM_photo(String m_photo) {
		this.m_photo = m_photo;
	}

	@Override
	public String toString() {
		return "PostVO [p_code=" + p_code + ", s_code=" + s_code + ", u_code=" + u_code + ", m_name=" + m_name
				+ ", m_photo=" + m_photo + "]";
	}

}
