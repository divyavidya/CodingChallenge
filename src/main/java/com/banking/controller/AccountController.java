package com.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.enums.AccountType;
import com.banking.model.Account;
import com.banking.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/account/add")
	public Account postAccount(@RequestBody Account account) {
		return accountService.postAccount(account);
	}

	@GetMapping("/account/accountType/{type}")
	public List<Account> getAccountsByType(@PathVariable("type") AccountType type) {
		return accountService.getAccountsByType(type);
	}
}
