package by.kiselevich.tacocloud.controller;

import java.util.ArrayList;
import java.util.List;

import by.kiselevich.tacocloud.repository.IngredientRepository;
import by.kiselevich.tacocloud.repository.TacoRepository;
import by.kiselevich.tacocloud.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import by.kiselevich.tacocloud.model.Taco;
import by.kiselevich.tacocloud.model.Ingredient;
import by.kiselevich.tacocloud.model.Ingredient.Type;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;
    private final TacoRepository tacoRepository;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository, TacoRepository tacoRepository) {
        this.ingredientRepository = ingredientRepository;
        this.tacoRepository = tacoRepository;
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }
    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        addIngredientsToModel(ingredients, model);
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco taco, Errors errors, Model model, @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            List<Ingredient> ingredients = new ArrayList<>();
            ingredientRepository.findAll().forEach(ingredients::add);
            addIngredientsToModel(ingredients, model);
            return "design";
        }
        log.info("Processing taco: " + taco);
        taco = tacoRepository.save(taco);
        order.addTaco(taco);
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
