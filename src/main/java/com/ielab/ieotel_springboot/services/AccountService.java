package com.ielab.ieotel_springboot.services;

import java.util.List;
import java.util.Optional;

import com.ielab.ieotel_springboot.models.Account;

public interface AccountService {
    
    public Account saveAccount(Account account);

    public List<Account> listAccount();

    public Optional<Account> showAccount(String id);
}
