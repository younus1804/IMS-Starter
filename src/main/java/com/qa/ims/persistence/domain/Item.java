package com.qa.ims.persistence.domain;

public class Item {
	
	private Long item_id;
	private String item_name;
	private double item_price;
	
	public Item(Long item_id, String item_name, double item_price) {
		this.setitem_id(item_id);
		this.setitem_name(item_name);
		this.setitem_price(item_price);
	}
	public Item(String item_name, double item_price) {
		this.setitem_name(item_name);
		this.setitem_price(item_price);

	}
	public Long getitem_id() {
		return item_id;
	}
	public void setitem_id(Long item_id) {
		this.item_id = item_id;
	}
	public String getitem_name() {
		return item_name;
	}

	public void setitem_name(String item_name) {
		this.item_name = item_name;
	}
	public double getitem_price() {
		return item_price;
	}

	public void setitem_price(double item_price) {
		this.item_price = item_price;
	}
	@Override
	public String toString() {
		return "id:" + item_id + " item name:" + item_name + " item price:" + item_price;
	}
}
