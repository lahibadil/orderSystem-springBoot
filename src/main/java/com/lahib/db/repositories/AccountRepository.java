package com.lahib.db.repositories;

import com.lahib.db.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Adil on 4/19/2017.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername (String username);
}
