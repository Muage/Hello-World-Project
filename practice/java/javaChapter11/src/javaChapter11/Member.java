package javaChapter11;

// ��ü ���� ��(equals() �޼���)
public class Member {
	public String id;
	
	public Member(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {	// �Ķ���Ͱ� Member Ÿ������ Ȯ��
			Member member = (Member)obj;	// Member Ÿ�� ���� ��ȯ
			if(id.equals(member.id)) {	// id �ʵ尪 �������� �˻�
				return true;	// �����ϸ� true ����
			}
		}
		return false;	// �Ķ���Ͱ� Member Ÿ�� �ƴϰų� id �ʵ尪 �ٸ��� false ����
	}
}
