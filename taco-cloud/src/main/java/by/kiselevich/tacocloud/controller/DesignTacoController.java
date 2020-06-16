package by.kiselevich.tacocloud.controller;

import java.util.ArrayList;
import java.util.List;

import by.kiselevich.tacocloud.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import by.kiselevich.tacocloud.model.Taco;
import by.kiselevich.tacocloud.model.Ingredient;
import by.kiselevich.tacocloud.model.Ingredient.Type;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        addIngredientsToModel(ingredients, model);
        model.addAttribute("taco", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors, Model model) {
        if (errors.hasErrors()) {
            List<Ingredient> ingredients = new ArrayList<>();
            ingredientRepository.findAll().forEach(ingredients::add);
            addIngredientsToModel(ingredients, model);
            return "design";
        }

        // Save the taco design...
        // We'll do this in chapter 3
        log.info("Processing design: " + design);
        return "redirect:/orders/current";
    }

    private void addIngredientsToModel(List<Ingredient> ingredients, Model model) {
        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        List<Ingredient> filteredIngredients = new ArrayList<>();
        for(Ingredient ingredient : ingredients) {
            if (ingredient.getType() == type) {
                filteredIngredients.add(ingredient);
            }
        }
        return filteredIngredients;
    }
}
