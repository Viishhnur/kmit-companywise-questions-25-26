# DBS OA Coding Question 2 - BST Queries

## Problem Statement

You are given Q queries in the form of 2D array `queries` of size Q × 2.  
You have to implement a binary search tree and apply these Q queries to it.  
Each query is of the form [X, Y].

- If X = 0, insert Y into the binary search tree.
- If X = 1, tell if Y exists in the binary search tree or not.
  - If it does, remove Y from the tree.
  - If it does NOT exist, print 0.
  - If it exists, print 1 and remove it.

### Input Format
```
Q
Q lines with two space-separated integers: X Y
```

### Output Format

For each query where X = 1:
- Print 1 if Y exists in the tree and remove it.
- Print 0 otherwise.

### Constraints
- 1 ≤ Q ≤ 10⁵  
- 0 ≤ queries[i][0] ≤ 1  
- 1 ≤ queries[i][1] ≤ 10⁴

### Sample Input
```
5
0 1
1 1
1 1
0 2
1 2
```

### Sample Output
```
1
0
1
```

## Solution (Java)
```java
int[] solve(int Q, int[][] queries) {
    Set<Integer> seen = new HashSet<>();
    List<Integer> res = new ArrayList<>();

    for (int[] q : queries) {
        int x = q[0], val = q[1];
        if (x == 0) {
            seen.add(val);
        } else {
            if (seen.contains(val)) {
                res.add(1);
                seen.remove(val);
            } else {
                res.add(0);
            }
        }
    }

    return res.stream().mapToInt(i -> i).toArray();
}
```
