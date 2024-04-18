package com.example.bankingapp.mapper;

import com.example.bankingapp.dto.AccountDto;
import com.example.bankingapp.entity.Account;

public class AccountMapper {
	
	//when i call this method it will get accountdto as a  arguments and return same data with Account type
	public static Account mapToAccount(AccountDto accountDto) {
	
		Account account = new Account(
				accountDto.getId(),
				accountDto.getAccountHoldername(),
				accountDto.getBalance()
				
				
				);
		return account;
	}
	
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(
				account.getId(),
				account.getAccountHoldername(),
				account.getBalance()
				);
		return accountDto;
		
	}

}