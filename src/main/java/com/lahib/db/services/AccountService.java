package com.lahib.db.services;

import com.lahib.db.entities.Account;

/**
 * Created by Adil on 4/19/2017.
        */
public interface AccountService {
    Account findByUsername(String username);
}
