package com.study.exceptions.model.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.study.exceptions.model.dto.UserDTO;
import com.study.exceptions.model.entity.User;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);

    default List<UserDTO> toListDTO(List<User> users) {
        if (users == null) {
            return new ArrayList<UserDTO>();
        }

        return users.stream().map(this::toDTO).collect(Collectors.toList());

    }
    
}
