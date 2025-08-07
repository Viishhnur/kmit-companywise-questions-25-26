/*  Problem Title: "Magic Swap Wizards – Alice & Bob"

Problem Statement:

In the fantastic Land of Swaps, there are two mighty wizards: Alice and Bob. They each have a row of N distinct positive integers.

    One sequence belongs to Alice, the other to Bob.

    It is necessary for the good of the kingdom that both sequences become identical, though initially they may not be the same.

They can perform the following magical coordinated swaps:

    Alice’s ability: She can choose any two positions i and j in her sequence and swap the elements at those positions.

    Bob’s ability: After Alice's swap, Bob can also perform a similar swap. But he must swap two positions P and Q such that |P - Q| = |i - j|, i.e., 
    the distance between swapped indices must be the same.

Using these rules, the goal is to check if Alice and Bob can make both sequences identical.

Input Format:

First line: Integer N - size of both sequences
Second line: N space-separated integers - Alice's sequence
Third line: N space-separated integers - Bob's sequence

Output Format:

Print "yes" if they can make the sequences equal, otherwise print "no".

Sample Test Case-1 :
Input:
5
1 3 4 2 5
4 3 5 7 1

Output:
no

Sample Testcase 2:
Input:
4
1 2 3 4
4 3 2 1

Output:
yes

Constraints:

    1 ≤ N ≤ 10⁵

    1 ≤ A[i], B[i] ≤ 10⁵

    Sum of N over all test cases ≤ 10⁵
 */
#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class MagicSwapWizards {
    bool canMatch(vector<int>& A, vector<int>& B) {
    vector<int> evenA, oddA, evenB, oddB;
    for (int i = 0; i < A.size(); ++i) {
        if (i % 2 == 0) {
            evenA.push_back(A[i]);
            evenB.push_back(B[i]);
        } else {
            oddA.push_back(A[i]);
            oddB.push_back(B[i]);
        }
    }
    sort(evenA.begin(), evenA.end());
    sort(evenB.begin(), evenB.end());
    sort(oddA.begin(), oddA.end());
    sort(oddB.begin(), oddB.end());
    
    return evenA == evenB && oddA == oddB;
}

};
