package com.elibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elibrary.model.User;

public interface UserRepository  extends JpaRepository<User,Integer>{

}
