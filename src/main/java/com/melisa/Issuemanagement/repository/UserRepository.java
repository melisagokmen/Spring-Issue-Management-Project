package com.melisa.Issuemanagement.repository;

import com.melisa.Issuemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
