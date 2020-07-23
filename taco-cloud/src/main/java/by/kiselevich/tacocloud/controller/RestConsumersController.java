package by.kiselevich.tacocloud.controller;

import by.kiselevich.tacocloud.model.Ingredient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/rest_consumers")
public class RestConsumersController {

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping(path = "/rest_template")
    public Ingredient getIngredientFlto() {
        return restTemplate.getForObject("http://localhost:8080/api/ingredients/{id}", Ingredient.class, "FLTO");
    }
}
