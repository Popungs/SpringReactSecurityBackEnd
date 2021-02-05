package com.jml.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jml.dao.UserDao;
import com.jml.model.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserDao userDao;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> u = userDao.findByUserName(username);
		
		u.orElseThrow(() -> new UsernameNotFoundException("Not Found: " + username));
		System.out.println(u.get());
		return u.map(MyUserDetails::new).get();	
	}
	

}
