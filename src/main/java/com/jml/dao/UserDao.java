package com.jml.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jml.model.User;

public interface UserDao extends JpaRepository<User,Integer>{
	  Optional<User> findByUserName(String userName);
}
