package com.levasalmi.unit_logbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Entry API", version = "1.0", description = "API documentation for managing logbook entries"))
@SpringBootApplication
public class UnitLogbookApplication {

  public static void main(String[] args) {
    SpringApplication.run(UnitLogbookApplication.class, args);
  }

}
