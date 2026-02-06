# Balanced Permutation Subarrays

## Problem Statement

You are given an array `A` of size `n` which is a **permutation** of integers from `1` to `n`.

A number `k` (where `1 ≤ k ≤ n`) is said to be **balanced** if there exists **at least one contiguous subarray** of `A` that contains **exactly the elements**:

{1, 2, 3, ..., k}

The order of elements inside the subarray does **not** matter, but:

- The subarray must be **contiguous**
- It must contain **all numbers from 1 to k**
- It must not contain any extra numbers

For each value of `k` from `1` to `n`, determine whether `k` is balanced.

Return a string of length `n` where:

- `'1'` at position `k` means `k` is balanced
- `'0'` at position `k` means `k` is not balanced

---

## Input Format

- An integer `n` — size of the array
- An array `A` of `n` distinct integers, which is a permutation of `1` to `n`

---

## Output Format

- A binary string of length `n`
- The `k`-th character represents whether `k` is balanced

---

## Constraints

- `1 ≤ n ≤ 2 × 10^5`
- `A` is a permutation of `{1, 2, 3, ..., n}`

---

## Example 1

### Input

n = 4
A = [4, 2, 3, 1]

### Explanation

| k   | Required Elements | Subarray Exists? | Balanced |
| --- | ----------------- | ---------------- | -------- |
| 1   | {1}               | [1]              | Yes      |
| 2   | {1,2}             | No               | No       |
| 3   | {1,2,3}           | [2,3,1]          | Yes      |
| 4   | {1,2,3,4}         | [4,2,3,1]        | Yes      |

### Output

1011

---

## Example 2

### Input

n = 5
A = [1, 2, 3, 4, 5]

### Explanation

Every prefix already contains `{1..k}` for all `k`.

### Output

11111

---

## Example 3

### Input

n = 5
A = [5, 1, 3, 2, 4]

### Output

---

## Notes

- The array is guaranteed to be a permutation.
- Order inside the subarray does not matter.
- Only **contiguous** subarrays are allowed.

---

## Key Insight (For Implementation)

For a given `k`, the numbers `{1..k}` form a valid subarray **if and only if** the distance between their minimum index and maximum index is exactly `k - 1`.

---

