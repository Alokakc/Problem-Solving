//memo
class Solution {
    int start = 0;
    public int solve(int[] nums, int i, int[] dp) {
        if(start == 0) {
            if(i >= nums.length-1) return 0;
        } else {
            if(i >= nums.length) return 0;
        }
        if(dp[i] != -1) return dp[i];
        int a = nums[i] + solve(nums, i+2, dp);
        int b = solve(nums, i+1, dp);
        return dp[i] = Math.max(a, b);
    }
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        int opt1 = solve(nums, 0, dp);
        start = 1;
        Arrays.fill(dp, -1);
        int opt2 = solve(nums, 1, dp);
        return Math.max(opt1, opt2);
    }
}

//tabulation
class Solution {
    public int rob2(int[] nums) {
        int n = nums.length;
        int prev2 = 0;
        int prev1 = nums[0];
        for(int i=1; i<n; i++) {
            int curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        int n = nums.length, l=0, m=0;
        if(n==1) return nums[0];
        int[] v1 = new int[n-1];
        int[] v2 = new int[n-1];
        for(int i=0; i<n; i++) {
            if(i!=0) v1[l++] = nums[i];
            if(i!=n-1) v2[m++] = nums[i];
        }
        return Math.max(rob2(v1), rob2(v2));
    }
}
