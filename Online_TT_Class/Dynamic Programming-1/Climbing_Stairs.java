//memo
class Solution {
    public int solve(int n, int i, List<Integer> dp) {
        if(i==n) return 1;
        if(i>n) return 0;
        if(dp.get(i) != -1) return dp.get(i);
        int step1 = solve(n, i+1, dp);
        int step2 = solve(n, i+2, dp);
        dp.set(i, step1 + step2);
        return step1 + step2;
    }
    public int climbStairs(int n) {
        List<Integer> dp = new ArrayList(Collections.nCopies(n+1, -1));
        return solve(n, 0, dp);
    }
}

//tabulation
class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}


