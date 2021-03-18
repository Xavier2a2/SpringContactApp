package com.sparta.aaron.contactapp.services;

import com.sparta.aaron.contactapp.entities.ContactsEntity;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Table;
import java.util.List;

@Named
public class ContactDTO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public ContactsEntity findContactById(int id) {
        return entityManager.find(ContactsEntity.class, id);
    }

    public List<ContactsEntity> getAllContacts() {
        return entityManager.createQuery("select c from contacts c",
                ContactsEntity.class).getResultList();
    }

    public List<ContactsEntity> getContactByUserID(int id){
        return entityManager.createQuery(
                "select c from contacts c where c.user_id = :id",
                ContactsEntity.class).setParameter("id", id)
                .getResultList();
    }

    public List<ContactsEntity> getContactByName(String name){
        return entityManager.createQuery(
                "select c from contacts c where c.first_name = :name or c.last_name = :name",
                ContactsEntity.class)
                .setParameter("name", name)
                .getResultList();
    }

    public void resetContactTimer(int contactID){
        entityManager.createQuery(
                "update contacts set last_contact = CURDATE() where contact_id = :contact_id",
                ContactsEntity.class)
                .setParameter("contact_id", contactID)
                .getResultList();
    }

}
