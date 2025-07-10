/*
Make Array Non-Decreasing with Minimum Total Increments
📘 Problem Statement

You are given an array of n integers, nums.
You are allowed to perform any number of operations. In each operation:

    Choose a subarray [l, r] (where 0 ≤ l ≤ r < n)

    Choose a positive integer xᵢ

    Increase each element in that subarray by xᵢ

Your goal is to make the array non-decreasing, i.e.,

nums[i] ≤ nums[i + 1] for all 0 ≤ i < n - 1

Return the minimum total sum of all xᵢ used across all operations.
🧾 Input Format

    An integer array nums of length n.

🎯 Output Format

    A single integer: the minimum total sum of all increments needed to make the array non-decreasing.

✅ Constraints

    1 ≤ n ≤ 10^6

    1 ≤ nums[i] ≤ 10^9

    Subarrays can overlap

    You may use as many operations as needed, and each xᵢ can be any positive integer

🔍 Example-1
Input:
nums = [5, 2, 3]

Output:
3

Explanation:
- To make nums non-decreasing:
  - You can increase nums[1] by 3 → [5, 5, 6] or
  - You can increase subarray [1, 2] by 1 → [5, 3, 4], then [1] by 2 → [5, 5, 4], then [2] by 1 → [5, 5, 5]
- The optimal solution is to increase 2 → 5 using one operation (x = 3)

So, minimum total increment sum = 3

Example-2
Input:
nums = [1, 2, 3, 4]

Output:
0

Explanation:
Already non-decreasing; no increments needed.


 */

public class Make_Arr_Non_Decreasing_With_Total_Increments {

}