package com.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.enums.AccountType;
import com.banking.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	List<Account> findByType(AccountType type);

}
