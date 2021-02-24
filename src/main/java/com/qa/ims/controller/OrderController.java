package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	private OrderDAO orderDAO;
	private Utils utils;
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orderr = orderDAO.readAll();
		for (Order order : orderr) {
			LOGGER.info(order.toString());
		}
		return orderr;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter a customer id");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter an item name");
		String order_item = utils.getString();
		LOGGER.info("Please enter the quantity for this item");
		Long item_quantity = utils.getLong();
		Order order = orderDAO.create(new Order(order_id, order_item, item_quantity));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter an item name");
		String order_item = utils.getString();
		LOGGER.info("Please enter the items quantity");
		Long item_quantity = utils.getLong();
		Order order = orderDAO.create(new Order(order_id, order_item, item_quantity));
		LOGGER.info("Order Updated");
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long order_id = utils.getLong();
		return orderDAO.delete(order_id);
	}
}
