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

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	
	@Mock
	private Utils utils;
	
	@Mock
	private ItemDAO dao1;
	
	@InjectMocks
	private ItemController controller1;

	@Test
	public void Createtest() {
		final String itemname = "apple";
		final double itemprice = (double) 2;
			
		final Item created1 = new Item(itemname, itemprice);

		Mockito.when(utils.getString()).thenReturn(itemname);
		Mockito.when(utils.getDouble()).thenReturn(itemprice);
		Mockito.when(dao1.create(created1)).thenReturn(created1);
		
		assertEquals(created1, controller1.create());

		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(dao1, Mockito.times(1)).create(created1);
	}
	
	@Test
	public void ReadAlltest() {
		List<Item> item = new ArrayList<>();
		item.add(new Item("apple", (double) 2));

		Mockito.when(dao1.readAll()).thenReturn(item);

		assertEquals(item, controller1.readAll());

		Mockito.verify(dao1, Mockito.times(1)).readAll();
	}
	
	@Test
	public void Updatetest() {
		Item updated1 = new Item("pear", (double) 3);

		Mockito.when(this.utils.getString()).thenReturn(updated1.getitem_name());
		Mockito.when(this.utils.getDouble()).thenReturn(updated1.getitem_price());
		Mockito.when(this.dao1.update(updated1)).thenReturn(updated1);

		assertEquals(updated1, this.controller1.update());

		Mockito.verify(this.utils, Mockito.times(1)).getString();
		Mockito.verify(this.utils, Mockito.times(1)).getDouble();
		Mockito.verify(this.dao1, Mockito.times(1)).update(updated1);
}
	@Test
	public void Deletetest() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao1.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller1.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao1, Mockito.times(1)).delete(ID);
	}
}
