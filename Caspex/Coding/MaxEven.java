// "Max Numbers to Make the Sum Even"

// You are given a list of positive integers. You must select the maximum number of integers from the list such that their total sum is even.

// Write a program to return this maximum count of numbers that can be selected.

import java.util.*;
public class MaxEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of integers: ");
        int n = sc.nextInt();
        
        int[] numbers = new int[n];
        System.out.println("Enter the integers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        
        int countOdd = 0;

        for (int num : numbers) {
            if (num % 2 != 0) {
                countOdd++;
            }
        }

        if (countOdd % 2 == 0) {
            // If the count of odd numbers is even, we can take all numbers
            System.out.println("Maximum count of numbers with even sum: " + n);
        } else {
            // If the count of odd numbers is odd, we must exclude one odd number
            System.out.println("Maximum count of numbers with even sum: " + (n - 1));
        }

        sc.close();
    }
}
