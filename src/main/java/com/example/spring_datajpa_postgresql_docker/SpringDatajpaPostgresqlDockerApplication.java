package com.example.spring_datajpa_postgresql_docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringDatajpaPostgresqlDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaPostgresqlDockerApplication.class, args);
	}

}
