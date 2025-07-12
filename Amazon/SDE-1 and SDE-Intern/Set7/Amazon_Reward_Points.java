
/*
Amazon Shopping periodically has offers to attract more customers.

It recently launched an offer for n items in its inventory, where the iᵗʰ item offered pointValues[i]
 reward points to the customer purchasing the item.
Every time an offer-bearing item is purchased:

    The customer gains the point value of the selected item.

    Then, the reward points of the remaining items are reduced by 1, unless doing so would reduce them below
     0.

    Each item can be purchased at most once.

🎯 Goal:

Find the maximum possible reward points that can be gathered by purchasing the items optimally.
🧾 Function Signature

long calculateMaximumPointsEarned(List<Integer> pointValues)

🔹 Parameters:

    pointValues: a List of integers representing reward points of each item

🔹 Returns:

    long: the maximum reward points which can be collected

📌 Constraints:

    1 ≤ n ≤ 10⁵

    0 ≤ pointValues[i] ≤ 10⁶

🔍 Example:
Input:

pointValues = [5, 2, 2, 3, 1]

Output:

7

Explanation:

Purchase order:

    Pick index 2 (value 2), others become: [4, 1, 0, 2, 0]

    Pick index 3 (value 2), others become: [3, 0, 0, 0, 0]

    Pick index 0 (value 3), others become: [0, 0, 0, 0, 0]

Total = 2 + 2 + 3 = 7
 */
import java.util.*;

public class Amazon_Reward_Points {
    public static long calculateMaximumPointsEarned(List<Integer> pointValues) {

        // Everytime i pick a elements all other values decrease by 1 unit
        // So , I will greedily pick the points with highest value first
        Collections.sort(pointValues, Collections.reverseOrder());

        int effect = 0;
        long total = 0L;
        for (int point : pointValues) {
            int currVal = point - effect; // subtracting the effect

            if (currVal <= 0) {
                break;
            }

            total += currVal;
            effect++; // spread the effect to next numbers

        }
        return total;
    }

    
}
