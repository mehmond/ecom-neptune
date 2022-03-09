package com.app.NeptuneDemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.NeptuneDemo.model.CustomerUserDetail;	
import com.app.NeptuneDemo.model.User;
import com.app.NeptuneDemo.repository.UserRepository;
@Service
public class CustomerUserServiceDetail implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findUserByEmail(email);
		user.orElseThrow(()-> new UsernameNotFoundException("User not found!"));
		return user.map(CustomerUserDetail::new).get();
	}
}
