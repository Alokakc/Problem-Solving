class find_peak_element {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1 || nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1; 
        int s = 0, e = n-1;
        while(s <= e) {
            int mid = (s+e)/2;
            if(mid==0) {
                s++;
                continue;
            }
            if(mid==n-1) {
                e--;
                continue;
            }
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) return mid;
            if(nums[mid]<nums[mid+1]) s = mid+1;
            else e = mid-1;
        }
        return 0;
    }

}