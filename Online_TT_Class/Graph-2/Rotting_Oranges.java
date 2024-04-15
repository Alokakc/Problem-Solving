import java.util.*;

class Pair<T, U> {
    public final T first;
    public final U second;
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}
public class Rotting_Oranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair<Pair<Integer, Integer>, Integer>> q = new LinkedList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right
        int cntOne = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair<>(new Pair<>(i, j), 0));
                }
                if(grid[i][j] == 1) cntOne++;
            }
        }

        int time = 0, one = 0;
        while(!q.isEmpty()) {
            Pair<Pair<Integer, Integer> , Integer> p = q.remove();
            int r = p.first.first;
            int c = p.first.second;
            int t = p.second;
            time = Math.max(time, t);
            for (int[] direction : directions) {
                int nr = r + direction[0];
                int nc = c + direction[1];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1 && !vis[nr][nc]) {
                    one++;
                    vis[nr][nc] = true;
                    q.add(new Pair<>(new Pair<>(nr, nc), t+1));
                }
            }
        }
        if(cntOne != one) return -1;
        return time;
    }
}
