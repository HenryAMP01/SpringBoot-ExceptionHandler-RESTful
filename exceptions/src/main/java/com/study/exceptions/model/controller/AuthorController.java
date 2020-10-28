package com.study.exceptions.model.controller;

import java.util.List;

import javax.validation.Valid;

import com.study.exceptions.model.dto.AuthorDTO;
import com.study.exceptions.model.entity.Author;
import com.study.exceptions.model.mapper.AuthorMapper;
import com.study.exceptions.model.service.IAuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping(value = "/api/authors")
@CrossOrigin("*")
@RestController
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @Autowired
    private AuthorMapper authorMapper;

    @GetMapping
    public List<AuthorDTO> findAllAuthors() {
        return authorMapper.toListDTO(authorService.findAllAuthors());
    }

    @GetMapping(value = "/{id}")
    public AuthorDTO findByAuthorId(@PathVariable("id") Long id) {
        return authorMapper.toDTO(authorService.findByAuthorId(id));
    }

    @PostMapping
    public AuthorDTO saveAuthor(@Valid @RequestBody Author author) {
        return authorMapper.toDTO(authorService.saveAuthor(author));
    }

    @PutMapping(value = "/{id}")
    public AuthorDTO updateAuthor(@Valid @RequestBody Author author, @PathVariable("id") Long id) {

        Author authorFound = authorService.findByAuthorId(id);

        // authorFound.setId(author.getId());
        authorFound.setCode(author.getCode());
        authorFound.setName(author.getName());

        return authorMapper.toDTO(authorService.saveAuthor(authorFound));

    }

    @DeleteMapping(value = "/{id}")
    public void deleteByAuthorId(@PathVariable("id") Long id) {
        authorService.deleteByAuthorId(id);

    }

}
