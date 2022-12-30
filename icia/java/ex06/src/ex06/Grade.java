package ex06;

import java.text.DecimalFormat;

//���� Ŭ����
public class Grade {
	//�ʵ�(�Ӽ�)
	String name;
	int kor;
	int eng;
	int mat;
	
	//������
	public Grade(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	//�޼ҵ�
	
	//���� ���ϱ�
	public int total() {
		int tot = kor + eng + mat;
		return tot;
	}

	//��� ���ϱ�
	public String average() {
		DecimalFormat df = new DecimalFormat("###.00");
		double avg = total() / 3.;
		return df.format(avg);
	}
	
	//���� ���
	public void print() {
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + kor);
		System.out.println("���� : " + eng);
		System.out.println("���� : " + mat);
		System.out.println("���� : " + total());
		System.out.println("��� : " + average());
	}
	
	//���� ��� ���
	public void printList() {
		System.out.println(name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + total() + "\t" + average());
	}
}
