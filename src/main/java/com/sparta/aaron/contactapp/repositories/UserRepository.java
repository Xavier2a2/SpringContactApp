package com.sparta.aaron.contactapp.repositories;

import com.sparta.aaron.contactapp.entities.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UsersEntity, Integer> {
}
