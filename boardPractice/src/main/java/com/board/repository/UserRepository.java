package com.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
