package kitchen.messaging.jms;

import by.kiselevich.tacocloud.model.Order;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
@Slf4j
public class JmsOrderReceiver implements OrderReceiver {

    private final JmsTemplate jms;
    private final Destination orderQueue;

    @Autowired
    public JmsOrderReceiver(JmsTemplate jms, Destination orderQueue) {
        this.jms = jms;
        this.orderQueue = orderQueue;
    }

    @Override
    @SneakyThrows
    public Order receiveOrder() {
        Order order = (Order) jms.receiveAndConvert(orderQueue);
        log.debug("Received message: {}", order);
        return order;
    }
}
