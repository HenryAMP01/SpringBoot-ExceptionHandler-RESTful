package com.study.exceptions.model.dao;

import java.util.List;

import com.study.exceptions.model.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookDao extends JpaRepository<Book, Long> {

    @Query(value = "SELECT b.id, b.code, b.name FROM book_author AS ba "
    +"INNER JOIN book AS b ON ba.book_id = b.id "
    +"INNER JOIN author AS a ON ba.author_id = a.id "
    +"WHERE a.id=:authorId", nativeQuery = true)
    public List<Book> findByAuthorId(@Param("authorId") Long id);


}
