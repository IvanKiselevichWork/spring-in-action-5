package by.kiselevich.controller;

import by.kiselevich.model.Taco;
import by.kiselevich.repository.TacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/design")
public class DesignTacoController {

    private final TacoRepository tacoRepository;
    @Value("${taco.recent.size}")
    Long recentSize;

    @Autowired
    public DesignTacoController(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @GetMapping(path = "/{id}")
    public Mono<Taco> tacoById(@PathVariable("id") Long id) {
        return tacoRepository.findById(id);
    }

    @GetMapping(path = "/recent")
    public Flux<Taco> recentTacos() {
        return tacoRepository.findAll().take(recentSize);
    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Taco> postTaco(@RequestBody Mono<Taco> tacoMono) {
        return tacoRepository.saveAll(tacoMono).next();
    }
}
