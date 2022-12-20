package io.davi.tdd01.repositories;

import io.davi.tdd01.entities.Department;
import io.davi.tdd01.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
