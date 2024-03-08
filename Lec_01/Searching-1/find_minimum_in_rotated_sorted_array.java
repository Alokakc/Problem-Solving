public class find_minimum_in_rotated_sorted_array {
    
    public int findMin(int[] nums) {
        int s = 0, e = nums.length-1;
        // initialize ans with INT_MAX
        int ans = Integer.MAX_VALUE;
        while(s <= e) {
            int mid = (s+e)/2;
            // finding the sorted part of the array
            if(nums[s] <= nums[mid]) {
                // if this is the sorted part then, in this part nums[mid] will be min
                ans = Math.min(ans, nums[s]);
                // after taking min, heading towards the unsorted part
                s = mid+1;
            }
            else {
                // if this is the sorted part then, in this part nums[mid] will be min
                ans = Math.min(ans, nums[mid]);
                // after taking min, heading towards the unsorted part
                e = mid-1;
            }
        }
        return ans;
    }

}
