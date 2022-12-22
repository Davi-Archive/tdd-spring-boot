package io.davi.tdd2.dto;

import java.io.Serializable;
import java.time.LocalDate;

import io.davi.tdd2.entities.Event;

import javax.validation.constraints.NotBlank;

public class EventDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Digite o nome do evento")
    private String name;
    private LocalDate date;
    private String url;
    @NotBlank(message = "Digite o id da Cidade")
    private Long cityId;

    public EventDTO() {
    }

    public EventDTO(Long id, String name, LocalDate date, String url, Long cityId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.url = url;
        this.cityId = cityId;
    }

    public EventDTO(Event entity) {
        id = entity.getId();
        name = entity.getName();
        date = entity.getDate();
        url = entity.getUrl();
        cityId = entity.getCity().getId();
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", url='" + url + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
