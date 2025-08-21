package com.inventra.inventra.controllers;

import com.inventra.inventra.data.models.Reminders;
import com.inventra.inventra.dtos.requests.SendReminderRequest;
import com.inventra.inventra.dtos.responses.SendReminderResponse;
import com.inventra.inventra.services.ReminderService;
import com.inventra.inventra.services.ReminderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reminder/")
public class ReminderController {

    @Autowired
    ReminderService reminderService;

    @Autowired
    ReminderServiceImpl reminderServiceImpl;

    @PostMapping("/auto-Reminder")
    public ResponseEntity<?> autoReminder(){
        try {
            SendReminderResponse response = reminderServiceImpl.checkOverdueAssignments();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/manual-Reminder")
    public ResponseEntity<?> manuallyReminder(@RequestBody SendReminderRequest request){
        try {
            SendReminderResponse response = reminderServiceImpl.sendManualReminder(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

}
