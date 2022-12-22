package io.davi.tdd2.controllers;

import io.davi.tdd2.dto.EventDTO;
import io.davi.tdd2.entities.Event;
import io.davi.tdd2.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/events")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping
    public ResponseEntity<Page<EventDTO>> findAllPaged(Pageable pageable){
        Page<EventDTO> page = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(page);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EventDTO> updateOne(@PathVariable Long id, @RequestBody EventDTO dto) {
        EventDTO event = service.update(id, dto);
        return ResponseEntity.ok().body(event);
    }

}
