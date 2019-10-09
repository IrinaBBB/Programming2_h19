package pattern_matching;

import java.util.HashMap;

public class BoyerMooreHorspool {

    public static void main(String[] args) {

        String[] myInput = PatternMatching.getInfoFromTheUser();
        int index = searchPattern(myInput[0], myInput[1]);

        if (index == -1) {
            System.out.println("No match");
        } else {
            System.out.println("Matched at index " + index);
        }

    }

    
    public static int searchPattern(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();

        if (textLength == 0 || patternLength == 0 || patternLength > textLength) {
            return -1;
        }

        HashMap<Character, Integer> badMatchTable = getBadMatchesTable(pattern);

        int i = patternLength - 1;
        int j = i;
        int k = i;

        while (j >= 0 && i <= textLength - 1) {
            j = patternLength - 1;
            k = i;

            while (j >= 0 && text.charAt(k) == pattern.charAt(j)) {
                k--;
                j--;
            }

            i += badMatchTable.get(text.charAt(i));
        }

        if (k >= textLength - patternLength) {
            return -1;
        } else {
            return k + 1;
        }
    }

    private static HashMap<Character, Integer> getBadMatchesTable(String pattern) {
        HashMap<Character, Integer> badMatchTable = new HashMap<>();

        for (int i = 0; i < 255; i++) {
            badMatchTable.put((char) i, pattern.length());
        }

        for (int i = 0; i < pattern.length() - 1; i++) {
            badMatchTable.put(pattern.charAt(i), pattern.length() - i - 1);
        }

        return badMatchTable;
    }

}
