package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UsersDao extends JpaRepository<Users, Integer> {
    public List<Users> findByFirstNameIgnoreCase(String firstName);

    public List<Users> findByFirstNameOrLastNameIgnoreCase(String firstName, String lastName);

    public Optional<Users> findByEmailIgnoreCase(String email);

    public Optional<Users> findByMobileNo(String mobileNo);

    Optional<Users> findByEmailAndPassword(String email, String password);
}
