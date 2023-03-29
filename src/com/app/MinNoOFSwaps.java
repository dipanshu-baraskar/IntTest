package com.app;

import java.util.Arrays;

public class MinNoOFSwaps {

    // Function that returns true if s1
// and s2 are anagrams of each other
    static boolean isAnagram(String s1, String s2) {
        s1 = sortString(s1);
        s2 = sortString(s2);
        return (s1.equals(s2));
    }

    // Method to sort a string alphabetically
    public static String sortString(String inputString) {
        // convert input string to char array
        char tempArray[] = inputString.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);

        // return new sorted string
        return new String(tempArray);
    }

    // Function to return the minimum swaps required
    static int CountSteps(char[] s1, char[] s2, int size) {
        int i = 0, j = 0;
        int result = 0;
        // Iterate over the first string and convert
        // every element equal to the second string
        while (i < size) {
            j = i;
            // Find index element of first string which
            // is equal to the ith element of second string
            while (s1[j] != s2[i]) {
                j += 1;
            }
            // Swap adjacent elements in first string so
            // that element at ith position becomes equal
            while (i < j) {
                // Swap elements using temporary variable
                char temp = s1[j];
                s1[j] = s1[j - 1];
                s1[j - 1] = temp;
                j -= 1;
                result += 1;
            }
            i += 1;
        }
        return result;
    }

    // Driver code
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdab";

        int size = s2.length();

        // If both the strings are anagrams
        // of each other then only they
        // can be made equal
        if (isAnagram(s1, s2))
            System.out.println(CountSteps(s1.toCharArray(), s2.toCharArray(), size));
        else
            System.out.println(-1);
    }
}
