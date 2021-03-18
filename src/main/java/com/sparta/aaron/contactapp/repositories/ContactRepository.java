package com.sparta.aaron.contactapp.repositories;

import com.sparta.aaron.contactapp.entities.ContactsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<ContactsEntity, Integer> {
    @Query(value = "SELECT DISTINCT * from contacts c where c.contact_id = ?", nativeQuery = true)
    Iterable<ContactsEntity> findContactById(int id);
}
