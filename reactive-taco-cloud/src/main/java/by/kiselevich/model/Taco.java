package by.kiselevich.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Taco {
    private Long id;
    private Timestamp createdAt;
    private String name;
    private List<Ingredient> ingredients;
}
