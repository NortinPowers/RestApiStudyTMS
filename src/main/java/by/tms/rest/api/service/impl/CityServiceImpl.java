package by.tms.rest.api.service.impl;

import by.tms.rest.api.repository.CityRepository;
import by.tms.rest.api.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;


}
