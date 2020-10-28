package com.study.exceptions.model.controller;

import java.util.List;

import javax.validation.Valid;

import com.study.exceptions.model.dto.UserDTO;
import com.study.exceptions.model.entity.User;
import com.study.exceptions.model.mapper.UserMapper;
import com.study.exceptions.model.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping(value = "/api/users")
@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public List<UserDTO> findAllUsers() {
        return userMapper.toListDTO(userService.findAllUsers());
    }

    @GetMapping(value = "/{id}")
    public UserDTO findByUserId(@PathVariable("id") Long id) {
        return userMapper.toDTO(userService.findByUserId(id));
    }

    @PostMapping
    public UserDTO saveUser(@Valid @RequestBody User user) {
        return userMapper.toDTO(userService.saveUser(user));
    }

    @PutMapping(value = "/{id}")
    public UserDTO updateUser(@Valid @RequestBody User user, @PathVariable("id") Long id) {

        User userFound = userService.findByUserId(id);

        if (userFound == null) {

        }

        // userFound.setId(user.getId());
        userFound.setCode(user.getCode());
        userFound.setName(user.getName());

        return userMapper.toDTO(userService.saveUser(userFound));

    }

    @DeleteMapping(value = "/{id}")
    public void deleteByUserId(@PathVariable("id") Long id) {
        userService.deleteByUserId(id);

    }

}