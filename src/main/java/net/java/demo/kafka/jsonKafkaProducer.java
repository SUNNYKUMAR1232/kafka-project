package net.java.demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import net.java.demo.payload.User;

@Service
public class jsonKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(jsonKafkaProducer.class);

    private KafkaTemplate<String, User> kafkaTemplate;
    
    public jsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User user) {
        LOGGER.info(String.format("#### -> Message send -> %s", user.toString()));
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, "topic2")
                .build();
                kafkaTemplate.send(message);
    }

}
