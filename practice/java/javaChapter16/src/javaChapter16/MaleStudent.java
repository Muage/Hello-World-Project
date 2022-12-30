package javaChapter16;

import java.util.ArrayList;
import java.util.List;

public class MaleStudent {
	private List<Student> list;	// 요소를 저장할 컬렉션

	public MaleStudent() {
		list = new ArrayList<Student>();
		System.out.println("[" + Thread.currentThread().getName() + "] MaleStudent()");
	}
	
	public void accumulate(Student student) {	// 요소 수집 메서드
		list.add(student);
		System.out.println("[" + Thread.currentThread().getName() + "] accumulate()");
	}
	
	public void combine(MaleStudent other) {	// 두 MaleStudent를 겹합하는 메서드(병렬 처리 시에만 호출)
		list.addAll(other.getList());
		System.out.println("[" + Thread.currentThread().getName() + "] combine()");
	}
	
	public List<Student> getList() {	// 요소가 저장된 컬렉션 리턴
		return list;
	}
}
