package org.openyu.java.memoryleak;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * The Class MemoryLeakThreadTest.
 */
public class MemoryLeakThreadTest {

	/**
	 * Thread.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void thread() throws Exception {
		int size = 20000; // 2w
		//
		long start = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			//
			Thread thread = new Thread(new Runner());
			thread.start();
			System.out.println("create: " + i);
		}
		long end = System.currentTimeMillis();
		//
		Thread.sleep(10 * 1000);
		System.out.println("time: " + (end - start) + " mills.");
	}

	/**
	 * The Class Runner.
	 */
	protected class Runner implements Runnable {

		/*
		 * (non-Javadoc)
		 *
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
			}
		}
	}

	/**
	 * Thread pool executor.
	 *
	 * #fix 1
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void threadPoolExecutor() throws Exception {
		int size = 20000; // 2w
		//
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100,
				100,
				0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());

		long start = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			//
			Runner runner = new Runner();
			threadPoolExecutor.submit(runner);
			System.out.println("create: " + i);
		}
		long end = System.currentTimeMillis();
		//
		Thread.sleep(10 * 1000);
		System.out.println("time: " + (end - start) + " mills.");
	}

	/**
	 * Completion service.
	 *
	 * #fix 2
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void completionService() throws Exception {
		int size = 20000; // 2w
		//
		CompletionService<Object> completionService = new ExecutorCompletionService<Object>(
				Executors.newFixedThreadPool(100));
		//
		long start = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			//
			Runner runner = new Runner();
			completionService.submit(runner, null);
			System.out.println("create: " + i);
		}
		long end = System.currentTimeMillis();
		//
		Thread.sleep(10 * 1000);
		System.out.println("time: " + (end - start) + " mills.");
	}

	/**
	 * Executor service.
	 *
	 * #fix 3
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void executorService() throws Exception {
		int size = 20000; // 2w
		//
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		//
		long start = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			//
			Runner runner = new Runner();
			executorService.submit(runner, null);
			System.out.println("create: " + i);
		}
		long end = System.currentTimeMillis();
		//
		Thread.sleep(10 * 1000);
		System.out.println("time: " + (end - start) + " mills.");
	}
}
