
class Surrounded_Regions {
    int[][] dir = {{0,-1}, {0,1}, {1,0}, {-1,0}};
    public void dfs(int i, int j, char[][] mat, int n, int m) {
        mat[i][j] = 'a';
        for(int k=0; k<4; k++) {
            int r = i + dir[k][0];
            int c = j + dir[k][1];
            if(r>=0 && r<n && c>=0 && c<m && mat[r][c]=='O') {
                dfs(r, c, mat, n, m);
            }
        }
    }
    public void solve(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        for(int i=0; i<m; i++) {
            if(mat[0][i] == 'O') dfs(0, i, mat, n, m);
            if(mat[n-1][i] == 'O') dfs(n-1, i, mat, n, m);
        }
        for(int i=0; i<n; i++) {
            if(mat[i][0] == 'O') dfs(i, 0, mat, n, m);
            if(mat[i][m-1] == 'O') dfs(i, m-1, mat, n, m);
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(mat[i][j] == 'a') mat[i][j] = 'O';
                else mat[i][j] = 'X';
            }
        }
    }
}