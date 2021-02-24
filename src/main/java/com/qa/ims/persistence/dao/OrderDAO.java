package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order>{
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long item_quantity = resultSet.getLong("item_quantity");
		double total_price= resultSet.getDouble("total_price");
		Long order_id = resultSet.getLong("order_id");
		String order_item = resultSet.getString("order_item");
		return new Order(order_id, order_item, item_quantity, total_price);
}
	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(
						"SELECT `order_id`, `order_item`, `item_quantity`, (`item_quantity`*`ims`.`item`.`item_price`) AS 'total_price' FROM `ims`.`order`, `ims`.`item`, `ims`.`customers` where `ims`.`order`.order_id = `ims`.`customers`.`id`");) {
			List<Order> order = new ArrayList<>();
			while (resultSet.next()) {
				order.add(modelFromResultSet(resultSet));
			}
			return order;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM `ims`.`order` ORDER BY `ims`.`order`.`order_no` DESC LIMIT 1;");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	@Override
	public Order create(Order orderr) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("insert into `ims`.`order`(`order`.`order_id`, `order`.`order_item`, `order`.`item_quantity`) VALUES (?, ?, ?)");) {
			statement.setLong(1, orderr.getorder_id());
			statement.setString(2, orderr.getorder_item());
			statement.setLong(3, orderr.getitem_quantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	

	@Override
	public Order read(Long order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM order WHERE order_id = ?");) {
			statement.setLong(1, order_id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public Order update(Order orderr) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE order SET order_item = ?, item_quantity = ? WHERE order_id = ?");) {
			statement.setString(1, orderr.getorder_item());
			statement.setLong(2, orderr.getitem_quantity());
			statement.setLong(3, orderr.getorder_id());
			statement.executeUpdate();
			return read(orderr.getorder_id());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	@Override
	public int delete(long order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM `ims`.`order` WHERE `order`.`order_id` = ?;");) {
			statement.setLong(1, order_id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
