package com.example.spring_datajpa_postgresql_docker.dto;

import lombok.Data;

import java.util.List;

@Data
public class PersonDto {

    private Long id;
    private String name;
    private String surname;
    private List<String> addresses;
}
