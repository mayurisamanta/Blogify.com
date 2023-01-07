package com.blogify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogify.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
