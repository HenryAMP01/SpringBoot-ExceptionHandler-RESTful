package com.study.exceptions.model.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.study.exceptions.model.dto.ReviewDTO;
import com.study.exceptions.model.entity.Review;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    @Mapping(source = "review.user.id", target = "userId")
    @Mapping(source = "review.book.id", target = "bookId")
    ReviewDTO toDTO(Review review);

    default List<ReviewDTO> toListDTO(List<Review> reviews) {
        if (reviews == null) {
            return new ArrayList<ReviewDTO>();
        }

        return reviews.stream().map(this::toDTO).collect(Collectors.toList());

    }

}
