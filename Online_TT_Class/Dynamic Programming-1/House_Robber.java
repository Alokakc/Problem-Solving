//memo
class Solution {
    public int solve(List<Integer> nums, int i, int[] dp) {
        if(i >= nums.size()) return 0;
        if(dp[i] != -1) return dp[i];
        int a = nums.get(i) + solve(nums, i+2, dp);
        int b = solve(nums, i+1, dp);
        return dp[i] = Math.max(a, b);
    }
    public int rob(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        for(int x: nums) arr.add(x);
        return solve(arr, 0, dp);
    }
}

//tabulation
class Solution {
    public int rob(int[] nums) {
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
}
