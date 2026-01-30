# Maximum Weighted Sum with At-Most-One Adjacent Swap per Element

## 🧩 Problem Statement

You are given an array `arr` of `n` integers (0-based indexed).

You are allowed to perform the following operation **any number of times**:

- Choose an index `i` (0 ≤ i < n − 1)
- Swap `arr[i]` with `arr[i + 1]`

### ⚠️ Constraint on Swaps
- **Each element can be swapped at most once**
- Hence, swaps must be **non-overlapping adjacent swaps**

---

## 🎯 Objective

Maximize the value of the following expression:

\[
\sum_{i=0}^{n-1} arr[i] \times (i + 1)
\]

---

## 📌 Constraints

- `1 ≤ n ≤ 2 × 10^5`
- `-10^9 ≤ arr[i] ≤ 10^9`
- Time complexity must be **O(n)**

---

## 🧠 Key Insight

A swap at index `i` is beneficial only if:

```
arr[i] > arr[i+1]
```

Gain from swap = `arr[i] - arr[i+1]`

---

## 🧪 Test Cases

### Test Case 1
```
Input:  [5, 3, 4]
Output: 25
```

### Test Case 2
```
Input:  [1, 2, 3, 4]
Output: 30
```

### Test Case 3
```
Input:  [4, 3, 2, 1]
Output: 22


```
### Test Case 3
```
Input:  [1,9,7,3,4]
Output: 74
---

## ✅ CPP Solution

```cpp
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

long long maxStrength(vector<int> arr){
        int n = arr.size();

        int i = 0;

        while(i < n - 1){
            if(arr[i] > arr[i+1]){
                // swap karna hai 
                swap(arr[i],arr[i+1]);
                i += 2;
            }else{
                i++;
            }
        }

        long long ans = 0;
        for(i = 0 ; i < n ; i++){
            ans +=  1LL * arr[i] * (i+1);
        }

        return ans;
}
int main()
{
    vector<int> arr = {(int)1e9, -(int)1e9};
    cout << maxStrength(arr);

}
```

---

## ⏱️ Complexity Analysis

- Time: **O(n)**
- Space: **O(1)**

---
