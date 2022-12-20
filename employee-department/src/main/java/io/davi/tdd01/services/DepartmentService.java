package io.davi.tdd01.services;

import io.davi.tdd01.dto.DepartmentDTO;
import io.davi.tdd01.entities.Department;
import io.davi.tdd01.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public List<DepartmentDTO> findAll() {
        List<Department> list = repository.findAll(Sort.by("name"));
        return list.stream().map(x -> new DepartmentDTO(x))
                .collect(Collectors.toList());
    }
}
