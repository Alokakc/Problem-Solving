import java.util.Arrays;

class Solution {

    //MEMOIZATION

    // public int solve(int i, int n, int[][] dp) {
    //     if(n == 0) return 0;
    //     if(n<0 || i==0) return 10;
    //     if(dp[i][n] != -1) return dp[i][n];
    //     int pick = 1+solve(i, n-i*i, dp);
    //     int nonpick = solve(i-1, n, dp);
    //     return dp[i][n] = Math.min(pick, nonpick);
    // } 
    // public int numSquares(int n) {
    //     int i = (int)Math.sqrt(n);
    //     int[][] dp = new int[i+1][n+1];
    //     for(int j=0; j<=i; j++) Arrays.fill(dp[j], -1);
    //     int ans = solve(i, n, dp);
    //     return ans;
    // }

    //TABULATION

    // public int numSquares(int n) {
    //     int ind = (int)Math.sqrt(n);
    //     int[][] dp = new int[ind+1][n+1];
    //     for(int j=0; j<=n; j++) {
    //         dp[0][j] = 10;
    //     }
    //     dp[0][0] = 0;
    //     for(int i=1; i<=ind; i++) {
    //         for(int j=1; j<=n; j++) {
    //             int pick = 10;
    //             if(j-i*i >= 0) pick = 1 + dp[i][j-i*i];
    //             int nonpick = dp[i-1][j];
    //             dp[i][j] = Math.min(pick, nonpick);
    //         }
    //     }
    //     return dp[ind][n];
    // }

    //SPACE-OPTIMIZATION

    public int numSquares(int n) {
        int ind = (int)Math.sqrt(n);
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
        for(int j=1; j<=n; j++) {
            prev[j] = 10;
        }
        for(int i=1; i<=ind; i++) {
            curr[0] = 0;
            for(int j=1; j<=n; j++) {
                int pick = 10;
                if(j-i*i >= 0) pick = 1 + curr[j-i*i];
                int nonpick = prev[j];
                curr[j] = Math.min(pick, nonpick);
            }
            prev = Arrays.copyOf(curr, curr.length);
        }
        return prev[n];
    }
}