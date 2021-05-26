package remcowewers.examExercise.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Component
public class  EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @PostConstruct
    public void signUpEmail() {

        String from = "dondiablo@wewers.nl";
        String to = "remcowewers24@gmail.com";

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject("This is a plain text email");
        message.setText("Hello guys! This is a plain text email.");
        System.out.println("email send");
        mailSender.send(message);

    }



}
