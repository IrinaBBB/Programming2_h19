package tennis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TennisGameParameterizedTest {

    private static TennisGame tennisGame = new TennisGame();

    @Parameterized.Parameter
    public int input;
    @Parameterized.Parameter(1)
    public String expected;


    @Parameterized.Parameters(name = "{index}: Player {0} scored: => {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {1, "15 - 0"},
                {1, "30 - 0"},
                {2, "30 - 15"},
                {1, "40 - 15"},
                {2, "40 - 30"},
                {2, "deuce"},
                {1, "Advantage player 1"},
                {2, "deuce"},
                {2, "Advantage player 2"},
                {1, "deuce"},
                {1, "Advantage player 1"},
                {1, "Game won by player 1"},
                {0, "0 - 0"},
                {1, "15 - 0"},
                {1, "30 - 0"},
                {1, "40 - 0"},
                {1, "Game won by player 1"},
                {2, "0 - 15"},
                {2, "0 - 30"},
                {2, "0 - 40"},
                {2, "Game won by player 2"},
                {1, "15 - 0"},
                {2, "15 - 15"},
                {1, "30 - 15"},
                {2, "30 - 30"},
                {2, "30 - 40"},
                {2, "Game won by player 2"}
        });
    }



    @Test
    public void testFactorialFunctionUsingParameterizedTests() {
        assertEquals(expected, tennisGame.point(input));
    }


}