package by.kiselevich.tacocloud.data;

import by.kiselevich.tacocloud.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, String> {

}
