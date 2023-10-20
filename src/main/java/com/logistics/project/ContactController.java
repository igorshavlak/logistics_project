package com.logistics.project;

import com.logistics.project.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
    private JavaMailSender emailSender;

    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestBody ContactForm contactForm) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("vdrabovskyi@gmail.com");
        message.setSubject("New Contact Request");
        message.setText("Name: " + contactForm.getName() + "\nPhone Number: " + contactForm.getPhoneNumber());
        emailSender.send(message);
        return ResponseEntity.ok("Email sent successfully");
    }
}
