package com.inventory.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.management.model.InventoryResponse;
import com.inventory.management.model.UserRequest;
import com.inventory.management.model.UserResponse;
import com.inventory.management.service.UserServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@PostMapping("/createUser")
	@ApiOperation(value="createUser",notes = "Creates USer",response = UserResponse.class )
	public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest){

		UserResponse userResponse=new UserResponse();
		
		userResponse= userServiceImpl.createUser(userRequest);
		return ResponseEntity.ok(userResponse);
	}
	
	@GetMapping("/getUsers")
	@ApiOperation(value="getUsers",notes = "Get USers",response = UserResponse.class )
	public ResponseEntity<List<UserResponse>> getUsers(){

		System.out.println("test");
		
		//userServiceImpl.getUsers();
		return ResponseEntity.ok(userServiceImpl.getUsers());
	}
	
	@GetMapping("/getUserbyId")
	@ApiOperation(value="getUserbyId",notes = "Get User by ID",response = UserResponse.class )
	public ResponseEntity<UserResponse> getUserbyId(@RequestBody UserRequest userRequest){

		UserResponse resp=new UserResponse();
		resp=userServiceImpl.getUserbyId(userRequest);
		
		//userServiceImpl.getUsers();
		return ResponseEntity.ok(resp);
	}
	
	@DeleteMapping("/deleteUserbyId")
	@ApiOperation(value="delete user",notes = "deleteuser",response = UserResponse.class )
	public ResponseEntity<UserResponse> deleteUserbyId(@RequestBody UserRequest userRequest){

		UserResponse resp=new UserResponse();
		resp=userServiceImpl.deleteUserbyId(userRequest);
		
		//userServiceImpl.getUsers();
		return ResponseEntity.ok(resp);
	}


}
