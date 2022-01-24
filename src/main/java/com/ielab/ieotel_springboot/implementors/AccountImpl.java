package com.ielab.ieotel_springboot.implementors;

import java.util.List;
import java.util.Optional;

import com.ielab.ieotel_springboot.models.Account;
import com.ielab.ieotel_springboot.repositories.AccountRepository;
import com.ielab.ieotel_springboot.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.bytebuddy.asm.Advice.Return;

@Service
@Transactional
public class AccountImpl implements AccountService{

    @Autowired
    private AccountRepository acRepo;

    @Override
    public Account saveAccount(Account account) {
        // TODO Auto-generated method stub
        return this.acRepo.save(account);
    }

    @Override
    public List<Account> listAccount() {
        // TODO Auto-generated method stub
        return this.acRepo.findAll();
    }

    @Override
    public Optional<Account> showAccount(String id) {
        // TODO Auto-generated method stub
        return this.acRepo.findById(id);
    }
    
}
