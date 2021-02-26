package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao2;

	@InjectMocks
	private OrderController controller2;
	
	@Test
	public void Createtestt() {
		final Long idorder = (long) 1;
		final String orderitem = "apple";
		final Long qty = (long) 5;
		final Order created2 = new Order(idorder, orderitem, qty);

		Mockito.when(utils.getLong()).thenReturn(idorder);
		Mockito.when(utils.getString()).thenReturn(orderitem);
		Mockito.when(utils.getLong()).thenReturn(qty);
		Mockito.when(dao2.create(created2)).thenReturn(created2);

		assertEquals(created2, controller2.create());
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(dao2, Mockito.times(1)).create(created2);
	}
	@Test
	public void ReadAlltestt() {
		List<Order> order = new ArrayList<>();
		order.add(new Order(1L, "apple", 3L));

		Mockito.when(dao2.readAll()).thenReturn(order);

		assertEquals(order, controller2.readAll());

		Mockito.verify(dao2, Mockito.times(1)).readAll();
	}
	@Test
	public void Updatetestt() {
		Order updated2 = new Order(1L, "pear", 5L);

		Mockito.when(this.utils.getLong()).thenReturn(updated2.getorder_id());
		Mockito.when(this.utils.getString()).thenReturn(updated2.getorder_item());
		Mockito.when(this.utils.getLong()).thenReturn(updated2.getitem_quantity());
		Mockito.when(this.dao2.update(updated2)).thenReturn(updated2);

		assertEquals(updated2, this.controller2.update());

		Mockito.verify(this.utils, Mockito.times(2)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getString();
		Mockito.verify(this.dao2, Mockito.times(1)).update(updated2);
	}
	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao2.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller2.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao2, Mockito.times(1)).delete(ID);
	}
}
