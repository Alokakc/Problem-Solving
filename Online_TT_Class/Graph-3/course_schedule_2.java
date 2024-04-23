import java.util.*;
class Solution {
    public int[] findOrder(int nc, int[][] p) {
        int n = p.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<nc; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++) {
            adj.get(p[i][1]).add(p[i][0]);
        }
        int[] in = new int[nc];
        for(int i=0; i<nc; i++) {
            for(int x: adj.get(i)) in[x]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<nc; i++) if(in[i]==0) q.add(i);
        int k=0;
        int[] res = new int[nc];
        while(!q.isEmpty()) {
            int node = q.remove();
            res[k++] = node;
            for(int x: adj.get(node)) {
                in[x]--;
                if(in[x]==0) q.add(x);
            }
        }
        return k < nc ? new int[]{} : res;
    }
}