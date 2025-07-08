package com.example.schedulr.repository;

import com.example.schedulr.db.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {

    @Query("select a from UserDetails a where a.userName=?1")
    UserDetails checkCredentials(String userName);

    @Query("select a from UserDetails a where a.emailId=?1")
    UserDetails checkEmail(String emailId);

}
