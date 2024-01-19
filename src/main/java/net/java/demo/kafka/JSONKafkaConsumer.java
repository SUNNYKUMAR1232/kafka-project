package net.java.demo.kafka;

import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import net.java.demo.payload.User;

@Service
public class JSONKafkaConsumer {
    
    private static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JSONKafkaConsumer.class);

    @KafkaListener(topics = "topic2", groupId = "group_id")
    public void consume(User user) {
        LOGGER.info(String.format("#### -> Consumed message -> %s", user.toString()));
    }
}
