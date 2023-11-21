package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.model.BankExecutive;
import com.banking.model.User;
import com.banking.service.BankExecutiveService;
import com.banking.service.UserService;

@RestController
public class BankExecutiveController {
	@Autowired
	private BankExecutiveService bankExecutiveService;
	@Autowired
	private UserService userService;
	
	@PostMapping("/bankExecutive/add")
	public BankExecutive postBankExecutive(@RequestBody BankExecutive bankExecutive) {
		User user = bankExecutive.getUser();
		user=userService.postUser(user);
		bankExecutive.setUser(user);
		return bankExecutiveService.postBankExecutive(bankExecutive);
	}

}
