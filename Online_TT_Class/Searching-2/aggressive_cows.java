import java.util.Arrays;

class aggressive_cows {
    
    public static boolean f(int n, int k, int[] s, int mid) {
        k--;
        int curr = 0;
        for(int i=1; i<n; i++) {
            if(s[i]-s[curr] >= mid) {
                curr = i;
                k--;
            }
        }
        if(k<=0) return true;
        return false;
    }
    
    public static int solve(int n, int k, int[] s) {
        Arrays.sort(s);
        int max = s[n-1] - s[0];
        int min = Integer.MAX_VALUE;
        for(int i=1; i<s.length; i++) {
            int t = s[i] - s[i-1];
            min = Math.min(min, t);
        }
        int st = min, e = max, ans = Integer.MIN_VALUE;
        while(st <= e) {
            int mid = (st+e)/2;
            if(f(n, k, s, mid)) {
                ans = Math.max(ans, mid);
                st = mid+1;
            }
            else {
                e = mid-1;
            }
        }
        return ans;
    }

}
