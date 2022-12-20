package io.davi.tdd2.services;

import io.davi.tdd2.dto.CityDTO;
import io.davi.tdd2.entities.City;
import io.davi.tdd2.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    private List<CityDTO> findAll() {
        List<City> list = repository.findAll(Sort.by("name"));
        return list.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());
    }

    private CityDTO insert(CityDTO dto) {
        City entity = new City();
        entity.setName(dto.getName());
        repository.save(entity);
        return new CityDTO(entity);
    }

    private void deleteOne(Long id) {
        repository.deleteById(id);
    }
}
