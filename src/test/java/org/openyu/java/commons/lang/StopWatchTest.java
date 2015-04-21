package org.openyu.java.commons.lang;

import org.apache.commons.lang.time.StopWatch;
import org.junit.Test;

public class StopWatchTest {

	@Test
	public void start() {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		//
		doTask(3 * 1000);
		//
		stopWatch.stop();
		System.out.println(" times: " + stopWatch.getTime() + " mills. ");
	}

	@Test
	public void split() {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		//split 1
		doTask(3 * 1000);
		stopWatch.split();
		System.out.println("split 1: " + stopWatch.toSplitString());

		//suspend
		stopWatch.suspend();
		doTask(2 * 1000);
		//resume
		stopWatch.resume();

		//split 2
		doTask(1 * 1500);
		stopWatch.split();
		System.out.println("split 2: " + stopWatch.toSplitString());

		//split 3
		doTask(2 * 2500);
		stopWatch.split();
		System.out.println("split 3: " + stopWatch.toSplitString());

		stopWatch.stop();
		
		System.out.println("times: " + stopWatch.getTime() + " mills. ");
	}

	protected void doTask(long sleep) {
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
