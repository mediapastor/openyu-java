package org.openyu.java.commons.lang;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * The Class BookTest.
 */
public class BookTest {

	/**
	 * Equals.
	 */
	@Test
	public void equals() {
		Book book = new Book();
		book.setId(1);
		//
		Book book2 = new Book();
		book2.setId(1);
		//
		boolean result = book.equals(book2);
		System.out.println("book.equals(book2) = " + result);
		assertTrue(result);
	}

	/**
	 * HashCodez.
	 */
	@Test
	public void hashCodez() {
		Book book = new Book();
		book.setId(1);
		//
		Book book2 = new Book();
		book2.setId(1);
		//
		boolean result = book.equals(book2);
		System.out.println("book.equals(book2) = " + result);
		assertTrue(result);
		int hashCode = book.hashCode();
		int hashCode2 = book2.hashCode();
		System.out.println("book.hashCode() = " + book.hashCode());
		System.out.println("book2.hashCode() = " + book2.hashCode());
		assertTrue(hashCode == hashCode2);
	}

	/**
	 * To stringz.
	 */
	@Test
	public void toStringz() {
		Book book = new Book();
		book.setId(1);
		book.setName("OpenYu");

		String result = book.toString();
		System.out.println(result);
		assertTrue(result.indexOf("id") > 0);
		assertTrue(result.indexOf("name") > 0);
	}

	/**
	 * Compare to.
	 */
	@Test
	public void compareTo() {
		Book book = new Book();
		book.setId(1);
		book.setName("OpenYu");
		//
		Book book2 = new Book();
		book2.setId(2);
		book2.setName("OpenYu");
		//
		int result = book.compareTo(book2);
		System.out.println(result);
		assertEquals(-1, result);
		//

		Book book3 = new Book();
		book3.setId(3);
		book3.setName("Java");
		//
		Book[] books = new Book[] { book2, book, book3 };
		System.out.println("before sort: ");
		for (Book r : books) {
			System.out.println(r);
		}
		//
		System.out.println();
		Arrays.sort(books);
		System.out.println("after sort: ");
		for (Book r : books) {
			System.out.println(r);
		}
		//
		assertEquals(1, books[0].getId());
		assertEquals(2, books[1].getId());
		assertEquals(3, books[2].getId());
	}
}
