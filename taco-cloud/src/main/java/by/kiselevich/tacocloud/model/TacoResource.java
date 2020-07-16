package by.kiselevich.tacocloud.model;

import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import java.sql.Timestamp;
import java.util.List;

public class TacoResource extends RepresentationModel<Taco> {

    @Getter
    private final String name;
    @Getter
    private final Timestamp createdAt;
    @Getter
    private final List<Ingredient> ingredients;

    public TacoResource(Taco taco) {
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = taco.getIngredients();
    }
}
