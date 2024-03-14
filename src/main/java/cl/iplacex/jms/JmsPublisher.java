package cl.iplacex.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import cl.iplacex.models.Company;

@Component
public class JmsPublisher {

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("eva002")
    String topic;
    public void send(Company apple) {
        jmsTemplate.convertAndSend(topic, apple);
    }
}