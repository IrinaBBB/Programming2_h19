package fizz_buzz;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {
    @Test
    public void test() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        Assert.assertEquals("1", fizzBuzz.action(1));
        Assert.assertEquals("2", fizzBuzz.action(2));
        Assert.assertEquals("Fizz", fizzBuzz.action(3));
        Assert.assertEquals("4", fizzBuzz.action(4));
        Assert.assertEquals("Buzz", fizzBuzz.action(5));
        Assert.assertEquals("Fizz", fizzBuzz.action(6));
        Assert.assertEquals("Buzz", fizzBuzz.action(10));
        Assert.assertEquals("FizzBuzz", fizzBuzz.action(15));
    }

}
