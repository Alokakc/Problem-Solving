public class get_equal_substring_within_budget {

    private boolean f(String s, String t, int cost, int mid) {
        for(int i=0, j=0; j<s.length();) {
            if(s.charAt(j)==t.charAt(j)) {
                if(j-i+1>=mid) return true;
                j++;
            }
            else {
                int c = Math.abs(s.charAt(j)-t.charAt(j));
                if(cost-c >=0) {
                    cost -= c;
                    if(j-i+1>=mid) return true;
                    j++;
                }
                else {
                    int cl = Math.abs(s.charAt(i)-t.charAt(i));
                    cost += cl;
                    i++;
                }
            }
        }
        return false;
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int st = 0, e = s.length(), ans = 0;
        while(st <= e) {
            int mid = (st+e)/2;
            boolean flag = f(s, t, maxCost, mid);
            if(flag) {
                ans = mid;
                st = mid+1;
            }
            else {
                e = mid-1;
            }
        }
        return ans;
    }
}
