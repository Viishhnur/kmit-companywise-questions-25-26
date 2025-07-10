/*
Question 2: Minimum Flips to Make Even-Length Binary Segments
📘 Problem Statement:

You are given a binary string s of even length. You are allowed to flip any bit (i.e., change '0' to '1' or '1' to '0') any number of times.

Your task is to:

    Make the string such that every group of consecutive same bits has an even length (e.g., "00", "1111", "0000" are valid; "0", "111" are invalid).

    Among all such valid strings with minimum number of bit flips, also return the minimum number of segments that result.

🧠 Your Objective:

Return an array of two integers:

    The minimum number of bit flips needed to make all segments even in size.

    The minimum number of segments possible among all such valid strings.

🧾 Input:

    A binary string s of even length
    Constraints:

        2 <= s.length <= 10^5

        s.length % 2 == 0

        s[i] ∈ {'0', '1'}

🧾 Output:

Return a list of two integers:

[min_flips, min_segments]

🔍 Example 1:

Input: "1011"

Output: [1, 1]

Explanation:

    Flip the first '0' → "1111"

    Now segments = ["1111"] → even length → valid

    Minimum flips = 1, Minimum segments = 1

🔍 Example 2:

Input: "0011110000"

Output: [0, 3]

Explanation:

    Already valid. Segments: ["00", "1111", "0000"]

    All are even-length segments → no flips needed

    Minimum segments = 3

🔍 Example 3:

Input: "1101"

Output: [1, 1]

Explanation:

    Flip '0' → "1111" or Flip '1' → "1001"

    Best: "1111" → 1 flip, 1 segment → [1, 1]

But "1111" is best (1 flip, 1 segment), so output should be:

[1, 1]

 */

import java.util.*;

public class Min_Flips_To_Make_Even_Length_Binary_Segment {

    private static int isValid(String s, final int n) {
        List<String> segs = new ArrayList<>();
        char ch = s.charAt(0);
        StringBuilder seq = new StringBuilder(ch + "");

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ch) {
                seq.append(s.charAt(i));
            } else {
                if (seq.length() % 2 == 1) return -1;
                segs.add(seq.toString());
                ch = s.charAt(i);
                seq = new StringBuilder(ch + "");
            }
        }

        // Add the last segment
        if (seq.length() % 2 == 1) return -1;
        segs.add(seq.toString());

        return segs.size(); // valid segments
    }

    private static void backtrack(int idx, int flips, StringBuilder sb, String s, final int n, int[] res) {
        if (idx == n) {
            int segments = isValid(sb.toString(), n);
            if (segments != -1) {
                if (flips < res[0] || (flips == res[0] && segments < res[1])) {
                    res[0] = flips;
                    res[1] = segments;
                }
            }
            return;
        }

        char ch = s.charAt(idx);

        // Flip bit
        sb.append(ch == '0' ? '1' : '0');
        backtrack(idx + 1, flips + 1, sb, s, n, res);
        sb.deleteCharAt(sb.length() - 1); // backtrack

        // Do not flip
        sb.append(ch);
        backtrack(idx + 1, flips, sb, s, n, res);
        sb.deleteCharAt(sb.length() - 1); // backtrack
    }
    public static int[] getMinFlipsAndSegments(String s) {
        int flips = 0;
        int segments = 0;

        int n = s.length();
        int i = 0;

        while (i < n) {
            char ch = s.charAt(i);
            int j = i;

            // move j while characters are same
            while (j < n && s.charAt(j) == ch) j++;

            int len = j - i;
            if (len % 2 != 0) flips++; // flip 1 bit to make length even

            segments++; // new segment

            i = j; // move to next group
        }

        return new int[]{flips, segments};
    }
    private static int[] getMinFlipsAndSegments(String s, final int n) {

        // Approach-i) Backtracking (TLE) 
        // int[] res = {n, n}; // initialize with worst case
        // backtrack(0, 0, new StringBuilder(), s, n, res);
        // return res;

        // Approach-ii) Greedy
        return getMinFlipsAndSegments(s);
    }

    public static void main(String[] args) {
        String s;
        try (Scanner sc = new Scanner(System.in)) {
            s = sc.next();
        }
        System.out.println(Arrays.toString(getMinFlipsAndSegments(s, s.length())));
    }
}
