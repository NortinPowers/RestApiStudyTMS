package by.tms.rest.api.repository;

import by.tms.rest.api.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

}
