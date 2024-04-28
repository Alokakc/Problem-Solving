import java.util.*;

class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int len = edge[2];
            adj.get(u).add(new int[]{v, len});
            adj.get(v).add(new int[]{u, len});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0});
        int[] res = new int[n];
        Arrays.fill(res, -1);
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];
            if (res[node] != -1) continue;
            res[node] = time;
            for (int[] ng : adj.get(node)) {
                int nextNode = ng[0];
                int et = ng[1];
                int nt = time + et;
                if (nt < disappear[nextNode]) {
                    pq.offer(new int[]{nextNode, nt});
                }
            }
        }
        
        return res;
    }
}