package com.example.userms.repo;

import com.example.userms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin
public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findByUserName(String userName);
}
