package by.kiselevich.tacocloud.service;

import by.kiselevich.tacocloud.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;

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
        jmsTemplate.convertAndSend(orderQueue, order, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws JMSException {
                message.setStringProperty("X_ORDER_SOURCE", "WEB");
                return message;
            }
        });
    }
}
