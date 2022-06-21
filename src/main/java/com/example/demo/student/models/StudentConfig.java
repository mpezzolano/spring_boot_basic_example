package com.example.demo.student.models;

import com.example.demo.student.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    public static final String MARIAM_2 = "mariam2";

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
               Student Mariam = new Student(
                       "mariam",
                       "mariam@dom.com",
                       LocalDate.of(2000, Month.JANUARY,10),
                       10
               );

            Student Mariam2 = new Student(
                    MARIAM_2,
                    "mariam2@dom.com",
                    LocalDate.of(2000, Month.JANUARY,10),
                    10
            );

            repository.saveAll(
                    List.of(Mariam,Mariam2)
            );

        };
    }
}
