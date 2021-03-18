package com.sparta.aaron.contactapp.services;

import com.sparta.aaron.contactapp.entities.ContactsEntity;
import com.sparta.aaron.contactapp.repositories.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {

    private ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    public Iterable<ContactsEntity> getAllContacts() {
        return contactRepository.findAll();
    }

    public Optional<ContactsEntity> findById(Integer id) {
        return contactRepository.findById(id);
    }

    public void saveContact(ContactsEntity contactsEntity){
        contactRepository.save(contactsEntity);
    }
}
