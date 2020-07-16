package by.kiselevich.tacocloud.resourceassembler;

import by.kiselevich.tacocloud.controller.IngredientController;
import by.kiselevich.tacocloud.model.Ingredient;
import by.kiselevich.tacocloud.model.IngredientResource;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class IngredientResourceAssembler extends RepresentationModelAssemblerSupport<Ingredient, IngredientResource> {

    public IngredientResourceAssembler() {
        super(IngredientController.class, IngredientResource.class);
    }

    @Override
    protected IngredientResource instantiateModel(Ingredient entity) {
        return new IngredientResource(entity);
    }

    @Override
    public IngredientResource toModel(Ingredient entity) {
        return createModelWithId(entity.getId(), entity);
    }
}
