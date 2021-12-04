package com.example.inicio.api.models;

public class ScoreDto {

    private int score;
    private int userId;
    private int playerId;
    private int gameId;

    public ScoreDto() {
    }

    public ScoreDto(int score, int userId, int playerId, int gameId) {
        this.score = score;
        this.userId = userId;
        this.playerId = playerId;
        this.gameId = gameId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}
