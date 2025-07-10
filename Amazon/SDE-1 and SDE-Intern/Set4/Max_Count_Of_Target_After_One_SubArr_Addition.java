/*
Problem 1: Maximize Count of Target After One Subarray Addition
📘 Problem Statement

You are given an array arr of integers and a target integer k.
You are allowed to perform at most one operation:

        Choose a subarray from index i to j (inclusive),

        Choose an integer X,

        Add X to every element in the subarray.

Your goal is to choose such a subarray and a value of X (you can choose X = 0 or skip the operation entirely) to maximize the number of elements equal to k in the final array.
🧾 Input Format

    An integer array arr of length n

    An integer k — the target value

🎯 Output Format

    Return an integer — the maximum number of elements equal to k that can exist in the array after at most one operation.

 Constraints

    1 ≤ n ≤ 10^5

    -10^9 ≤ arr[i], k ≤ 10^9

🔍 Examples & Test Cases
 Test Case 1:

Input:
arr = [6, 4, 4, 6, 4, 4]
k = 6

Output: 5

Explanation:
Add 2 to subarray [1:4] → [6, 6, 6, 8, 6, 6]  
Final count of 6s = 5

 Test Case 2:

Input:
arr = [2, 5, 2, 5, 2]
k = 2

Output: 4

Explanation:
Add -3 to subarray [1:3] → [2, 2, -1, 2, 2]  
Final array = [2, 2, -1, 2, 2] → 4 occurrences of 2

 Test Case 3:

Input:
arr = [1, 2, 3]
k = 4

Output: 1

Explanation:
Add 1 to subarray [2:2] → [1, 2, 4]  
Only 1 element is equal to 4

 */
public class Max_Count_Of_Target_After_One_SubArr_Addition {

}
