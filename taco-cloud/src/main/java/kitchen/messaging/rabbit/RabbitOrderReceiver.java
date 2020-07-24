package kitchen.messaging.rabbit;

import by.kiselevich.tacocloud.model.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

@Component
public class RabbitOrderReceiver {

    private final RabbitTemplate rabbit;

    @Autowired
    public RabbitOrderReceiver(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }

    public Order receiveOrder() {
        return rabbit.receiveAndConvert("tacocloud.orders", new ParameterizedTypeReference<Order>() {});
    }
}
