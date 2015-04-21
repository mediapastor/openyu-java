package org.openyu.java.role.vo;

import java.io.Serializable;

/**
 * The Interface Role.
 *
 * 寫上註解
 */
							  //支援序列化     //支援複製   //支援比較
public interface Role extends Serializable, Cloneable, Comparable<Role> {

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	long getId();

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the id
	 */
	void setId(long id);

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	String getName();

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the name
	 */
	void setName(String name);

	/**
	 * Gets the strength.
	 *
	 * @return the strength
	 */
	int getStrength();

	/**
	 * Sets the strength.
	 *
	 * @param strength
	 *            the strength
	 */
	void setStrength(int strength);

	/**
	 * Clone.
	 *
	 * 宣告成public
	 *
	 * @return the object
	 */
	Object clone();
}
