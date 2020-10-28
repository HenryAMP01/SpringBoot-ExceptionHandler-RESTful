package com.study.exceptions.model.dto;

import java.io.Serializable;
import java.util.Objects;


public class AuthorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String code;

    private String name;

    public AuthorDTO() {
    }

    public AuthorDTO(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AuthorDTO)) {
            return false;
        }
        AuthorDTO authorDTO = (AuthorDTO) o;
        return Objects.equals(id, authorDTO.id) && Objects.equals(code, authorDTO.code)
                && Objects.equals(name, authorDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", code='" + getCode() + "'" + ", name='" + getName() + "'" + "}";
    }

}
