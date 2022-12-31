package model;

public class UserVO {
	private String userid;
	private String usercode;
	private String username;
	private String userpassword;
	private String lecturename;
	private String lectureimage;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
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

	public String getLecturename() {
		return lecturename;
	}

	public void setLecturename(String lecturename) {
		this.lecturename = lecturename;
	}

	public String getLectureimage() {
		return lectureimage;
	}

	public void setLectureimage(String lectureimage) {
		this.lectureimage = lectureimage;
	}

	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", usercode=" + usercode + ", username=" + username + ", userpassword="
				+ userpassword + ", lecturename=" + lecturename + ", lectureimage=" + lectureimage + "]";
	}
}
