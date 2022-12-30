package javaChapter15;

public class Person  implements Comparable<Person> {
	public String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public int compareTo(Person o) {
		if(age < o.age) return -1;
		else if(age == o.age) return 0;
		else return 1;
	}
}
