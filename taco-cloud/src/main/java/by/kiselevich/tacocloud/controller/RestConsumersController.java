package by.kiselevich.tacocloud.controller;

import by.kiselevich.tacocloud.model.Ingredient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequestMapping(path = "/rest_consumers")
public class RestConsumersController {

    private RestTemplate restTemplate = new RestTemplate();
    private Traverson traverson = new Traverson(URI.create("http://localhost:8080/api"), MediaTypes.HAL_JSON);

    @GetMapping(path = "/rest_template")
    public Ingredient getIngredientFlto() {
        return restTemplate.getForObject("http://localhost:8080/api/ingredients/{id}", Ingredient.class, "FLTO");
    }

    @GetMapping(path = "/traverson")
    public CollectionModel<Ingredient> getIngredients() {
        ParameterizedTypeReference<CollectionModel<Ingredient>> ingredientType = new ParameterizedTypeReference<CollectionModel<Ingredient>>() {};
        return traverson.follow("ingredients").toObject(ingredientType);
    }
}