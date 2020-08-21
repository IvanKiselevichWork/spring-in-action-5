package by.kiselevich.repository;

import by.kiselevich.model.Taco;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TacoRepository extends ReactiveCrudRepository<Taco, Long> {
}
