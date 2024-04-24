import java.util.*;

class Solution {
    public void bfs(int node, List<List<Integer>> adj, int n, List<List<Integer>> ans) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(node);
        vis[node] = true;
        while(!q.isEmpty()) {
            int nb = q.remove();
            for(int x: adj.get(nb)) {
                if(!vis[x]) {
                    ans.get(x).add(node);
                    vis[x] = true;
                    q.add(x);
                }
            }
        }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
            ans.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++) adj.get(edges[i][0]).add(edges[i][1]);
        for(int i=0; i<n; i++) {
            bfs(i, adj, n, ans);
        }
        for(List<Integer> x: ans) Collections.sort(x);
        return ans;
    }
}
