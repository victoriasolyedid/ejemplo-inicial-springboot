package com.example.springboot;

import com.example.springboot.models.repositories.RepositoryOnMem;
import com.example.springboot.models.repositories.TurnoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public TurnoRepository createRepository() {

        return new RepositoryOnMem();

    }
}
