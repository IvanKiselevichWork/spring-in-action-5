package kitchen.messaging.jms;

import by.kiselevich.tacocloud.model.Order;

public interface OrderReceiver {

    Order receiveOrder();
}
