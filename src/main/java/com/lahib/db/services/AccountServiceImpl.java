package com.lahib.db.services;

import com.lahib.db.entities.Account;
import com.lahib.db.repositories.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Adil on 4/19/2017.
 */
@Service
public class AccountServiceImpl implements AccountService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * The Spring Data repository for Account entities.
     */
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findByUsername(String username) {
        logger.info("> findByUsername");
        Account account = accountRepository.findByUsername(username);

        logger.info("< findByUsername");
        return account;
    }
}
