import java.util.Arrays;

//memo
class Solution1 {
    public int helper(int i, int j, int[][] ob, int[][] dp) {
        if(i==ob.length-1 && j==ob[i].length-1 && ob[i][j] == 1) return 0;
        if(i==ob.length-1 && j==ob[i].length-1) return 1;
        if(i>=ob.length || j>=ob[i].length) return 0;
        if(ob[i][j] == 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int forRight = helper(i, j+1, ob, dp);
        int forDown = helper(i+1, j, ob, dp);
        return dp[i][j] = forRight + forDown;
    }
    public int uniquePathsWithObstacles(int[][] ob) {
        int[][] dp = new int[ob.length][ob[0].length];
        for(int i=0; i<ob.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(0, 0, ob, dp);
    }
}

//tabulation
class Solution2 {
    public int uniquePathsWithObstacles(int[][] ob) {
        int n = ob.length, m = ob[0].length;
        int[][] dp = new int[n][m];
        boolean flag = false;
        for(int i=0; i<m; i++) {
            if(ob[0][i] == 1) {
                flag = true;
                dp[0][i] = 0;
            }
            else {
                if(!flag) dp[0][i] = 1;
                else dp[0][i] = 0;
            }
        }
        flag = false;
        for(int i=0; i<n; i++) {
            if(ob[i][0] == 1) {
                flag = true;
                dp[i][0] = 0;
            }
            else {
                if(!flag) dp[i][0] = 1;
                else dp[i][0] = 0;
            }
        }
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(ob[i][j] == 1) dp[i][j] = 0;
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
}