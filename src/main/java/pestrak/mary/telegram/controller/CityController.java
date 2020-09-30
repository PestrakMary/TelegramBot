package pestrak.mary.telegram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pestrak.mary.telegram.entity.City;
import pestrak.mary.telegram.repository.CityRepository;

import java.util.Optional;

@RestController
public class CityController {

    @Autowired
    CityRepository cityRepository;

    @GetMapping(value ="/cities")
    public ResponseEntity<?> cities() {
        final Iterable<?> cities = cityRepository.findAll();

        return cities.iterator().hasNext() ?
                new ResponseEntity<>(cities, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value ="/cities/{id}")
    public ResponseEntity<?> city(@PathVariable(name = "id") int id) {
        final Optional<?> city = cityRepository.findById(id);

        return city.map(value ->
                new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value ="/cities")
    public ResponseEntity<?> addCity(@RequestBody City city) {
            cityRepository.save(city);
            return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value ="/cities/{id}")
    public ResponseEntity<?> updateCity(@PathVariable(name = "id") int id, @RequestBody City city) {
        boolean updated = false;
        if (cityRepository.existsById(id)) {
            city.setId(id);
            cityRepository.save(city);
            updated = true;
        }
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value ="/cities/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(name = "id") int id) {
        boolean deleted = false;
        if(cityRepository.existsById(id)) {
            cityRepository.deleteById(id);
            deleted = true;
        }

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
