import java.util.*;

public class Number_of_Provinces {
    public void dfs(int city, List<List<Integer>> adj, int[] vis) {
        vis[city] = 1;
        for(Integer it: adj.get(city)) {
            if(vis[it] == 0) dfs(it, adj, vis);
        }
    }
    public int findCircleNum(int[][] c) {
        int n = c.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i != j) {
                    if(c[i][j] == 1) {
                        adj.get(i+1).add(j+1);
                    }
                } 
            }
        }
        int ans = 0;
        int[] vis = new int[n+1];
        for(int i=1; i<=n; i++) {
            if(vis[i] == 0) {
                ans++;
                dfs(i, adj, vis);
            }
        }
        return ans;
    }
}
