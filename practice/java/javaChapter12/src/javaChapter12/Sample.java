package javaChapter12;

import java.awt.Toolkit;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Sample {
	// �ݹ� ����� �۾� �Ϸ� �뺸�ޱ�
	private ExecutorService executorService;
	
	public Sample() {
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	}
	
	private CompletionHandler<Integer, Void> callBack = new CompletionHandler<Integer, Void>(){
		@Override
		public void completed(Integer result, Void attachment) {
			System.out.println("completed() ����: " + result);
		}
		
		@Override
		public void failed(Throwable exc, Void attachment) {
			System.out.println("failed() ����: " + exc.toString());
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
	
	public static void main(String[] args) throws Exception {	// ���� ������
		// BeepTask
		// ���� ������� �۾� ������ ���� ����
		Runnable beepTask = new BeepTask();
		Thread thread = new Thread(beepTask);
		thread.start();
		for(int i = 0; i < 5; i++) {
			System.out.println("��");
			try {
				thread.sleep(500);
			} catch(Exception e) {}
		}
		
		// Runnable �͸� ��ü �̿�
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
			System.out.println("��");
			try {
				rthread.sleep(500);
			} catch(Exception e) {}
		}
		
		// Thread
		// ������ �̸�
		Thread mainThread = Thread.currentThread();	// �ڵ� �����ϴ� ������ ��ü ���
		System.out.println("���α׷� ���� ������ �̸�: " + mainThread.getName());
		
		ThreadA threadA = new ThreadA();
		System.out.println("�۾� ������ �̸�: " + threadA.getName());
		threadA.start();
		
		ThreadB threadB = new ThreadB();
		System.out.println("�۾� ������ �̸�: " + threadB.getName());
		threadB.start();
		
		// CalcThread
		// �켱����
		for(int i = 1; i <= 10; i++) {
			Thread pthread = new CalcThread("thread" + i);	// ������ �̸�
			if(i != 10) {
				pthread.setPriority(Thread.MIN_PRIORITY);	// ���� ���� �켱����
			} else {
				pthread.setPriority(Thread.MAX_PRIORITY);	// ���� ���� �켱����
			}
			pthread.start();
		}
		
		// StatePrintThread
		// ���� ���
		StatePrintThread statePrintThread = new StatePrintThread(new TargetThread());
		statePrintThread.start();
		
		//AutoSaveThread
		// ����(deamon) ������
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		autoSaveThread.setDaemon(true);
		autoSaveThread.start();
		
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {}
		System.out.println("���� ������ ����");
		
		// WorkThread
		//������ �׷� �ϰ� ����
		ThreadGroup myGroup = new ThreadGroup("myGroup");	// myGroup�� �� ������ ���Խ�Ŵ
		WorkThread workThreadA = new WorkThread(myGroup, "workThreadA");
		WorkThread workThreadB = new WorkThread(myGroup, "workThreadB");
		
		workThreadA.start();
		workThreadB.start();
		
		System.out.println("[main ������ �׷��� list() �޼��� ��� ����]");
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		mainGroup.list();
		System.out.println();
		
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {};
		
		System.out.println("[myGroup ������ �׷��� interrupt() �޼��� ȣ��]");
		myGroup.interrupt();
		
		// ������Ǯ
		ExecutorService executorService = Executors.newFixedThreadPool(2);	// �ִ� ������ ���� 2�� ������Ǯ ����
		
		for(int i = 0; i < 10; i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService;	// ������ �� ���� �� �۾� ������ �̸� ���
					int poolSize = threadPoolExecutor.getPoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.println("[�� ������ ����: " + poolSize + "] �۾� ������ �̸�: " + threadName);
					
					int value = Integer.parseInt("��");	// ���� �߻� ��Ŵ
				}
			};
			
//			executorService.execute(runnable);	// �۾� ó�� ��û
			executorService.submit(runnable);
			
			Thread.sleep(10);
		}
		executorService.shutdown();	//������Ǯ ����
		
		// ���ϰ��� ���� �۾� �Ϸ� �뺸
		ExecutorService rexecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//		
		System.out.println("[�۾� ó�� ��û]");
//		Runnable runnable = new Runnable() {
//
//			@Override
//			public void run() {
//				int sum = 0;
//				for(int i = 1; i <= 10; i++) {
//					sum += i;
//				}
//				System.out.println("[ó�� ���] " + sum);
//			}
//		};
//		Future future = rexecutorService.submit(runnable);
//		
//		try {
//			future.get();
//			System.out.println("[�۾� ó�� �Ϸ�]");
//		} catch(Exception e) {
//			System.out.println("[���� ���� �߻���] " + e.toString());
//		}
//		rexecutorService.shutdown();
		
		// ���ϰ��� �ִ� �۾� �Ϸ� �뺸
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
//			System.out.println("[ó�� ���] " + sum);
//			System.out.println("[�۾� ó�� �Ϸ�]");
//		} catch(Exception e) {
//			System.out.println("[���� ���� �߻���] " + e.toString());
//		}
//		rexecutorService.shutdown();
		
		// ���� ó�� ����� �ܺ� ��ü�� ����
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
//			System.out.println("[ó�� ���] " + result.accmValue);
//			System.out.println("[�۾� ó�� �Ϸ�]");
//		} catch(Exception e) {
//			System.out.println("[���� ���� �߻���] " + e.toString());
//		}
//		rexecutorService.shutdown();
		
		// �۾� �Ϸ� ������ �뺸 �ޱ�
//		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(rexecutorService);
//		
//		System.out.println("[�۾� ó�� ��û]");
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
//		System.out.println("[ó�� �Ϸ�� �۾� Ȯ��]");
//		
//		rexecutorService.submit(new Runnable() {
//			@Override
//			public void run() {
//				while(true) {
//					try {
//						Future<Integer> future = completionService.take();
//						int value = future.get();
//						System.out.println("[ó�� ���] " + value);
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
		
		// �ݹ� ����� �۾� �Ϸ� �뺸�ޱ�
		Sample sample = new Sample();
		sample.doWork("3", "3");
		sample.doWork("3", "��");
		sample.finish();
	}
}

class Result {
	int accmValue;
	
	synchronized void addValue(int value) {
		accmValue += value;
	}
}