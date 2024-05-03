import java.util.*;

class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            int[] dis = new int[n];
            Arrays.fill(dis, (int)1e9);
            int[] par = new int[n];
            Arrays.fill(par, -1);
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            dis[i] = 0;
            while(!q.isEmpty()) {
                int curr = q.remove();
                for(int nb: adj.get(curr)) {
                    if(dis[nb] == (int)1e9) {
                        dis[nb] = dis[curr] + 1;
                        par[nb] = curr;
                        q.add(nb);
                    }
                    else if(par[curr] != nb) {
                        ans = Math.min(ans, dis[nb]+dis[curr]+1);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}