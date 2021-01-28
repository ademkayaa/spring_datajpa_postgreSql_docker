package com.example.spring_datajpa_postgresql_docker.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"}) // eğer id'ler birbirine eşit ise bu iki nesne eşit
@ToString
public class Person {

    @Id
    @SequenceGenerator(name = "seq_person",allocationSize = 1)
    @GeneratedValue(generator = "seq_person",strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(length = 100, name = "name")
    private String name;

    @Column(length = 100, name = "surname")
    private String surname;

    @OneToMany
    @JoinColumn(name = "person_address_id")
    private List<Address> addressList;
}
