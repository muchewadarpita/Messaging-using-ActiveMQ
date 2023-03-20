package com.example.Messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/messages")
    public void sendMessage(@RequestBody String message) {
        jmsTemplate.convertAndSend("test.queue", message);
    }

}
