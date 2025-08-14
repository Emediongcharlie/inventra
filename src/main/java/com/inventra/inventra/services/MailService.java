package com.inventra.inventra.services;

import com.inventra.inventra.data.models.Assignment;
import com.inventra.inventra.data.models.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendNotification(String toEmail, Assignment assignment, Items items) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Gentle Reminder");
        message.setText("The assigned item " + items.getName() + " with ID " + items.getItemId() + " and assignment ID " + assignment.getAssignmentId() + " is overdue for return");
        message.setFrom("emediongcharlie@gmail.com");
        mailSender.send(message);
    }
}
