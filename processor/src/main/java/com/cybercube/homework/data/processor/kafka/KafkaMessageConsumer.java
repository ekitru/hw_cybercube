package com.cybercube.homework.data.processor.kafka;

import com.cybercube.homework.data.processor.MessageProcessor;
import com.cybercube.homework.data.processor.dto.PersonDataDto;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaMessageConsumer {

    private final MessageProcessor processor;

    @KafkaListener(topics = "personData")
    void listener(String data) {
        log.debug("New message received {}", data);
        var dataDto = new Gson().fromJson(data, PersonDataDto.class);
        processor.process(dataDto);
    }
}