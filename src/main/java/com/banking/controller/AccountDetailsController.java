package com.banking.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.dto.AccountDetailsDto;
import com.banking.exception.InvalidIdException;
import com.banking.model.Account;
import com.banking.model.AccountDetails;
import com.banking.model.AccountHolder;
import com.banking.model.BankExecutive;
import com.banking.service.AccountDetailsService;
import com.banking.service.AccountHolderService;
import com.banking.service.AccountService;
import com.banking.service.BankExecutiveService;

@RestController
public class AccountDetailsController {
	@Autowired
	private AccountDetailsService accountDetailsService;
	@Autowired
	private AccountHolderService accountHolderService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private BankExecutiveService bankExecutiveService;
	
	@PostMapping("/accountDetails/add")
	public ResponseEntity<?> postAccountDetails(AccountDetailsDto accountDetailsDto) {
		try {
			int accountHolderId=accountDetailsDto.getAccountHolderId();
			AccountHolder accountHolder=accountHolderService.getByAccHolderId(accountHolderId);
			AccountDetails accountDetails=new AccountDetails();
			accountDetails.setAccountHolder(accountHolder);
			int accountId= accountDetailsDto.getAccountId();
			Account account=accountService.getByAccId(accountId);
			accountDetails.setAccount(account);
			int bankExecutiveId=accountDetailsDto.getBankExecutiveId();
			BankExecutive bankExecutive=bankExecutiveService.getByBankExecId(bankExecutiveId);
			accountDetails.setBankExecutive(bankExecutive);
			LocalDate dateOfCreation=LocalDate.now();
			accountDetails.setDateOfCreation(dateOfCreation);
			accountDetails=accountDetailsService.post(accountDetails);
			return ResponseEntity.ok().body(account);
			
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	
	

}}
