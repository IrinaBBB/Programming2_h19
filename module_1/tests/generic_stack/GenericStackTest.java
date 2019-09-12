package generic_stack;

import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;
import static org.junit.jupiter.api.Assertions.*;

class GenericStackTest {

    @Test
     void pushTwoObjectsToEmptyStackCheckThatSizeIsTwo() {
        GenericStack<String> stack = new GenericStack<>();
        pushObjectsInOrder(stack, "hi", "hello");
        assertEquals(2, stack.size());
    }

    @Test
     void pushTwoNullObjectsToEmptyStackCheckThatSizeIsZero() {
        GenericStack<String> stack = new GenericStack<>();
        pushObjectsInOrder(stack, null, null);
        assertEquals(0, stack.size());
    }

    @Test
     void throwExceptionIfPoppingFromEmptyStack() {
        GenericStack<String> stack = new GenericStack<>();
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
     void throwExceptionIfPeekingFromEmptyStack() {
        GenericStack<String> stack = new GenericStack<>();
        assertThrows(EmptyStackException.class, stack::peek);
    }

    @Test
     void isEmptyMethodReturnsTrueIfArrayIsEmpty() {
        GenericStack<Integer> stack = new GenericStack<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    void isEmptyMethodReturnsFalseIfArrayIsNotEmpty() {
        GenericStack<Integer> stack = new GenericStack<>();
        pushObjectsInOrder(stack, 1, 2);
        assertFalse(stack.isEmpty());
    }

    @Test
    void methodPeekReturnsTheLastPushedInteger() {
        GenericStack<Integer> stack = new GenericStack<>();
        pushObjectsInOrder(stack, 1, 2, 3);
        assertEquals(3, stack.peek());
    }

    @Test
    void methodPeekReturnsTheLastPushedString() {
        GenericStack<String> stack = new GenericStack<>();
        pushObjectsInOrder(stack, "june", "july", "august");
        assertEquals("august", stack.peek());
    }

    @Test
    void stackSizeIsUnchangedIfPeeking() {
        GenericStack<String> stack = new GenericStack<>();
        pushObjectsInOrder(stack, "june", "july", "august");
        stack.peek();
        assertEquals(3, stack.size());
    }

    @Test
    void stackSizeIsOneLessIfPopping() {
        GenericStack<String> stack = new GenericStack<>();
        pushObjectsInOrder(stack, "june", "july", "august");
        stack.pop();
        assertEquals(2, stack.size());
    }

    private <E> void pushObjectsInOrder(GenericStack<E> stack, Object... objects) {
        for (Object object : objects) {
            stack.push((E)object);
        }
    }

}