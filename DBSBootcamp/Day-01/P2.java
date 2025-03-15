/*
There are N persons in a Instagram Page, the persons are identified by a 
unique identification number from 0 to N-1. There may exist a strange person 
in the IG page.

The rules to identify the strange person X are:
    - Everyone in the IG Page follows the person X.
    - X does not follow anybody in that IG Page.

You are given a N*N matrix IG[][] representing the followers in the IG Page,
the matrix contains only 0's and 1's. 0 indicates "not follows", 
1 indicates "follows". Your task is to find the strange person X among 
the N people. You are allowed to perform only one operation:
    - You can check whether M follows N, if yes, means M follows N.
    But it won't guarantee that N follows M.

You can perform this operation as less as possible to find the strange person X.

If you found a strange person X, print the identification number of X,
Otherwise, print '-1'

Input Format:
-------------
Line-1 : An integer N, number of persons
Next N lines : N space separated integers.

Output Format:
--------------
Print an integer, the UIN or '-1'


Sample Input-1:
---------------
4
1 1 0 1
0 1 1 1
1 0 1 1
0 0 0 1

Sample Output-1:
----------------
3

Explanation:
------------
Look at the hint.


Sample Input-2:
---------------
4
1 1 0 1
0 1 1 1
1 0 1 1
1 0 0 1

Sample Output-2:
----------------
-1
 */

import java.util.*;
public class P2{
    private static int getStrangePerson(int[][] grid,int n){

        // Better caluclate the indegree and outdegree of all nodes
        int[] indegree = new int[n];
        int[] outdegree = new int[n];
        // just check the cols where there all ones
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1) {
                    indegree[j]++;
                    outdegree[i]++;
                }
                
            }
            
        }
        
        // System.out.println("Indegree : " + Arrays.toString(indegree));
        // System.out.println("Outdegree : " + Arrays.toString(outdegree));

        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == n && outdegree[i] == 1) return i;
        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(getStrangePerson(grid,n));
        
        sc.close();
    }
}