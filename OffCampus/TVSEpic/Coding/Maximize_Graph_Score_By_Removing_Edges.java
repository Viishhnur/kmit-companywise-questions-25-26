
/*
# 🚀 Maximize Graph Score by Removing Edges

## 🧩 Problem Statement

You are given an **undirected** graph with `N` nodes (numbered from `0` to `N-1`) and `M` edges. Additionally, you are given an integer `K`, 
which specifies the exact number of **edges that must be removed** from the graph.

The **"score"** of the graph is calculated as:

> For each node `i` (0 ≤ i < N), count the number of **other nodes** that can be reached from node `i` via any path in the graph.  
> The **total score** is the sum of these reachable counts for **all nodes**.

Your task is to **choose exactly K edges** to remove from the graph such that the **total score** is **maximized**.

---

## 📥 Input Format

- The first line contains three space-separated integers: `N`, `M`, and `K`
    - `N`: Number of nodes (0 to N-1)
    - `M`: Number of edges
    - `K`: Number of edges to remove
- The next `M` lines each contain two integers `u` and `v` representing an undirected edge between `u` and `v`.

---

## 📤 Output Format

- Print a single integer — the **maximum score** possible after removing exactly `K` edges.

## 🔎 Sample Input

4 2 2
0 1
1 2


###  Sample Output
0


Sample Test Case-2:

Input:
12 11 3
0 1
1 2
2 3
3 4
4 2
5 6
6 7
7 8
8 6
9 10
10 11

Output:
34

## 📊 Constraints
1 <= N <= 10^3
1 <= M <= min(10^3, N*(N-1)/2)
0 <= K <= M
0 <= u, v < N

 */
import java.util.*;

class DisjointSet {
    private final int n;
    private final int[] parent;
    private final int[] size;
    private int cycleCount;

    private void init() {
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    public DisjointSet(int n) {
        this.n = n;
        this.parent = new int[n];
        this.size = new int[n];
        this.cycleCount = 0;
        init();
    }

    public int findUParent(int node) {
        if (node == parent[node]) {
            return node;
        }

        return parent[node] = findUParent(parent[node]);
    }

    public void unionBySize(int u, int v) {
        int pu = findUParent(u);
        int pv = findUParent(v);

        if (pu == pv) {
            cycleCount++;
            return;
        }

        if (size[pu] <= size[pv]) {
            // attach smaller component to larger component
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }

    public int getCycleCount() {
        return cycleCount;
    }

    public int componentsScore() {

        // This calculcates aggregate component score for entire DSU
        int score = 0;
        for (int node = 0; node < n; node++) {
            int boss = findUParent(node);
            if (boss == node) {
                // get the component score bro
                score += size[boss] * (size[boss] - 1); // (number of reachable pairs)
            }
        }
        return score;
    }

    public int[] getSizeArray() {
        return size;
    }

}

public class Maximize_Graph_Score_By_Removing_Edges {
    private static int maxScore;

    private static void dfs(int idx, int removed, int k, int n, int[][] edges, List<Integer> toRemove) {
        if (removed == k) {
            DisjointSet dsu = new DisjointSet(n);
            Set<Integer> removedSet = new HashSet<>(toRemove);
            for (int i = 0; i < edges.length; i++) {
                if (!removedSet.contains(i)) {
                    // If not removed then add this edge to DSU
                    dsu.unionBySize(edges[i][0], edges[i][1]);
                }
            }
            maxScore = Math.max(maxScore, dsu.componentsScore());
            return;
        }

        if (idx >= edges.length)
            return;

        // Try removing this edge
        toRemove.add(idx);
        dfs(idx + 1, removed + 1, k, n, edges, toRemove);
        toRemove.remove(toRemove.size() - 1);

        // Or don't remove
        dfs(idx + 1, removed, k, n, edges, toRemove);
    }

    // May be i thought this would help not sure if this greedy approach works
    // private static int getMaxScoreAfterKRemovals(int n, int m, int k, int[][] edges) {
    //     // Create a DSU
    //     DisjointSet dsu = new DisjointSet(n);

    //     for (int[] edge : edges) {
    //         int u = edge[0];
    //         int v = edge[1];

    //         dsu.unionBySize(u, v);
    //     }

    //     // now get number of cycles and remaining value of k
    //     k -= dsu.getCycleCount();

    //     if (k == 0) {
    //         return dsu.componentsScore(); // all components can be included as it is
    //     }

    //     // Otherwise sort the sizes array and reduce
    //     List<Integer> sizesSorted = Arrays.stream(dsu.getSizeArray())
    //                                         .filter(x -> x != 1)
    //                                         .boxed()
    //                                         .collect(Collectors.toList());
        
    //     for(int i = 0 ; i < sizesSorted.size() ; i++){

    //         if(k <= 0) break;
    //         int val = sizesSorted.get(i);
    //         if (val - 1 <= k) {
    //             sizesSorted.set(i, 0);
    //             k -= (val - 1);
    //         }


    //     }

    //     int maxi = 0;

    //     for(int i = 0 ; i < sizesSorted.size() ; i++){
    //         int s = sizesSorted.get(i);
    //         if(s == 0) continue;
    //         maxi += s * (s - 1);
    //     }

    //     return maxi;

    // }

    public static void main(String[] args) {
        int n, m, k;
        int[][] edges;
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
            m = sc.nextInt();
            k = sc.nextInt();

            edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

        }

        maxScore = 0;
        dfs(0, 0, k, n, edges, new ArrayList<>());
        System.out.println(maxScore);

        // Approach-ii)
        // System.out.println(getMaxScoreAfterKRemovals(n,m,k,edges));

    }
}
