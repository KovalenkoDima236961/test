package com.dimon.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(Solution withoutRecursion) {
        return args -> {
            ClassPathResource resource = new ClassPathResource("products.json");

            String jsonContent = new String(Files.readAllBytes(Paths.get(resource.getURI())));

            ObjectMapper objectMapper = new ObjectMapper();
            LinkedHashMap orderedJsonMap = objectMapper.readValue(jsonContent, LinkedHashMap.class);

            System.out.println("First Task");
            withoutRecursion.runPr(orderedJsonMap, 0);
            System.out.println("Second Task");
            withoutRecursion.findMaxPr(orderedJsonMap);
        };
    }

}
