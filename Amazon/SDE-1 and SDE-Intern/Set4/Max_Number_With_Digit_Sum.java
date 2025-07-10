/*
Maximum Number With Digit Sum Equal to N Using x and y
📘 Problem Statement

You are given two digits x and y (between 0 and 9), and a target digit sum n.

You can form numbers by appending digits — only digit x or digit y — any number of times and in any order.

Your goal is to construct the maximum possible number such that the sum of its digits equals n.
🧾 Input Format

    Integer x — first allowed digit

    Integer y — second allowed digit

    Integer n — required digit sum

🎯 Output Format

    Return the maximum number (as an integer or string) that can be formed using digits x and y such that the sum of digits equals n.

    If no such number can be formed, return -1.

 Constraints

    0 ≤ x, y ≤ 9

    1 ≤ n ≤ 10^5

🔍 Examples & Test Cases
 Test Case 1:

Input:
x = 3, y = 4, n = 13

Output: 4333

Explanation:
Digits used: 4 + 3 + 3 + 3 = 13  
4333 is the largest number possible with sum 13 using only 3 and 4.

 Test Case 2:

Input:
x = 9, y = 7, n = 345

Output: 99999999999999999999999999999999999999999999999999... (38 nines + 1 seven)

Explanation:
Use as many 9s as possible. 345 // 9 = 38 → 342
Remaining: 345 - 342 = 3 → not divisible by 7 → try fewer 9s
Eventually, 38 9s + 1 7 → sum = 345  
Number: 999...97

 Test Case 3:

Input:
x = 8, y = 5, n = 2

Output: -1

Explanation:
No combination of 5 and 8 can sum to 2 → Not possible
 */
public class Max_Number_With_Digit_Sum {
    
}
