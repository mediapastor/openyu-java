package org.openyu.java.role.vo.impl;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openyu.java.role.vo.Role;

/**
 * The Class RoleImplTest.
 */
public class RoleImplTestNG {

	/**
	 * Instantiates a new role impl test.
	 */
	public RoleImplTestNG() {
	}

	/**
	 * Setter.
	 */
	@Test
	public void setter() {
		Role result = new RoleImpl();
		result.setId(1);
		System.out.println(result.getId());
		AssertJUnit.assertEquals(1, result.getId());
		//
		result.setName("OpenYu");
		System.out.println(result.getName());
		AssertJUnit.assertEquals("OpenYu", result.getName());
		//
		result.setStrength(100);
		System.out.println(result.getStrength());
		AssertJUnit.assertEquals(100, result.getStrength());
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
		AssertJUnit.assertNotNull(result);

		// 複製出來的role2與role1, 所有field值相等
		System.out.println(result.getId());
		AssertJUnit.assertEquals(role.getId(), result.getId());
		//
		System.out.println(result.getName());
		AssertJUnit.assertEquals(role.getName(), result.getName());
		//
		System.out.println(result.getStrength());
		AssertJUnit.assertEquals(role.getStrength(), result.getStrength());
		//
		result.setId(2);// role2改變id,不會改到role1.id
		System.out.println(result.getId());
		AssertJUnit.assertTrue(role.getId() != result.getId());
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
		AssertJUnit.assertTrue(result);
	}
}
