package by.kiselevich.tacocloud.model;

import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

@Getter
public class IngredientResource extends RepresentationModel<Ingredient> {
    private final String name;
    private final Ingredient.Type type;

    public IngredientResource(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }
}
