class Solution {

    //MEMOIZATION

    // public int solve(List<Integer> nums, int i, int t, int[][] dp) {
    //     if(i<0) {
    //         if(t==0) return 0;
    //         else return Integer.MIN_VALUE;
    //     }
    //     if(t<0) return Integer.MIN_VALUE;
    //     if(dp[i][t] != -1) return dp[i][t];
    //     int pick = 1 + solve(nums, i-1, t-nums.get(i), dp);
    //     int nonpick = solve(nums, i-1, t, dp);
    //     return dp[i][t] = Math.max(pick, nonpick);
    // }
    // public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
    //     int n = nums.size();
    //     int[][] dp = new int[n+1][target+1];
    //     for(int[] x: dp) {
    //         Arrays.fill(x, -1);
    //     }
    //     int ans = solve(nums, n-1, target, dp);
    //     return ans<0?-1:ans;
    // }

    //TABULATION

    // public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
    //     int n = nums.size();
    //     int[][] dp = new int[n+1][target+1];
    //     for (int i = 0; i <= n; i++) {
    //         for (int t = 0; t <= target; t++) {
    //             if (i == 0) {
    //                 if (t == 0) {
    //                     dp[i][t] = 0;
    //                 } else {
    //                     dp[i][t] = Integer.MIN_VALUE;
    //                 }
    //             } else {
    //                 dp[i][t] = Integer.MIN_VALUE;
    //             }
    //         }
    //     }
    //     for(int i=1; i<=n; i++) {
    //         for(int j=0; j<=target; j++) {
    //             int pick = Integer.MIN_VALUE;
    //             if(j-nums.get(i-1) >= 0) pick = 1 + dp[i-1][j-nums.get(i-1)];
    //             int nonpick = dp[i-1][j];
    //             dp[i][j] = Math.max(pick, nonpick);
    //         }
    //     }
    //     return dp[n][target] < 0 ? -1 : dp[n][target];
    // }

    //SPACE-OPTIMIZATION

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[] prev = new int[target+1];
        int[] curr = new int[target+1];
        Arrays.fill(prev, Integer.MIN_VALUE);
        for(int i=1; i<=n; i++) {
            prev[0] = 0;
            for(int j=0; j<=target; j++) {
                int pick = Integer.MIN_VALUE;
                if(j-nums.get(i-1) >= 0) pick = 1 + prev[j-nums.get(i-1)];
                int nonpick = prev[j];
                curr[j] = Math.max(pick, nonpick);
            }
            prev = Arrays.copyOf(curr, target+1);
        }
        return prev[target] < 0 ? -1 : prev[target];
    }
}
