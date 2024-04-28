import java.util.*;

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        if (p1.second != p2.second) {
            return Integer.compare(p1.second, p2.second); 
        } else {
            return Integer.compare(p1.first, p2.first); 
        }
    }
}

class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int t = times[i][2];
            adj.get(u).add(new Pair(v, t));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        int[] ans = new int[n+1];
        Arrays.fill(ans, (int)(1e9));
        ans[k] = 0;
        pq.add(new Pair(k, 0));
        while(!pq.isEmpty()) {
            Pair pt = pq.remove();
            int node = pt.first;
            int time = pt.second;
            for(int i=0; i<adj.get(node).size(); i++) {
                int itnode = adj.get(node).get(i).first;
                int ittime = adj.get(node).get(i).second;
                if(time+ittime < ans[itnode]) {
                    ans[itnode] = time+ittime;
                    pq.add(new Pair(itnode, ans[itnode]));
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i=1; i<ans.length; i++) {
            if(ans[i] == (int)(1e9)) return -1;
            res = Math.max(res, ans[i]);
        }
        return res;
    }
}

