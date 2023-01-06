package com.blogify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogify.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
