package by.kiselevich.tacocloud.config;

import by.kiselevich.tacocloud.model.Taco;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.RepresentationModelProcessor;

@Configuration
public class TacoRestConfig {

    // not working if use lambda
    @Bean
    public RepresentationModelProcessor<PagedModel<EntityModel<Taco>>> tacoProcessor(EntityLinks links) {
        return new RepresentationModelProcessor<PagedModel<EntityModel<Taco>>>() {
            @Override
            public PagedModel<EntityModel<Taco>> process(PagedModel<EntityModel<Taco>> resources) {
                resources.add(links.linkFor(Taco.class).slash("recent").withRel("recents"));
                return resources;
            }
        };
    }
}
