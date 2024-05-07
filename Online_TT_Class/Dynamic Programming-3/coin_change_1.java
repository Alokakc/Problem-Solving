import java.util.Arrays;

class Solution {
    
    //MEMO

    // public int solve(int[] coins, int amount, int i, int[][] dp) {
    //     if(amount == 0) {
    //         return 0;
    //     }
    //     if(i<0) return 10001;
    //     if(dp[i][amount] != -1) return dp[i][amount];
    //     int pick = 10001;
    //     if(amount-coins[i]>=0) pick = 1+solve(coins, amount-coins[i], i, dp);
    //     int nonpick = solve(coins, amount, i-1, dp);
    //     return dp[i][amount] = Math.min(pick, nonpick);
    // }
    // public int coinChange(int[] coins, int amount) {
    //     int n = coins.length;
    //     int[][] dp = new int[n+1][amount+1];
    //     for(int i=0; i<n; i++) {
    //         Arrays.fill(dp[i], -1);
    //     }
    //     int ans = solve(coins, amount, n-1, dp);
    //     return ans == 10001 ? -1 : ans;
    // }

    //TABULATION

    // public int coinChange(int[] coins, int amount) {
    //     int n = coins.length;
    //     int[][] dp = new int[n][amount+1];
    //     for(int i=0; i<n; i++) {
    //         Arrays.fill(dp[i], 10001);
    //     }
    //     for(int i=0;i<n;i++){
    //         dp[i][0]=0;
    //     }
    //     for(int i=0;i<=amount;i++){
    //         if(i%coins[0]==0){
    //             dp[0][i]=i/coins[0];
    //         }
    //     }
    //     for(int i=1;i<n;i++){
    //         for(int j=1;j<=amount;j++){
    //             int pick = 10001;
    //             if(j-coins[i]>=0) pick = 1+dp[i][j-coins[i]];
    //             int nonpick = dp[i-1][j];
    //             dp[i][j] = Math.min(pick, nonpick);
    //         }
    //     }
    //     return dp[n-1][amount]==10001?-1:dp[n-1][amount];
    // }

    //SPACE-OPTIMIZATION-1

    // public int coinChange(int[] coins, int amount) {
    //     int n = coins.length;
    //     int[] prev = new int[amount+1];
    //     int[] curr = new int[amount+1];
    //     Arrays.fill(prev, 10001);
    //     Arrays.fill(curr, 10001);
    //     prev[0] = 0;
    //     for(int i=0;i<=amount;i++){
    //         if(i%coins[0] == 0){
    //             prev[i] = i/coins[0];
    //         }
    //     }
    //     for(int i=1;i<n;i++){
    //         curr[0] = 0;
    //         for(int j=1;j<=amount;j++){
    //             int pick = 10001;
    //             if(j-coins[i]>=0) pick = 1+curr[j-coins[i]];
    //             int nonpick = prev[j];
    //             curr[j] = Math.min(pick, nonpick);
    //         }
    //         prev = curr;
    //     }
    //     return prev[amount]==10001?-1:prev[amount];
    // }

    //SPACE-OPTIMIZATION-2

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        Arrays.fill(prev, 10001);
        prev[0] = 0;
        for(int i=0; i<=amount; i++){
            if(i % coins[0] == 0){
                prev[i] = i/coins[0];
            }
        }
        for(int i=1; i<n; i++){
            prev[0] = 0;
            for(int j=1; j<=amount; j++){
                int pick = 10001;
                if(j-coins[i] >= 0) pick = 1 + prev[j-coins[i]];
                int nonpick = prev[j];
                prev[j] = Math.min(pick, nonpick);
            }
        }
        return prev[amount] == 10001 ? -1 : prev[amount];
    }
}