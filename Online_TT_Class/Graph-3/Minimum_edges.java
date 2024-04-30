import java.util.*;

class Pair {
    int first;
    int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public static int minimumEdgeReversal(int[][] edges, int n, int m, int src, int dst) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(new Pair(v, 0));
            adj.get(v).add(new Pair(u, 1));
        }
        int[] dis = new int[n+1];
        Arrays.fill(dis, (int)(1e9));
        Deque<Pair> deque = new ArrayDeque<>();
        deque.addFirst(new Pair(src, 0));
        dis[src] = 0;
        while(!deque.isEmpty()) {
            Pair p = deque.removeFirst();
            int node = p.first;
            for(int i=0; i<adj.get(node).size(); i++) {
                Pair np = adj.get(node).get(i);
                int adjNode = np.first;
                int adjCost = np.second;
                if(dis[node] + adjCost < dis[adjNode]) {
                    dis[adjNode] = dis[node] + adjCost;
                    if(adjCost == 0) deque.addFirst(new Pair(adjNode, 0));
                    else deque.addLast(new Pair(adjNode, 1));
                }
            }
        }
        return dis[dst] == (int)(1e9) ? -1 : dis[dst];
    }
}