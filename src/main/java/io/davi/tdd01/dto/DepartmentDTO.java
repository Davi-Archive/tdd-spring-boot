package io.davi.tdd01.dto;

import io.davi.tdd01.entities.Department;

import java.io.Serializable;

public class DepartmentDTO implements Serializable {
    private Long id;
    private String name;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Department entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
