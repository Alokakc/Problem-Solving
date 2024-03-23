import java.util.ArrayList;

public class kth_Element_of_Two_Sorted_Arrays {
    public static int kthElement(ArrayList<Integer> nums1, ArrayList<Integer> nums2, int n, int m, int k) {
        if(n>m) return kthElement(nums2, nums1, m, n, k);
        int low = Math.max(0, k-m), high = Math.min(k, n);
        while(low<=high) {
            int mid1 = (low+high)>>1;
            int mid2 = k-mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if(mid1<n) r1 = nums1.get(mid1);
            if(mid2<m) r2 = nums2.get(mid2);
            if(mid1>0) l1 = nums1.get(mid1-1);
            if(mid2>0) l2 = nums2.get(mid2-1);
            if(l1<=r2 && l2<=r1) {
                return Math.max(l1, l2);
            }
            else if(l1>r2) high=mid1-1;
            else low=mid1+1;
        }
        return 0;
    }
}
