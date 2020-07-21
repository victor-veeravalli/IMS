package com.inventory.management.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class InventoryRequest {
	
	private int inventoryItemCode;
	private String inventoryItemName;
	private int quantity;
	private BigDecimal price;
	public int getInventoryItemCode() {
		return inventoryItemCode;
	}
	public void setInventoryItemCode(int inventoryItemCode) {
		this.inventoryItemCode = inventoryItemCode;
	}
	public String getInventoryItemName() {
		return inventoryItemName;
	}
	public void setInventoryItemName(String inventoryItemName) {
		this.inventoryItemName = inventoryItemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
