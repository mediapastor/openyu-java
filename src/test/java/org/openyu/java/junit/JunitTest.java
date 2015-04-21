package org.openyu.java.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The Class JunitTest.
 */
public class JunitTest {

 /**
  * Sets the up before class.
  *
  * @throws Exception
  *             the exception
  */
 @BeforeClass
 public static void setUpBeforeClass() throws Exception {
  System.out.println("1: initialize something before class");
 }

 /**
  * Tear down after class.
  *
  * @throws Exception
  *             the exception
  */
 @AfterClass
 public static void tearDownAfterClass() throws Exception {
  System.out.println("4: release something after class");
 }

 /**
  * Sets the up.
  *
  * @throws Exception
  *             the exception
  */
 @Before
 public void setUp() throws Exception {
  System.out.println("2: initialize something before method");
 }

 /**
  * Tear down.
  *
  * @throws Exception
  *             the exception
  */
 @After
 public void tearDown() throws Exception {
  System.out.println("3: release something before method");
 }

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
  * Test.
  */
 @Test
 public void test2() {
  System.out.println("---------------------------");
  System.out.println("test2 java.openyu.org");
  System.out.println("---------------------------");
 }
}
