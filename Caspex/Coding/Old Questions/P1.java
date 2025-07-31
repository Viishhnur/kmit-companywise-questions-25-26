/*
You are given an array A of size n containing positive integers, along with another array X of size m that specifies 
the indices of elements to be dropped from array A.

Your task is to remove the elements at the specified indices from array A and then print the modified array as output.

Constraints:
------------
1 ≤ n ≤ 10^4

1 ≤ m ≤ 10^4

1 ≤ A[i] ≤ 10^6

All the elements of the second array  of size M should be distinct.

The index of the elements in the array start from 0

Any elements of array X cannot be negitive.


Input Format:
--------------
The first line of the input accepts an integer displaying the size of the array(n)
The second line of the input accepts the elements of the array of size n. each separated by a space
The third line of the input accepts an integer displaying the size of the array(m).
The fourth line of input accepts the elements of the array of size m. each separated by a space. These elements contains consists of the indices we want to drop from the main array which is of size n.

Output Format:
--------------
A single line of output displays the array after dropping the elements.

Sample Input 1:
---------------
4
1 2 3 4
2
2 3

Sample Output 1:
----------------
1 2

Explanation
------------
The First line of input creates an array of size 4. The elements of this array is mentioned in the second line of input
i.e.[1,2,3,4]. The third line of input is an array of size 2 which means that 2 elements from the array A need to be 
dropped . The fourth line of input contains the array( [2,3]) which displays that the elements of indices 2 and 3 need
to be dropped from the main array([1,2,3,4]).
The final output is array:[1,2]

Sample Input 2:
---------------
6
3 4 5 6 3 2
1
2

Sample Output 2:
----------------
3 4 6 3 2

Explanation 
-----------
The First line of input creates an array of size 6. The elements of this array is mentioned in the second line of input
i.e.[3,4,5,6,3,2]. The third line of input is an array of size 1 which means that 1 elements from the array  needs to 
be
dropped . The fourth line of input contains the array( [2]) which displays that the elements of indices 2 need to be 
dropped from the main array([3,4,5,6,3,2]).
The final output is array:[3,4,6,3,2]
 */
import java.util.*;
public class P1 {
    private static void printModifiedArray(int[] A,int[] B,final int m,final int n){
        // sort the array B
        Arrays.sort(B);
        int ptr = 0;
        System.out.println("Modified Arr: ");
        for(int i = 0 ; i < m ; i++){
            if(i != B[ptr]){
                System.out.print(A[i] + " ");
            }else{
                ptr++;
            }
        }
    }
    public static void main(String[] args) {
        int m,n;
        int[] A,B;
        try (Scanner sc = new Scanner(System.in)) {
            m = sc.nextInt();
            A = new int[m];
            for(int i = 0 ; i < m ; i++){
                A[i] = sc.nextInt();
            }

            n = sc.nextInt();
            B = new int[n];
            for(int i = 0 ; i < n ; i++){
                B[i] = sc.nextInt();
            }
        }

        printModifiedArray(A,B,m,n);
    }
}