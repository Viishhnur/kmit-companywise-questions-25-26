/*
Question 1: Buy Book Volumes in Consecutive Order
📘 Problem Statement:

You are given an array volumes[] of n integers. On day i (0-based), volume volumes[i] is available for purchase.

You can only buy volumes if all the volumes seen so far (up to day i) form a consecutive sequence (without any gaps).
 If the condition is met, you buy all volumes not bought so far and print them in ascending order. Otherwise, print -1.

Return an array of arrays, where each element represents the result for that day.
🧠 Input:

    volumes: An array of integers representing the volume number offered on each day.

    1 <= volumes.length <= 10^5

    1 <= volumes[i] <= 10^5

    All values are unique.

🧾 Output:

    A list of lists:

        Each sublist contains the sorted list of volumes bought on that day, or [-1] if not bought.

Input: volumes = [1, 4, 3, 2, 6, 5]

Output:
[
 [1],
 [-1],
 [-1],
 [2, 3, 4],
 [-1],
 [5, 6]
]

Explanation:

    Day 0: Volume 1 → valid → buy [1]

    Day 1: [1, 4] → not consecutive → -1

    Day 2: [1, 4, 3] → not consecutive → -1

    Day 3: [1, 4, 3, 2] → now [1, 2, 3, 4] → buy [2, 3, 4]

    Day 4: [1,2,3,4,6] → gap → -1

    Day 5: [1,2,3,4,6,5] → now [1..6] → buy [5,6]
 */
import java.util.*;
public class Buy_Book_Volumes {

    private static boolean checkIsConsective(int n,int sumTillNow,int mini){

        // n represents noOfElements taken till now
        int requiredSum = (n * (2 * mini + n - 1)) / 2; // this is sum of n elements in AP whose Common difference is 1
        return sumTillNow == requiredSum;
    }
    private static List<List<Integer>> solve(List<Integer> volumes,final int n){

        if(volumes.isEmpty()) return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();

        ans.add(Arrays.asList(volumes.get(0)));
        int l = 1 , r = 1;
        int sum = volumes.get(0);
        int mini = volumes.get(0);

        while(l <= r && r < n){

            sum += volumes.get(r); // tracks current sum
            mini = Math.min(mini,volumes.get(r)); // tracks current minimum

            // check if this is consective after sorting
            if(checkIsConsective(r+1,sum,mini)){
                // get the sublist from l to r
                List<Integer> row = volumes.subList(l, r+1);
                Collections.sort(row);
                ans.add(row);
                l = r + 1;
            }else{
                ans.add(Arrays.asList(-1));
            }

            r++;
        }

        return ans;

    }
    
    public static void main(String[] args) {
        int n;
        List<Integer> volumes = new ArrayList<>();
        try(Scanner sc = new Scanner(System.in)){
            n = sc.nextInt();
            for(int i = 0 ; i < n ; i++){
                volumes.add(sc.nextInt());   
            }
        }

        System.out.println(solve(volumes,n));

    }
}
