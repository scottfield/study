package com.jackie.email.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Jackie on 2016/8/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class SendEmailDemoTest {
    @Autowired
    private SendEmailDemo sendEmailDemo;

    @Test
    public void sendEmail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ckx0211_em@163.com");//发件人
        message.setTo("ckx0211_em@163.com");//收件人
        message.setSubject("test");//主题
        message.setText("test content");//内容
        sendEmailDemo.sendEmail(message);
    }

}