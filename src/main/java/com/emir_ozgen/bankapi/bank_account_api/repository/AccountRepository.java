package com.emir_ozgen.bankapi.bank_account_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.emir_ozgen.bankapi.bank_account_api.entity.Account;

public interface AccountRepository  extends JpaRepository<Account,Long> {
}
