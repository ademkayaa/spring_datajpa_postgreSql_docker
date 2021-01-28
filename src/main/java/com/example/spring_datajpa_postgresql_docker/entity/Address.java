package com.example.spring_datajpa_postgresql_docker.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_adDress")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"}) // eğer id'ler birbirine eşit ise bu iki nesne eşit
@ToString
public class Address implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_person_address",allocationSize = 1)
    @GeneratedValue(generator = "seq_person_address",strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(length = 500, name = "address")
    private String address;

    @Enumerated
    private AdressType adressType;

    @Column(name = "active")
    private boolean active;

    @ManyToOne // burada eager= her bu bilgi calıştırıldıgında person gelsin lazy sadece get cagrıldıgında gelsin
    @JoinColumn(name = "person_address_id")
    private Person person;

    public enum AdressType{
        HOME_ADDRESS,
        WORK_ADDRESS,
        OTHER
    }
}
