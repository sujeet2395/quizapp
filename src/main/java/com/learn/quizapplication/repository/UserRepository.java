package com.learn.quizapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.quizapplication.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
