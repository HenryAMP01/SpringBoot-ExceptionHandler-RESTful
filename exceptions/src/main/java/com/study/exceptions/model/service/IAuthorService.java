package com.study.exceptions.model.service;

import java.util.List;

import com.study.exceptions.model.entity.Author;

public interface IAuthorService {

    public Author findByAuthorId(Long id);

    public List<Author> findAllAuthors();

    public Author saveAuthor(Author author);

    public void deleteByAuthorId(Long id);

}
