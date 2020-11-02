package com.cybercube.homework.data.collector;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataProcessingService {

    private final ConfigurationService configurationService;
    private final QueueSender sender;

    public void process(PersonData data) {
        log.debug("Start processing new person {}", data);
        double seed = configurationService.getPersonSeed();
        sender.sendPersonData(data, seed);
    }
}