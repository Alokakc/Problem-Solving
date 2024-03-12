class seacrh_in_rotated_sorted_array {
    
    public int search(int[] nums, int target) {
        int start=0, end=nums.length-1, mid=0;
        while(start<=end){
            mid = (start+end)/2;
            if(target==nums[mid]) return mid;

            // checking for the sorted part
            if(nums[start]<=nums[mid]){
                // if target found in sorted part
                if(target>=nums[start] && target<nums[mid]){
                    end = mid-1;
                }
                // if target not found in sorted part
                else start = mid+1;
            }
            else{
                // if target found in sorted part
                if(target<=nums[end] && target>nums[mid]) start = mid+1;
                // if target not found in sorted part
                else end = mid-1;
            }
        }
        // if target is not present in the array
        return -1;
    } 

}