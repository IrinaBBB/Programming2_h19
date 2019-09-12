package generic_stack;

import java.util.EmptyStackException;

public class GenericStack<E> {

    private E[] stack;
    private int top;

    public GenericStack() {
        stack = (E[]) new Object[100];
    }

    public GenericStack(int capacity) {
        stack = (E[]) new Object[capacity];
    }

    public void push(E obj) {
        if (obj != null) {
            if (top == stack.length) {

                E[] newArray = (E[]) new Object[2 * stack.length];
                System.arraycopy(stack, 0, newArray, 0, stack.length);
                stack = newArray;
            }

            stack[top++] = obj;
        }
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        E obj = stack[--top];
        stack[top] = null;
        return obj;
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void printStack() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
