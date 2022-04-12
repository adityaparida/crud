package com.sample.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.crud.domain.User;
import com.sample.crud.exception.NotFoundException;
import com.sample.crud.repo.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/all")
	public List<User> getAllUser() {
		return userRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) 
		throws NotFoundException {
		User user = userRepo.findById(id).orElseThrow(() -> new NotFoundException("For the ID of: " + id));
		return ResponseEntity.ok(user);
	}

	@PostMapping("/create")
	public User createEmployee(@Valid @RequestBody User user) {
		return userRepo.save(user);
	}
}
