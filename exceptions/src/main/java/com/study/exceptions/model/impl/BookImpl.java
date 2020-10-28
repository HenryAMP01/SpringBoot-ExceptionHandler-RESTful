package com.study.exceptions.model.impl;

import java.util.List;

import com.study.exceptions.exception.custom.ResourceNotFoundException;
import com.study.exceptions.model.dao.IBookDao;
import com.study.exceptions.model.entity.Book;
import com.study.exceptions.model.service.IBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookImpl implements IBookService {

    @Autowired private IBookDao bookDao;

    @Override
    @Transactional(readOnly = true)
    public Book findByBookId(Long id) {
        return bookDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAllBooks() {
        return bookDao.findAll();
    }

    @Override
    @Transactional
    public Book saveBook(Book book) {
        return bookDao.save(book);
    }

    @Override
    @Transactional
    public void deleteByBookId(Long id) {
        bookDao.deleteById(id);
    }

    // Aditional methods

    @Override
    @Transactional(readOnly = true)
    public List<Book> findByAuthorId(Long id) {
        return bookDao.findByAuthorId(id);
    }
    
}