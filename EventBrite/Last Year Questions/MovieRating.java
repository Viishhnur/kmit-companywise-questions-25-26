
/*
1. Movie Ratings
Alexa loves movies and maintains a list of negative and/or positive integer ratings for the movies in her collection. She's getting ready for a film festival and wants to choose some subsequence of movies from her collection to bring such that the following conditions are satisfied:

The collective sum of their ratings is maximal.

She must go through her list in order and cannot skip more than one movie in a row.

In other words, she cannot skip over two or more consecutive movies. For example, if
ratings = [1, -3, -2], she must include either the second number or the first and third numbers to get a maximal rating sum of -1.

Example
If ratings = [-3, 2, 4, -1, -2, -5],
Her maximal choices are [2, 4, -2] for a sum of 4.

Function Description
Complete the function maximizeRatings in the editor below. The function must return an integer denoting the maximum possible rating sum for Alexa's chosen subsequence of movies without reordering them.

maximizeRatings has the following parameter(s):
ratings(ratings[0],....ratings[n-1]): an array of integers

Constraints:
1 ≤ n ≤ 10⁵
-1000 ≤ ratings[i] ≤ 1000, where 0 ≤ i < n

Input
ratings: a list of integers of size n (1 ≤ n ≤ 10⁵)
Each ratings[i] (where 0 ≤ i < n) is in the range -1000 to 1000

Sample Case 0
Input
5  
9  
-1  
-3  
4  
5  

Output
17

Explanation
Alexa picks the bolded items in ratings = [9, -1, -3, 4, 5] to get maximum rating:
9 + 4 + 5 = 17.
Thus, the answer is 17.
 */
import java.util.*;

public class MovieRating {

    private static int solve(int idx, int[] ratings, final int n, boolean taken) {
        if (idx == n) {
            return 0;
        }

        int take = ratings[idx] + solve(idx + 1, ratings, n, true);
        // But you can only notTake if have taken prev
        int notTake = Integer.MIN_VALUE;
        if (taken) {
            notTake = solve(idx + 1, ratings, n, false);
        }

        return Math.max(take, notTake);
    }

    private static int maximizeRatings(int[] ratings, final int n) {
        return solve(0, ratings, n, true);  // initially taken is true to allow skipping the first element if needed 
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] ratings = new int[n];

            for (int i = 0; i < n; i++) {
                ratings[i] = sc.nextInt();
            }

            System.out.println(maximizeRatings(ratings, n));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}