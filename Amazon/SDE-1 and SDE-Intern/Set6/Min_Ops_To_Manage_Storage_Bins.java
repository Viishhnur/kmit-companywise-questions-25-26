/*
Minimum Operations to Balance Storage Bins
📘 Problem Statement:

You are given an array items of length n, where items[i] represents the number of items in the i-th storage bin.

You can perform the following operation any number of times:

    Choose the bin with the maximum number of items (any if multiple)

    Remove 1 item from it and add it to the bin with the minimum number of items (any if multiple)

🎯 Objective:

Perform such operations until the difference between the number of items in any two bins is at most 1.

Return the minimum number of operations required to reach this state.
🧾 Input:

    An integer n — number of bins

    An array items of size n, with items[i] as the count of items in the i-th bin

🧾 Output:

    An integer — the minimum number of operations to balance the bins

✅ Constraints:

    2 ≤ n ≤ 2 × 10^5

    1 ≤ items[i] ≤ 10^9

Example-1:-
Input: items = [1, 3, 2, 5]
Output: 2

Explanation:
Step 1: [1, 3, 2, 5] → move 1 from bin 4 to bin 1 → [2, 3, 2, 4]  
Step 2: [2, 3, 2, 4] → move 1 from bin 4 to bin 3 → [2, 3, 3, 3]

All bins now have values 2 or 3 → difference is ≤ 1

Example-2:-
Input: items = [4, 4, 4]
Output: 0

Explanation:
Already balanced. No operation required.

 */
public class Min_Ops_To_Manage_Storage_Bins {

}
