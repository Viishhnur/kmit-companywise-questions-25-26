
# Eventbrite Online Assessment (OA) Questions - April 2025

## Question 1: Server Connection
  
### Problem Statement:
A company has a network of servers represented as a tree (undirected graph with no cycles). Each server is a node. You are given:
- `server_nodes`: Total number of servers (nodes)
- `server_from[]`: List of edges (from nodes)
- `server_to[]`: List of edges (to nodes)
- `server_weight[]`: List of edge weights between connected servers
- `signal_speed`: A signal can travel a path if the **total weight of that path is divisible by signal_speed**

For each server `i`, calculate how many other servers it can communicate with (i.e., for every other server `j`, if the distance from i to j is divisible by `signal_speed`, it's valid).

### Input Example:
```text
server_nodes = 4
server_from = [1, 2, 3]
server_to =   [2, 3, 4]
server_weight = [2, 2, 2]
signal_speed = 2
```

### Output:
```text
[6, 6, 6, 6]
```

Each server can communicate with 2 others where the path weight is divisible by 2. => 

### Similar LeetCode Problems:
- [LeetCode 743 - Network Delay Time](https://leetcode.com/problems/network-delay-time/)  
- [LeetCode 787 - Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/)  
- [LeetCode 399 - Evaluate Division (DFS weighted graph)](https://leetcode.com/problems/evaluate-division/)  

### Approach Guidance:
You need to compute **all-pairs shortest paths** (Floyd-Warshall for dense graphs or Dijkstra from every node for sparse graphs). Then filter distances divisible by `signal_speed`. Since it’s a tree, better to precompute distances using **DFS from every node** (O(N^2)).

### Your Solution Template:
```java
public static List<Integer> getServerPairs(int serverNodes, List<Integer> serverFrom,
                                           List<Integer> serverTo, List<Integer> serverWeight,
                                           int signalSpeed) {
    // TODO: Implement tree construction using adjacency list
    // TODO: For each node, run DFS to calculate distances to all others
    // TODO: Count pairs where distance is divisible by signalSpeed
    return new ArrayList<>();
}
```

---

## Question 2: Maximum Reveal Difficulty
**Type**: Greedy / Partitioning  
**Difficulty**: Medium  
**Tags**: Greedy, Combinatorics, Subset Sum, Partition

### Problem Statement:
You are given `n` modules with a `difficulty[]` array. You need to divide them into 3 **non-empty** groups such that:
- Each module is in exactly one group
- Each group is assigned to a different server
- Then choose one module from each group and find **max(|a-b| + |b-c| + |c-a|)** over all such selections

Return the **maximum possible overall difficulty**.

### Input Example:
```text
difficulty = [5, 6, 1, 4, 2]
```

### Output:
```text
8
```

Explanation: Choose groups as:
- Group 1: [5, 6, 4]
- Group 2: [1]
- Group 3: [2]
Then from these, pick 6 (G1), 1 (G2), 2 (G3). Total difficulty: `|6-1| + |1-2| + |2-6| = 5+1+4 = 10` (or another valid optimal combination).

### Similar LeetCode Problems:
- [LeetCode 805 - Split Array With Same Average](https://leetcode.com/problems/split-array-with-same-average/)  
- [LeetCode 698 - Partition to K Equal Sum Subsets](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/)  
- [LeetCode 1388 - Pizza With 3n Slices (Greedy Partition)](https://leetcode.com/problems/pizza-with-3n-slices/)

### Approach Guidance:
Brute-force all 3-group partitions (O(3^n)), but optimize using greedy heuristics. Maximize min/max elements among the 3 groups.

### Your Solution Template:
```java
public static int getMaxDifficulty(List<Integer> difficulty) {
    // TODO: Generate all valid 3-group partitions
    // TODO: For each partition, pick one value from each group and compute max(|a-b| + |b-c| + |c-a|)
    // Hint: This simplifies to 2 * (max - min)
    return 0;
}
```


### Advice:
- For **Q1**, prelearn: `DFS from every node`, `Floyd-Warshall`, or `Tree DP`
- For **Q2**, learn: `k-group partition logic`, `max pairwise diff`, or reduce to `max-min` selection

These are **NOT easy to fully solve in 1 hr**, especially without pattern recognition.

---
