package io.davi.tdd2.services;

import io.davi.tdd2.dto.EventDTO;
import io.davi.tdd2.entities.City;
import io.davi.tdd2.entities.Event;
import io.davi.tdd2.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public EventDTO update(Long id, EventDTO dto){
        Event entity = repository.getOne(id);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new EventDTO(entity);
    }

    private void copyDtoToEntity(EventDTO dto, Event entity) {
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setUrl(dto.getUrl());
        entity.setCity(new City(dto.getCityId(),null));
    }

}
