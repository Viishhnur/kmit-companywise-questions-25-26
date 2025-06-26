
/*
# Can You Get There?

## Problem Statement

You are given a 2D grid of size `N x M` where each cell contains a directional instruction:

* `'R'`: move right
* `'L'`: move left
* `'U'`: move up
* `'D'`: move down
* `'*'`: winning spot (goal cell)

You start at the top-left cell (position `(1, 1)` in 1-based indexing) and follow the instructions one step at a time.

You are allowed to **change at most `K` instructions** anywhere in the grid. Your goal is to determine the **minimum number of changes** required to 
reach the `'*'` cell. If it is **impossible**, return `-1`.

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

 */
import java.util.*;

public class Can_You_Reach_There {

    static class State {
        int x, y, time, changes;

        State(int x, int y, int time, int changes) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.changes = changes;
        }
    }

    static final int[] dx = {0, 0, -1, 1}; // R, L, U, D
    static final int[] dy = {1, -1, 0, 0};
    static final char[] dir = {'R', 'L', 'U', 'D'};

    public static int minChanges(char[][] grid, int n, int m, int k) {
        Queue<State> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][k + 1];

        q.offer(new State(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            State curr = q.poll();
            int x = curr.x, y = curr.y;

            if (grid[x][y] == '*') return curr.changes;
            if (curr.changes > k) continue;

            // Try all 4 directions
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                int newChanges = curr.changes + (grid[x][y] != dir[d] ? 1 : 0);

                if (newChanges <= k && !visited[nx][ny][newChanges]) {
                    visited[nx][ny][newChanges] = true;
                    q.offer(new State(nx, ny, curr.time + 1, newChanges));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n,m,k;
        char[][] grid;
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
            m = sc.nextInt();
            k = sc.nextInt();
            grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                grid[i] = sc.next().toCharArray();
            }
        }
        System.out.println(minChanges(grid, n, m, k));
    }
}

/*
import java.util.*;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[] dir = {'D', 'U', 'R', 'L'};

    public static int solve(int N, int M, int K, List<String> S) {
        int[][][] dist = new int[N][M][K + 1];
        for (int[][] layer : dist)
            for (int[] row : layer)
                Arrays.fill(row, Integer.MAX_VALUE);

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0, 0, 0}); // x, y, time, changes

        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int x = curr[0], y = curr[1], t = curr[2], c = curr[3];

            if (x < 0 || y < 0 || x >= N || y >= M) continue;
            if (S.get(x).charAt(y) == '*') return c;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                char ch = S.get(x).charAt(y);
                int nt = t + 1;
                int nc = ch == dir[d] ? c : c + 1;

                if (nt > K || dist[nx][ny][nt] <= nc) continue;
                dist[nx][ny][nt] = nc;

                if (ch == dir[d]) dq.addFirst(new int[]{nx, ny, nt, nc});
                else dq.addLast(new int[]{nx, ny, nt, nc});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = Integer.parseInt(scan.nextLine().trim());
        int M = Integer.parseInt(scan.nextLine().trim());
        int K = Integer.parseInt(scan.nextLine().trim());

        List<String> S = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            S.add(scan.nextLine().trim());
        }

        System.out.println(solve(N, M, K, S));
    }
}

 */