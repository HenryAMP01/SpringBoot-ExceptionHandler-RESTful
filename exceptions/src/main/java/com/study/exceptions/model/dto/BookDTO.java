package com.study.exceptions.model.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class BookDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String code;

    private String name;

    private Set<AuthorDTO> authors;

    public BookDTO() {
    }

    public BookDTO(Long id, String code, String name, Set<AuthorDTO> authors) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.authors = authors;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AuthorDTO> getAuthors() {
        return this.authors;
    }

    public void setAuthors(Set<AuthorDTO> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BookDTO)) {
            return false;
        }
        BookDTO bookDTO = (BookDTO) o;
        return Objects.equals(id, bookDTO.id) && Objects.equals(code, bookDTO.code)
                && Objects.equals(name, bookDTO.name) && Objects.equals(authors, bookDTO.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, authors);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", code='" + getCode() + "'" + ", name='" + getName() + "'"
                + ", authors='" + getAuthors() + "'" + "}";
    }

}
