package com.example.spring_datajpa_postgresql_docker.service.impl;

import com.example.spring_datajpa_postgresql_docker.dto.PersonDto;
import com.example.spring_datajpa_postgresql_docker.entity.Address;
import com.example.spring_datajpa_postgresql_docker.entity.Person;
import com.example.spring_datajpa_postgresql_docker.repo.AddressRepository;
import com.example.spring_datajpa_postgresql_docker.repo.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.example.spring_datajpa_postgresql_docker.service.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public PersonDto save(PersonDto personDto) {
        //Assert.isNull(personDto.getName(),"name can not empty");

        Person person = new Person();
        person.setName(personDto.getName());
        person.setSurname(personDto.getSurname());

        final Person personDB = personRepository.save(person);

        List<Address> list = new ArrayList<>();
        personDto.getAddresses().forEach(item -> {
            Address address = new Address();
            address.setAddress(item);
            address.setAdressType(Address.AdressType.OTHER);
            address.setActive(true);
            address.setPerson(personDB);
            list.add(address);

        });

        addressRepository.saveAll(list);
        personDto.setId(personDB.getId());

        return personDto;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> people = personRepository.findAll();
        List<PersonDto> personDtos = new ArrayList<>();

        people.forEach(it -> {
            PersonDto personDto = new PersonDto();
            personDto.setId(it.getId());
            personDto.setName(it.getName());
            personDto.setSurname(it.getSurname());
            personDto.setAddresses(it.getAddressList().stream().map(Address::getAddress).collect(Collectors.toList()));
            personDtos.add(personDto);

        });
        return personDtos;
    }

    @Override
    public Page<PersonDto> getAll(Pageable pageable) {
        return null;
    }
}
