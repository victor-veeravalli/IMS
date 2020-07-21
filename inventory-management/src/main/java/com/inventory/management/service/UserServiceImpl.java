package com.inventory.management.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.inventory.management.entities.UserEntity;
import com.inventory.management.model.UserRequest;
import com.inventory.management.model.UserResponse;
import com.inventory.management.repository.UserRepository;

@Service
public class UserServiceImpl {

	@Autowired
	UserRepository userRepository;
	
	private  RedisTemplate<String, UserEntity> redisTemplate;

	public UserResponse createUser(UserRequest userRequest) {

		UserEntity userEntity = new UserEntity();
		UserResponse userResponse = new UserResponse();

		BeanUtils.copyProperties(userRequest, userEntity);

		userRepository.save(userEntity);
		userResponse.setStatus("true");
		userResponse.setMessage("Successful");

		return userResponse;
	}

	public List<UserResponse> getUsers() {

		UserEntity userEntity = new UserEntity();

		List<UserResponse> userRespList = new ArrayList<UserResponse>();

		List<UserEntity> userList = userRepository.findAll();
		//BeanUtils.copyProperties(userList, userRespList);

		List<UserResponse> respCopy = userList.stream().map(i -> new UserResponse(i.getId(), i.getFirstName(),
				i.getLastName(), i.getAddress(), i.getCity(), i.getState(), i.getCountry()))
				.collect(Collectors.toList());

		//Collections.addAll(userList, userRespList);
		
		return respCopy;
	}

	public UserResponse getUserbyId(UserRequest userRequest) {

		UserEntity userEntity = new UserEntity();
		UserResponse userResponse = new UserResponse();

		BeanUtils.copyProperties(userRequest, userEntity);
		// List<UserEntity> userList=new
		
		/*
		 * final String key = "user_" +userRequest.getId(); final
		 * ValueOperations<String, UserEntity> operations = redisTemplate.opsForValue();
		 * final boolean hasKey = redisTemplate.hasKey(key); if (hasKey) { final
		 * UserEntity user = operations.get(key); BeanUtils.copyProperties(user,
		 * userResponse); return userResponse; }
		 */

		Optional<UserEntity> user = userRepository.findById(userEntity.getId());

		if (user.isPresent()) {

			userEntity = user.get();
			BeanUtils.copyProperties(userEntity, userResponse);
		}

		userResponse.setStatus("true");
		userResponse.setMessage("Successful");

		return userResponse;
	}

	public UserResponse deleteUserbyId(UserRequest userRequest) {
		// TODO Auto-generated method stub
		UserEntity entity = new UserEntity();
		UserResponse resp = new UserResponse();
		BeanUtils.copyProperties(userRequest, entity);
		userRepository.deleteById(entity.getId());

		resp.setStatus("true");
		resp.setMessage("Succesfully deleted");

		return resp;
	}

}
