//memo
class Solution {
    public long solve(int i, int[][] q, long[] dp) {
        if(i>=q.length) return 0;
        if(dp[i] != -1) return dp[i];
        long pick = q[i][0] + solve(i+q[i][1]+1, q, dp);
        long skip = solve(i+1, q, dp);
        return dp[i] = Math.max(pick, skip);
    }
    public long mostPoints(int[][] q) {
        int n = q.length;
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        return solve(0, q, dp);
    }
}

//tabulation
class Solution {
    public long mostPoints(int[][] q) {
        int n = q.length;
        long[] dp = new long[n+1];
        for(int i=n-1; i>=0; i--) {
            long pick = q[i][0];
            if(i+q[i][1]+1 < n+1) {
                pick += dp[i+q[i][1]+1];
            }
            long skip = dp[i+1];
            dp[i] = Math.max(pick, skip);
        }
        return dp[0];
    }
}
