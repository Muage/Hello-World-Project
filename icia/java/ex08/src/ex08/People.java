package ex08;

public class People {
	private String jno;
	private String name;
	
	//�⺻������
	public People() {
		
	}

	//������(�����ε� : �Ű������� ������ �ٸ� �� ���)
	public People(String jno, String name) {
		this.jno = jno;
		this.name = name;
	}
	
	//���� ��� �޼ҵ�
	public void print() {
		System.out.println("�ֹι�ȣ : " + jno);
		System.out.println("�̸� : " + name);
	}

	public String getJno() {
		return jno;
	}

	public void setJno(String jno) {
		this.jno = jno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
