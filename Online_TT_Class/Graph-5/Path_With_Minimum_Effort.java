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
    public static int MinimumEffort(int n, int m, int[][] h) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>(new PairComparator());
        int[][] dir = {{0,1}, {0,-1}, {-1,0}, {1,0}};
        int[][] dis = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(dis[i], (int)(1e9));
        pq.add(new Tuple(0, 0, 0));
        dis[0][0] = 0;
        while(!pq.isEmpty()) {
            Tuple t = pq.remove();
            int effort = t.effort;
            int row = t.row;
            int col = t.col;
            if(row == n-1 && col == m-1) return effort;
            for(int i=0; i<4; i++) {
                int nr = row + dir[i][0];
                int nc = col + dir[i][1];
                if(nr>=0 && nr<n && nc>=0 && nc<m) {
                    int newEff = Math.max(Math.abs(h[row][col]-h[nr][nc]), effort);
                    if(newEff < dis[nr][nc]) {
                        dis[nr][nc] = newEff;
                        pq.add(new Tuple(dis[nr][nc], nr, nc));
                    }
                }
            }
        }
        return 0;
    }
}
