package hash_map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {
    private MyMap<Integer, Integer> map;
    private MyMap<String, String> stringMap;

    @BeforeEach
    public void setUp() {
        this.map = new MyHashMap<>();
        this.stringMap = new MyHashMap<>();
    }

    @Test
    void assertEmptyWhenCreated() {
        assertTrue(map.isEmpty());
    }

    @Test
    void assertEmptyFalseOnAddingAnElement() {
        map.put(1, 1);
        assertFalse(map.isEmpty());
    }

    @Test
    void assertSizeIncrementsWhenAddingElements() {
        map.put(1, 1);
        assertEquals(1, map.size());

        map.put(2, 3);
        assertEquals(2, map.size());
    }


    @Test
    void assertThatDoubleValuesForKeysAreAllowed() {
        setUpStringMap();
        assertEquals("[Bird, Cat, Seagull, World, Bye]", stringMap.getAll("Hello").toString());
    }

    @Test
    void assertThatPairsWithTheSameKeyAreRemoved() {
        stringMap.remove("Hello");
        assertEquals("[]", stringMap.getAll("Hello").toString());
    }

    void setUpStringMap() {
        stringMap.put("Hello", "World");
        stringMap.put("Hi", "Bye");
        stringMap.put("Hello", "Cat");
        stringMap.put("Hello", "Seagull");
        stringMap.put("Hello", "Bird");
        stringMap.put("Hello", "Bye");
    }
}