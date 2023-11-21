package com.banking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.enums.AccountType;
import com.banking.exception.InvalidIdException;
import com.banking.model.Account;
import com.banking.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	public Account postAccount(Account account) {
		return accountRepository.save(account);
	}

	public Account getByAccId(int accountId) throws InvalidIdException {
		Optional<Account> optional = accountRepository.findById(accountId);
		 if(!optional.isPresent())
				throw new InvalidIdException("Account Id is invalid");
			return optional.get();
	}

	public List<Account> getAccountsByType(AccountType type) {
		// TODO Auto-generated method stub
		return accountRepository.findByType(type);
	}

}
