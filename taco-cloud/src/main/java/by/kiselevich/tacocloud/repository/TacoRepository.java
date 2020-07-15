package by.kiselevich.tacocloud.repository;

import by.kiselevich.tacocloud.model.Taco;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> {
}
