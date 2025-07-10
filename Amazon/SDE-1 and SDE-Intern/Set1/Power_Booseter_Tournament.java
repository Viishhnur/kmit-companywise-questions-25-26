
/*
Problem Title: Multi-Player Tournament Power Booster Winners

Description:

Amazon Games have recently launched a new multi-player tournament on the platform.
Each game of the tournament has 3 rounds. The players are provided with exactly three power boosters at the start of the game, and each player 
is aware of the power boosters of their opponent.

In each round, the player can choose to compete with any of the power boosters, and any power booster can be used at most once in a particular game.
 In any particular round, the player with a higher power booster wins.

A player X is considered to be able to defeat player Y if there exists a rearrangement of power boosters of X such that some rearrangement 
of power boosters of Y can be defeated in at least 2 out of the 3 rounds.
Example:

    If power boosters of X = [9, 5, 11] and Y = [7, 12, 3]

        X uses boosters in order [3, 7, 12] → used against [11, 9, 5], wins 2/3 rounds.

        Another arrangement wins 2/3 as well.

        ✅ Thus, X can defeat Y.

    If X = [1, 2, 3] and Y = [3, 4, 5], X cannot defeat Y in any arrangement.

Function Description:

Implement the function:

int possibleWinners(int[] boost_a, int[] boost_b, int[] boost_c)

Parameters:

    boost_a[n]: the first booster of each player

    boost_b[n]: the second booster of each player

    boost_c[n]: the third booster of each player

Returns:

    int: the number of players capable of defeating all other players using any optimal arrangement of their boosters.

Sample Input-1 :-
4
boost_a = [3, 4, 1, 16]
boost_b = [2, 11, 5, 6]
boost_c = [8, 7, 9, 10]

Sample Output-1:-
2

🔢 Constraints:

  2 ≤ n ≤ 10^5

  1 ≤ boost_a[i], boost_b[i], boost_c[i] ≤ 10^9

  All power boosters of each player are pairwise distinct

 */
import java.util.*;

public class Power_Booseter_Tournament {

  private static int possibleWinners(int[] boost_a, int[] boost_b, int[] boost_c) {
      int n = boost_a.length;

      List<int[]> players = new ArrayList<>();
      for(int i = 0 ; i < n ; i++){
        players.add(new int[] {boost_a[i],boost_b[i],boost_c[i]});
        Arrays.sort(players.get(i));
      }

      // Brute force is to try a player for every other player 
      // T.C:- O(N^2)
      int cnt = 0;
      for(int i = 0 ; i < n ; i++){
        boolean canDefeatAll = true;
        int[] p1 = players.get(i);

        for(int j = 0 ; j < n ; j++){
          if(j == i) continue;

          int[] p2 = players.get(j);

          int ptr1 = 0 , ptr2 = 0;
          int wins = 0;

          while(ptr1 < 3 && ptr2 < 3){
            if(p1[ptr1] > p2[ptr2]){
              wins++;
              ptr1++;
              ptr2++;
            }else{
              // move the ptr1 so that we may get a better booster value
              ptr1++;
            }
          }
          
          if(wins < 2){
            canDefeatAll = false;
            break;
          }

        }


        if(canDefeatAll){
          cnt++;
        }
      }

      return cnt;

  }

  public static void main(String[] args) {
    int n;
    int[] boost_a, boost_b, boost_c;

    try (Scanner sc = new Scanner(System.in)) {
      n = sc.nextInt();

      boost_a = new int[n];
      for(int i = 0 ; i < n ; i++){
        boost_a[i] = sc.nextInt(); 
      }

      boost_b = new int[n];
      for(int i = 0 ; i < n ; i++){
        boost_b[i] = sc.nextInt(); 
      }

      boost_c = new int[n];
      for(int i = 0 ; i < n ; i++){
        boost_c[i] = sc.nextInt(); 
      }

      
    }

    System.out.println(possibleWinners(boost_a, boost_b, boost_c));
  }
}
