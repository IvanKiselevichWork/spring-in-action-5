package by.kiselevich.tacocloud.service;

import by.kiselevich.tacocloud.model.Order;

public interface OrderMessagingService {
    public void sendOrder(Order order);
}
