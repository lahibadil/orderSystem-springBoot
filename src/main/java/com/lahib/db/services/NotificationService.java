package com.lahib.db.services;

import com.lahib.db.entities.Account;
import org.springframework.mail.MailException;

public interface NotificationService {
    void sendEmail(Account account, String msg) throws MailException;
}
