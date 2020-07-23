package by.kiselevich.tacocloud.service;

import by.kiselevich.tacocloud.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class JmsOrderMessagingService implements OrderMessagingService {

    protected JmsTemplate jmsTemplate;

    @Autowired
    public JmsOrderMessagingService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendOrder(Order order) {
        jmsTemplate.send((session -> session.createObjectMessage(order)));
    }
}
