package pattern_matching;

import java.util.Scanner;

public class PatternMatching {


    public static void main(String[] args) {
        String[] inputFromTheUser = getInfoFromTheUser();

        int index = getSubstringIndex(inputFromTheUser[0], inputFromTheUser[1]);

        if (index == -1) {
            System.out.println("No match");
        } else {
            System.out.println("Matched at index " + index);
        }
    }

    static int getSubstringIndex(String s1, String s2) {

        if (s1 == null || s2 == null || s1.length() < s2.length() || s1.equals("") || s2.equals("")) {
            return -1;
        }

        int k = 0;

        for (int i = 0; i < s1.length(); i++) {

            if (k == s2.length()) {
                return i - k;
            } else {
                if (s1.charAt(i) == s2.charAt(k)) {
                    k++;
                } else {
                    i -= k;
                    k = 0;
                }
            }

            if (i == s1.length() - 1 && k == s2.length()) {
                return i - k + 1;
            }
        }
        return -1;
    }

    static String[] getInfoFromTheUser() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a string s1: ");
        String s1 = input.nextLine();
        System.out.println("Enter a string s2: ");
        String s2 = input.nextLine();

        return new String[]{s1, s2};

    }
}
