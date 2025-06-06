package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/users")
	public List<User> listUsers() {
		List<User> listUsers = userRepo.findAll();
		return listUsers;
	}
}
