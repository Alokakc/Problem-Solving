import java.util.*;
public class Find_if_Path_Exists_in_Graph {
    public boolean vPath(List<List<Integer>> adj, boolean[] vis, int s, int d) {
        if(s == d) return true;
        vis[s] = true;
        for(Integer nb: adj.get(s)) {
            if(!vis[nb]) {
                if(vPath(adj, vis, nb, d)) return true;
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int s, int d) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] vis = new boolean[n];
        return vPath(adj, vis, s, d);
    }
}