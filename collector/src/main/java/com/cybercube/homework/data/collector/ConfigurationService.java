package com.cybercube.homework.data.collector;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {

    @Value("${data.consumer.person.seed}")
    private Double personSeed;

    double getPersonSeed() {
        return personSeed;
    }
}