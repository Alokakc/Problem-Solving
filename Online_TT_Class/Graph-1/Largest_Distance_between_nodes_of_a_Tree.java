import java.util.*;

public class Largest_Distance_between_nodes_of_a_Tree {
    int res = 0;
    public int maxDistance(List<List<Integer>> adj, boolean[] vis, int node) {
        vis[node] = true;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Integer nb: adj.get(node)) {
            if(!vis[nb]) {
                int temp = 1+maxDistance(adj, vis, nb);
                pq.add(temp);
                if(pq.size()>2) pq.remove();
            } 
        }
        int a = 0, b = 0;
        if(!pq.isEmpty()) a = pq.remove();
        if(!pq.isEmpty()) b = pq.remove();
        res = Math.max(res, a+b);
        return Math.max(a, b);
    }
    
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int i=0; i<n; i++) {
            if(A.get(i) == -1) continue;
            adj.get(i).add(A.get(i));
            adj.get(A.get(i)).add(i);
        }
        boolean[] vis = new boolean[n];
        maxDistance(adj, vis, 0);
        return res;
    }
}
