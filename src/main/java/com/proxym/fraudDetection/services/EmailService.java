package com.proxym.fraudDetection.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail, String subject, int i){
        SimpleMailMessage m = new SimpleMailMessage();
        m.setFrom("mohamedachrafhamrouni@gmail.com");
        m.setTo(toEmail);
        m.setText(Integer.toString(i));
        m.setSubject(String.valueOf(subject));

        mailSender.send(m);
        System.out.println("Email Sent Successfully.... ");
    }
}
