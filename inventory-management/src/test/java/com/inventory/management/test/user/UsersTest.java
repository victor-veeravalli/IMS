package com.inventory.management.test.user;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.inventory.management.entities.UserEntity;
import com.inventory.management.repository.UserRepository;

@RunWith(SpringRunner.class)
public class UsersTest {
	
	@Autowired
	UserRepository repository;
	
	@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void testCreate() {
		
	
		UserEntity user=new UserEntity();
		user.setFirstName("test");
		user.setLastName("testlastname");
		user.setCity("hyd");
		user.setCountry("India");
		user.setMobileNumber("9797979797");
		repository.save(user);
		
	}
	
	@Test
	public void testRead() {
		
	
		Optional<UserEntity> user=repository.findById((long) 1);
		UserEntity entity=new UserEntity();
		if(user.isPresent()) {
			entity=user.get();
		}
		
		assertEquals("Victor", entity.getFirstName());
	}
	
	@Test
	public void testDelete() {
		
		repository.deleteById((long) 1);
	}
	
	

}
