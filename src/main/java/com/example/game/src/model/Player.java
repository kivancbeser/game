package com.example.game.src.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Player {
    private long id;
    private String name;
    private String surname;
}
