package com.study.exceptions.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    private String commentary;

    @NotNull
    @ManyToOne
    private Book book;

    @NotNull
    @ManyToOne
    private User user;

    public Review() {
    }

    public Review(Long id, String commentary, Book book, User user) {
        this.id = id;
        this.commentary = commentary;
        this.book = book;
        this.user = user;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentary() {
        return this.commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Review)) {
            return false;
        }
        Review review = (Review) o;
        return Objects.equals(id, review.id) && Objects.equals(commentary, review.commentary)
                && Objects.equals(book, review.book) && Objects.equals(user, review.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, commentary, book, user);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", commentary='" + getCommentary() + "'" + ", book='" + getBook() + "'"
                + ", user='" + getUser() + "'" + "}";
    }

}
