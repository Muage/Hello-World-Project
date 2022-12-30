package javaChapter12;

import java.awt.Toolkit;

public class BeepTask implements Runnable {

	@Override
	public void run() {	// 스레드 실행 내용
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch(Exception e) {}
		}
	}
}
