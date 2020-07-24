package kitchen.messaging.jms;

import by.kiselevich.tacocloud.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderListener {

    @JmsListener(destination = "tacocloud.order.queue")
    public void receiveOrder(Order order) {
        log.debug("Order received: {}", order);
    }
}
