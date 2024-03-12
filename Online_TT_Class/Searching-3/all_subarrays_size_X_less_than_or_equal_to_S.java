public class all_subarrays_size_X_less_than_or_equal_to_S {

    public static boolean f(int n, int[] nums, int sum, int mid) {
        int currSum = 0;
        for(int i=0; i<mid; i++) currSum += nums[i];
        int l=0, r=mid-1;
        while(r<n) {
            if(currSum > sum) return false;
            else {
                currSum -= nums[l];
                r++; l++;
                if(r<n) currSum += nums[r];
            }
        }
        return true;
    }

    public static int AllSubarrays(int n, int[] nums, int sum) {
        int s = 0, e = n;
        int ans = 0;
        while(s <= e) {
            int mid = (s+e)/2;
            if(f(n, nums, sum, mid)) {
                ans = mid;
                s = mid+1;
            }
            else e = mid-1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] nums = {5, 4, 3, 2, 1};
        int sum = 10;
        int ans = AllSubarrays(n, nums, sum);
        System.out.println(ans);
    }

}