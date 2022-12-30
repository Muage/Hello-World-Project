package javaChapter15;

public class Student {
	public int sno;
	public String name;
	
	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}
	
	public boolean equals(Object obj) {	// 학번과 이름 동일한 경우 true 리턴
		if(obj instanceof Student) {
			Student student = (Student)obj;
			return(sno == student.sno) && (name.equals(student.name));
		} else {
			return false;
		}
	}
	
	public int hashCode() {	// 학번과 이름 같다면 동일한 값 return
		return sno + name.hashCode();
	}
}
