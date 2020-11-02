package com.cybercube.homework.data.processor;

import com.cybercube.homework.data.processor.dto.PersonDataDto;
import com.cybercube.homework.data.processor.redis.RedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageProcessor {

    private final ScoreCalculator calculator;
    private final RedisRepository redisRepository;

    public void process(PersonDataDto data) {
        log.debug("Process new person data {}", data);
        double score = calculator.calculateScore(data.getSeed(), data.getAge());

        log.info("{} {} has {} score", data.getFirstName(), data.getLastName(), score);
        redisRepository.save(data.getUid(), score);
    }
}
