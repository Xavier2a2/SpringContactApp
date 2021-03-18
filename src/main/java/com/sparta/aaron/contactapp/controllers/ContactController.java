package com.sparta.aaron.contactapp.controllers;

import com.sparta.aaron.contactapp.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @GetMapping("/")
    public @ResponseBody
    String welcome(){
        return "Welcome to the Contact App";
    }
}
