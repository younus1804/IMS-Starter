package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {
	
	private final ItemDAO DAO1 = new ItemDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void readAlltest() {
		List<Item> expected1 = new ArrayList<>();
		expected1.add(new Item("apple", (double) 2));
		assertEquals(expected1, DAO1.readAll());
	}
	@Test
	public void readLatesttest() {
		assertEquals(new Item("apple", (double) 2), DAO1.readAll());
	}
	@Test
	public void createtest() {
		final Item created1 = new Item("apple", (double) 2);
		assertEquals(created1, DAO1.create(created1));
	}
	@Test
	public void readtest() {
		final long IDitem = 1L;
		assertEquals(new Item(IDitem, "apple", (double) 2), DAO1.read(IDitem));
	}
	
	@Test
	public void updatetest() {
		final Item updated = new Item("pear", (double) 4);
		assertEquals(updated, DAO1.update(updated));
	}
	@Test
	public void deletetest() {
			assertEquals(1, DAO1.delete(1));
		}
	@Test
	public void exceptiondelete() {
		DBUtils.connect("db.url=jdbc:h2:~/del");
		Item created1 = new Item("apple", (double) 2);
		DAO1.create(created1);
		assertEquals(0, DAO1.delete((created1.getitem_id())));
	}
	@Test
	public void exceptionupdate() {
		DBUtils.connect("db.url=jdbc:h2:~/upd");
		Item updated = new Item("pear", (double) 4);
		assertEquals(updated, DAO1.update(updated));
	}
	@Test
	public void exceptionread() {
		DBUtils.connect("db.url=jdbc:h2:~/read");
		Item created1 = new Item("apple", (double) 2);
		assertEquals(created1, DAO1.read(created1.getitem_id()));
		}
	@Test
	public void exceptionreadlat() {
		DBUtils.connect("db.url=jdbc:h2:~/readl");
		Item created1 = new Item("apple", (double) 2);
		assertEquals(created1, DAO1.readLatest());
		}
	@Test
	public void exceptionreadall() {
		DBUtils.connect("db.url=jdbc:h2:~/reada");
		Item created1 = new Item("apple", (double) 2);
		assertEquals(created1, DAO1.readAll());
		}
}
