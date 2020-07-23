package by.kiselevich.tacocloud.service;

import by.kiselevich.tacocloud.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;

public class JmsOrderMessagingService implements OrderMessagingService {

    private final JmsTemplate jmsTemplate;
    private final Destination orderQueue;

    @Autowired
    public JmsOrderMessagingService(JmsTemplate jmsTemplate, Destination orderQueue) {
        this.jmsTemplate = jmsTemplate;
        this.orderQueue = orderQueue;
    }

    @Override
    public void sendOrder(Order order) {
        jmsTemplate.send(orderQueue, (session -> session.createObjectMessage(order)));
    }
}
