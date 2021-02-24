package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	private ItemDAO itemDAO;
	private Utils utils;
	
	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}
	
	@Override
	public List<Item> readAll() {
		List<Item> itemm = itemDAO.readAll();
		for (Item item : itemm) {
			LOGGER.info(item.toString());
		}
		return itemm;
	}
	@Override
	public Item create() {
		LOGGER.info("Please enter an item name");
		String item_name = utils.getString();
		LOGGER.info("Please enter an item price");
		double item_price = utils.getDouble();
		Item item = itemDAO.create(new Item(item_name, item_price));
		LOGGER.info("Item created");
		return item;
	}
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long item_id = utils.getLong();
		LOGGER.info("Please enter an item name");
		String item_name = utils.getString();
		LOGGER.info("Please enter the items price");
		double item_price = utils.getDouble();
		Item item = itemDAO.create(new Item(item_id, item_name, item_price));
		LOGGER.info("Item Updated");
		return item;
	}
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long item_id = utils.getLong();
		return itemDAO.delete(item_id);
	}
	

}
