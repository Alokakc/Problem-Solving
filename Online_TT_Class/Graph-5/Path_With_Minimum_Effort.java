import java.util.*;

class Tuple {
    int effort;
    int row;
    int col;
    Tuple(int effort, int row, int col) {
        this.effort = effort;
        this.row = row;
        this.col = col;
    }
}

class PairComparator implements Comparator<Tuple> {
    @Override
    public int compare(Tuple p1, Tuple p2) {
        return Integer.compare(p1.effort, p2.effort); 
    }
}

class Solution {
    public int minimumEffortPath(int[][] h) {
        int n = h.length;
        int m = h[0].length;
        if(n==1 && m==1) return 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>(new PairComparator());
        int[][] dir = {{0,1}, {0,-1}, {-1,0}, {1,0}};
        boolean[][] vis = new boolean[n][m];
        vis[0][0] = true;
        if(n>1) {
            pq.add(new Tuple(Math.abs(h[0][0]-h[1][0]), 1, 0));
            vis[1][0] = true;
        }
        if(m>1) {
            pq.add(new Tuple(Math.abs(h[0][0]-h[0][1]), 0, 1));
            vis[0][1] = true;
        }
        while(!pq.isEmpty()) {
            Tuple t = pq.remove();
            int effort = t.effort;
            int row = t.row;
            int col = t.col;
            vis[row][col] = true;
            System.out.println(effort+" "+row+" "+col);
            if(row == n-1 && col == m-1) {
                return effort;
            }
            for(int i=0; i<4; i++) {
                int nr = row + dir[i][0];
                int nc = col + dir[i][1];
                if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc]) {
                    int eff = Math.max(effort, Math.abs(h[row][col]-h[nr][nc]));
                    pq.add(new Tuple(eff, nr, nc));
                }
            }
        }
        return 0;
    }
}