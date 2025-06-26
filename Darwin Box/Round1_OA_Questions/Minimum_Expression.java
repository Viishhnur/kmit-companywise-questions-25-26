/*
Matt likes cooking. But more than that, he likes to give gifts. 
And now he wants to give his girlfriend an unforgettable gift. 
But unfortunately he forgot the password to the safe where the gift is kept.

But he knows how to hack the safe. 
To do this, you need to correctly answer questions asked by the embedded computer. 
The computer is very strange, and asks special questions. 
Sometimes it can ask about 10000 questions (really weird). 
Because of this, Matt wants you to write a program that will help him to crack the safe.

The questions are different, but there is only one type of question. Several numbers are given and between them one of three characters: 
‘+’, ‘–’, ‘*’ can be inserted. 
Note that in this case there is no operator‐precedence — that is, you must evaluate strictly left to right. 
For example: 1 – 2 * 3 must be interpreted as (1 – 2) * 3 = –3 and not as 1 – (2*3).
The computer asks: What is the minimum possible value of any valid expression you can form by inserting one operator between each adjacent pair of numbers?

Input Format:
-------------
Line-1: an integer T denoting the number of test cases.
Then for each test case:
	- A line containing a positive integer N
	- A line containing N space‐separated integers A[1], A[2], …, A[N] (these are the numbers, in order, with no operators).

Output Format:
--------------
For each test case, output a single line containing the minimal value of any valid expression you can form.

Constraints:
-------------
1 ≤ T ≤ 10^5
1 ≤ N ≤ 10
–9 ≤ A[i] ≤ 9

Sample Input:
-------------
2
3
1 2 3
1
9

Sample Output:
--------------
-4
9

Explanation
Test case 1: best is 1 – 2 – 3 = –4.
Test case 2: only one number, 9.
 */
import java.util.*;
public class Minimum_Expression{
    private void dfs(int i,long resTillNow,int[] nums,final int n,long[] mini){
        
        if(i == n){
            mini[0] = Math.min(resTillNow,mini[0]); // minimize the result
            return;
        }
        
        long currNum = nums[i];
        
        if(i == 0){
            dfs(i+1,currNum,nums,n,mini);
        }else{
            dfs(i+1,resTillNow + currNum,nums,n,mini);
            dfs(i+1,resTillNow - currNum,nums,n,mini);
            dfs(i+1,resTillNow * currNum,nums,n,mini);
        }
        
    }
    
    private long dfs2(int i,long resTillNow,int[] nums,final int n){
        if(i == n){
            return resTillNow;
        }
        
        long currNum = nums[i];
        
        long a = dfs2(i+1,resTillNow + currNum,nums,n);
        long b = dfs2(i+1,resTillNow - currNum,nums,n);
        long c = dfs2(i+1,resTillNow * currNum,nums,n);
        
        return Math.min(a,Math.min(b,c));
        
    }
    
    private long dfs2Memo(int i,long resTillNow,int[] nums,final int n,Map<String,Long> dp){
        if(i == n){
            return resTillNow;
        }
        
        String key = i + "," + resTillNow;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        
        long currNum = nums[i];
        
        long a = dfs2Memo(i+1,resTillNow + currNum,nums,n,dp);
        long b = dfs2Memo(i+1,resTillNow - currNum,nums,n,dp);
        long c = dfs2Memo(i+1,resTillNow * currNum,nums,n,dp);
        
        long res = Math.min(a,Math.min(b,c));
        dp.put(key,res);
        
        return res;
        
    }
    
    private void printMinValue(int[] nums,final int n){
        
        // Approach-i) Recursion Way-1
        // long[] mini = {Long.MAX_VALUE};
        // dfs(0,0L,nums,n,mini);
        // System.out.println(mini[0]);
        
        // Approach-ii) Another way of recursion
        // System.out.println(dfs2(1,nums[0],nums,n));
        
        // Approach-iii) Memoization
        System.out.println(dfs2Memo(1,nums[0],nums,n,new HashMap<>()));
    }
    public static void main(String... args){
        int T;
        
        Minimum_Expression obj = new Minimum_Expression();
        try(Scanner sc = new Scanner(System.in)){
            T = sc.nextInt();
            
            while(T-- > 0){
                int n = sc.nextInt();
                int[] nums = new int[n];
                
                for(int i = 0 ; i < n ; i++) nums[i] = sc.nextInt();
                
                obj.printMinValue(nums,n);
            }
        }
    }
}