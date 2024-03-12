class sqrt_x {
    
    public int mySqrt(int x) {
        if(x==0) return 0;
        long s = 1, e = x/2;
        long ans = 1;
        while(s <= e) {
            long mid = (s+e)/2;
            long comp = mid*mid;
            if(comp <= x) {
                ans = mid;
                s = mid+1;
            }
            else {
                e = mid-1;
            }
        }
        return (int)ans;
    }

}
