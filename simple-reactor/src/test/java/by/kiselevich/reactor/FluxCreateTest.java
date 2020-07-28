package by.kiselevich.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class FluxCreateTest {

    @Test
    public void createAFlux_just() {
        Flux<String> fruitFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry");
        fruitFlux.subscribe(f -> System.out.println("Here's some fruit: " + f));
    }
}
