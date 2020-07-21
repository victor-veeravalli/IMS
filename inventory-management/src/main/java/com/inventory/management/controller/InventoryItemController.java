package com.inventory.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.management.model.InventoryRequest;
import com.inventory.management.model.InventoryResponse;
import com.inventory.management.service.InventoryServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
public class InventoryItemController {

	@Autowired
	InventoryServiceImpl inventoryService;
	
	
	@PostMapping("/createInventory")
	@ApiOperation(value="test",notes = "",response = InventoryResponse.class )
	public ResponseEntity<InventoryResponse> createInventory(@RequestBody InventoryRequest inventoryRequest){
		
		InventoryResponse resp=new InventoryResponse();
		resp=inventoryService.createInventory(inventoryRequest);
		
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping("/getInventories")
	
	public ResponseEntity<InventoryResponse> getInventories(@RequestBody InventoryRequest req){
		
		//inventoryService.
		
		return ResponseEntity.ok(new InventoryResponse());
		}
}