package model;

public class UsersVO {
	private String usercode;
	private String userid;
	private String username;
	private String userpassword;

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	@Override
	public String toString() {
		return "UsersVO [usercode=" + usercode + ", userid=" + userid + ", username=" + username + ", userpassword="
				+ userpassword + "]";
	}
}
