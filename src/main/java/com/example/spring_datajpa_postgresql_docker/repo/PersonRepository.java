package com.example.spring_datajpa_postgresql_docker.repo;
import com.example.spring_datajpa_postgresql_docker.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}

