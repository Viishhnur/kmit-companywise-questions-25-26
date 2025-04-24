/*
Question 1: Server Connection

A company has a network of servers represented as a tree (undirected graph with no cycles). Each server is a node. You are given:
- `server_nodes`: Total number of servers (nodes)
- `server_from[]`: List of edges (from nodes)
- `server_to[]`: List of edges (to nodes)
- `server_weight[]`: List of edge weights between connected servers
- `signal_speed`: A signal can travel a path if the total weight of that path is divisible by signal_speed

For each server `i`, calculate how many other servers it can communicate with 
(i.e., for every other server `j`, if the distance from i to j is divisible by `signal_speed`, it's valid).


Sample Input-1:-

server_nodes = 4
edges = 3
server_from = [1, 1, 2]
server_to =   [2, 3, 4]
server_weight = [2, 5, 3]
signal_speed = 5


Sample Output-1:-
[2, 0, 2, 2]

Sample Input-2:-

server_nodes = 4
edges = 3
server_from = [1, 2, 3]
server_to =   [2, 3, 4]
server_weight = [2, 2, 2]
signal_speed = 2


Sample Output-2:-
[6, 6, 6, 6]
Each server can communicate with 3 others where the path weight is divisible by 2. so 3*(3-1) => 6
 */
import java.util.*;

class Graph {
    private final int nodes;
    private final int edges_cnt;
    private final List<List<int[]>> adjLst;

    public Graph(int n, int edges) {
        this.nodes = n;
        this.edges_cnt = edges;
        this.adjLst = new ArrayList<>();
    }

    public void buildAdjList(List<Integer> server_from, List<Integer> server_to, List<Integer> server_weight) {

        for (int i = 0; i <= nodes; i++) {
            adjLst.add(new ArrayList<>());
        }

        for (int i = 0; i < edges_cnt; i++) { // in this edges_cnt is n - 1 since complete graph
            int u = server_from.get(i);
            int v = server_to.get(i);
            int wt = server_weight.get(i);

            adjLst.get(u).add(new int[] { v, wt });
            adjLst.get(v).add(new int[] { u, wt });

        }

    }

    private int bfs(int start, int signal_speed) {
        boolean[] visited = new boolean[nodes + 1];
        Queue<int[]> qu = new LinkedList<>();

        // initally push {start,0} -> (node,dist from j)

        qu.offer(new int[] { start, 0 });
        visited[start] = true;

        int reachableCnt = 0;

        while (!qu.isEmpty()) {
            int[] curr = qu.poll();
            int curr_node = curr[0];
            int dist_from_start = curr[1];

            // check if this can be included in our answer
            if (curr_node != start && dist_from_start % signal_speed == 0) {
                reachableCnt++;
            }

            // go to nbrs and add them into queue if un visited
            for (int[] nbrs : adjLst.get(curr_node)) {
                int nbr = nbrs[0];
                int d = nbrs[1];

                if (!visited[nbr]) {
                    visited[nbr] = true;
                    qu.offer(new int[] { nbr, d + dist_from_start });
                }
            }
        }
        // ordered pairs among reachableCount nodes: r * (r - 1)
        return reachableCnt * (reachableCnt - 1); // rC2 is number of pairs (j,k)

    }

    public List<Integer> getServerPairs(int signalSpeed) {
        List<Integer> res = new ArrayList<>();

        // May be BFS helps me out , if i am able to calulclate distance of every node
        // from every other node
        for (int node = 1; node <= nodes; node++) {
            // start a BFS
            res.add(bfs(node, signalSpeed));
        }

        return res;
    }

}

public class ServerConnections {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int nodes = sc.nextInt();
            int edges = sc.nextInt(); // should be nodes - 1

            // sc.nextLine();
            List<Integer> from = new ArrayList<>();
            for (int i = 0; i < edges; i++) {
                from.add(sc.nextInt());

            }

            List<Integer> to = new ArrayList<>();
            for (int i = 0; i < edges; i++) {
                to.add(sc.nextInt());

            }

            List<Integer> wt = new ArrayList<>();
            for (int i = 0; i < edges; i++) {
                wt.add(sc.nextInt());

            }

            int signal_speed = sc.nextInt();

            // Now create the graph and build the adjLst
            Graph g = new Graph(nodes, edges);
            g.buildAdjList(from, to, wt);

            System.out.println(g.getServerPairs(signal_speed));
        }
    }
}
