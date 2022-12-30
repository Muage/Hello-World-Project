package javaChapter12;

import java.awt.Toolkit;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Sample {
	// 콜백 방식의 작업 완료 통보받기
	private ExecutorService executorService;
	
	public Sample() {
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	}
	
	private CompletionHandler<Integer, Void> callBack = new CompletionHandler<Integer, Void>(){
		@Override
		public void completed(Integer result, Void attachment) {
			System.out.println("completed() 실행: " + result);
		}
		
		@Override
		public void failed(Throwable exc, Void attachment) {
			System.out.println("failed() 실행: " + exc.toString());
		}
	};
	
	public void doWork(final String x, final String y) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					int intX = Integer.parseInt(x);
					int intY = Integer.parseInt(y);
					int result = intX + intY;
					callBack.completed(result, null);
				} catch(Exception e) {
					callBack.failed(e, null);
				}
			}
		};
		executorService.submit(task);
	}
	
	public void finish() {
		executorService.shutdown();
	}
	
	public static void main(String[] args) throws Exception {	// 메인 스레드
		// BeepTask
		// 메인 스레드와 작업 스레드 동시 실행
		Runnable beepTask = new BeepTask();
		Thread thread = new Thread(beepTask);
		thread.start();
		for(int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				thread.sleep(500);
			} catch(Exception e) {}
		}
		
		// Runnable 익명 객체 이용
		Thread rthread = new Thread(new Runnable() {	
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i = 0; i < 5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(500);
					} catch(Exception e) {}
				}
			}
		});
		rthread.start();
		for(int i = 0; i < 5; i++) {
			System.out.println("댕");
			try {
				rthread.sleep(500);
			} catch(Exception e) {}
		}
		
		// Thread
		// 스레드 이름
		Thread mainThread = Thread.currentThread();	// 코드 실행하는 스레드 객체 얻기
		System.out.println("프로그램 시작 스레드 이름: " + mainThread.getName());
		
		ThreadA threadA = new ThreadA();
		System.out.println("작업 스레드 이름: " + threadA.getName());
		threadA.start();
		
		ThreadB threadB = new ThreadB();
		System.out.println("작업 스레드 이름: " + threadB.getName());
		threadB.start();
		
		// CalcThread
		// 우선순위
		for(int i = 1; i <= 10; i++) {
			Thread pthread = new CalcThread("thread" + i);	// 스레드 이름
			if(i != 10) {
				pthread.setPriority(Thread.MIN_PRIORITY);	// 가장 낮은 우선순위
			} else {
				pthread.setPriority(Thread.MAX_PRIORITY);	// 가장 높은 우선순위
			}
			pthread.start();
		}
		
		// StatePrintThread
		// 상태 출력
		StatePrintThread statePrintThread = new StatePrintThread(new TargetThread());
		statePrintThread.start();
		
		//AutoSaveThread
		// 데몬(deamon) 스레드
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		autoSaveThread.setDaemon(true);
		autoSaveThread.start();
		
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {}
		System.out.println("메인 스레드 종료");
		
		// WorkThread
		//스레드 그룹 일괄 종료
		ThreadGroup myGroup = new ThreadGroup("myGroup");	// myGroup에 두 스레드 포함시킴
		WorkThread workThreadA = new WorkThread(myGroup, "workThreadA");
		WorkThread workThreadB = new WorkThread(myGroup, "workThreadB");
		
		workThreadA.start();
		workThreadB.start();
		
		System.out.println("[main 스레드 그룹의 list() 메서드 출력 내용]");
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		mainGroup.list();
		System.out.println();
		
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {};
		
		System.out.println("[myGroup 스레드 그룹의 interrupt() 메서드 호출]");
		myGroup.interrupt();
		
		// 스레드풀
		ExecutorService executorService = Executors.newFixedThreadPool(2);	// 최대 스레드 개수 2인 스레드풀 생성
		
		for(int i = 0; i < 10; i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService;	// 스레드 총 개수 및 작업 스레드 이름 출력
					int poolSize = threadPoolExecutor.getPoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.println("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름: " + threadName);
					
					int value = Integer.parseInt("삼");	// 예외 발생 시킴
				}
			};
			
