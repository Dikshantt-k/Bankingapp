package com.example.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bankingapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
