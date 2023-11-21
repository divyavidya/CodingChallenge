package com.banking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.exception.InvalidIdException;
import com.banking.model.BankExecutive;
import com.banking.repository.BankExecutiveRepository;

@Service
public class BankExecutiveService {
	@Autowired
	private BankExecutiveRepository bankExecutiveRepository;

	public BankExecutive postBankExecutive(BankExecutive bankExecutive) {
		
		return bankExecutiveRepository.save(bankExecutive);
	}

	public BankExecutive getByBankExecId(int bankExecutiveId) throws InvalidIdException {
		
		Optional<BankExecutive> optional = bankExecutiveRepository.findById(bankExecutiveId);
		 if(!optional.isPresent())
				throw new InvalidIdException("Bank Executive Id is invalid");
			return optional.get();
	}

}
