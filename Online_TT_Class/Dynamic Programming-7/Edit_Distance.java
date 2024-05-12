class Solution {

    //MEMOIZATION

    // public int solve(String word1, String word2, int word1_length, int word2_length, int i, int j, int[][] dp) {
    //     if(i<0 && j<0) return 0;
    //     if(i < 0) return j+1;
    //     if(j < 0) return i+1;
    //     if(dp[i][j] != -1) return dp[i][j];
    //     if(word1.charAt(i) == word2.charAt(j)) {
    //         return solve(word1, word2, word1_length, word2_length, i-1, j-1, dp);
    //     }
    //     else {
    //         int Insert_character = solve(word1, word2, word1_length, word2_length, i-1, j, dp);
    //         int Delete_character = solve(word1, word2, word1_length, word2_length, i, j-1, dp);
    //         int Replace_character = solve(word1, word2, word1_length, word2_length, i-1, j-1, dp);
    //         return dp[i][j] = Math.min(Insert_character, Math.min(Delete_character, Replace_character)) + 1;
    //     }
    // }
    // public int minDistance(String word1, String word2) {
    //     int word1_length = word1.length();
    //     int word2_length = word2.length();
    //     int[][] dp = new int[word1_length+1][word2_length+1];
    //     for(int i=0; i<=word1_length; i++) {
    //         Arrays.fill(dp[i], -1);
    //     }
    //     int ans = solve(word1, word2, word1_length, word2_length, word1_length-1, word2_length-1, dp);
    //     for(int i=0;i<=word1_length;i++){
    //         System.out.println(Arrays.toString(dp[i]));
    //     }
    //     return ans;
    // }


    //TABULATION

    // public int minDistance(String word1, String word2) {
    //     int word1_length = word1.length();
    //     int word2_length = word2.length();
    //     int[][] dp = new int[word1_length+1][word2_length+1];
    //     for(int i=1; i<=word1_length; i++) {
    //         dp[i][0] = i;
    //     }
    //     for(int i=1; i<=word2_length; i++) {
    //         dp[0][i] = i;
    //     }
    //     for(int i=1; i<=word1_length; i++) {
    //         for(int j=1; j<=word2_length; j++) {
    //             if(word1.charAt(i-1) == word2.charAt(j-1)) {
    //                 dp[i][j] =  dp[i-1][j-1];
    //             }
    //             else {
    //                 int Insert_character = dp[i-1][j];
    //                 int Delete_character = dp[i][j-1];
    //                 int Replace_character = dp[i-1][j-1];
    //                 dp[i][j] = Math.min(Insert_character, Math.min(Delete_character, Replace_character)) + 1;
    //             }
    //         }
    //     }
    //     return dp[word1_length][word2_length];
    // }

    //SPACE-OPTIMIZATION

    public int minDistance(String word1, String word2) {
        int word1_length = word1.length();
        int word2_length = word2.length();
        int[] prev = new int[word2_length+1];
        int[] curr = new int[word2_length+1];
        for(int i=1; i<=word2_length; i++) {
            prev[i] = i;
        }
        for(int i=1; i<=word1_length; i++) {
            curr[0] = i;
            for(int j=1; j<=word2_length; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    curr[j] =  prev[j-1];
                }
                else {
                    int Insert_character = prev[j];
                    int Delete_character = curr[j-1];
                    int Replace_character = prev[j-1];
                    curr[j] = Math.min(Insert_character, Math.min(Delete_character, Replace_character)) + 1;
                }
            }
            System.arraycopy(curr, 0, prev, 0, word2_length + 1);
        }
        return prev[word2_length];
    }
}