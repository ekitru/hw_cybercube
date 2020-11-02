package com.cybercube.homework.data.processor;

import com.cybercube.homework.data.processor.kafka.KafkaConfig;
import com.cybercube.homework.data.processor.redis.RedisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({KafkaConfig.class, RedisConfig.class})
public class ProcessorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcessorApplication.class, args);
    }
}