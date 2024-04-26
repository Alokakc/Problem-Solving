class Solution {
    public boolean dfs(int node, int set, int[] vis, int[][] adj) {
        vis[node] = set;
        for(int x: adj[node]) {
            if(vis[x] == 0) {
                if(!dfs(x, 1-set, vis, adj)) return false;
            }
            else {
                if(set == vis[x]) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        for(int i=0; i<n; i++) {
            if(vis[i]==0) {
                if(!dfs(i, 0, vis, graph)) return false;
            }
        }
        return true;
    }
}