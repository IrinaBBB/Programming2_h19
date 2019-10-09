package sorting;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void checkThatArrayOfIntegersIsSorted() {
        Integer[] toSort = {1, 5, 3, 2, 4, 6};
        MergeSort.mergeSort(toSort);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, toSort);
    }

    @Test
    public void checkThatArrayOfStringsIsSorted() {
        String[] toSort = {"hello", "bye", "light", "pen", "rain"};
        MergeSort.mergeSort(toSort);
        assertArrayEquals(new String[]{"bye", "hello", "light", "pen", "rain"}, toSort);
    }

    @Test
    public void checkThatArrayOfDoublesIsSorted() {
        Double[] toSort = {3.5, 4.58, 23.77, 11.0, 12.01};
        MergeSort.mergeSort(toSort);
        assertArrayEquals(new Double[]{3.5, 4.58, 11.0, 12.01, 23.77}, toSort);
    }

    @Test
    public void checkThatArrayOfCharactersIsSorted() {
        Character[] toSort = {'z', 'D', 'a', 'h', 'S', 'G'};
        MergeSort.mergeSort(toSort);
        assertArrayEquals(new Character[]{'D', 'G', 'S', 'a', 'h', 'z'}, toSort);
    }

}