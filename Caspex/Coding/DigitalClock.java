// Given a string consisting only of digits (e.g., "1210"), each digit represents a number displayed on a 7-segment digital display. Your task is to write a Java program that calculates the total number of segments used to display all digits in the string.

import java.util.*;
public class DigitalClock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string of digits: ");
        String input = sc.nextLine();
        
        // Array representing the number of segments for each digit from 0 to 9
        int[] segments = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
        
        int totalSegments = 0;
        
        // Calculate the total number of segments
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                totalSegments += segments[c - '0'];
            } else {
                System.out.println("Invalid character: " + c);
            }
        }
        
        System.out.println("Total segments used: " + totalSegments);

        sc.close();
    }
}
