/*
Problem Title: Maximum System Memory Capacity (Greedy + Sorting)

Description:
The developers at Amazon are working on optimizing the capacity of their cloud system. In the system, there are `n` servers where the memory capacity 
of the ith server is represented by the array `memory[i]`.

A system always contains an even number of servers. If the system has `2x` servers, then `x` of them will be primary and the other `x` will be
backup servers.

For each primary server `P`, there exists a backup server `B` where the memory capacity of `B` is at least the memory capacity of P.

The backup server `B` must have memory capacity ≥ memory capacity of its paired primary server.

The system's memory capacity is the sum of memory capacities of all primary servers.

---

Objective:
Given `n` servers and an array `memory`, find the maximum system memory capacity that can be formed using the `n` servers.

---

Function Signature:

```java
public static long maximumCapacity(List<Integer> memory)
```

Input:

* `List<Integer> memory`: the memory capacities of the given `n` servers.

Output:

* `long`: the maximum total memory for the primary servers satisfying the constraints.

---

Sample Input-1:-
[2,4,3,1,2]

Sample Output-1:-
5

Sample Input-2:-
[1,2,1,2]

Sample Output-2:-
3


Constraints:

* `2 ≤ n ≤ 10^5` (even number)
* `1 ≤ memory[i] ≤ 10^9`


 */
import java.util.*;
public class Maximize_Primary_Server_Memory {
    public static long maximumCapacity(List<Integer> memory){
        int n = memory.size();
        // 1) First sort the list
        Collections.sort(memory);

        // 2) Now traverse from second last element (let second last be our first primary server) to get the maximum capacity in primary servers , then leave one
        // and go back , take alternative

        long maxPrimaryServerMemory = 0L;

        for(int i = n - 2 ; i >= 0 ; i-=2){
            maxPrimaryServerMemory += memory.get(i);
        }

        return maxPrimaryServerMemory;
    }

    public static void main(String[] args) {
        int n;
        List<Integer> arr = new ArrayList<>();
        try(Scanner sc = new Scanner(System.in)){
            n = sc.nextInt();
            for(int i = 0 ; i < n ; i++){
                arr.add(sc.nextInt());
            }
        }

        System.out.println(maximumCapacity(arr));
    }

}
