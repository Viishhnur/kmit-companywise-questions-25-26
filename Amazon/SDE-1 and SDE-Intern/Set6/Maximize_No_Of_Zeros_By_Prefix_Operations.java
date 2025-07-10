/*
Maximize Number of Zeros by Prefix Operations
📘 Problem Statement:

You are given an array sequenceData of length n, where each element is a positive integer.

You can perform the following operation any number of times (including zero):

    Choose a prefix of the array (i.e., the first s elements where 1 ≤ s ≤ n)

    The chosen prefix must not contain any zeros

    Decrease every element in the prefix by 1

🎯 Objective:

Perform any sequence of such operations to maximize the number of 0s in the array.
🧾 Input:

    An integer n — length of the array

    An array sequenceData of size n with positive integers

🧾 Output:

    Return a single integer: the maximum number of zeros that can be achieved after performing operations

✅ Constraints:

    1 ≤ n ≤ 10^5

    1 ≤ sequenceData[i] ≤ 10^9

Example-1:-
Input: sequenceData = [3, 2, 2, 1]
Output: 4

Explanation:
We can apply 1 operation on the full prefix (all elements):
[3,2,2,1] → [2,1,1,0]

Now, we **cannot include the last element** (0) in further operations.
Next round on prefix [2,1,1] → [1,0,0] → final array = [1,0,0,0]

Total number of zeros = 3

So maximum zeros = 3

Example-2
Input: sequenceData = [5, 5, 5]
Output: 3

Explanation:
Keep applying prefix operations on the entire array until all become 0.
Final result: [0, 0, 0]

 */

import java.util.*;

public class Maximize_No_Of_Zeros_By_Prefix_Operations {

    private static int maxZeros(int[] nums){

        int minSeenSoFar = Integer.MAX_VALUE;

        int cnt = 0;

        for(int num : nums){
            //  If num ≤ everything we’ve seen before, we can make it zero 
            if(num <= minSeenSoFar){
                cnt++;
                minSeenSoFar = num;
            }

            // otherwise we can never bring this element down to 0
            // without driving some earlier element negative
        }

        return cnt;
    }
    public static void main(String[] args) {
        int n;
        int[] nums;

        try(Scanner sc = new Scanner(System.in)){
            n = sc.nextInt();
            nums = new int[n];
            
            for(int i = 0 ; i < n ; i++){
                nums[i] = sc.nextInt();   
            }
        }

        System.out.println(maxZeros(nums));
    }
}
