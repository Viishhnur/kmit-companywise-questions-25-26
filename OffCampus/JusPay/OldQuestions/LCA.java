/*
Question

You are given a forest (it may contain a single tree or more than one tree) with N nodes. Each node is given an integer value from 0 to (N-1).

You have to find the Nearest Common Ancestor (NCA) of two given nodes x1 and x2.

N can be very large. Aim for an algorithm with a time complexity of O(N).

Input Format

An integer T, denoting the number of test cases, followed by 3T lines (as each test case has 3 lines).

First line of each test case contains the value of N.

Second line of each test case contains a list of N values, where the number at index i is the parent of node i.

The parent of the root is -1.

The index range is [0, N-1].

Third line of each test case contains two integers within the range [0, N-1] whose common ancestor you have to find.

Output Format

For each test case, output a single line that has the nearest common ancestor of the two given nodes x1 and x2.

If a common ancestor is not present, output -1.

Sample Input:- 
2
6
5 -1 1 1 5 2
0 3
13
4 3 -1 -1 1 2 7 3 1 4 2 1 2
8 5

Sample Output:-
1
-1  
 */
import java.util.*;

class Node{
    int val;
    Node parent;

    public Node(int val){
        this.val = val;
        this.parent = null;
    }

}

class Tree{
    private Node root;

    public Tree(int[] arr){
        root = buildTree(arr);
    }

    private Node buildTree(int[] arr){
        if(arr[0] == -1) return null;

        Queue<Node> qu = new LinkedList<>();
        root = new Node(arr[0]);
        qu.offer(root);

        int i = 1;
        while(!qu.isEmpty()){
            Node node = qu.poll();

            if(i < arr.length && arr[i] != -1){
                node.left = new Node(arr[i]);
                qu.offer(node.left);
            }

            i++;

            if(i < arr.length && arr[i] != -1){
                node.right = new Node(arr[i]);
                qu.offer(node.right);
            }

            i++;

        }

        return root;
    }

    public void printLevelOrder(){

    }

}
public class LCA {
    public static void main(String[] args) {
        int T;

        try(Scanner sc = new Scanner(System.in)){
            T = sc.nextInt();
            while(T-- > 0){
                int N = sc.nextInt();
                int[] arr = new int[N];
                for(int i = 0 ; i < N ; i++){
                    arr[i] = sc.nextInt();   
                }

                int x1 = sc.nextInt() , x2 = sc.nextInt();
                System.out.println();
            }
        }
    }
}
