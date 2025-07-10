/* Problem Title: Minimum Operations for Fair Item Distribution in Bins

📘 Problem Statement:

You are given an integer n and an array items of size n, where items[i] represents the number of items in the i-th bin.

Your goal is to distribute the items fairly across all bins by performing the following operation:

        In one operation, choose a bin with the maximum number of items (if multiple exist, choose any one),

        Remove one item from it,

        Then, place that item into a bin with the minimum number of items (again, if multiple exist, choose any one).

You can repeat this operation as many times as you like.

The distribution is considered balanced when the difference between the number of items in any two bins is at most 1.

Return the minimum number of operations required to achieve a balanced distribution.
🧾 Input Format:

    An integer n — the number of bins.

    An array items of size n — where items[i] is the number of items in the i-th bin.

 Constraints:

    2 ≤ n ≤ 2 * 10^5

    1 ≤ items[i] ≤ 10^9

🎯 Output Format:

    Return a single integer — the minimum number of operations needed to reach a fair and balanced state.

🔍 Examples:
 Sample Input 0:

n = 3
items = [4, 4, 4]

 Sample Output 0:

0

 Explanation:

All bins already have the same number of items → no operations needed.
 Sample Input 1:

n = 2
items = [1, 7]

 Sample Output 1:

3

 Explanation:

Total items = 8
Target = [4, 4]
To reach this, perform 3 operations by moving items from bin 1 to bin 0.
 Sample Input 2:

n = 4
items = [1, 3, 2, 5]

 Sample Output 2:

2

 Explanation:

    Total items = 11

    Average = 11 / 4 = 2.75 → So balanced bins must be [3, 3, 3, 2] or [2, 2, 3, 4] etc., where no two bins differ by more than 1.

    Operations:

        Move item from bin 3 to bin 0: [2, 3, 2, 4]

        Move item from bin 3 to bin 2: [2, 3, 3, 3]

    Now it is balanced: no bin differs by more than 1.

Note: A 3rd operation like [3, 3, 3, 2] would not reduce the imbalance; hence, it is not needed.
 */
public class Min_Ops_For_Fair_Distribution_Of_Bins {
    
}
