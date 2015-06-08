package org.openyu.java.memoryleak;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * The Class MemoryLeakSubstringTest.
 */
public class MemoryLeakSubstringTest {

	/**
	 * Substring.
	 *
	 * memory leak
	 */
	@Test
	public void substring() {
		List<String> result = new ArrayList<String>(10000);
		int count = 10000;
		long beg = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			result.add(new Substring().substring());
		}
		long end = System.currentTimeMillis();
		//
		System.out.println((end - beg) + " mills.");
	}

	/**
	 * The Class Substring.
	 */
	protected class Substring {

		/** The value. */
		// 1M
		private String value = new String(new byte[1 * 1024 * 1024]);

		/**
		 * Substring.
		 *
		 * @return the string
		 */
		public String substring() {
			return this.value.substring(0, 2);
		}
	}

	/**
	 * New string substring.
	 *
	 * #fix 1
	 */
	@Test
	public void newStringSubstring() {
		List<String> result = new ArrayList<String>(10000);
		int count = 10000;
		long beg = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			result.add(new NewStringSubstring().substring());
		}
		long end = System.currentTimeMillis();
		//
		System.out.println((end - beg) + " mills.");
	}

	/**
	 * The Class NewStringSubstring.
	 */
	protected class NewStringSubstring {

		/** The value. */
		// 1M
		private String value = new String(new byte[1 * 1024 * 1024]);

		/**
		 * Substring.
		 *
		 * @return the string
		 */
		public String substring() {
			return new String(this.value.substring(0, 2));
		}
	}

	/**
	 * String builder substring.
	 *
	 * #fix 2
	 */
	@Test
	public void stringBuilderSubstring() {
		List<String> result = new ArrayList<String>(10000);
		int count = 10000;
		long beg = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			result.add(new StringBuilderSubstring().substring());
		}
		long end = System.currentTimeMillis();
		//
		System.out.println((end - beg) + " mills.");
	}

	/**
	 * The Class StringBuilderSubstring.
	 */
	protected class StringBuilderSubstring {

		/** The value. */
		// 1M
		private String value = new String(new byte[1 * 1024 * 1024]);

		/**
		 * Substring.
		 *
		 * @return the string
		 */
		public String substring() {
			StringBuilder buff = new StringBuilder();
			buff.append(value);
			return buff.substring(0, 2);
		}
	}
}
