package net.java.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.java.demo.kafka.jsonKafkaProducer;
import net.java.demo.payload.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class jsonMessageController {

    private jsonKafkaProducer producer;


    public jsonMessageController(jsonKafkaProducer producer) {
        this.producer = producer;
    }
    
    // http://localhost:8080/api/v1/kafka/publish?message=Hello world
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        producer.sendMessage(user);
        return ResponseEntity.ok("user sent to kafka");
    }

    
}
