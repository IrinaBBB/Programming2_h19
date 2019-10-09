package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSortWithComparator {

    public static <E> void mergeSortWithComparator
            (E[] list, Comparator<? super E> comparator) {

        if (list.length > 1) {
            E[] firstHalf = Arrays.copyOfRange(list, 0, list.length / 2);
            E[] secondHalf = Arrays.copyOfRange(list, list.length / 2, list.length);
            mergeSortWithComparator(firstHalf, comparator);
            mergeSortWithComparator(secondHalf, comparator);

            mergeWithComparator(firstHalf, secondHalf, list, comparator);

        }
    }

    private static <E> void mergeWithComparator(E[] firstHalf, E[] secondHalf, E[] list,
                                                Comparator<? super E> comparator) {

        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while (current1 < firstHalf.length && current2 < secondHalf.length) {
            if (comparator.compare(firstHalf[current1], secondHalf[current2]) < 0) {
                list[current3++] = firstHalf[current1++];
            } else {
                list[current3++] = secondHalf[current2++];
            }
        }

        while (current1 < firstHalf.length) {
            list[current3++] = firstHalf[current1++];
        }

        while (current2 < secondHalf.length) {
            list[current3++] = secondHalf[current2++];
        }
    }
}



