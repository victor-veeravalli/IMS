package com.inventory.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.management.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
