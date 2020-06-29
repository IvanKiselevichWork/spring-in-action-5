package by.kiselevich.tacocloud.repository;

import by.kiselevich.tacocloud.model.Order;

public interface OrderRepository {
    Order save(Order order);
}
