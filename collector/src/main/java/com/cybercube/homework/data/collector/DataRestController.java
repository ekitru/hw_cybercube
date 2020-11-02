package com.cybercube.homework.data.collector;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/data")
public class DataRestController {

    private final DataProcessingService service;

    DataRestController(DataProcessingService service) {
        this.service = service;
    }

    @PostMapping("/person")
    String processPerson(@RequestBody PersonData person) {
        log.debug("Incoming person {}", person);
        service.process(person);
        return "{\"status\":\"OK\"}\n";
    }
}
