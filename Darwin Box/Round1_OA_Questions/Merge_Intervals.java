/*
You are working as a scheduling coordinator at a conference center. 
Your task is to optimize room usage by merging overlapping time slots 
to avoid booking conflicts.

Input Format:
-------------
First line contains n, the number of booking intervals.
Next n lines each contain two space‐separated integers start_time and end_time.
(Times are represented in 24-hour format (e.g., 1300 for 1:00 PM).)

Output Format:
--------------
The merged list of non‐overlapping intervals in sorted order.
Each interval printed in HHMM HHMM format, zero‐padded to 4 digits.

Constraints:
------------
-> 0000 ≤ start_time < end_time ≤ 2400
-> start_time and end_time follow valid 24-hour format
-> 1 ≤ n ≤ 10^5

Sample Input:
-------------
4
0900 1030
1000 1200
1230 1315
1300 1445

Sample Output:
--------------
0900 1200
1230 1445
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Merge_Intervals{
    private List<List<String>> getMergedIntervals(List<String[]> lst,final int n){
        // sort according to start time 
        Collections.sort(lst,(a,b) ->{
            return a[0].compareTo(b[0]);
        });
        
        String prevStartTime = lst.get(0)[0];
        String prevEndTime = lst.get(0)[1];
        
        List<List<String>> ans = new ArrayList<>();
        for(int i = 1 ; i < n ; i++){
            String currStartTime = lst.get(i)[0];
            String currEndTime = lst.get(i)[1];
            
            if(currStartTime.compareTo(prevEndTime) <= 0){
                // if currstart < prevEnd yes this can be merged into a single interval
                // take max of prevEnd time
                if(currEndTime.compareTo(prevEndTime) > 0){
                    // if curr > prev , update prevEndTime
                    prevEndTime = currEndTime;
                }
            }else{
                ans.add(Arrays.asList(prevStartTime,prevEndTime));
                prevStartTime = currStartTime;
                prevEndTime = currEndTime;
            }
        }
        
        ans.add(Arrays.asList(prevStartTime,prevEndTime));
        return ans;
    }
    public static void main(String... args){
        int n;
        List<String[]> lst = new ArrayList<>();
        
        try(Scanner sc = new Scanner(System.in)){
            n = sc.nextInt();
            for(int i = 0 ; i < n ; i++){
                lst.add(new String[]{sc.next(),sc.next()});
            }
        }
        
        List<List<String>> ans = new Merge_Intervals().getMergedIntervals(lst,n);
        
        ans.forEach(interval -> {
            System.out.println(interval.get(0) + " " + interval.get(1));
        });
    }
}