package com.technologyconversations.articles.javabuildtools;

public class Game {

    private Player player1;
    private Player player2;
    private static final int MIN_SCORE_TO_WIN = 3;

    public Game(final Player player1Value, final Player player2Value) {
        this.player1 = player1Value;
        this.player2 = player2Value;
    }

    public final String getScore() {
        if (player1.getScore() >= MIN_SCORE_TO_WIN && player2.getScore() >= MIN_SCORE_TO_WIN) {
            if (Math.abs(player2.getScore() - player1.getScore()) >= 2) {
                return getLeadPlayer().getName() + " won";
            } else if (player1.getScore() == player2.getScore()) {
                return "deuce";
            } else {
                return "advantage " + getLeadPlayer().getName();
            }
        } else {
            return player1.getScoreDescription() + ", " + player2.getScoreDescription();
        }
    }

    public final Player getLeadPlayer() {
        if (player1.getScore() > player2.getScore()) {
            return player1;
        } else {
            return player2;
        }
    }

}
