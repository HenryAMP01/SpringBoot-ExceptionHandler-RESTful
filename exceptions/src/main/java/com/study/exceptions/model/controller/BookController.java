package com.study.exceptions.model.controller;

import java.util.List;

import javax.validation.Valid;

import com.study.exceptions.model.dto.BookDTO;
import com.study.exceptions.model.entity.Book;
import com.study.exceptions.model.mapper.BookMapper;
import com.study.exceptions.model.service.IBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/books")
@CrossOrigin("*")
@RestController
public class BookController {

    @Autowired private IBookService bookService;

    @Autowired private BookMapper bookMapper;

    @GetMapping
    public List<BookDTO> findAllBooks() {
        return bookMapper.toListDTO(bookService.findAllBooks());
    }

    @GetMapping(value = "/{id}")
    public BookDTO findByBookId(@PathVariable("id") Long id) {
        return bookMapper.toDTO(bookService.findByBookId(id));
    }

    @PostMapping
    public BookDTO saveBook(@Valid @RequestBody Book book) {
        return bookMapper.toDTO(bookService.saveBook(book));
    }

    @PutMapping(value = "/{id}")
    public BookDTO updateBook(@Valid @RequestBody Book book, @PathVariable("id") Long id){

        Book bookFound = bookService.findByBookId(id);

        if(bookFound == null){
            
        }

        //bookFound.setId(book.getId());
        bookFound.setCode(book.getCode());
        bookFound.setName(book.getName());
        bookFound.setAuthors(book.getAuthors());

        return bookMapper.toDTO(bookService.saveBook(bookFound));

    }

    @DeleteMapping(value = "/{id}")
    public void deleteByBookId(@PathVariable("id") Long id){
        bookService.deleteByBookId(id);

    }

    // Aditional methods

    @GetMapping(value = "/author/{id}")
    public List<BookDTO> findByAuthorId(@PathVariable("id") Long id) {
        return bookMapper.toListDTO(bookService.findByAuthorId(id));
    }

    
    
}