package com.sparta.aaron.contactapp.controllers;

import com.sparta.aaron.contactapp.entities.ContactsEntity;
import com.sparta.aaron.contactapp.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

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

    @GetMapping("/id")
    public String findContactById(@RequestParam Integer id, ModelMap modelMap){
        Iterable<ContactsEntity> contacts = contactService.findContactById(id);
        modelMap.addAttribute("contacts", contacts);
        return "contacts";
    }

    @GetMapping("/resetContact")
    public String resetScale(@RequestParam Integer id, ModelMap modelMap){
        Iterable<ContactsEntity> contacts = contactService.resetScale(id);
        modelMap.addAttribute("contacts", contacts);
        return "contacts";
    }

    @GetMapping("/searchDatabase")
    public String findContact(@RequestParam String search, ModelMap modelMap){
        if(isNumerical(search)){
            int id = Integer.parseInt(search);
            Iterable<ContactsEntity> contacts = contactService.findContactById(id);
            modelMap.addAttribute("contacts", contacts);
        } else {
            Iterable<ContactsEntity> contacts = contactService.findContact(search);
            modelMap.addAttribute("contacts", contacts);
        }
        return "contacts";
    }

    @GetMapping("/edit-firstName")
    public String edit(@RequestParam("contact") Integer id, @RequestParam("FirstName") String newName, ModelMap modelMap){
        Iterable<ContactsEntity> contacts = contactService.updateFirstName(id, newName);
        modelMap.addAttribute("contacts", contacts);
        return "contacts";
    }
//    @GetMapping("/edit/firstname")
//    public String editContact(@RequestParam String newName, @RequestParam String name, ModelMap modelMap){
//        ContactsEntity contacts = contactService.editContactFirstName(newName, name);
//        modelMap.addAttribute("contactToEdit", contacts);
//        return "contacts";
//    }

    private boolean isNumerical(String search){
        char[] charString = search.toCharArray();
        String numbers = "0123456789";
        for(char character : charString){
            if(!numbers.contains(""+character)){
                return false;
            }
        }
        return true;
    }


}
