# Inncircles Coding Problems

---

## 1. Extract Hashtag Words

**Problem Statement:**

You are given a string. Your task is to return **all words** from the string that:

- Start with the character `#`
- Contain **only lowercase English alphabets** (a-z)
- Have **more than 3 alphabet characters** (excluding the `#`)

A valid word must look like this: `#example`, where `example` is lowercase and its length is **at least 4**.

**Example Input:**
```
I love #cats and #dogs but #h also #elephant is cute
```

**Example Output:**
```
["#cats", "#dogs", "#elephant"]
```

---

## 2. Maximum Subarray Sum of Size K

**Problem Statement:**

Given an array of integers and an integer `K`, return the **maximum sum** of any **contiguous subarray** of length `K`.

You must use the **sliding window** technique to ensure linear time complexity.

**Example Input:**
```python
arr = [1, 4, 2, 10, 23, 3, 1, 0, 20]
k = 4
```

**Example Output:**
```
39
```

**Explanation:**  
The subarray `[4, 2, 10, 23]` has the maximum sum = 39.

---

## 3. Extract Words by Format

**Problem Statement:**

You are given a string that may contain words in the following three formats:

- **Alpha Format:**  
  Pattern: `EX-[0-9]{3}-[A-Z]{2}`  
  Example: `EX-123-AB`

- **Beta Format:**  
  Pattern: `[0-9]{3}-[a-z]{3}-[0-9]{2}`  
  Example: `123-abc-45`

- **Gamma Format:**  
  Pattern: `#G:[a-zA-Z]{6}`  
  Example: `#G:abCDef`

Return all substrings in the string that match **any** of the above formats.

**Example Input:**
```
The codes are EX-123-AB and 456-def-99 and #G:xyzABC. Another one is #G:12abCD and EX-789-XY.
```

**Example Output:**
```
["EX-123-AB", "456-def-99", "#G:xyzABC", "EX-789-XY"]
```

---

## 4. Operation Frequency Counter

**Problem Statement:**

You are given a list (or space-separated string) of **sequential operations** such as `load`, `sleep`, etc.  
For each operation, you must print how many times **that particular operation has occurred** up to that point.

**Example Input:**
```
load sleep load
```

**Example Output:**
```
1 1 2
```

**Explanation:**  
- First `load` → count becomes 1  
- Then `sleep` → count becomes 1  
- Then another `load` → count becomes 2