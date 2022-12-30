package javaChapter11;

// Arrays - 배열 항목 정렬
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
