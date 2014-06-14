package com.technologyconversations.articles.javabuildtools;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

public class PlayerTest {

    @Test
    public final void pointsCanBeAddedToEachPlayer() {
        Player victor = new Player("Victor");
        Player sarah = new Player("Sarah");
        final int victorScore = 3;
        final int sarahScore = 4;
        for (int index = 1; index <= victorScore; index++) {
            victor.winBall();
        }
        for (int index = 1; index <= sarahScore; index++) {
            sarah.winBall();
        }
        assertThat(victor, hasProperty("score", is(victorScore)));
        assertThat(sarah, hasProperty("score", is(sarahScore)));
    }
}
