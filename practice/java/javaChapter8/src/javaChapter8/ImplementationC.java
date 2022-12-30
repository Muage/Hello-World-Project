package javaChapter8;

public class ImplementationC implements InterfaceC {
	@Override
	public void methodA() {
		System.out.println("ImplementatiocC-methodA() 실행");
	}
	
	@Override
	public void methodB() {
		System.out.println("ImplementatiocC-methodB() 실행");
	}
	
	@Override
	public void methodC() {
		System.out.println("ImplementatiocC-methodC() 실행");
	}
}
