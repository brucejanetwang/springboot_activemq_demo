package com.brucejanet.activmq_demo.activemq;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQConsume {

    @JmsListener(destination="queue-1")
    public void recievequeue(String message) {
        System.out.println("queue:" + message + "###################");
    }

    @JmsListener(destination="topic-1", containerFactory="topicListenerContainer")
    public void recievetopic(String message) {
        System.out.println("topic" + message + "###################");
    }
    @JmsListener(destination="topic-1", containerFactory="topicListenerContainer")
    public void recievetopic2(String message) {
        System.out.println("topic2" + message + "###################");
    }

}
