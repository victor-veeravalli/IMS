package com.inventory.management.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;



@Data
@Entity
@Table(name="INVT_ITEMS")
public class InventoryItemsEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ITEM_ID")
	private int id;
	@NotEmpty
	@Column(name="ITEM_CODE")
	private String inventoryItemCode;
	@Column(name="ITEM_NAME")
	private String inventoryItemName;
	@Column(name="PRICE")
	private BigDecimal price;
	@Column(name="QUANTITY")
	private int quantity;

}
