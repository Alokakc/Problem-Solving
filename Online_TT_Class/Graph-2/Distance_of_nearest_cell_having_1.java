import java.util.*;

class Pair<T, U> {
    public final T first;
    public final U second;
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}
public class Distance_of_nearest_cell_having_1
{
    public void BFS(int[][] grid, int n, int m, boolean[][] vis) {
        Queue<Pair<Pair<Integer, Integer>, Integer>> q = new LinkedList<>();
        int[] x = {0, 0, -1, 1};
        int[] y = {-1, 1, 0, 0};
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {
                    q.add(new Pair<>(new Pair<>(i, j), 0));
                    vis[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()) {
            Pair<Pair<Integer, Integer>, Integer> p = q.remove();
            int i = p.first.first;
            int j = p.first.second;
            int dis = p.second;
            grid[i][j] = dis;
            for (int k=0; k<4; k++) {
                int nr = i + x[k];
                int nc = j + y[k];
                if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.add(new Pair<>(new Pair<>(nr, nc), dis+1));
                }
            }
        }
    }
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] Dgrid = grid;
        BFS(Dgrid, n, m, vis);
        return Dgrid;
    }
}

