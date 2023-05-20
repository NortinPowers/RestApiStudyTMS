package by.tms.rest.api.repository;

import by.tms.rest.api.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
