package by.kiselevich.tacocloud.data;

import by.kiselevich.tacocloud.model.Order;
import by.kiselevich.tacocloud.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, String> {

    List<Order> findByZip(String deliveryZip);

    List<Order> readOrdersByZipAndPlacedAtBetween(String zip, Timestamp startDate, Timestamp endDate);

    List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
