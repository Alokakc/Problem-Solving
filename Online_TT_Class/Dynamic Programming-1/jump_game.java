import java.util.Arrays;

class Solution {
    public int solve(int i, int[] nums, int[] dp) {
        if(i>=nums.length-1) return 0;
        if(dp[i] != -1) return dp[i];
        int res = 10000;
        for(int j=i+1; j<=i+nums[i]; j++) {
            res = Math.min(res, 1+solve(j, nums, dp));
        }
        return dp[i] = res;
    }
    public int jump(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return solve(0, nums, dp);
    }
}