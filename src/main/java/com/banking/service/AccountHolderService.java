package com.banking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.banking.exception.InvalidIdException;
import com.banking.model.AccountHolder;
import com.banking.repository.AccountHolderRepository;


@Service
public class AccountHolderService {

	@Autowired
	private AccountHolderRepository accountHolderRepository;

	public AccountHolder postAccountHolder(AccountHolder accountHolder) {
		return accountHolderRepository.save(accountHolder);
	}

	public AccountHolder getByAccHolderId(int accountHolderId) throws InvalidIdException {
		Optional<AccountHolder> optional = accountHolderRepository.findById(accountHolderId);
		 if(!optional.isPresent())
				throw new InvalidIdException("AccountHolder Id is invalid");
			return optional.get();
	}

	

	public List<AccountHolder> getbyAccHolderbyEid(int eid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
