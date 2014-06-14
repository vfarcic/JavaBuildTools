package com.technologyconversations.articles.javabuildtools;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/*
Implement a simple tennis game

**Rules:**

* Scores from zero to three points are described as "love", "fifteen", "thirty", and "forty" respectively.
* If at least three points have been scored by each side and a player has one more point than his opponent,
* the score of the game is "advantage" for the player in the lead.
* If at least three points have been scored by each player, and the scores are equal, the score is "deuce".
* A game is won by the first player to have won at least four points in total and at least two points more
* than the opponent.
*/
public class GameTest {

    private Player victor;
    private Player sarah;
    private Game game;

    @Before
    public final void beforeGameTest() {
        victor = new Player("Victor");
        sarah = new Player("Sarah");
        game = new Game(victor, sarah);
    }

    @Test
    public final void loveShouldBeDescriptionForScore0() {
        Game actual = new Game(victor, sarah);
        assertThat(actual, hasProperty("score", is("love, love")));
    }

    @Test
    public final void fifteenShouldBeDescriptionForScore1() {
        sarah.winBall();
        assertThat(game, hasProperty("score", is("love, fifteen")));
    }

    @Test
    public final void thirtyShouldBeDescriptionForScore2() {
        victor.winBall();
        victor.winBall();
        sarah.winBall();
        assertThat(game, hasProperty("score", is("thirty, fifteen")));
    }

    @Test
    public final void fortyShouldBeDescriptionForScore3() {
        final int score = 3;
        for (int index = 1; index <= score; index++) {
                victor.winBall();
        }
        assertThat(game, hasProperty("score", is("forty, love")));
    }

    @Test
    public final void advantageShouldBeDescriptionWhenAtLeastThreePointsHaveBeenScoredByBothAndPlayerHasOnePointMore() {
        final int victorScore = 3;
        final int sarahScore = 4;
        for (int index = 1; index <= victorScore; index++) {
            victor.winBall();
        }
        for (int index = 1; index <= sarahScore; index++) {
            sarah.winBall();
        }
        assertThat(game, hasProperty("score", is("advantage Sarah")));
    }

    @Test
    public final void deuceShouldBeDescriptionWhenAtLeastThreePointsHaveBeenScoredByEachPlayerAndTheScoresAreEqual() {
        final int victorScore = 3;
        final int sarahScore = 3;
        for (int index = 1; index <= victorScore; index++) {
            victor.winBall();
        }
        for (int index = 1; index <= sarahScore; index++) {
            sarah.winBall();
        }
        assertThat(game, hasProperty("score", is("deuce")));
        victor.winBall();
        assertThat(game, hasProperty("score", is(not("deuce"))));
        sarah.winBall();
        assertThat(game, hasProperty("score", is("deuce")));
    }

    @Test
    public final void gameShouldBeWonByTheFirstPlayerToHaveWonAtLeastFourPointsInTotalAndWithAtLeastTwoPointsMore() {
        final int victorScore = 4;
        final int sarahScore = 3;
        for (int index = 1; index <= victorScore; index++) {
            victor.winBall();
        }
        for (int index = 1; index <= sarahScore; index++) {
            sarah.winBall();
        }
        assertThat(game, hasProperty("score", is(not("Victor won"))));
        assertThat(game, hasProperty("score", is(not("Sarah won"))));
        victor.winBall();
        assertThat(game, hasProperty("score", is("Victor won")));
    }

}
