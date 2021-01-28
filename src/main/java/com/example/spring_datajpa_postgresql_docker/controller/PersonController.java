package com.example.spring_datajpa_postgresql_docker.controller;

import com.example.spring_datajpa_postgresql_docker.dto.PersonDto;
import com.example.spring_datajpa_postgresql_docker.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {


    private final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> save(@RequestBody PersonDto personDto) {
        return ResponseEntity.ok(personService.save(personDto));
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> list_All(){

        //System.out.println("get ");
        return ResponseEntity.ok(personService.getAll());
    }


}
