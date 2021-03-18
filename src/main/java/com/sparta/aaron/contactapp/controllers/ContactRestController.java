package com.sparta.aaron.contactapp.controllers;

import com.sparta.aaron.contactapp.entities.ContactsEntity;
import com.sparta.aaron.contactapp.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Optional;

@RestController
public class ContactRestController {

    private final ContactService contactService;

    @Autowired
    public ContactRestController(ContactService contactService){
        this.contactService = contactService;
    }

    @GetMapping("/rest/contacts")
    public Iterable<ContactsEntity> findAll(){
        return contactService.getAllContacts();
    }

    @GetMapping("/contacts/id=")
    @Path("{id}")
    public Optional<ContactsEntity> findById(@PathParam("id") Integer id) {
        return contactService.findById(id);
    }
}
