package by.kiselevich.tacocloud.config;

import by.kiselevich.tacocloud.repository.IngredientRepository;
import by.kiselevich.tacocloud.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@Profile({"!prod", "dev"})
@Configuration
public class DevelopmentConfig {

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository ingredientRepository,
                                        UserRepository userRepository,
                                        PasswordEncoder passwordEncoder) {
        return null;
    }
}