//			executorService.execute(runnable);	// 작업 처리 요청
			executorService.submit(runnable);
			
			Thread.sleep(10);
		}
		executorService.shutdown();	//스레드풀 종료
		
		// 리턴값이 없는 작업 완료 통보
		ExecutorService rexecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//		
		System.out.println("[작업 처리 요청]");
//		Runnable runnable = new Runnable() {
//
//			@Override
//			public void run() {
//				int sum = 0;
//				for(int i = 1; i <= 10; i++) {
//					sum += i;
//				}
//				System.out.println("[처리 결과] " + sum);
//			}
//		};
//		Future future = rexecutorService.submit(runnable);
//		
//		try {
//			future.get();
//			System.out.println("[작업 처리 완료]");
//		} catch(Exception e) {
//			System.out.println("[실행 예외 발생함] " + e.toString());
//		}
//		rexecutorService.shutdown();
		
		// 리턴값이 있는 작업 완료 통보
//		Callable<Integer> task = new Callable<Integer>() {
//			@Override
//			public Integer call() throws Exception {
//				int sum = 0;
//				for(int i = 1; i <= 10; i++) {
//					sum += i;
//				}
//				return sum;
//			}
//		};
//		Future<Integer> future = rexecutorService.submit(task);
//		
//		try {
//			int sum = future.get();
//			System.out.println("[처리 결과] " + sum);
//			System.out.println("[작업 처리 완료]");
//		} catch(Exception e) {
//			System.out.println("[실행 예외 발생함] " + e.toString());
//		}
//		rexecutorService.shutdown();
		
		// 직접 처리 결과를 외부 객체에 저장
//		class Task implements Runnable {
//			Result result;
//			public Task(Result result) {
//				this.result = result;
//			}
//			
//			@Override
//			public void run() {
//				int sum = 0;
//				for(int i = 0; i <= 10; i++) {
//					sum += i;
//				}
//				result.addValue(sum);
//			}
//		}
//		
//		Result result = new Result();
//			
//		Runnable task1 = new Task(result);
//		Runnable task2 = new Task(result);
//		Future<Result> future1 = rexecutorService.submit(task1, result);
//		Future<Result> future2 = rexecutorService.submit(task2, result);
//		
//		try {
//			result = future1.get();
//			result = future2.get();
//			System.out.println("[처리 결과] " + result.accmValue);
//			System.out.println("[작업 처리 완료]");
//		} catch(Exception e) {
//			System.out.println("[실행 예외 발생함] " + e.toString());
//		}
//		rexecutorService.shutdown();
		
		// 작업 완료 순으로 통보 받기
//		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(rexecutorService);
//		
//		System.out.println("[작업 처리 요청]");
//		
//		for(int i = 0; i < 3; i++) {
//			completionService.submit(new Callable<Integer>() {
//				@Override
//				public Integer call() throws Exception {
//					int sum = 0;
//					for(int i = 1; i <= 10; i++) {
//						sum += i;
//					}
//					return sum;
//				}
//			});
//		}
//		System.out.println("[처리 완료된 작업 확인]");
//		
//		rexecutorService.submit(new Runnable() {
//			@Override
//			public void run() {
//				while(true) {
//					try {
//						Future<Integer> future = completionService.take();
//						int value = future.get();
//						System.out.println("[처리 결과] " + value);
//					} catch(Exception e) {
//						break;
//					}
//				}
//			}
//		});
//		
//		try {
//			Thread.sleep(3000);
//		} catch(Exception e) {}
//		rexecutorService.shutdown();
		
		// 콜백 방식의 작업 완료 통보받기
		Sample sample = new Sample();
		sample.doWork("3", "3");
		sample.doWork("3", "삼");
		sample.finish();
	}
}

class Result {
	int accmValue;
	
	synchronized void addValue(int value) {
		accmValue += value;
	}
}