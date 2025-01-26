package com.example.bsm.repository;

import com.example.bsm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

//    1.  @Query("from User where email:")
//    public Optional<User> findByEmail(String email);


    //2. method naming convention
    public Optional<User> findByEmail(String email);
}
