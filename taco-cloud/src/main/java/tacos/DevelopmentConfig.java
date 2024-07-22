package tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import tacos.Ingredient.Type;
import tacos.data.IngredientRepository;
import tacos.data.UserRepository;

@Profile("!prod")
@Configuration
public class DevelopmentConfig {

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository ingredientRepo,
            UserRepository userRepo,
            PasswordEncoder encoder) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                ingredientRepo.deleteAll();
                userRepo.deleteAll();

                ingredientRepo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
                ingredientRepo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
                ingredientRepo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
                ingredientRepo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
                ingredientRepo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
                ingredientRepo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
                ingredientRepo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
                ingredientRepo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
                ingredientRepo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
                ingredientRepo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));

                userRepo.save(new User("alex", encoder.encode("pass"),
                        "Alex Sham", "15 Kluchevskaya Street", "Ekaterinburg", "Russia",
                        "1016", "89126567837"));
            }
        };
    }
}
