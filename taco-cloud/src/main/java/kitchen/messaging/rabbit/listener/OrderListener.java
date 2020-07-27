package kitchen.messaging.rabbit.listener;

import by.kiselevich.tacocloud.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderListener {

    @RabbitListener(queues = "tacocloud.order.queue")
    public void receiveOrder(Order order) {
        log.debug("Order received: {}", order);
    }
}
