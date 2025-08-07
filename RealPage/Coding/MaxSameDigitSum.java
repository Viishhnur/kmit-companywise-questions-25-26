/*
 * ❓ Question:
 * 
 * Given an array A consisting of N integers, find the maximum sum of two integers
 * from A that have the **same first and last digit**.
 * 
 * Example:
 * Input:  A = [130, 10, 191, 200, 10]
 * Output: 140
 * Explanation: The numbers 130 and 10 both have first digit '1' and last digit '0'.
 *              Their sum is 130 + 10 = 140.
 * 
 * If no such pair exists, return -1.
 */

import java.util.*;

public class MaxSameDigitSum{

    // Helper to get first digit of a number
    private static int getFirstDigit(int num) {
        num = Math.abs(num);
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }

    // Helper to get last digit of a number
    private static int getLastDigit(int num) {
        return Math.abs(num % 10);
    }

    public static int maxSumSameFirstLastDigits(int[] A) {
        // Map: key = "firstDigit_lastDigit", value = list of numbers with that pattern
        Map<String, List<Integer>> map = new HashMap<>();

        for (int num : A) {
            int first = getFirstDigit(num);
            int last = getLastDigit(num);
            String key = first + "_" + last;

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(num);
        }

        int maxSum = -1;

        for (List<Integer> list : map.values()) {
            if (list.size() >= 2) {
                // Sort descending to get top two largest numbers
                list.sort(Collections.reverseOrder());
                int sum = list.get(0) + list.get(1);
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] A = {130, 10, 191, 200, 10};
        int result = maxSumSameFirstLastDigits(A);
        System.out.println("Max sum of matching first and last digit pair: " + result);
    }
}
