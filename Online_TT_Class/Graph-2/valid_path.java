import java.util.*;
class Solution {
    int[][] direction = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public double dist(int i, int j, int x, int y) {
        return Math.sqrt((i-x)*(i-x) + (j-y)*(j-y));
    }
    public boolean dfs(int i, int j, int x, int y, boolean[][] vis, boolean[][] cantReach) {
        if(i==x && j==y) return true;
        vis[i][j] = true;
        for(int k=0; k<8; k++) {
            int r = i + direction[k][0];
            int c = j + direction[k][1];
            if(r>=0 && r<=x && c>=0 && c<=y && !vis[r][c] && !cantReach[r][c]) {
                if(dfs(r, c, x, y, vis, cantReach)) return true;
            }
        }
        return false;
    }
    public String solve(int x, int y, int n, int r, ArrayList<Integer> E, ArrayList<Integer> F) {
        double R = r;
        boolean[][] cantReach = new boolean[x+1][y+1];
        boolean[][] vis = new boolean[x+1][y+1];
        for(int i=0; i<=x; i++) {
            for(int j=0; j<=y; j++) {
                for(int k=0; k<n; k++) {
                    int x1 = E.get(k);
                    int y1 = F.get(k);
                    double distance = dist(i, j, x1, y1);
                    if(distance<=R) {
                        cantReach[i][j] = true;
                        break;
                    }
                }
            }
        }
        boolean ans = dfs(0, 0, x, y, vis, cantReach);
        return ans ? "YES" : "NO";
    }
}
