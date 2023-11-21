package com.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.model.AccountHolder;
import com.banking.service.AccountHolderService;

@RequestMapping("/accountHolder")
@RestController
public class AccountHolderController {

	@Autowired
	private AccountHolderService accountHolderService;
	
	@PostMapping("/add")
	public AccountHolder postAccountHolder(@RequestBody AccountHolder accountHolder){
		accountHolder = accountHolderService.postAccountHolder(accountHolder);
		return accountHolder;
	}
	

	
	@GetMapping("/getAllbyExe/{eid}")
	public List<AccountHolder> getAllByex(@PathVariable("ei") int eid){
		return null;
	}
	
	
}
