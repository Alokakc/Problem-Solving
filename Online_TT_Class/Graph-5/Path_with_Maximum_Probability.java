import java.util.*;

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        if (p1.second != p2.second) {
            return Double.compare(p2.second, p1.second); 
        } else {
            return Integer.compare(p2.first, p1.first); 
        }
    }
}

class Pair {
    int first;
    double second;
    public Pair(int first, double second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];
            adj.get(u).add(new Pair(v, p));
            adj.get(v).add(new Pair(u, p));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        double[] ans = new double[n];
        Arrays.fill(ans, Double.MIN_VALUE);
        pq.add(new Pair(start_node, 1.0));
        while(!pq.isEmpty()) {
            Pair pt = pq.remove();
            int node = pt.first;
            double sucProb = pt.second;
            for(int i=0; i<adj.get(node).size(); i++) {
                int itnode = adj.get(node).get(i).first;
                double itsucProb = adj.get(node).get(i).second;
                if(sucProb*itsucProb > ans[itnode]) {
                    ans[itnode] = sucProb*itsucProb;
                    pq.add(new Pair(itnode, ans[itnode]));
                }
            }
        }
        return ans[end_node];
    }
}