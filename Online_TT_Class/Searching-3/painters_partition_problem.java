import java.util.ArrayList;

public class painters_partition_problem {
    
    public static boolean f(ArrayList<Integer> b, int k, int time) {
        int curr = 0;
        for(int i=0; i<b.size(); i++) {
            if(curr+b.get(i)<=time) {
                curr += b.get(i);
            }
            else {
                k--;
                curr = b.get(i);
            }
        }
        k--;
        if(k<0) return false;
        return true;
    }
    public static int findLargestMinDistance(ArrayList<Integer> b, int k)
    {
        int max = 0, min = Integer.MIN_VALUE, ans = 0;
        for(int x: b) {
            max += x;
            min = Math.max(min, x);
        }
        while(min <= max) {
            int mid = (min+max)/2;
            if(f(b, k, mid)) {
                ans = mid;
                max = mid-1;
            }
            else min = mid+1;
        }
        return ans;
    }

}
