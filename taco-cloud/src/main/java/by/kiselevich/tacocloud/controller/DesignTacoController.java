package by.kiselevich.tacocloud.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    private static final List<Ingredient> INGREDIENTS = Arrays.asList(
            new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
            new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
            new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
            new Ingredient("CARN", "Carnitas", Type.PROTEIN),
            new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
            new Ingredient("LETC", "Lettuce", Type.VEGGIES),
            new Ingredient("CHED", "Cheddar", Type.CHEESE),
            new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
            new Ingredient("SLSA", "Salsa", Type.SAUCE),
            new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
    );

    @GetMapping
    public String showDesignForm(Model model) {
        addIngredientsToModel(model);
        model.addAttribute("taco", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors, Model model) {
        if (errors.hasErrors()) {
            addIngredientsToModel(model);
            return "design";
        }

        // Save the taco design...
        // We'll do this in chapter 3
        log.info("Processing design: " + design);
        return "redirect:/orders/current";
    }

    private void addIngredientsToModel(Model model) {
        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(INGREDIENTS, type));
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
