package com.movieflix;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Movieflix",
                description = "Uma API para cadastro de streamings",
                version = "1"
        )
)
public class MovieflixApplication {

    public static void main(String[] args) {

        SpringApplication.run(MovieflixApplication.class, args);
    }

}
