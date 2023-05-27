package by.tms.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories("by.tms.rest.api.repository")
@EnableTransactionManagement
public class RestApiStudyTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiStudyTestApplication.class, args);
    }

}
