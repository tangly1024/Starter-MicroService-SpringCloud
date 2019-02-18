package com.tangly.amqp.handler;

import com.tangly.amqp.mq.MqObject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Sender {

    private final AmqpTemplate rabbitTemplate;

    @Autowired
    public Sender(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send() {
        MqObject mqObject = new MqObject(1L, "ha", "ha");
        this.rabbitTemplate.convertAndSend("hello", mqObject);
    }

}
