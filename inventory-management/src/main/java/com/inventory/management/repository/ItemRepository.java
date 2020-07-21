package com.inventory.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.management.entities.InventoryItemsEntity;

public interface ItemRepository extends JpaRepository<InventoryItemsEntity, Integer> {

}
