package com.game.src.main;

import java.io.Serializable;

/**
 * Created by Agil on 19/04/15.
 */
public class Score implements Serializable {
    private int score;
    private String Score;

    public int getScore() {
        return score;
    }



    public Score(String Score, int score) {
        this.score = score;
        this.Score = Score;
    }

}
