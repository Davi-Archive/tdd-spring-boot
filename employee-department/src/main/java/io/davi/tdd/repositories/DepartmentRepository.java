package io.davi.tdd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.davi.tdd.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
