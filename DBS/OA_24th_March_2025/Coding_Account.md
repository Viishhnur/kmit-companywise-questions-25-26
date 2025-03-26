# DBS OA Coding Question 1 - Account Information Filter

## Problem Statement

Find out the following information about accounts that you transact with through your digital wallet. Based on the user's input information, this information must be in increasing order of bank account numbers.

### Input Format

- The first line contains a single integer `N`, denoting the number of saved accounts.
- Each of the next `N` lines contains 5 strings denoting saved account information:
  1. `account_number`
  2. `account_holder_first_name`
  3. `account_holder_last_name`
  4. `registered_mobile_number`
  5. `branch_code`
- The next line contains a string `D` denoting the name of the information the user has.
- The last line contains a string `V` denoting the value of the user's information.

### Output Format

Print all the information of the accounts in increasing order of `account_number` where the given field `D` has the value `V`.

### Constraints

- 1 ≤ N ≤ 1000  
- 1 ≤ A[i][j] ≤ 15  
- All fields contain only lowercase letters and numbers.

### Sample Input
```
3
1122199312 rohan garg 7384728384 1022
11221909566 shivam kumar 9128494856 1022
1122139321 shivam sharma 7384728384 1022
account_holder_first_name
shivam
```

### Sample Output
```
1122139321 shivam sharma 7384728384 1022
11221909566 shivam kumar 9128494856 1022
```

## Solution (Java)
```java
String[][] solve(int N, String[][] accounts, String D, String V) {
    Map<String, Integer> fieldMap = Map.of(
        "account_number", 0,
        "account_holder_first_name", 1,
        "account_holder_last_name", 2,
        "registered_mobile_number", 3,
        "branch_code", 4
    );

    int idx = fieldMap.get(D);
    int cnt = 0;

    for (String[] account : accounts) {
        if (account[idx].equals(V)) {
            cnt++;
        }
    }

    String[][] res = new String[cnt][5];
    int ind = 0;
    for (String[] account : accounts) {
        if (account[idx].equals(V)) {
            res[ind++] = account;
        }
    }

    Arrays.sort(res, Comparator.comparing(acc -> acc[0]));
    return res;
}
```
