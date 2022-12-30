package javaChapter8;

public interface ChildInterface2 extends ParentInterface {
	@Override
	// ¿Á¡§¿«
	public default void method2() {}
	
	public void method3();
}