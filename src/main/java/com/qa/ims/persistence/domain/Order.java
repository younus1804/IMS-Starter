package com.qa.ims.persistence.domain;

public class Order {
	
	private Long order_id;
	private String order_item;
	private Long item_quantity;
	private double total_price;
	
	public Order(Long order_id, String order_item, Long item_quantity, double total_price) {
		this.setorder_id(order_id);
		this.setorder_item(order_item);
		this.setitem_quantity(item_quantity);
		this.settotal_price(total_price);
	}
	public void settotal_price(double total_price) {
		this.total_price = total_price;
	}
	public double gettotal_price() {
		return total_price;
	}
	

	public Order(String order_item, Long item_quantity) {
		this.setorder_item(order_item);
		this.setitem_quantity(item_quantity);
	}
	public Order(Long order_id, String order_item, Long item_quantity) {
		this.setorder_item(order_item);
		this.setitem_quantity(item_quantity);
		this.setorder_id(order_id);
	}
	public Order() {
	}
	public void setitem_quantity(Long item_quantity) {
		this.item_quantity = item_quantity;
		
	}
	public Long getorder_id() {
		return order_id;
	}
	public void setorder_id(Long order_id) {
		this.order_id = order_id;
	}
	public String getorder_item() {
		return order_item;
	}
	public void setorder_item(String order_item) {
		this.order_item = order_item;
	}
	public Long getitem_quantity() {
		return item_quantity;
	}
	@Override
	public String toString() {
		return "order id:" + order_id + " order item:" + order_item + " item quantity:" + item_quantity + " subtotal " + total_price;
	}
}
	
	
