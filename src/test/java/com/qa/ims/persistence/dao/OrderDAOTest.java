package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO DAO2 = new OrderDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void Createtestt() {
		final Order created2 = new Order(2L, "apple", 3L);
		assertEquals(created2, DAO2.create(created2));
	}
	
	@Test
	public void ReadAlltestt() {
		List<Order> expected2 = new ArrayList<>();
		expected2.add(new Order(1L, "apple", 3L));
		assertEquals(expected2, DAO2.readAll());
	}
	
	@Test
	public void ReadLatesttestt() {
		assertEquals(new Order(1L, "apple", 3L), DAO2.readLatest());
	}
	
	@Test
	public void Readtestt() {
		final long ID = 1L;
		assertEquals(new Order(ID, "apple", 3L), DAO2.read(ID));
	}
	
	@Test
	public void Updatetestt() {
		final Order updated2 = new Order(2L, "pear", 5L);
		assertEquals(updated2, DAO2.update(updated2));

	}
	@Test
	public void Deletetestt() {
		assertEquals(1, DAO2.delete(1));
	}
	public void oexceptiondelete() {
		DBUtils.connect("db.url=jdbc:h2:~/odel");
		Order created2 =  new Order(2L, "apple", 3L);
		DAO2.create(created2);
		assertEquals(0, DAO2.delete((created2.getorder_id())));
	}
	@Test
	public void oexceptionupdate() {
		DBUtils.connect("db.url=jdbc:h2:~/oupd");
		Order updated2 = new Order(2L, "apple", 3L);
		assertEquals(updated2, DAO2.update(updated2));
	}
	@Test
	public void oexceptionread() {
		DBUtils.connect("db.url=jdbc:h2:~/oread");
		Order created2 = new Order(2L, "apple", 3L);
		assertEquals(created2, DAO2.read(created2.getorder_id()));
		}
	@Test
	public void oexceptionreadlat() {
		DBUtils.connect("db.url=jdbc:h2:~/oreadl");
		Order created2 = new Order(2L, "apple", 3L);
		assertEquals(created2, DAO2.readLatest());
		}
	@Test
	public void oexceptionreadall() {
		DBUtils.connect("db.url=jdbc:h2:~/oreada");
		Order created2 = new Order(2L, "apple", 3L);
		assertEquals(created2, DAO2.readAll());
		}
}
