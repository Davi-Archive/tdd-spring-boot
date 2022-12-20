package io.davi.tdd01.services;

import io.davi.tdd01.dto.EmployeeDTO;
import io.davi.tdd01.entities.Department;
import io.davi.tdd01.entities.Employee;
import io.davi.tdd01.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAll(Pageable pageable) {
        Page<Employee> page = repository.findAll(pageable);
        return page.map(x -> new EmployeeDTO(x));
    }

    @Transactional
    public EmployeeDTO insert(EmployeeDTO dto) {
        Employee entity = new Employee();
        return new EmployeeDTO(repository.save(dtoToEntity(dto, entity)));
    }

    private Employee dtoToEntity(EmployeeDTO dto, Employee entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setDepartment(new Department(dto.getDepartmentId(), null));
        return entity;
    }
}
