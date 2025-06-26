# Five Friends

## Problem Statement

Alice, Bob, Carol, Daniel, and Emily are close friends. Each of them has multiple wallets containing different amounts of money.

The details are:

* **Alice** has `A` wallets, with the amount in each wallet given in array `arA`.
* **Bob** has `B` wallets, with the amount in each wallet given in array `arB`.
* **Carol** has `C` wallets, with the amount in each wallet given in array `arC`.
* **Daniel** has `D` wallets, with the amount in each wallet given in array `arD`.
* **Emily** has `E` wallets, with the amount in each wallet given in array `arE`.

All friends want to contribute to a pool by selecting exactly **one wallet each**. Your goal is to select one wallet per person such that the **inequality factor** is minimized.

## Inequality Factor

The inequality factor is defined as:

```
Inequality Factor = max(contributed_amounts) - min(contributed_amounts)
```

## Function Signature

```python
int fiveFriends(int A, int B, int C, int D, int E,
                int[] arA, int[] arB, int[] arC, int[] arD, int[] arE)
```

### Parameters

| Name | Type          | Description                         |
| ---- | ------------- | ----------------------------------- |
| A    | INTEGER       | Number of wallets Alice has         |
| B    | INTEGER       | Number of wallets Bob has           |
| C    | INTEGER       | Number of wallets Carol has         |
| D    | INTEGER       | Number of wallets Daniel has        |
| E    | INTEGER       | Number of wallets Emily has         |
| arA  | INTEGER ARRAY | Amounts in each of Alice's wallets  |
| arB  | INTEGER ARRAY | Amounts in each of Bob's wallets    |
| arC  | INTEGER ARRAY | Amounts in each of Carol's wallets  |
| arD  | INTEGER ARRAY | Amounts in each of Daniel's wallets |
| arE  | INTEGER ARRAY | Amounts in each of Emily's wallets  |

### Returns

* **INTEGER**: The minimum possible value of the inequality factor.

---

## Sample Test Cases

### Test Case 1

**Input:**

```
A = 1, B = 1, C = 1, D = 1, E = 2
arA = [2]
arB = [2]
arC = [3]
arD = [2]
arE = [100, 2]
```

**Output:**

```
98
```

**Explanation:**

* Selected values: \[2, 2, 3, 2, 100]
* Inequality factor = 100 - 2 = 98

### Test Case 2

**Input:**

```
A = 1, B = 2, C = 1, D = 4, E = 3
arA = [4]
arB = [1, 3]
arC = [3]
arD = [2, 2, 1, 2]
arE = [1, 2, 3]
```

**Output:**

```
3
```

**Explanation:**

* Selected values: \[4, 1, 3, 2, 1]
* Inequality factor = 4 - 1 = 3

### Test Case 3

**Input:**

```
A = 1, B = 2, C = 1, D = 2, E = 2
arA = [2]
arB = [2, 3]
arC = [3]
arD = [2, 2]
arE = [1, 4]
```

**Output:**

```
2
```

**Explanation:**

* Selected values: [2, 2, 3, 2, 1]
* Inequality factor = 3 - 1 = 2

```java
import java.util.*;

public class FiveFriends {

    static class Wallet {
        int value;     // Money in the wallet
        int index;     // Index in the array
        int listIndex; // Which friend's list: 0 = A, ..., 4 = E

        Wallet(int value, int index, int listIndex) {
            this.value = value;
            this.index = index;
            this.listIndex = listIndex;
        }
    }

    public static int fiveFriends(int A, int B, int C, int D, int E,
                                  int[] arA, int[] arB, int[] arC, int[] arD, int[] arE) {

        // Put all arrays into a list of arrays
        List<int[]> lists = List.of(arA, arB, arC, arD, arE);

        // Sort each list
        for (int[] arr : lists) Arrays.sort(arr);

        // Min-heap to hold one wallet from each list
        PriorityQueue<Wallet> minHeap = new PriorityQueue<>(Comparator.comparingInt(w -> w.value));

        int maxValue = Integer.MIN_VALUE;
        // Initialize: add the first wallet from each friend
        for (int i = 0; i < 5; i++) {
            int val = lists.get(i)[0];
            minHeap.offer(new Wallet(val, 0, i));
            maxValue = Math.max(maxValue, val);
        }

        int minRange = Integer.MAX_VALUE;

        while (true) {
            Wallet minWallet = minHeap.poll(); // Wallet with the smallest value
            int minValue = minWallet.value;
            minRange = Math.min(minRange, maxValue - minValue);

            // Move to the next wallet in the same list
            int nextIndex = minWallet.index + 1;
            int listIdx = minWallet.listIndex;

            if (nextIndex >= lists.get(listIdx).length) break; // End of list reached

            int nextVal = lists.get(listIdx)[nextIndex];
            minHeap.offer(new Wallet(nextVal, nextIndex, listIdx));
            maxValue = Math.max(maxValue, nextVal); // Update max
        }

        return minRange;
    }

    public static void main(String[] args) {
        int A = 1, B = 2, C = 1, D = 2, E = 2;
        int[] arA = {2};
        int[] arB = {2, 3};
        int[] arC = {3};
        int[] arD = {2, 2};
        int[] arE = {1, 4};

        int result = fiveFriends(A, B, C, D, E, arA, arB, arC, arD, arE);
        System.out.println("Minimum Inequality Factor = " + result); // Output should be 2
    }
}
```