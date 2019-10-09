package sorting;

import java.util.Arrays;

public class MergeSortTest {
    public static void main(String[] args) {
        Integer[] intArray = {2, 4, 3, 5, 7, 1};
        MergeSort.mergeSort(intArray);
        System.out.print("Sorted Integer object: ");
        System.out.println(Arrays.toString(intArray));

        Double[] doubleArray = {3.4, -22.1, 4.0, 5.6, 2.5, 2.0};
        MergeSort.mergeSort(doubleArray);
        System.out.print("Sorted Double object: ");
        System.out.println(Arrays.toString(doubleArray));

        Character[] charArray = {'a', 'J', 'v', 'A', 'w', 'e'};
        MergeSort.mergeSort(charArray);
        System.out.print("Sorted Character object: ");
        System.out.println(Arrays.toString(charArray));

        String[] stringArray = {"Tom", "Mary", "Kitty", "Sam", "Maddy", "Leonard"};
        MergeSort.mergeSort(stringArray);
        System.out.print("Sorted String object: ");
        System.out.println(Arrays.toString(stringArray));

    }
}
