//memo
import java.util.Arrays;

class Solution {
    public int solve(int i, int prev, int[] nums, int[][] dp) {
        if(i==nums.length) return 0;
        if(dp[i][prev+1] != -1) return dp[i][prev+1];
        int pick = Integer.MIN_VALUE;
        if(prev == -1 || nums[i]>nums[prev]) {
            pick = 1 + solve(i+1, i, nums, dp);
        }
        int nonpick = solve(i+1, prev, nums, dp);
        return dp[i][prev+1] = Math.max(pick, nonpick);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, -1, nums, dp);
    }
}

//tabulation
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=n-1; i>=0; i--) {
            for(int prev=i-1; prev>=-1; prev--) {
                int pick = Integer.MIN_VALUE;
                if(prev == -1 || nums[i]>nums[prev]) {
                    pick = 1 + dp[i+1][i+1];
                }
                int nonpick = dp[i+1][prev+1];
                dp[i][prev+1] = Math.max(pick, nonpick);
            }
        }
        return dp[0][0];
    }
}

//Binary Search
class Solution {
    public int lower_bound(int n, List<Integer> nums, int target) {
        int low = 0, high = n-1;
        int ans = n;
        while(low <= high) {
            int mid = (low+high)/2;
            if(nums.get(mid) >= target) {
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for(int i=1; i<n; i++) {
            if(nums[i] > sub.get(sub.size()-1)) {
                sub.add(nums[i]);
            }
            else {
                int index = lower_bound(sub.size(), sub, nums[i]);
                sub.set(index, nums[i]);
            }
        }
        return sub.size();
    }
}
