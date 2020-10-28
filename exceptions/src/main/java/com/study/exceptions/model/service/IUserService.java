package com.study.exceptions.model.service;

import java.util.List;

import com.study.exceptions.model.entity.User;

public interface IUserService {

    public User findByUserId(Long id);

    public List<User> findAllUsers();

    public User saveUser(User author);

    public void deleteByUserId(Long id);

    
}