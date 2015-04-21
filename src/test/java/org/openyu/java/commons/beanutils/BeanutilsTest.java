package org.openyu.java.commons.beanutils;

import static org.junit.Assert.*;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.openyu.java.commons.lang.Book;

public class BeanutilsTest {

	@Test
	public void setProperty() throws Exception {
		Magazine magazine = new Magazine();

		BeanUtils.setProperty(magazine, "id", 1L);
		BeanUtils.setProperty(magazine, "name", "OpenYu");
		BeanUtils.setProperty(magazine, "price", 1000);

		// 不存在field,不會拋出exception
		BeanUtils.setProperty(magazine, "notExist", 1000);

		System.out.println(magazine);
		assertEquals(1L, magazine.getId());
		assertEquals("OpenYu", magazine.getName());
		assertEquals(1000, magazine.getPrice());
	}

	@Test
	public void getProperty() throws Exception {
		Magazine magazine = new Magazine();
		magazine.setId(1L);
		magazine.setName("OpenYu");
		magazine.setPrice(1000);

		String id = BeanUtils.getProperty(magazine, "id");
		String name = BeanUtils.getProperty(magazine, "name");
		String price = BeanUtils.getProperty(magazine, "price");

		// 不存在field,會拋出NoSuchMethodException
		// String notExist = BeanUtils.getProperty(magazine, "notExist");

		System.out.println("id = " + id + ", name = " + name + ", price ="
				+ price);
		//
		assertEquals("1", id);
		assertEquals("OpenYu", name);
		assertEquals("1000", price);
	}

	@Test
	public void getNestedProperty() throws Exception {
		Magazine magazine = new Magazine();
		magazine.setId(1L);
		magazine.setName("OpenYu");
		magazine.setPrice(1000);

		// author
		Author author = new Author();
		author.setId(1L);
		author.setName("Java");
		magazine.setAuthor(author);
		//
		String authorName = (String) BeanUtils.getNestedProperty(magazine,
				"author.name");
		System.out.println("Author Name: " + authorName);
		assertEquals("Java", authorName);
	}

	@Test
	public void getIndexedProperty() throws Exception {
		Bookstore bookstore = new Bookstore();
		//
		Magazine magazine = new Magazine();
		magazine.setId(1L);
		magazine.setName("OpenYu");
		magazine.setPrice(1000);
		bookstore.getMagazines().add(magazine);
		//
		Magazine magazine2 = new Magazine();
		magazine2.setId(2L);
		magazine2.setName("OpenYu2");
		magazine2.setPrice(2000);
		bookstore.getMagazines().add(magazine2);
		//
		Magazine magazine3 = new Magazine();
		magazine3.setId(3L);
		magazine3.setName("OpenYu3");
		magazine3.setPrice(2000);
		bookstore.getMagazines().add(magazine3);
		//
		String result = BeanUtils.getIndexedProperty(bookstore, "magazines[1]");
		System.out.println(result);
	}

	@Test
	public void getMappedProperty() throws Exception {
		Bookstore bookstore = new Bookstore();
		Book book = new Book();
		book.setId(1);
		book.setName("OpenYu");
		bookstore.getBooks().put("One", book);
		//
		Book book2 = new Book();
		book2.setId(2);
		book2.setName("OpenYu2");
		bookstore.getBooks().put("Two", book2);
		//
		Book book3 = new Book();
		book3.setId(3);
		book3.setName("OpenYu3");
		bookstore.getBooks().put("Three", book3);
		//
		String result = BeanUtils.getMappedProperty(bookstore, "books(Two)");
		System.out.println(result);
	}

	@Test
	public void copyProperties() throws Exception {
		Magazine magazine = new Magazine();
		magazine.setId(1L);
		magazine.setName("OpenYu");
		magazine.setPrice(1000);
		//
		Author author = new Author();
		author.setId(1L);
		author.setName("Java");
		magazine.setAuthor(author);
		System.out.println(magazine);
		//
		Book book = new Book();
		BeanUtils.copyProperties(book, magazine);
		System.out.println(book);
	}
}
