package com.example.bankingapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankingapp.dto.AccountDto;
import com.example.bankingapp.entity.Account;
import com.example.bankingapp.mapper.AccountMapper;
import com.example.bankingapp.repository.AccountRepository;

@Service
public class Impl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository; 

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		// TODO Auto-generated method stub
		Account account = AccountMapper.mapToAccount(accountDto);
		Account saveAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(saveAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		// TODO Auto-generated method stub
		Account account = accountRepository
				.findById(id)
				.orElseThrow(()-> new RuntimeException("accountdoes not exits"));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposite(Long id, double amount) {
		
		Account account = accountRepository
				.findById(id)
				.orElseThrow(()-> new RuntimeException("accountdoes not exits"));
		
		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account saveaccount =accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(saveaccount);
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {
		
		Account account = accountRepository
				.findById(id)
				.orElseThrow(()-> new RuntimeException("accountdoes not exits"));
		
		if(account.getBalance() < amount) 
		{
			throw new RuntimeException("Insufficiant ammount");
		}
		
		
		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account saveaccount =accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(saveaccount);
		
		 
	}

	@Override
	public List<AccountDto> getAllAccount() {
		List<Account> accounts = accountRepository.findAll();
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(Long id) {
		
		
	}

}
