package com.emir_ozgen.bankapi.bank_account_api.service;
import com.emir_ozgen.bankapi.bank_account_api.entity.Account;
import com.emir_ozgen.bankapi.bank_account_api.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }
    public Account createAccount(Account account){
        return accountRepository.save(account);
    }
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
    public Account getById(Long id){
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hesap bulunamadı! ID: " + id));
    }
    public Account updateAccount(Long id,Account updatedAccount){
        Account existing=getById(id);
        if(existing!= null){
            existing.setOwnerName(updatedAccount.getOwnerName());
            existing.setBalance(updatedAccount.getBalance());
            return accountRepository.save(existing);
        }
        return null;
    }
    public void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }
}
