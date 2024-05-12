class Solution {

    //RECURSION

    // public boolean isMatching(String s, String p, int i, int j) {
    //     if(i==s.length() && j==p.length()) return true;
    //     if(i==s.length()) {
    //         return p.charAt(j)=='*' && isMatching(s, p, i, j+1);
    //     }
    //     if(j==p.length()) return false;
    //     if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
    //         return isMatching(s, p, i+1, j+1);
    //     }
    //     else if(p.charAt(j) == '*') {
    //         return isMatching(s, p, i+1, j) ||
    //         isMatching(s, p, i, j+1);
    //     }
    //     else return false;
    // }
    // public boolean isMatch(String s, String p) {
    //     return isMatching(s, p, 0, 0);
    // }


    //MEMOIZATION

    public boolean isMatching(String s, String p, int i, int j, int[][] dp) {
        if(i==s.length() && j==p.length()) return true;
        if(i==s.length()) {
            boolean flag = p.charAt(j)=='*' && isMatching(s, p, i, j+1, dp);
            if(flag) dp[i][j] = 1;
            else dp[i][j] = 2;
            return flag;
        }
        if(j==p.length()) return false;
        if(dp[i][j] != 0) {
            if(dp[i][j] == 1) return true;
            else return false;
        } 
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            boolean flag = isMatching(s, p, i+1, j+1, dp);
            if(flag) dp[i][j] = 1;
            else dp[i][j] = 2;
            return flag;
        }
        else if(p.charAt(j) == '*') {
            boolean flag = isMatching(s, p, i+1, j, dp) ||
            isMatching(s, p, i, j+1, dp);
            if(flag) dp[i][j] = 1;
            else dp[i][j] = 2;
            return flag;
        }
        else return false;
    }
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()+1][p.length()+1];
        return isMatching(s, p, 0, 0, dp);
    }
}