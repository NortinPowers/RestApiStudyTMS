package by.tms.rest.api.repository;

import by.tms.rest.api.domain.City;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findCityByName(String name);
}
