import java.util.*;
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] in = new int[V];
        for(int i=0; i<V; i++) {
            for(int x: adj.get(i)) in[x]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++) if(in[i]==0) q.add(i);
        int ans = 0;
        while(!q.isEmpty()) {
            int node = q.remove();
            ans++;
            for(int x: adj.get(node)) {
                in[x]--;
                if(in[x]==0) q.add(x);
            }
        }
        return ans < V ? true : false;
    }
}