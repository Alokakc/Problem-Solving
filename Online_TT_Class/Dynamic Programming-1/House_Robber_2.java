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