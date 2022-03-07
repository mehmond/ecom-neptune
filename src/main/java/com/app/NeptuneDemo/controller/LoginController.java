package com.app.NeptuneDemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.NeptuneDemo.model.Role;
import com.app.NeptuneDemo.model.User;
import com.app.NeptuneDemo.repository.UserRepository;
import com.app.NeptuneDemo.service.RoleService;

@Controller
public class LoginController {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleService roleService;

	@GetMapping("/sign-in")
	public String signin() {
		return "signin";
	}

	@GetMapping("/sign-up")
	public String signup() {
		return "signup";
	}

	@PostMapping("/sign-up")
	public String signupSubmit(@ModelAttribute("user") User user, HttpServletRequest request) throws ServletException {
		String password = user.getPassword();
		user.setPassword(bCryptPasswordEncoder.encode(password));
		List<Role> roles = new ArrayList<>();
		roles.add(roleService.show((long) 2));
		user.setRoles(roles);
		userRepository.save(user);
		request.login(user.getEmail(), password);
		return "redirect:/";
	}

}
