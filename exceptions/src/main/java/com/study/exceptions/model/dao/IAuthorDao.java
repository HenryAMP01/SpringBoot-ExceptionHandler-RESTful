package com.study.exceptions.model.dao;

import com.study.exceptions.model.entity.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorDao extends JpaRepository<Author, Long> {
 
}
