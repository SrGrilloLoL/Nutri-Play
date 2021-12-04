package com.example.inicio.api.models;

public class Game {

    private String gameId;
    private String name;

    public Game() {
    }

    public Game(String gameId, String name) {
        this.gameId = gameId;
        this.name = name;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
