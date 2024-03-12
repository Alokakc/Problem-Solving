class minimum_number_of_days_to_make_m_bouquets {

    public boolean check(int[] b, int m, int k, int midDay) {
        int count = 0;
        for(int i=0; i<b.length; i++) {
            if(b[i] <= midDay) {
                count++;
            }
            else count = 0;
            if(count == k) {
                m--;
                count = 0;
            }
        }
        if(m <= 0) return true;
        return false;
    }

    public int minDays(int[] b, int m, int k) {
        int flower = m*k;
        int n = b.length, ans = Integer.MAX_VALUE;
        if(flower > n) return -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int x: b) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        while(min <= max) {
            int midDay = (min+max)/2;
            boolean flag = check(b, m, k, midDay);
            if(!flag) {
                min = midDay+1;
            }
            else {
                ans = Math.min(ans, midDay);
                max = midDay-1;
            }
        }
        if(ans != Integer.MAX_VALUE) return ans;
        return -1;
    }

}