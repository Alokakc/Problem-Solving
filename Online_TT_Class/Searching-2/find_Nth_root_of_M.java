class find_Nth_root_of_M {
    
    public int NthRoot(int n, int m)
    {
        if(m==0 || m==1) return m;
        long s = 1, e = m/n;
        long x = m;
        while(s <= e) {
            long mid = (s+e)/2;
            long comp = 1;
            for(int i=1; i<=n; i++) {
                if(comp>x) {
                    break;
                }
                comp *= mid;
            }
            if(comp == x) return (int)mid;
            if(comp < x) s = mid+1;
            else {
                e = mid-1;
            }
        }
        return -1;
    }

}
