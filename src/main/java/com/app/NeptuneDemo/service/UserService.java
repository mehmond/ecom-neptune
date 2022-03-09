package com.app.NeptuneDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.app.NeptuneDemo.model.CustomerUserDetail;
import com.app.NeptuneDemo.model.User;
import com.app.NeptuneDemo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User getAuthUser(Authentication auth) {
		Object principal = auth.getPrincipal();
		return ((CustomerUserDetail) principal).getUser();
	}

}
