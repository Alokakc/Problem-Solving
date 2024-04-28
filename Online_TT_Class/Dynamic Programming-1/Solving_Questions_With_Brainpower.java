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