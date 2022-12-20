package io.davi.tdd01.services;

import io.davi.tdd01.dto.DepartmentDTO;
import io.davi.tdd01.dto.EmployeeDTO;
import io.davi.tdd01.entities.Department;
import io.davi.tdd01.entities.Employee;
import io.davi.tdd01.repositories.DepartmentRepository;
import io.davi.tdd01.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Page<EmployeeDTO> findAll(Pageable pageable) {
        Page<Employee> page = repository.findAll(pageable);
        return page.map(x -> new EmployeeDTO(x));
    }
}
