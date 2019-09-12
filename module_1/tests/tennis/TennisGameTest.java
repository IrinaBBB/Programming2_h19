package tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


class TennisGameTest {

    private TennisGame tennisGame;

    @BeforeEach
     void setUp() {
        tennisGame = new TennisGame();
    }

    @Test
    void pointMethodWithArgumentZeroResetsTheScore() {
        int[] array = {1, 2, 0};
        assertThat(setScore(array), is(equalTo( "0 - 0")));
    }

    @Test
     void ifPlayerOneScoresFourTimesHeWins() {
        int[] array = {1, 1, 1, 1};
        assertThat(setScore(array), is(equalTo("Game won by player 1")));
    }

    @Test
    void ifPlayerTwoScoresFourTimesHeWins() {
        int[] array = {2, 2, 2, 2};
        assertThat(setScore(array), is(equalTo("Game won by player 2")));
    }

    @Test
    void deuceIfPlayersScoredEquallyButLessThanFourTimes() {
        int[] array = {1, 1, 1, 2, 2, 2};
        assertThat(setScore(array), is(equalTo("deuce")));
    }

    @Test
    void playerOneGetsAdvantageIfHeScoresAfterDeuce() {
        int[] array = {1, 1, 1, 2, 2, 2, 1};
        assertThat(setScore(array), is(equalTo("Advantage player 1")));
    }

    @Test
    void playerTwoGetsAdvantageIfHeScoresAfterDeuce() {
        int[] array = {1, 1, 1, 2, 2, 2, 2};
        assertThat(setScore(array), is(equalTo("Advantage player 2")));
    }

    @Test
    void deuceIfPlayerOneHasAdvantageAndPlayerTwoScores() {
        int[] array = {1, 1, 1, 2, 2, 2, 1, 2};
        assertThat(setScore(array), is(equalTo("deuce")));
    }

    @Test
    void deuceIfPlayerTwoHasAdvantageAndPlayerOneScores() {
        int[] array = {1, 1, 1, 2, 2, 2, 2, 1};
        assertThat(setScore(array), is(equalTo("deuce")));
    }

    @Test
    void playerOneWinsIfHeHasAdvantageAndScores() {
        int[] array = {1, 1, 1, 2, 2, 2, 1, 1};
        assertThat(setScore(array), is(equalTo("Game won by player 1")));
    }

    @Test
    void playerTwoWinsIfHeHasAdvantageAndScores() {
        int[] array = {1, 1, 1, 2, 2, 2, 2, 2};
        assertThat(setScore(array), is(equalTo("Game won by player 2")));
    }

    /* setScore calls point() method of TennisGame class as many times as needed with the needed parameters */
    private String setScore(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            tennisGame.point(array[i]);
        }
        return tennisGame.point(array[array.length - 1]);
    }

}