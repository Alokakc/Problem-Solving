import java.util.*;
class Solution {
    public boolean canFinish(int nc, int[][] p) {
        int n = p.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<nc; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++) {
            adj.get(p[i][0]).add(p[i][1]);
        }
        int[] in = new int[nc];
        for(int i=0; i<nc; i++) {
            for(int x: adj.get(i)) in[x]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<nc; i++) if(in[i]==0) q.add(i);
        int ans = 0;
        while(!q.isEmpty()) {
            int node = q.remove();
            ans++;
            for(int x: adj.get(node)) {
                in[x]--;
                if(in[x]==0) q.add(x);
            }
        }
        return ans < nc ? false : true;
    }
}