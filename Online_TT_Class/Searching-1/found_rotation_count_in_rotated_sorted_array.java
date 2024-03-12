public class found_rotation_count_in_rotated_sorted_array {
    
    int findKRotation(int nums[], int n) {
        // code here
        int s = 0, e = nums.length-1;
        int ans = Integer.MAX_VALUE, index = 0;
        while(s <= e) {
            int mid = (s+e)/2;
            // accessing minimum element and saving its index
            if(nums[s] <= nums[mid]) {
                if(ans > nums[s]) {
                    ans = nums[s];
                    index = s;
                }
                s = mid+1;
            }
            else {
                if(ans > nums[mid]) {
                    ans = nums[mid];
                    index = mid;
                }
                e = mid-1;
            }
        }
        return index;
    }

}
