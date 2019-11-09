package hash_map;


import java.util.*;

public class MyHashMap<K extends Comparable, V extends Comparable> implements MyMap<K, V> {
    /**
     * Hash table is an array with each cell that is a linked list
     */
    private ArrayList<LinkedList<Entry<K, V>>> table;
    /**
     * Specify a load factor used in the hash table
     */
    private double loadFactorThreshold = DEFAULT_MAX_LOAD_FACTOR;
    /**
     * Current hash table capacity. Capacity is a power of 2
     */
    private int capacity = DEFAULT_INITIAL_CAPACITY;
    /**
     * The number of entries in the map
     */
    private int size = 0;

    /**
     * Construct a map with the default capacity and load factor
     */
    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }

    /**
     * Construct a map with the specified initial capacity and default load factor
     */
    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
    }

    /**
     * Construct a map with the specified initial capacity and load factor
     */
    public MyHashMap(int initialCapacity, double loadFactorThreshold) {
        capacity = initialCapacity > MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY : trimToPowerOf2(initialCapacity);
        this.loadFactorThreshold = loadFactorThreshold;
        table = new ArrayList<>(Collections.nCopies(capacity, null));
    }

    /**
     * Add an entry (key, value) into the map
     */
    @Override
    public V put(K key, V value) {

        if (size >= capacity * loadFactorThreshold) {
            if (capacity == MAXIMUM_CAPACITY)
                rehash();
        }

        int bucketIndex = hash(key.hashCode());
        LinkedList<MyMap.Entry<K, V>> list;

        if (table.get(bucketIndex) == null) {
            table.set(bucketIndex, new LinkedList<>());
        }

        table.get(bucketIndex).add(new MyMap.Entry<>(key, value));


        size++;

        return value;

    }

    @Override
    public void remove(K key) {
        int bucketIndex = hash(key.hashCode());

        if (table.get(bucketIndex) != null) {
            LinkedList<Entry<K, V>> bucket = table.get(bucketIndex);
            Iterator<Entry<K, V>> i = bucket.iterator();

            Entry<K, V> entry;
            while (i.hasNext()) {
                entry = i.next();
                if (entry.getKey().equals(key)) {
                    i.remove();
                    size--;
                }
            }
        }
    }

    /**
     * Return a set consisting of the values in this map
     */
    @Override
    public Set<V> values() {
        Set<V> set = new HashSet<>();
        for (int i = 0; i < capacity; i++) {
            if (table.get(i) != null) {
                LinkedList<Entry<K, V>> bucket = table.get(i);
                for (Entry<K, V> entry : bucket)
                    set.add(entry.getValue());
            }
        }
        return set;
    }

    /**
     * Return a set consisting of the keys in this map
     */
    @Override
    public Set<K> keys() {
        Set<K> set = new HashSet<>();
        for (Entry<K, V> entry : entries()) {
            set.add(entry.getKey());
        }
        return set;
    }

    /**
     * Return the number of mappings in this map
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Remove all of the entries from this map
     */
    @Override
    public void clear() {
        capacity = DEFAULT_INITIAL_CAPACITY;
        table = new ArrayList<>(Collections.nCopies(capacity, null));
        size = 0;
    }

    /**
     * Return true if this map contains the value
     */
    @Override
    public boolean containsValue(V value) {
        for (Entry<K, V> entry : entries()) {
            if (entry.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<V> getAll(K key) {
        Set<V> set = new HashSet<>();
        int bucketIndex = hash(key.hashCode());


        if (table.get(bucketIndex) != null) {
            LinkedList<Entry<K, V>> list = table.get(bucketIndex);

            for (Entry<K, V> entry : list) {
                if (entry.getKey().equals(key)) {
                    set.add(entry.getValue());
                }
            }
        }

        return set;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entries() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Entry<K, V> entry : entries()) {
            builder.append(entry);
        }
        return builder.toString();
    }

    /**
     * Hash function
     */
    private int hash(int hashCode) {
        return supplementalHash(hashCode) & (capacity - 1);
    }

    /**
     * Ensure the hashing is evenly distributed
     */
    private static int supplementalHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /**
     * Return a power of 2 for goalCapacity
     */
    private int trimToPowerOf2(int goalCapacity) {
        int capacity = 1;
        while (capacity < goalCapacity) {
            capacity <<= 1;
        }
        return capacity;
    }

    /**
     * Rehash the map
     */
    private void rehash() {
        if (capacity == MAXIMUM_CAPACITY) {
            throw new RuntimeException("Exceeding maximum capacity");
        }
        capacity <<= 1;
    }
}