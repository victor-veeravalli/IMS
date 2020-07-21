package com.inventory.management.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.management.entities.InventoryItemsEntity;
import com.inventory.management.model.InventoryRequest;
import com.inventory.management.model.InventoryResponse;
import com.inventory.management.repository.ItemRepository;

@Service
public class InventoryServiceImpl {
	
	@Autowired
	ItemRepository itemRepository;
	

	public InventoryResponse createInventory(InventoryRequest req)
	{
		
		InventoryItemsEntity itemsEntity=new InventoryItemsEntity();
		BeanUtils.copyProperties(req, itemsEntity);
		itemRepository.save(itemsEntity);
		InventoryResponse resp=new InventoryResponse();
		resp.setStatus("Success");
		resp.setMessage("Successfully Created");
		return  resp;
				
	}
	
	public InventoryResponse getItems(InventoryRequest req) {
		
		InventoryResponse resp=new InventoryResponse();
		itemRepository.findAll();
		return resp;
	}
}
