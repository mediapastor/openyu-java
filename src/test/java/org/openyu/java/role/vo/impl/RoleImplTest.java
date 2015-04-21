package org.openyu.java.role.vo.impl;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.openyu.java.role.vo.Role;

/**
 * The Class RoleImplTest.
 */
public class RoleImplTest {

	/**
	 * Instantiates a new role impl test.
	 */
	public RoleImplTest() {
	}

	/**
	 * Setter.
	 */
	@Test
	public void setter() {
		Role result = new RoleImpl();
		result.setId(1);
		System.out.println(result.getId());
		assertEquals(1, result.getId());
		//
		result.setName("OpenYu");
		System.out.println(result.getName());
		assertEquals("OpenYu", result.getName());
		//
		result.setStrength(100);
		System.out.println(result.getStrength());
		assertEquals(100, result.getStrength());
	}

	/**
	 * Clonez.
	 */
	@Test
	public void clonez() {
		Role role = new RoleImpl();
		role.setId(1);
		role.setName("OpenYu");
		role.setStrength(100);

		// clone
		Role result = (Role) role.clone();
		assertNotNull(result);

		// 複製出來的role2與role1, 所有field值相等
		System.out.println(result.getId());
		assertEquals(role.getId(), result.getId());
		//
		System.out.println(result.getName());
		assertEquals(role.getName(), result.getName());
		//
		System.out.println(result.getStrength());
		assertEquals(role.getStrength(), result.getStrength());
		//
		result.setId(2);// role2改變id,不會改到role1.id
		System.out.println(result.getId());
		assertTrue(role.getId() != result.getId());
	}

	/**
	 * Equals.
	 */
	@Test
	public void equals() {
		Role role = new RoleImpl();
		role.setId(1);
		//
		Role role2 = new RoleImpl();
		role2.setId(1);
		//
		System.out.println(role.getId() + ", " + role2.getId());

		boolean result = role.equals(role2);
		System.out.println(result);
		// 尚未覆寫equals時,會測試失敗
		assertTrue(result);

		// 以下為追加的測試代碼
		Role role3 = role;
		result = role.equals(role3);
		assertTrue(result);
		//
		Role role4 = null;
		result = role.equals(role4);
		assertFalse(result);
		//
		Object object = new Object();
		result = role.equals(object);
		assertFalse(result);
		//
		role2.setId(99);
		result = role.equals(role2);
		assertFalse(result);
	}

	/**
	 * HashCodez.
	 */
	@Test
	public void hashCodez() {
		Role role = new RoleImpl();
		role.setId(1);
		//
		Role role2 = new RoleImpl();
		role2.setId(1);
		//
		boolean result = role.equals(role2);
		System.out.println(result);
		assertTrue(result);
		// 當role與role2相等, hashCode也需相等
		int hashCode = role.hashCode();
		int hashCode2 = role2.hashCode();
		System.out.println(hashCode + ", " + hashCode2);
		assertTrue(hashCode == hashCode2);
	}

	/**
	 * To stringz.
	 */
	@Test
	public void toStringz() {
		Role role = new RoleImpl();
		role.setId(1);
		role.setName("OpenYu");
		role.setStrength(100);

		String result = role.toString();
		System.out.println(result);
		assertTrue(result.indexOf("id") > 0);
		assertTrue(result.indexOf("name") > 0);
		assertTrue(result.indexOf("strength") > 0);
	}

	/**
	 * Compare to.
	 */
	@Test
	public void compareTo() {
		Role role = new RoleImpl();
		role.setId(1);
		role.setName("OpenYu");
		//
		Role role2 = new RoleImpl();
		role2.setId(2);
		role2.setName("OpenYu");
		//
		int result = role.compareTo(role2);
		System.out.println(result);
		assertEquals(-1, result);
		//

		Role role3 = new RoleImpl();
		role3.setId(3);
		role3.setName("Java");
		//
		Role[] roles = new Role[] { role2, role, role3 };
		System.out.println("before sort: ");
		for (Role r : roles) {
			System.out.println(r);
		}
		//
		System.out.println();
		Arrays.sort(roles);
		System.out.println("after sort: ");
		for (Role r : roles) {
			System.out.println(r);
		}
	}

	/**
	 * Compare.
	 */
	@Test
	public void compare() {
		Role role = new RoleImpl();
		role.setId(1);
		role.setName("OpenYu");
		//
		Role role2 = new RoleImpl();
		role2.setId(2);
		role2.setName("OpenYu");
		//
		int result = role.compareTo(role2);
		System.out.println(result);
		assertEquals(-1, result);
		//

		Role role3 = new RoleImpl();
		role3.setId(3);
		role3.setName("Java");
		//
		Role[] roles = new Role[] { role2, role, role3 };
		System.out.println("before sort: ");
		for (Role r : roles) {
			System.out.println(r);
		}
		//
		System.out.println();
		Arrays.sort(roles, new RoleNameComparator());
		System.out.println("after sort: ");
		for (Role r : roles) {
			System.out.println(r);
		}
	}
}
