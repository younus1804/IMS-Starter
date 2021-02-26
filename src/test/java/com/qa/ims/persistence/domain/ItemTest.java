package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;



public class ItemTest {
	private static Item testItem;

	@Test
	public void ItemOnetest() {
		testItem = new Item((long) 1, "apple", 1.5);
		assertNotNull(testItem);
	}
	@Test
	public void ItemTwotest() {
		testItem = new Item("apple", 1.5);
		assertNotNull(testItem);
	}
	@Test
	public void getitem_idtest() {
	Item apple = new Item((long) 1, "apple", 1.5);
	assertSame((long) 1, apple.getitem_id());
	}
	@Test
	public void setitem_idtest() {
		Long idnumber = (long) 2;
		Item apple = new Item("apple", 1.5);
		apple.setitem_id(idnumber);
		assertEquals(idnumber, apple.getitem_id());
	}
	@Test
	public void getitem_nametest() {
		Item apple = new Item((long) 1, "apple", 1.5);
		assertSame(("apple"), apple.getitem_name());
	}
	@Test
	public void setitem_nametest() {
		String itemname = "apple";
		Item apple = new Item();
		apple.setitem_name(itemname);
		assertEquals(itemname, apple.getitem_name());
	}
	@Test
	public void getitem_pricetest() {
		Item apple = new Item((long) 1, "apple", (double) 1);
		assertEquals((double) 1, apple.getitem_price(),(double) 1);
		
	}
	@Test
	public void setitem_pricetest() {
		double itemprice = (double) 1.5;
		Item apple = new Item();
		apple.setitem_price(itemprice);
		assertEquals((double) 1.5, apple.getitem_price(),(double) 1.5);
	}
	@Test
	public void toStringtest() {
		Item apple = new Item((long) 6, "apple", 1.5);
		assertEquals("id:6 item name:apple item price:1.5", apple.toString());
	}
}
