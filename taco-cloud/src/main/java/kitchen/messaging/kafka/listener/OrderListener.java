package kitchen.messaging.kafka.listener;

import by.kiselevich.tacocloud.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderListener {

    @KafkaListener(topics="tacocloud.orders.topic")
    public void handle(Order order) {
        log.debug("Order received: {}", order);
    }

    @KafkaListener(topics="tacocloud.orders.topic")
    public void handle(Order order, ConsumerRecord<Long, Order> record) {
        log.info("Received from partition {} with timestamp {}",
                record.partition(), record.timestamp());
    }

    @KafkaListener(topics="tacocloud.orders.topic")
    public void handle(Order order, Message<Order> message) {
        MessageHeaders headers = message.getHeaders();
        log.info("Received from partition {} with timestamp {}",
                headers.get(KafkaHeaders.RECEIVED_PARTITION_ID),
                headers.get(KafkaHeaders.RECEIVED_TIMESTAMP));
    }
}
