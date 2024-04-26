import java.util.*;
class Solution {
    public void dfs(int node, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        for(int nb: adj.get(node)) {
            if(!vis[nb]) dfs(nb, vis, st, adj);
        }
        st.push(node);
    }
    public void dfs2(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        for(int nb: adj.get(node)) {
            if(!vis[nb]) dfs2(nb, vis, adj);
        }
    }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                dfs(i, vis, st, adj);
            }
        }
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        for(int i=0; i<V; i++) adj2.add(new ArrayList<>());
        for(int i=0; i<adj.size(); i++) {
            ArrayList<Integer> list = adj.get(i);
            for(int x: list) {
                adj2.get(x).add(i);
            }
        }
        int ans = 0;
        Arrays.fill(vis, false);
        while(!st.isEmpty()) {
            int node = st.pop();
            if(!vis[node]) {
                ans++;
                dfs2(node, vis, adj2);
            }
        }
        return ans;
    }
}
