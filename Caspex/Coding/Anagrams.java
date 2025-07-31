/*
Question: Check if two strings are anagrams.

Two strings are said to be anagrams if they contain the same characters with the same frequency,
but possibly in a different order.

Example:
Input: str1 = "listen", str2 = "silent"
Output: true

Input: str1 = "hello", str2 = "world"
Output: false
*/

import java.util.Arrays;

public class Anagrams {

    // Method 1: Using sorting
    public static boolean isAnagram(String str1, String str2) {
        // Remove white spaces and convert to lowercase for case-insensitive comparison
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // If lengths are different, they can't be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert strings to character arrays and sort them
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Check if sorted arrays are equal
        return Arrays.equals(arr1, arr2);
    }

    // Main method to test the function
    public static void main(String[] args) {
        String str1 = "Listen";
        String str2 = "Silent";

        if (isAnagram(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }
    }
}
