package javaChapter8;

public interface ChildInterface3 extends ParentInterface {
	@Override
	// 추상 메서드로 재선언
	public void method2();
	
	public void method3();
}