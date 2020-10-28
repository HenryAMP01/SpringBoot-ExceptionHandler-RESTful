package com.study.exceptions.model.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.study.exceptions.model.dto.BookDTO;
import com.study.exceptions.model.entity.Book;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO toDTO(Book book);

    default List<BookDTO> toListDTO(List<Book> books) {
        if (books == null) {
            return new ArrayList<BookDTO>();
        }

        return books.stream().map(this::toDTO).collect(Collectors.toList());
    }

}
