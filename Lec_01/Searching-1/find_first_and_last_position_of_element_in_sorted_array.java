class find_first_and_last_position_of_element_in_sorted_array {

    //finding first occurance
    public static int first(int[] nums, int target){
        int low = 0, high = nums.length-1;
        int ans = -1;
           while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target) {
                ans = mid;
                high = mid-1;
            }
            else if(nums[mid] < target) {
                low = mid+1;
            }
            else high = mid-1;
        }
        return ans;
     }
 
     //finding last occurance
     public static int last(int[] nums, int target){
        int low = 0, high = nums.length-1;
        int ans = -1;
           while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target) {
                ans = mid;
                low = mid+1;
            }
            else if(nums[mid] < target) {
                low = mid+1;
            }
            else high = mid-1;
        }
        return ans;
     }
 
     public int[] searchRange(int[] nums, int target) {
         int[] newarr = new int[2];
         newarr[0] = first(nums, target);
         newarr[1] = last(nums, target);
         return newarr;
     }

}