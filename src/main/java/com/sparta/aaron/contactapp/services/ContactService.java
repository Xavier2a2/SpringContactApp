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

    public Iterable<ContactsEntity> findContactById(Integer id) {
        return contactRepository.findContactById(id);
    }

    public void saveContact(ContactsEntity contactsEntity){
        contactRepository.save(contactsEntity);
    }

    public Iterable<ContactsEntity> resetScale(Integer id) {
        contactRepository.resetScale(id);
        contactRepository.updateScales();
        return contactRepository.findAll();
    }

    public Iterable<ContactsEntity> findContact(String parameter){
        parameter = "%"+parameter+"%";
        return contactRepository.findContact(parameter);
    }

    public ContactsEntity editContactFirstName(String newName, String name){
        return contactRepository.editContactByFirstName(newName, name);
    }

    public Iterable<ContactsEntity> updateFirstName(Integer id, String newName){
        contactRepository.updateFirstName(newName, id);
        return contactRepository.findAll();
    }
}
