package com.userservice.app.repository;

import com.userservice.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//    User findByUserId(Long userId);
}
