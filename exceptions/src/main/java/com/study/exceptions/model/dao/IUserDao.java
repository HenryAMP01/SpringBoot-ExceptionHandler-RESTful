package com.study.exceptions.model.dao;

import com.study.exceptions.model.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<User, Long>{
    
}
