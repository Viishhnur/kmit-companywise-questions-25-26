/*
Samraj loves to play with numbers. Somebody gave him some numbers and he wishes 
to play a game with them. 
There are 3 operations that have to be applied periodically on the given set of numbers.

The operations to be applied in periodic manner are (bitwise) XOR, ADD, (bitwise) OR.

Suppose there are five numbers. Operations will be applied in the following manner:
(((a₁ XOR a₂) + a₃) OR a₄) XOR a₅

and it will go on further for more numbers in the same periodic fashion (XOR → ADD → OR → XOR → …).

You have to predict whether the maximum value possible by applying those operations 
cyclically on any chosen subsequence of the given set (order preserved) is Odd or Even.

NOTE: The sequencing of the numbers in the chosen subsequence is preserved from the main set.

Input Format:
-------------
The first line consists of an integer T, the number of test cases.
Then follow T test cases.
 - Each test case begins with an integer N, the length of the array.
 - Then N integers A₁, A₂, …, Aₙ follow (on one line), the elements of the array.

Output Format:
--------------
For each test case, print in a new line Even (without quotes) or Odd (without quotes), 
according to the parity of the maximum achievable result.

Sample Input:
-------------
2
5
4 5 6 7 8
4
1 2 3 4

Sample Output:
--------------
Odd
Even


Constraints:
------------
1 ≤ T ≤ 10
1 ≤ N ≤ 10^6
0 ≤ A[i] ≤ 10^5

 */
public class Cyclic_Sequence {

}
