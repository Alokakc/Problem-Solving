public class minimum_limit_of_balls_in_a_bag {
    
    public boolean f(int[] nums, int op, int balls) {
        for(int i=0; i<nums.length; i++) {
            if(op<0) break;
            if(nums[i]>balls) {
                int temp = nums[i]/balls;
                if(nums[i]%balls==0) temp--;
                op-=temp;
                if(op<0) break;
            }
        }
        if(op>=0) return true;
        return false;
    }
    public int minimumSize(int[] nums, int op) {
        int max = Integer.MIN_VALUE, ans = 0;
        for(int x: nums) {
            max = Math.max(max, x);
        }
        int min = 1;
        while(min <= max) {
            int mid = (min+max)/2;
            if(f(nums, op, mid)) {
                ans = mid;
                max = mid-1;
            }
            else {
                min = mid+1;
            }
        }
        return ans;
    }

}
