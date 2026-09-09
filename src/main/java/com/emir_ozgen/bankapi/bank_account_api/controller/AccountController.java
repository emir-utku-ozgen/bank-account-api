package com.emir_ozgen.bankapi.bank_account_api.controller;

import com.emir_ozgen.bankapi.bank_account_api.entity.Account;
import org.springframework.web.bind.annotation.*;
import com.emir_ozgen.bankapi.bank_account_api.service.AccountService;
import java.util.List;
@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService ;
    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }
    @PostMapping
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }
    @GetMapping
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id){
        return accountService.getById(id);
    }

    @PutMapping("/{id}")
    public Account updatedAccount(@PathVariable Long id,@RequestBody Account account){
        return accountService.updateAccount(id,account);
    }
    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return "Account with ID " + id + " has been deleted.";
    }
}
