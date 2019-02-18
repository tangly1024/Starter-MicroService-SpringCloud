package com.tangly.amqp.handler;

import com.tangly.amqp.mq.MqObject;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class Receiver {

    @RabbitHandler
    public void process(MqObject mqObject) {
        System.out.println("Receiver : " + mqObject);
    }

}
