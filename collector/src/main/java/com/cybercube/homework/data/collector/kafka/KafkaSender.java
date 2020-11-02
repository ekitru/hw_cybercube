package com.cybercube.homework.data.collector.kafka;

import com.cybercube.homework.data.collector.PersonData;
import com.cybercube.homework.data.collector.QueueSender;
import com.cybercube.homework.data.collector.dto.PersonDataDto;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaSender implements QueueSender {

    public static final String TOPIC_PERSON_DATA = "personData";

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendPersonData(PersonData data, double seed) {
        var message = new PersonDataDto()
                .setUid(UUID.randomUUID())
                .setFirstName(data.getFirstName())
                .setLastName(data.getLastName())
                .setAge(data.getAge())
                .setSeed(seed);

        var future = kafkaTemplate.send(TOPIC_PERSON_DATA, new Gson().toJson(message));
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.debug("Sent message=[{}] with offset=[{}]", message, result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.debug("Unable to send message=[{}] due to : {}", message, ex.getMessage());
            }
        });
    }
}