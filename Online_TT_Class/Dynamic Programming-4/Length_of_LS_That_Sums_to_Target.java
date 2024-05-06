import java.util.*;

//memo
class Solution {
    public int solve(List<Integer> nums, int i, int target, int[][] dp) {
        if(target==0) return 0;
        if(i>=nums.size() || target<0) return Integer.MIN_VALUE;
        if(dp[i][target] != -1) return dp[i][target];
        int ans = Integer.MIN_VALUE;
        ans = Math.max(ans, solve(nums, i+1, target, dp));
        int newans = Math.max(ans, 1+solve(nums, i+1, target-nums.get(i), dp));
        return dp[i][target] = Math.max(ans, newans);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp = new int[nums.size()+1][target+2];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        int ans = solve(nums, 0, target, dp);
        return ans<0?-1:ans;
    }
}