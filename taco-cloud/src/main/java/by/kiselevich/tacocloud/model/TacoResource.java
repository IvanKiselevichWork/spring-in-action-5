package by.kiselevich.tacocloud.model;

import by.kiselevich.tacocloud.resourceassembler.IngredientResourceAssembler;
import lombok.Getter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.sql.Timestamp;

@Relation(value = "taco", collectionRelation = "tacos")
public class TacoResource extends RepresentationModel<Taco> {

    private static final IngredientResourceAssembler INGREDIENT_RESOURCE_ASSEMBLER = new IngredientResourceAssembler();

    @Getter
    private final String name;
    @Getter
    private final Timestamp createdAt;
    @Getter
    private final CollectionModel<IngredientResource> ingredients;

    public TacoResource(Taco taco) {
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = INGREDIENT_RESOURCE_ASSEMBLER.toCollectionModel(taco.getIngredients());
    }
}
