package io.davi.tdd01.repositories;

import io.davi.tdd01.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
