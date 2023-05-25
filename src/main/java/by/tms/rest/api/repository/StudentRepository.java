package by.tms.rest.api.repository;

import by.tms.rest.api.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByNameIgnoreCaseAndSurnameIgnoreCase(String name, String surname);

    Optional<Student> findByNameIgnoreCase(String name);
}
