package com.study.exceptions.model.service;

import java.util.List;

import com.study.exceptions.model.entity.Book;

public interface IBookService {

    public Book findByBookId(Long id);

    public List<Book> findAllBooks();

    public Book saveBook(Book author);

    public void deleteByBookId(Long id);

    // Aditional methods

    public List<Book> findByAuthorId(Long id);
    
}
