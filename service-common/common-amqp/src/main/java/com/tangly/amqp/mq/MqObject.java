package com.tangly.amqp.mq;


import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@ToString
public class MqObject implements Serializable {
    private Long id;
    private String param;
    private String result;
}
