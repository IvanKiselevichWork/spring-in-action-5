package by.kiselevich.reactor;

import lombok.Data;

@Data
public class Player {

    private String name;
    private String surname;

    public Player(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
