package org.openyu.java.commons.beanutils;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.openyu.java.commons.lang.Book;

/**
 * The Class Bookstore.
 */
public class Bookstore {

	/** The id. */
	private long id;

	/** The name. */
	private String name;

	/** The magazines. */
	private	List<Magazine> magazines = new LinkedList<Magazine>();

	/** The books. */
	private Map<String,Book> books=new LinkedHashMap<String,Book>();

	/**
	 * Instantiates a new bookstore.
	 */
	public Bookstore() {
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the magazines.
	 *
	 * @return the magazines
	 */
	public List<Magazine> getMagazines() {
		return magazines;
	}

	/**
	 * Sets the magazines.
	 *
	 * @param magazines the new magazines
	 */
	public void setMagazines(List<Magazine> magazines) {
		this.magazines = magazines;
	}

	/**
	 * Gets the books.
	 *
	 * @return the books
	 */
	public Map<String, Book> getBooks() {
		return books;
	}

	/**
	 * Sets the books.
	 *
	 * @param books the books
	 */
	public void setBooks(Map<String, Book> books) {
		this.books = books;
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this)
		//return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("id", id)
				.append("name", name)
				.toString();
	}
}
