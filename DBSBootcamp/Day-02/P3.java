/*
There are P people in a Village, some of the people are relatives, 
others are not. Their relationship is transitive. 

For example, 
if A is a direct relative of B, and B is a direct relative of C, 
then A is an indirect relative of C. And we define a Relation Chain as 
a group of people who are direct or indirect relatives.

Given a P*P matrix R represents the relationship between people 
in the village. If R[i][j] = 1, then the i and j persons are direct 
relatives with each other, otherwise not. 

Your task is to find out the total number of Relation Chains 
among all the people.

Input Format:
-------------
Line-1 : An integer P, number of people
Next P lines : P space separated integers.

Output Format:
--------------
Print an integer, the total number of Relation Chains


Sample Input-1:
---------------
3
1 1 0
1 1 0
0 0 1

Sample Output-1:
----------------
2

Explanation:
------------
The 0-th and 1-st people are direct relatives, so they are in a relation chain.
The 2-nd person himself is in a relation chain. So return 2.


Sample Input-2:
---------------
3
1 1 0
1 1 1
0 1 1

Sample Output-2:
----------------
1

Explanation:
------------
The 0-th and 1-st people are direct relatives, 1-st and 2-nd people 
are direct relatives. So, the 0-th and 2-nd people are indirect relatives.
All of them in the same relative chain. So return 1.
 */ 
import java.util.*;

public class P3 {
    // T.C:- O(N^2),  S.C:- O(N)
    private static List<List<Integer>> adjLst; // make this a instance variable

    private static void dfs(int node, int[][] grid, boolean[] visited, int n) {
        visited[node] = true;

        for (int nbr : adjLst.get(node)) {
            if (!visited[nbr]) {
                dfs(nbr, grid, visited, n);
            }
        }

    }

    private static void buildAdjList(int[][] grid, int n) {
        for (int i = 0; i < n; i++) {
            adjLst.add(new ArrayList<>()); // first create space for each list
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    adjLst.get(i).add(j);
                }
            }
        }

    }

    private static int findCircleNum(int[][] grid,int n) {
        // a simple dfs would help us
        boolean[] visited = new boolean[n];

        adjLst = new ArrayList<>();
        buildAdjList(grid, n);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, grid, visited, n);
                cnt++;
            }

        }

        return cnt;

    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

            int p = sc.nextInt();
            int[][] persons = new int[p][p];
            for(int i = 0 ; i < p ; i++){
                for(int j = 0 ; j < p ; j++){
                    persons[i][j] = sc.nextInt();
                }
            }
    
            System.out.println(findCircleNum(persons,p));
            sc.close();
        }
    }
}