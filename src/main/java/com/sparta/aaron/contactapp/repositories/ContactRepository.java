package com.sparta.aaron.contactapp.repositories;

import com.sparta.aaron.contactapp.entities.ContactsEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ContactRepository extends CrudRepository<ContactsEntity, Integer> {

    //Search Queries
    @Query(value = "SELECT DISTINCT * from contacts c where c.contact_id = "+"?", nativeQuery = true)
    Iterable<ContactsEntity> findContactById(Integer id);

    @Query(value = "SELECT DISTINCT * from contacts c where c.first_name like ?1 or c.last_name like ?1 or c.contact_groups like ?1", nativeQuery = true)
    Iterable<ContactsEntity> findContact(String parameter);


    //Modifying Queries
    @Modifying
    @Transactional
    @Query(value = "update contacts set last_contact = CURDATE() where contact_id = ? ;", nativeQuery = true)
    void resetScale(Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE contacts set time_scale = (DATEDIFF(CURDATE(),last_contact))/max_period", nativeQuery = true)
    void updateScales();

    @Modifying
    @Transactional
    @Query(value = "update contacts set first_name = ? where contact_id = ?", nativeQuery = true)
    ContactsEntity editContactByFirstName(String newName, String name);

    @Modifying
    @Transactional
    @Query(value = "update contacts set first_name = ? where contact_id = ?", nativeQuery = true)
    void updateFirstName(String newName, Integer id);


}
