package com.study.exceptions.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class ReviewDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;

    private String commentary;

    private Long bookId;

    private Long userId;


    public ReviewDTO() {
    }

    public ReviewDTO(Long id, String commentary, Long bookId, Long userId) {
        this.id = id;
        this.commentary = commentary;
        this.bookId = bookId;
        this.userId = userId;
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

    public Long getBookId() {
        return this.bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ReviewDTO)) {
            return false;
        }
        ReviewDTO reviewDTO = (ReviewDTO) o;
        return Objects.equals(id, reviewDTO.id) && Objects.equals(commentary, reviewDTO.commentary) && Objects.equals(bookId, reviewDTO.bookId) && Objects.equals(userId, reviewDTO.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, commentary, bookId, userId);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", commentary='" + getCommentary() + "'" +
            ", bookId='" + getBookId() + "'" +
            ", userId='" + getUserId() + "'" +
            "}";
    }

    
}
