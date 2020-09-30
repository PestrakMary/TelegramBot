package pestrak.mary.telegram.bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pestrak.mary.telegram.repository.CityRepository;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public String findInformationByCity(String city){
        return cityRepository.findByCity(city).getText();
    }
}
