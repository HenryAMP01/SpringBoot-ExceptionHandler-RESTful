package com.study.exceptions.model.impl;

import java.util.List;

import com.study.exceptions.exception.custom.ResourceNotFoundException;
import com.study.exceptions.model.dao.IAuthorDao;
import com.study.exceptions.model.entity.Author;
import com.study.exceptions.model.service.IAuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorImpl implements IAuthorService {

    @Autowired private IAuthorDao authorDao;

    @Override
    @Transactional(readOnly = true)
    public Author findByAuthorId(Long id) {
        return authorDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> findAllAuthors() {
        return authorDao.findAll();
    }

    @Override
    @Transactional
    public Author saveAuthor(Author author) {
        return authorDao.save(author);
    }

    @Override
    @Transactional
    public void deleteByAuthorId(Long id) {
        authorDao.deleteById(id);
    }
    
}
