package pattern_matching;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BoyerMooreHorspoolTest {


    @Parameterized.Parameter
    public String text;
    @Parameterized.Parameter(1)
    public String pattern;
    @Parameterized.Parameter(2)
    public int expected;


    @Parameterized.Parameters(name = " {index}: \"{1}\" in \"{0}\" at index {2} ")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Mississippi", "sip", 6},
                {"We hold these truths to be self-evident", "truth", 14},
                {"A bad workman always blames his tools.", ".", 37},
                {"A bird in hand is worth two in the bush.", "A", 0},
                {"På seg sjølv kjenner ein andre.", "sjølv", 7},
                {"The basic ASCII set uses 7 bits for each character.", " ", 3},
                {"The basic ASCII set uses 7 bits for each character.", "7", 25},
                {"", "", -1},
                {"The basic ASCII set uses 7 bits for each character.", "", -1}
        });
    }


    @Test
    public void testFactorialFunctionUsingParameterizedTests() {
        assertEquals(expected, BoyerMooreHorspool.searchPattern(text, pattern));
    }
}
