/*
1. Binary String Examination

You are given a binary string S of length N. Suppose you create another string T of size N * K by concatenating K copies of S together.

Find the maximum size of a substring of T consisting only of 0's.

Function description

Complete the maxSize function. It has the following parameters:

| Name | Type    | Description                      |
| ---- | ------- | -------------------------------- |
| N    | INTEGER | The size of the given array.     |
| K    | INTEGER | The number of copies to be made. |
| S    | STRING  | The given string.                |

Return

The function must return an INTEGER denoting the maximum size of a substring of T consisting only of 0s.

Input format for debugging

    -> The first line contains an integer N, denoting the size of the given array.

    -> The next line contains an integer K, denoting the number of copies to be made.

    -> The third line contains the string S.
 */

import java.util.Scanner;

public class Binary_String_Examination {

    private static int maxSize(int N,int K,String s){
        String tmp = s.repeat(K);
        System.out.println(tmp);

        // now we should find length of longest substring in s , where all values are zeros
        int maxLen = 0;
        int cnt = 0;
        for(char ch : tmp.toCharArray()){
            if(ch == '0'){
                cnt++;
            }else{
                maxLen = Math.max(maxLen,cnt);
                cnt = 0;
            }
        }

        maxLen = Math.max(maxLen,cnt);
        return maxLen;
    }
    public static void main(String[] args) {
        int n,k;
        String s;

        try(Scanner sc = new Scanner(System.in)){
            n = sc.nextInt();
            k = sc.nextInt();

            s = sc.next();
        }

        System.out.println(maxSize(n, k, s));
    }
}