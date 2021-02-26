package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {
	private static Customer testCustomer;

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}
	@Test
	public void Customertest() {
		testCustomer = new Customer();
		assertNotNull(testCustomer);
	}
	@Test
	public void CustomerOnetest() {
		testCustomer = new Customer("John", "smith");
		assertNotNull(testCustomer);
	}
	@Test
	public void CustomerTwotest() {
		testCustomer = new Customer((long) 1, "John", "smith");
		assertNotNull(testCustomer);
	}
	@Test
	public void getIdtest() {
	Customer john = new Customer((long) 1, "John", "smith");
	assertSame((long) 1, john.getId());
	}
	@Test
	public void setIdtest() {
		Long number = (long) 10;
		Customer john = new Customer("John", "smith");
		john.setId(number);
		assertEquals(number, john.getId());
	}
	@Test
	public void getFirstNametest() {
		Customer john = new Customer((long) 1, "John", "smith");
		assertSame(("John"), john.getFirstName());
	}
	@Test
	public void setFirstNametest() {
		String fname = "John";
		Customer john = new Customer();
		john.setFirstName(fname);
		assertEquals(fname, john.getFirstName());
	}
	@Test
	public void getSurnametest() {
		Customer john = new Customer((long) 1, "John", "smith");
		assertSame(("smith"), john.getSurname());
	}
	@Test
	public void setSurnametest() {
		String lname = "smith";
		Customer john = new Customer();
		john.setSurname(lname);
		assertEquals(lname, john.getSurname());
	}
	@Test
	public void toStringtest() {
		Customer john = new Customer((long) 4, "John", "smith");
		assertEquals("id:4 first name:John surname:smith", john.toString());
	}
}
