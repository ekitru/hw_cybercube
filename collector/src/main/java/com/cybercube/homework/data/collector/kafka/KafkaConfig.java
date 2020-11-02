package com.cybercube.homework.data.collector.kafka;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.cybercube.homework.data.collector.kafka")
@Import({KafkaProducerConfig.class, KafkaTopicConfig.class})
public class KafkaConfig {
}
