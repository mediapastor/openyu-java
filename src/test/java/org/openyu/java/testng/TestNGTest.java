package org.openyu.java.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

/**
 * The Class TestNGTest.
 */
public class TestNGTest {

	/**
	 * Test.
	 */
	@Test
	public void test() {
		System.out.println("---------------------------");
		System.out.println("test java.openyu.org");
		System.out.println("---------------------------");
	}

	/**
	 * Before method.
	 */
	@BeforeMethod
	public void beforeMethod() {
	}

	/**
	 * After method.
	 */
	@AfterMethod
	public void afterMethod() {
	}

	/**
	 * Before class.
	 */
	@BeforeClass
	public void beforeClass() {
	}

	/**
	 * After class.
	 */
	@AfterClass
	public void afterClass() {
	}
}
