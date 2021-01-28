package com.example.spring_datajpa_postgresql_docker.repo;
import com.example.spring_datajpa_postgresql_docker.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
