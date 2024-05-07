class Solution {

    //RECURSION + MEMOIZATION

    // public int solve(int i, int amount, int[] coins, int[][] dp) {
    //     if(amount == 0) return 1;
    //     if(amount < 0 || i < 0) return 0;
    //     if(dp[i][amount] != -1) return dp[i][amount];
    //     int pick = solve(i, amount-coins[i], coins, dp);
    //     int nonpick = solve(i-1, amount, coins, dp);
    //     return dp[i][amount] = pick+nonpick;
    // }
    // public int change(int amount, int[] coins) {
    //     int n = coins.length;
    //     int[][] dp = new int[n][amount+1];
    //     for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
    //     return solve(n-1, amount, coins, dp);
    // }

    //TABULATION

    // public int change(int amount, int[] coins) {
    //     int n = coins.length;
    //     int[][] dp = new int[n+1][amount+1];
    //     for(int i=0; i<=n; i++) {
    //         dp[i][0] = 1;
    //     }
    //     for(int i=1; i<=n; i++) {
    //         for(int j=1; j<=amount; j++) {
    //             int pick = 0;
    //             if(j-coins[i-1] >= 0) pick = dp[i][j-coins[i-1]];
    //             int nonpick = dp[i-1][j];
    //             dp[i][j] = pick+nonpick;
    //         }
    //     }
    //     return dp[n][amount];
    // }

    //SPACE-OPTIMIZARION

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        for(int i=1; i<=n; i++) {
            prev[0] = 1;
            for(int j=1; j<=amount; j++) {
                int pick = 0;
                if(j-coins[i-1] >= 0) pick = prev[j-coins[i-1]];
                int nonpick = prev[j];
                prev[j] = pick+nonpick;
            }
        }
        return prev[amount];
    }
}