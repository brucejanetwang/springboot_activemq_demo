package com.brucejanet.activmq_demo.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

@Service
@EnableScheduling
public class ActiveProvider {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Resource(name = "queue1")
    private Destination queue1;

    @Resource(name = "topic1")
    private Destination topic1;

   @Scheduled(fixedRate = 3000)
    public String send1() {
        jmsTemplate.convertAndSend(queue1, "hello queue-1");
        System.out.println("queue send");
        return "ok";
    }

    @Scheduled(fixedRate = 3000)
    public String send2() {
        jmsTemplate.convertAndSend(topic1, "hello topic-1");
        System.out.println("topic send");
        return "ok";
    }

}
