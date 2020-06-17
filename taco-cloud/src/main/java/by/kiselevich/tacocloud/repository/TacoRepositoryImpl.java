package by.kiselevich.tacocloud.repository;

import by.kiselevich.tacocloud.model.Ingredient;
import by.kiselevich.tacocloud.model.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;

@Repository
public class TacoRepositoryImpl implements TacoRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TacoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Taco save(Taco taco) {
        long tacoId = saveTacoInfo(taco);
        taco.setId(tacoId);
        for (Ingredient ingredient : taco.getIngredients()) {
            saveIngredientToTaco(ingredient, tacoId);
        }
        return taco;
    }

    private long saveTacoInfo(Taco taco) {
        taco.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        PreparedStatementCreatorFactory preparedStatementCreatorFactory =
                new PreparedStatementCreatorFactory(
                    "insert into Taco (name, createdAt) values (?, ?)",
                    Types.VARCHAR,
                    Types.TIMESTAMP);
        preparedStatementCreatorFactory.setReturnGeneratedKeys(true);
        PreparedStatementCreator preparedStatementCreator = preparedStatementCreatorFactory.newPreparedStatementCreator(
            Arrays.asList(
                    taco.getName(),
                    taco.getCreatedAt()));
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        return keyHolder.getKey().longValue();
    }

    private void saveIngredientToTaco(Ingredient ingredient, long tacoId) {
        jdbcTemplate.update(
                "insert into Taco_Ingredients (taco, ingredient) values (?, ?)",
                tacoId, ingredient.getId());
    }
}
