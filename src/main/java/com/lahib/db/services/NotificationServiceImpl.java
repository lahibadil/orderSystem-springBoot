package com.lahib.db.services;

import com.lahib.db.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    private JavaMailSender javaMailSender;

   @Autowired
    public NotificationServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    @Override
    public void sendEmail(Account account, String msg) throws MailException{
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(account.getEmail());
        mailMessage.setFrom("adil.ildivo@gmail.com");
        mailMessage.setSubject("Notification");
        mailMessage.setText(msg);

        javaMailSender.send(mailMessage);
    }

}
