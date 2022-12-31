package model;

public class LectureVO extends ProfessorsVO {
	private String lecturecode;
	private String lecturename;
	private String lectureimage;
	private String lecturecontent;
	private String lectureprofessors;

	public String getLecturecode() {
		return lecturecode;
	}

	public void setLecturecode(String lecturecode) {
		this.lecturecode = lecturecode;
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

	public String getLecturecontent() {
		return lecturecontent;
	}

	public void setLecturecontent(String lecturecontent) {
		this.lecturecontent = lecturecontent;
	}

	public String getLectureprofessors() {
		return lectureprofessors;
	}

	public void setLectureprofessors(String lectureprofessors) {
		this.lectureprofessors = lectureprofessors;
	}

	@Override
	public String toString() {
		return "LectureVO [lecturecode=" + lecturecode + ", lecturename=" + lecturename + ", lectureimage="
				+ lectureimage + ", lecturecontent=" + lecturecontent + ", lectureprofessors=" + lectureprofessors
				+ "]";
	}
}
