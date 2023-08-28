package com.example.game.src.model;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Game {
    private long id;
    private long playerId;
    private double betAmount;
    private double winAmount;
    private String currency;
}
