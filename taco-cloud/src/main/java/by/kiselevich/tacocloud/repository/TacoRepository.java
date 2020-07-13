package by.kiselevich.tacocloud.repository;

import by.kiselevich.tacocloud.model.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, String> {

}
