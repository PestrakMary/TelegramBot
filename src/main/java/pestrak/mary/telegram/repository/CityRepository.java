package pestrak.mary.telegram.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pestrak.mary.telegram.entity.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {
    City findByCity(String city);
    void deleteAllByCity(String city);
}
