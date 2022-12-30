package javaChapter11;

// 객체 동등 비교(equals() 메서드)
public class Member {
	public String id;
	
	public Member(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {	// 파라미터값 Member 타입인지 확인
			Member member = (Member)obj;	// Member 타입 강제 변환
			if(id.equals(member.id)) {	// id 필드값 동일한지 검사
				return true;	// 동일하면 true 리턴
			}
		}
		return false;	// 파라미터값 Member 타입 아니거나 id 필드값 다르면 false 리턴
	}
}
