class Solution {

    //MEMOIZATION

    // public int solve(String s, int n, int i, int[] dp) {
    //     if(i >= n) return 1;
    //     if(dp[i] != -1) return dp[i];
    //     int one = 0;
    //     if(s.charAt(i) != '0') one = solve(s, n, i+1, dp);
    //     int two = 0;
    //     if(s.charAt(i) != '0' && i+1 < n) {
    //         String st = s.substring(i, i+2);
    //         int num = Integer.parseInt(st);
    //         if(num <= 26) {
    //             two = solve(s, n, i+2, dp);
    //         }
    //     }
    //     return dp[i] = one + two;
    // }
    // public int numDecodings(String s) {
    //     int n = s.length();
    //     int[] dp = new int[n+1];
    //     Arrays.fill(dp, -1);
    //     return solve(s, n, 0, dp);
    // }

    //TABULATION

    // public int numDecodings(String s) {
    //     int n = s.length();
    //     int[] dp = new int[n+2];
    //     dp[n+1] = 1;
    //     dp[n] = 1;
    //     for(int i=n-1; i>=0; i--) {
    //         int one = 0;
    //         if(s.charAt(i) != '0') one = dp[i+1];
    //         int two = 0;
    //         if(s.charAt(i) != '0' && i+1 < n) {
    //             String st = s.substring(i, i+2);
    //             int num = Integer.parseInt(st);
    //             if(num <= 26) {
    //                 two = dp[i+2];
    //             }
    //         }
    //         dp[i] = one + two;
    //     }
    //     return dp[0];
    // }

    //SPACE-OPTIMIZATION

    public int numDecodings(String s) {
        int n = s.length();
        int prev2 = 1;
        int prev1 = 1;
        for(int i=n-1; i>=0; i--) {
            int one = 0;
            if(s.charAt(i) != '0') one = prev1;
            int two = 0;
            if(s.charAt(i) != '0' && i+1 < n) {
                String st = s.substring(i, i+2);
                int num = Integer.parseInt(st);
                if(num <= 26) {
                    two = prev2;
                }
            }
            int curr = one + two;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}