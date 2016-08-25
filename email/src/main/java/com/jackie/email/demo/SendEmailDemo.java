package com.jackie.email.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 * Created by Jackie on 2016/8/25.
 */
@Component
public class SendEmailDemo {
    @Autowired
    private MailSender mailSender;

    public void sendEmail(SimpleMailMessage message) {
        mailSender.send(message);

    }
}
