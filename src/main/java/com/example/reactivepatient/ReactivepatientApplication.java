package com.example.reactivepatient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class ReactivepatientApplication {

  public static void main(String[] args) {
    SpringApplication.run(ReactivepatientApplication.class, args);
  }
}
