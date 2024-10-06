package com.saurbah.dating.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saurbah.dating.entities.Interest;
import com.saurbah.dating.entities.UserAccount;
import com.saurbah.dating.repos.InterestRepostiry;
import com.saurbah.dating.repos.UserAccountRepository;

@RestController
@RequestMapping("/api")
public class UserAccountController {
	@Autowired
	private UserAccountRepository userRepo;
	
	@Autowired
	private InterestRepostiry interestRepo;

	@PostMapping("/users/register-user")
	public UserAccount registerUser(@RequestBody UserAccount userAccount) {
		System.out.println(userAccount);
		return userRepo.save(userAccount);
	}
	
	@PostMapping("/interest/update")
	public Interest updateInterest(@RequestBody Interest interest) {
		UserAccount userAccount = userRepo.findById(interest.getUserAccountId()).get();
		interest.setUserAccount(userAccount);
		return interestRepo.save(interest);
	}
	
	@GetMapping("/users/get/all")
	public List<UserAccount> getAllUserAccounts(){
		return userRepo.findAll();
	}
	
	@DeleteMapping("/users/delete/{interestId}")
	public void deleteInterest(@PathVariable("interestId") int id) {
		interestRepo.deleteById(id);
	}
}
