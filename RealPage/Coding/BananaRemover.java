/*
 * ❓ Question:
 * 
 * You are given a string S consisting of only uppercase English letters.
 * In one move, you can remove a set of characters forming the word "BANANA".
 * To form "BANANA", you need:
 * - 1 'B'
 * - 3 'A's
 * - 2 'N's
 * 
 * Characters can appear in any order.
 * 
 * Return the maximum number of times the word "BANANA" can be removed from the string.
 * 
 * 🔹 Example:
 * Input:  "NAABXXAN"
 * Output: 1   // After removing BANANA once, we get "XX"
 */

public class BananaRemover {

    public static int maxBananaRemovals(String S) {
        int countA = 0, countB = 0, countN = 0;

        for (char ch : S.toCharArray()) {
            if (ch == 'A') countA++;
            else if (ch == 'B') countB++;
            else if (ch == 'N') countN++;
        }

        return Math.min(countB, Math.min(countA / 3, countN / 2));
    }

    public static void main(String[] args) {
        String input = "NAABXXAN";
        int result = maxBananaRemovals(input);
        System.out.println("Max BANANA removals: " + result);
    }
}
