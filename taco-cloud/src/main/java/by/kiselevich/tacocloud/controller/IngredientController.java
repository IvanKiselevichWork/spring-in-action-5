package by.kiselevich.tacocloud.controller;

import by.kiselevich.tacocloud.model.Ingredient;
import by.kiselevich.tacocloud.model.IngredientResource;
import by.kiselevich.tacocloud.repository.IngredientRepository;
import by.kiselevich.tacocloud.resourceassembler.IngredientResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/ingredient", produces = "application/json")
@CrossOrigin(origins = "*")
public class IngredientController {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public  IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("{id}")
    public IngredientResource ingredientById(@PathVariable String id) {
        Optional<Ingredient> optionalIngredient = ingredientRepository.findById(id);
        return new IngredientResourceAssembler()
                .toModel(optionalIngredient.orElseThrow(() -> new RuntimeException("No ingredient with id: " + id)));
    }
}
