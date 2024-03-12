class  single_element_in_a_sorted_array {

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[n-1]!=nums[n-2]) return nums[n-1];
        int low = 0, high = n-1;
        while(low <= high) {
            if(high-low == 0) return nums[low];
            int mid = (low+high)/2;
            if(nums[mid-1] != nums[mid] && nums[mid] != nums[mid+1]) return nums[mid];
            if((mid%2 != 0 && nums[mid-1] == nums[mid]) || (mid%2 == 0 && nums[mid-1] != nums[mid])) {
                low = mid+1;
            }
            else if((mid%2 != 0 && nums[mid-1] != nums[mid]) || (mid%2 == 0 && nums[mid-1] == nums[mid])) {
                high = mid-1;
            }
        }
        return 0;
    }

}