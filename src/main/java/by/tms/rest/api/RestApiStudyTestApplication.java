package by.tms.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("by.tms.rest.api.repository")
public class RestApiStudyTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiStudyTestApplication.class, args);
    }

}
