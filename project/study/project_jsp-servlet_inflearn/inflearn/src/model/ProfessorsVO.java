package model;

public class ProfessorsVO {
	private String professorscode;
	private String professorsname;

	public String getProfessorscode() {
		return professorscode;
	}

	public void setProfessorscode(String professorscode) {
		this.professorscode = professorscode;
	}

	public String getProfessorsname() {
		return professorsname;
	}

	public void setProfessorsname(String professorsname) {
		this.professorsname = professorsname;
	}

	@Override
	public String toString() {
		return "ProfessorsVO [professorscode=" + professorscode + ", professorsname=" + professorsname + "]";
	}
}
