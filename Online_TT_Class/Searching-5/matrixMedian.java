import java.util.ArrayList;

public class matrixMedian {
    public int upperBound(ArrayList<Integer> nums, int key) {
        int s = 0, e = nums.size()-1, ans = nums.size();
        while(s<=e) {
            int mid = (s+e)>>1;
            if(nums.get(mid) > key) {
                ans = mid;
                e = mid-1;
            }
            else {
                s = mid+1;
            }
        }
        return ans;
    }
    public int lessthanElement(ArrayList<ArrayList<Integer>> nums, int mid) {
        int ans = 0;
        for(int i=0; i<nums.size(); i++) {
            ans += upperBound(nums.get(i), mid);
        }
        return ans;
    }
    public int findMedian(ArrayList<ArrayList<Integer>> nums) {
        int n = nums.size(), m = nums.get(0).size();
        int s = Integer.MAX_VALUE, e = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            s = Math.min(s, nums.get(i).get(0));
            e = Math.max(e, nums.get(i).get(m-1));
        }
        while(s<=e) {
            int mid = (s+e)>>1;
            int smallerElement = lessthanElement(nums, mid);
            if(smallerElement <= (int)((n*m)/2)) s = mid+1;
            else e = mid-1;
        }
        return s;
    }
}
