package org.openyu.java.role.vo.impl;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.openyu.java.role.vo.Role;

/**
 * The Class RoleImpl.
 */
public class RoleImpl implements Role {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4239702119231824382L;

	/** The id. */
	private long id;

	/** The name. */
	private String name;

	/** The strength. */
	private int strength;

	/**
	 * Instantiates a new role impl.
	 */
	public RoleImpl() {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.openyu.java.role.vo.Role#getId()
	 */
	public long getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.openyu.java.role.vo.Role#setId(long)
	 */
	public void setId(long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.openyu.java.role.vo.Role#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.openyu.java.role.vo.Role#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.openyu.java.role.vo.Role#getStrength()
	 */
	public int getStrength() {
		return strength;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.openyu.java.role.vo.Role#setStrength(int)
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		RoleImpl result = null;
		try {
			result = (RoleImpl) super.clone();
		} catch (CloneNotSupportedException ex) {
			throw new AssertionError();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleImpl other = (RoleImpl) obj;
		// if (id != other.id)
		if (getId() != other.getId())
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	/**
	 * ___equals.
	 *
	 * @param obj
	 *            the obj
	 * @return true, if successful
	 */
	public boolean ___equals(Object obj) {
		if (!(obj instanceof RoleImpl)) {
			return false;
		}
		RoleImpl other = (RoleImpl) obj;
		return new EqualsBuilder()
				.append(getId(), other.getId())
				.isEquals();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		// result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (getId() ^ (getId() >>> 32));
		return result;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	/**
	 * ___hash code.
	 *
	 * @return the int
	 */
	public int ___hashCode() {
		return new HashCodeBuilder()
				.append(getId())
				.toHashCode();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", strength=" + strength + "]";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	/**
	 * ___to string.
	 *
	 * @return the string
	 */
	public String ___toString() {
		return new ToStringBuilder(this).append("id", id)
				.append("name", name)
				.append("strength", strength)
				.toString();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int ___compareTo(Role o) {
		long id = o.getId();
		if (this.getId() > id) {
			return 1;
		} else if (this.getId() < id) {
			return -1;
		} else {
			return 0;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Role o) {
		return new CompareToBuilder()
				.append(this.getId(), o.getId())
				.toComparison();
	}
}
