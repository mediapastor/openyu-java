package org.openyu.java.role.vo.impl;

import java.util.Comparator;

import org.openyu.java.role.vo.Role;

/**
 * The Class RoleNameComparator.
 */
public class RoleNameComparator implements Comparator<Role> {


	/**
	 * Instantiates a new role name comparator.
	 */
	public RoleNameComparator() {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Role o1, Role o2) {
		long id1 = o1.getId();
		long id2 = o2.getId();
		String name1 = o1.getName();
		String name2 = o2.getName();

		// 排序: name+id
		int result = name1.compareTo(name2);
		if (result == 0) {
			if (id1 > id2) {
				return 1;
			} else if (id1 < id2) {
				return -1;
			} else {
				return 0;
			}
		}
		return result;
	}

}
