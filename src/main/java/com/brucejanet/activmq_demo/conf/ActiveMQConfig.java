package com.brucejanet.activmq_demo.conf;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.beans.factory.annotation.Configurable;

@Configuration
public class ActiveMQConfig {

    /**
     * 自定义了4个Destination,两个queue,两个topic
     */
    @Bean
    public Destination queue1() {
        return new ActiveMQQueue("queue-1");
    }

    @Bean
    public Destination queue2() {
        return new ActiveMQQueue("queue-2");
    }

    @Bean
    public Destination topic1() {
        return new ActiveMQTopic("topic-1");
    }

    @Bean
    public Destination topic2() {
        return new ActiveMQTopic("topic-2");
    }

    /**
     * JmsListener注解默认只接收queue消息,如果要接收topic消息,需要设置containerFactory,注意setPubSubDomain=true的设置，区分queue和topic
     */
    @Bean(name="topicListenerContainer")
    public JmsListenerContainerFactory<?> topicListenerContainer(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory topicListenerContainer = new DefaultJmsListenerContainerFactory();
        topicListenerContainer.setPubSubDomain(true);
        topicListenerContainer.setConnectionFactory(activeMQConnectionFactory);
        return topicListenerContainer;
    }

}
