package com.tangly.amqp;

import com.tangly.amqp.handler.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AmqpApplication.class)
public class AmqpApplicationTest {

    @Autowired
    private Sender sender;

    @Test
    public void hello() {
        sender.send();
    }
}
