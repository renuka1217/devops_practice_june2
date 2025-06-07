package com.login.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://192.168.23.131:5173")
@RestController
@RequestMapping("/")
public class AppController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/users")
	public List<User> listUsers() {
		List<User> listUsers = userRepo.findAll();
		return listUsers;
	}
}
