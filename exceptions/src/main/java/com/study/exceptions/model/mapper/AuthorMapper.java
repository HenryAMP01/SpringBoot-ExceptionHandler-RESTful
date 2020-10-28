package com.study.exceptions.model.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.study.exceptions.model.dto.AuthorDTO;
import com.study.exceptions.model.entity.Author;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDTO toDTO(Author author);

    default List<AuthorDTO> toListDTO(List<Author> authors) {
        if (authors == null) {
            return new ArrayList<>();
        }

        return authors.stream().map(this::toDTO).collect(Collectors.toList());

    }

}
