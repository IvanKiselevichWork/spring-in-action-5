package kitchen.messaging.jms;

import by.kiselevich.tacocloud.model.Order;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.Message;

@Component
@Slf4j
public class JmsOrderReceiver implements OrderReceiver {

    private final JmsTemplate jms;
    private final MessageConverter converter;
    private final Destination orderQueue;

    @Autowired
    public JmsOrderReceiver(JmsTemplate jms, MessageConverter converter, Destination orderQueue) {
        this.jms = jms;
        this.converter = converter;
        this.orderQueue = orderQueue;
    }

    @Override
    @SneakyThrows
    public Order receiveOrder() {
        Message message = jms.receive(orderQueue);
        log.debug("Received message: {}", message);
        return (Order) converter.fromMessage(message);
    }
}
