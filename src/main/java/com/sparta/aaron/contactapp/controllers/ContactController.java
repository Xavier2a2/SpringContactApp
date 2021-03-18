package com.sparta.aaron.contactapp.controllers;

import com.sparta.aaron.contactapp.entities.ContactsEntity;
import com.sparta.aaron.contactapp.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @GetMapping("")
    public String welcome(){
        return "index";
    }

    @GetMapping("/contacts")
    public String getAllContacts(ModelMap modelMap){
        Iterable<ContactsEntity> contactEntities = contactService.getAllContacts();
        modelMap.addAttribute("contacts", contactEntities);
        return "contacts";
    }

    @GetMapping("/c")
    public String findContactById(@RequestParam Integer id, ModelMap modelMap){
        Iterable<ContactsEntity> contacts = contactService.findContactById(id);
        modelMap.addAttribute("contacts", contacts);
        return "contacts";
    }
}
