package com.study.exceptions.model.dao;

import java.util.List;

import com.study.exceptions.model.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookDao extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM book b INNER JOIN book_author ba ON b.id = ba.book_id INNER JOIN author a ON ba.author_id = a.id WHERE a.id=:authorId", nativeQuery = true)
    public List<Book> findByAuthorId(@Param("authorId") Long id);

}
