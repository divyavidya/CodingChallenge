package com.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.model.AccountDetails;
import com.banking.repository.AccountDetailsRepository;

@Service
public class AccountDetailsService {

	@Autowired
	private AccountDetailsRepository accountDetailsRepository;

	public AccountDetails post(AccountDetails accountDetails) {
		
		return accountDetailsRepository.save(accountDetails);
	}
	
}
