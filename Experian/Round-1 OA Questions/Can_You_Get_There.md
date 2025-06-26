# Can You Get There?

## Problem Statement

You are given a 2D grid of size `N x M` where each cell contains a directional instruction:

* `'R'`: move right
* `'L'`: move left
* `'U'`: move up
* `'D'`: move down
* `'*'`: winning spot (goal cell)

You start at the top-left cell (position `(1, 1)` in 1-based indexing) and follow the instructions one step at a time.

You are allowed to **change at most `K` instructions** anywhere in the grid. Your goal is to determine the **minimum number of changes** required to reach the `'*'` cell. If it is **impossible**, return `-1`.

---

## Input Format

* The first line contains an integer `N`, denoting the number of rows.
* The second line contains an integer `M`, denoting the number of columns.
* The third line contains an integer `K`, denoting the limit for the allowed changes.
* The next `N` lines contain a string of length `M`, describing the `N` rows of the grid.

---

## Constraints

* `1 <= N <= 50`
* `1 <= M <= 50`
* `0 <= K <= 1000`
* `1 <= len(S[i]) <= 10^5`

---

## Sample Test Cases

### Test Case 1

**Input:**

```
2
2
2
RD
D*
```

**Output:**

```
0
```

**Explanation:**
You can reach the winning spot at (2,2) by following the current directions. No changes needed.

---

### Test Case 2

**Input:**

```
2
2
0
RR
R*
```

**Output:**

```
-1
```

**Explanation:**
At time 0, you are at (1,1). All instructions lead right. You can never reach (2,2) and you are not allowed to make any changes.

---

### Test Case 3

**Input:**

```
2
2
0
*L
LL
```

**Output:**

```
0
```

**Explanation:**
You start on the goal cell (1,1), so you don't need to move or change anything.

---

## Objective

Return the **minimum number of changes required** to reach the winning spot. If it’s not possible even after `K` changes, return `-1`.
