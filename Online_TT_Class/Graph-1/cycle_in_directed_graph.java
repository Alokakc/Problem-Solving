import java.util.ArrayList;
class cycle_in_directed_graph {
    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;
        for(int nb: adj.get(node)) {
            if(!vis[nb]) {
                if(dfs(nb, adj, vis, pathVis)) return true;
            }
            else {
                if(pathVis[nb]) return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                if(dfs(i, adj, vis, pathVis)) return true;
            }
        }
        return false;
    }
}
