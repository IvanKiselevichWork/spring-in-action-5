package by.kiselevich.tacocloud.repository;

import by.kiselevich.tacocloud.model.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findAll(String id);

    Ingredient save(Ingredient ingredient);
}
