package com.saurbah.dating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saurbah.dating.entities.UserAccount;
import com.saurbah.dating.repos.UserAccountRepository;

@RestController
@RequestMapping("/api")
public class UserAccountController {
	@Autowired
	private UserAccountRepository userRepo;

	@PostMapping("/users/register-user")
	public UserAccount registerUser(@RequestBody UserAccount userAccount) {
		System.out.println(userAccount);
		return userRepo.save(userAccount);
	}
}
