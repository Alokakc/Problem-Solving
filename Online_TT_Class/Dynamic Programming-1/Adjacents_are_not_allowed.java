class Solution{
    
    //MEMOIZATION
    
    // static int solve(int n, int i, int mat[][], int dp[])
    // {
    //     if(i>=n) return 0;
    //     if(dp[i] != -1) return dp[i];
    //     int pick = Math.max(mat[0][i], mat[1][i]) + solve(n, i+2, mat, dp);
    //     int npick = solve(n, i+1, mat, dp);
    //     return dp[i] = Math.max(pick, npick);
    // }
    // static int maxSum(int N, int mat[][])
    // {
    //     int[] dp = new int[N+1];
    //     Arrays.fill(dp, -1);
    //     return solve(N, 0, mat, dp);
    // }
    
    
    //TABULATION
    
    // static int maxSum(int N, int mat[][])
    // {
    //     int[] dp = new int[N+1];
    //     for(int i=N-1; i>=0; i--) {
    //         int pick = Math.max(mat[0][i], mat[1][i]);
    //         if(i+2 <= N) pick += dp[i+2];
    //         int npick = dp[i+1];
    //         dp[i] = Math.max(pick, npick);
    //     }
    //     return dp[0];
    // }
    
    //SPACE-OPTIMIZATION
    
    static int maxSum(int N, int mat[][])
    {
        int prev2 = 0, prev1 = 0,  curr = 0;
        for(int i=N-1; i>=0; i--) {
            int pick = Math.max(mat[0][i], mat[1][i]);
            if(i+2 <= N) pick += prev2;
            int npick = prev1;
            curr = Math.max(pick, npick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}