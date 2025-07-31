import java.util.Arrays;

// Question:
// Divide an array into groups such that the difference between 
// any two elements in a set is 1. Count the number of such sets.
//
// Example:
// Input: arr = {2, 1, 11, 3}
// Valid sets: {1, 2, 3}, {11}
// Output: 2
public class GroupCounter {


    public static int countGroups(int[] arr) {
        if (arr.length == 0) return 0;

        Arrays.sort(arr);  // Sort the array

        int groups = 1;     // At least one group
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                // Start a new group if difference > 1
                groups++;
            }
        }
        return groups;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 11, 3};
        int result = countGroups(arr);
        System.out.println("Number of valid sets: " + result);  // Output: 2
    }
}
