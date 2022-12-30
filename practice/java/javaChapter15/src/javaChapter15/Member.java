package javaChapter15;

public class Member {
	public String name;
	public int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {	// name과 age 값 같으면 true 리턴
		if(obj instanceof Member) {
			Member member = (Member)obj;
			return member.name.equals(name) && (member.age == age);
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {	// name과 age 값 같으면 동일한 hasCode 리턴
		return name.hashCode() + age;
	}
}
