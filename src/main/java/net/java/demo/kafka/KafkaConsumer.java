package net.java.demo.kafka;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);


    @KafkaListener(topics = "topic1", groupId = "group_id")
    public void consume(String message) {
        LOGGER.info(String.format("#### -> Consumed message -> %s", message));
    }
}
