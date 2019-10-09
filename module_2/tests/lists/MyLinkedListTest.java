package lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    MyLinkedList<Integer> myList;
    MyLinkedList<Integer> emptyList;

    @BeforeEach
    void setUp() {
        Integer[] integers = {1, 6, 23, 56, 99, 12, 5, 79};
        myList= new MyLinkedList<>(integers);
        emptyList = new MyLinkedList<>();
    }

    @Test
    void assertThatGetFirstReturnsTheFirstElement() {
        assertEquals(1, myList.getFirst());
    }

    @Test
    void assertThatGetFirstIsNullWhenArrayIsNull() {
        assertNull(emptyList.getFirst());
    }

    @Test
    void assertThatGetLastReturnsTheLastElement() {
        assertEquals(79, myList.getLast());
    }

    @Test
    void assertThatGetLastIsNullWhenArrayIsNull() {
        assertNull(emptyList.getLast());
    }

    @Test
    void assertThatAddFirstAddsElementAtFirstPosition() {
        myList.addFirst(5);
        assertEquals(5, myList.getFirst());
    }

    @Test
    void assertThatAddFirstAddsElementAtFirstPositionOfEmptyList() {
        emptyList.addFirst(5);
        assertEquals(5, emptyList.getFirst());
    }

    @Test
    void assertThatAddAddsElementAtAnyPosition() {
        myList.add(3,33);
        assertEquals(33, myList.get(3));
    }

    @Test
    void assertThatAddAddsElementAtFirstPosition() {
        myList.add(0,33);
        assertEquals(33, myList.getFirst());
    }

    @Test
    void assertThatAddAddsElementAtLastPosition() {
        myList.add(33,33);
        assertEquals(33, myList.getLast());
    }

    @Test
    void assertThatRemoveFirstRemovesElementAtFirstPosition() {
        myList.removeFirst();
        assertEquals(6, myList.getFirst());
    }

    @Test
    void assertThatRemoveLastRemovesElementAtLastPosition() {
        myList.removeLast();
        assertEquals(5, myList.getLast());
    }

    @Test
    void assertThatRemoveRemovesElementAtAnyPosition() {
        myList.remove(3);
        assertEquals(99, myList.get(3));
        myList.remove(1);
        assertEquals(23, myList.get(1));
    }

    @Test
    void assertThatClearClearsList() {
        myList.clear();
        assertNull(myList.getFirst());
        assertNull(myList.getLast());
    }

    @Test
    void assertThatIndexOfReturnsIndexOfElement() {   //{1, 6, 23, 56, 99, 12, 5, 79};
        assertEquals(0, myList.indexOf(1));
        assertEquals(2, myList.indexOf(23));
    }

    @Test
    void assertThatLastIndexOfReturnsLastIndexOfElement() {
        assertEquals(2, myList.lastIndexOf(23));
        myList.addLast(23);
        assertEquals(8, myList.lastIndexOf(23));
    }

    @Test
    void assertThatSetSetsElementAtChosenPosition() {
        myList.set(0, 67);
        assertEquals(67, myList.get(0));
        myList.set(5, 66);
        assertEquals(66, myList.get(5));
    }

    @Test
    void assertThatExceptionIsThrownIfSetWithIndexGreaterThanSize() {
        assertThrows(IndexOutOfBoundsException.class, () -> myList.set(100, 100));
    }

    @Test
    void assertThatContainsReturnsTrueIfElementIsInList() {
        assertTrue(myList.contains(1));
        assertTrue(myList.contains(99));
        assertTrue(myList.contains(79));
    }

    @Test
    void assertThatContainsReturnsFalseIfElementISNotInList() {
        assertFalse(myList.contains(100));
        assertFalse(myList.contains(500));
        assertFalse(myList.contains(22));
    }
}