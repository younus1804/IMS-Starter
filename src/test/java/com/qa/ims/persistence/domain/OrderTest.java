package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class OrderTest {
	private static Order testOrder;
	
	@Test
	public void OrderOnetest() {
		testOrder = new Order((long) 1, "apple", (long) 3, 1.5);
		assertNotNull(testOrder);
	}
	@Test
	public void settotal_pricetest() {
		double totalprice1 = (double) 3;
		Order one = new Order();
		one.settotal_price(totalprice1);;
		assertEquals((double) 3, one.gettotal_price(), (double) 3);
	}
	@Test
	public void gettotal_pricetest() {
		Order orderr1 = new Order((long) 1, "apple", (long) 3, (double) 1.5);
		assertEquals((double) 1.5, orderr1.gettotal_price(), (double) 1.5);
	}
	@Test
	public void OrderTwotest() {
		testOrder = new Order("apple", (long) 3);
		assertNotNull(testOrder);
	}
	@Test
	public void OrderThreetest() {
		testOrder = new Order((long) 1, "apple", (long) 3);
		assertNotNull(testOrder);
	}
	@Test
	public void setitem_quantitytest() {
		Long itemqty = (long) 3;
		Order one = new Order();
		one.setitem_quantity(itemqty);
		assertEquals(itemqty, one.getitem_quantity());
	}
	@Test
	public void getorder_idtest() {
		Order orderr1 = new Order((long) 1, "apple", (long) 3, 1.5);
		assertSame((long) 1, orderr1.getorder_id());
	}
	@Test
	public void setorder_idtest() {
		Long orderid = (long) 2;
		Order one = new Order();
		one.setorder_id(orderid);;
		assertEquals(orderid, one.getorder_id());
	}
	@Test
	public void getorder_itemtest() {
		Order orderr1 = new Order((long) 1, "apple", (long) 3, 1.5);
		assertSame(("apple"), orderr1.getorder_item());
	}
	@Test
	public void setorder_itemtest() {
		String orderitemname = "apple";
		Order one = new Order();
		one.setorder_item(orderitemname);;
		assertEquals(orderitemname, one.getorder_item());
	}
	@Test
	public void getitem_quantitytest() {
		Order orderr1 = new Order((long) 1, "apple", (long) 3, 1.5);
		assertSame((long) 3, orderr1.getitem_quantity());
	}
	@Test
	public void toStringtest() {
		Order orderr1 = new Order((long) 1, "apple", (long) 3, (double) 6.0);
		assertEquals("order id:1 order item:apple item quantity:3 subtotal 6.0" ,orderr1.toString());
	}
}
	
