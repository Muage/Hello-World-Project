package javaChapter11;

// Arrays - �迭 �׸� ����
public class AMember implements Comparable<AMember> {
	String name;
	
	AMember(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(AMember o) {
		return name.compareTo(o.name);
	}
}
