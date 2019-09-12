package postfix_notation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PostfixNotationTest {

    @Test
    void throwsExceptionIfTheExpressionIsNotInTheCorrectFormat() {
        assertThrows(Exception.class, () -> PostfixNotation.evaluateExpression("@2323"));
        assertThrows(Exception.class, () -> PostfixNotation.evaluateExpression("(2 + 3) - 6"));
    }

    @Test
    void doesNotThrowsExceptionIfTheExpressionIsInTheCorrectFormat() {
        assertDoesNotThrow(() ->PostfixNotation.evaluateExpression("4 2 + 3 5 1 - * +"));
        assertDoesNotThrow(() ->PostfixNotation.evaluateExpression("1 2 + 3 *"));
    }

    @Test
    void fiveOnePlusReturnsSix() throws Exception {
        assertEquals(6, PostfixNotation.evaluateExpression("1 5 +"));
    }

    @Test
    void fiveOneMinusReturnsFour() throws Exception {
        assertEquals(4, PostfixNotation.evaluateExpression("5 1 -"));
    }

    @Test
    void fourTwoMultiplyReturnsEight() throws Exception {
        assertEquals(8, PostfixNotation.evaluateExpression("4 2 *"));
    }


    @Test
    void fourTwoDivideReturnsSix() throws Exception {
        assertEquals(4, PostfixNotation.evaluateExpression("5 1 -"));
    }

    @Test
    void expressionsEvaluatesRight() throws Exception {
        assertEquals(18, PostfixNotation.evaluateExpression("4 2 + 3 5 1 - * +"));
        assertEquals(9, PostfixNotation.evaluateExpression("1 2 + 3 *"));
        assertEquals(3, PostfixNotation.evaluateExpression("4 15 7 4 - * 5 / - 8 +"));
    }
}